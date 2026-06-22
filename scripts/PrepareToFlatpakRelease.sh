#!/bin/bash

# Exit on error
set -e

echo "🚀 Starting Flatpak Release Preparation..."

# 1. Extract version from build.gradle.kts
VERSION=$(grep 'val version =' app/openaudiotools/build.gradle.kts | cut -d'"' -f2)
TODAY=$(date +%Y-%m-%d)

echo "📦 Detected Version: $VERSION"
echo "📅 Date: $TODAY"

# 2. Update Metadata
MANIFEST="distribution/flatpak/com.ktvincco.openaudiotools.yaml"
METAINFO="distribution/flatpak/com.ktvincco.openaudiotools.metainfo.xml"

sed -i "s/release version=\"[^\"]*\" date=\"[^\"]*\"/release version=\"$VERSION\" date=\"$TODAY\"/" "$METAINFO"

# Update git tag in manifest if it's in git mode (only if not in local test dir mode)
if grep -q "type: git" "$MANIFEST"; then
    sed -i "s/tag: v.*/tag: v$VERSION/" "$MANIFEST"
fi

echo "✅ Metadata updated to v$VERSION"

# 3. Handle Offline Dependencies
GENERATOR_URL="https://raw.githubusercontent.com/flatpak/flatpak-builder-tools/master/gradle/flatpak-gradle-generator.py"
GENERATOR_SCRIPT="scripts/flatpak-gradle-generator.py"
OUTPUT_JSON="distribution/flatpak/generated-sources.json"

# Clear previous generated sources
rm -f "$OUTPUT_JSON"

if [ ! -f "$GENERATOR_SCRIPT" ]; then
    echo "📥 Downloading Official Flatpak Gradle Generator..."
    curl -sL "$GENERATOR_URL" -o "$GENERATOR_SCRIPT"
    chmod +x "$GENERATOR_SCRIPT"
fi

echo "🔍 Generating Gradle dependency log..."
./gradlew :app:openaudiotools:createDistributable --info --refresh-dependencies > gradle_raw.log 2>&1 || true

echo "🧹 Filtering log..."
grep -E "Downloaded https://|Cached resource https://" gradle_raw.log > gradle_clean.log || true

echo "🔍 Processing dependency list..."
# Note: Generator script creates a JSON array of sources
python3 "$GENERATOR_SCRIPT" gradle_clean.log "$OUTPUT_JSON" --destdir flatpak-gradle/res

rm gradle_raw.log gradle_clean.log

echo "✨ Done! All files are ready for release v$VERSION."
echo "👉 Run the builder to test: flatpak-builder --user --install --force-clean build-dir $MANIFEST"
