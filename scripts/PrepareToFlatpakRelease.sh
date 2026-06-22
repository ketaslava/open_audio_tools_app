#!/bin/bash

# Exit on error
set -e

echo "🚀 Starting Flatpak Release Preparation..."

# 1. Extract version from build.gradle.kts
VERSION=$(grep 'val version =' app/openaudiotools/build.gradle.kts | cut -d'"' -f2)
TODAY=$(date +%Y-%m-%d)

echo "📦 Detected Version: $VERSION"
echo "📅 Date: $TODAY"

# 2. Update Flatpak Manifest (YAML)
MANIFEST="distribution/flatpak/com.ktvincco.openaudiotools.yaml"

# Check if we are in "local test" mode
if grep -q "type: dir" "$MANIFEST"; then
    echo "⚠️  Manifest is in LOCAL TEST mode (type: dir). Remember to switch to 'git' before publishing!"
else
    # Update the git tag version only if we are in git mode
    sed -i "s/tag: v.*/tag: v$VERSION/" "$MANIFEST"
fi

# 3. Update Metainfo (XML)
METAINFO="distribution/flatpak/com.ktvincco.openaudiotools.metainfo.xml"
sed -i "s/release version=\"[^\"]*\" date=\"[^\"]*\"/release version=\"$VERSION\" date=\"$TODAY\"/" "$METAINFO"

echo "✅ Manifest and Metainfo updated to v$VERSION"

# 4. Handle Offline Dependencies
GENERATOR_URL="https://raw.githubusercontent.com/flatpak/flatpak-builder-tools/master/gradle/flatpak-gradle-generator.py"
GENERATOR_SCRIPT="scripts/flatpak-gradle-generator.py"
OUTPUT_JSON="distribution/flatpak/generated-sources.json"

# Clear any previous generated sources
rm -f "$OUTPUT_JSON"

if [ ! -f "$GENERATOR_SCRIPT" ]; then
    echo "📥 Downloading Official Flatpak Gradle Generator..."
    curl -sL "$GENERATOR_URL" -o "$GENERATOR_SCRIPT"
    chmod +x "$GENERATOR_SCRIPT"
fi

echo "🔍 Generating Gradle dependency log (this will take a while)..."
# We use --info and --refresh-dependencies to get all URLs.
./gradlew :app:openaudiotools:createDistributable --info --refresh-dependencies > gradle_raw.log 2>&1 || true

echo "🧹 Filtering log to remove 404s and failed attempts..."
grep "Downloaded https://" gradle_raw.log > gradle_clean.log || true

echo "🔍 Processing clean log to generate offline dependency list..."
python3 "$GENERATOR_SCRIPT" gradle_clean.log "$OUTPUT_JSON" --destdir flatpak-gradle/res

# Cleanup logs
rm gradle_raw.log gradle_clean.log

# 5. Ensure the manifest includes the generated sources
# We use a more compatible syntax for YAML inclusion
if ! grep -q "generated-sources.json" "$MANIFEST"; then
    echo "🔗 Linking generated-sources.json to manifest..."
    # Add it as a simple string item in the list
    sed -i "/sources:/a \      - generated-sources.json" "$MANIFEST"
fi

echo "✨ Done! All files are ready for release v$VERSION."
echo ""
echo "🛠️  HOW TO TEST LOCALLY:"
echo "   1. Edit $MANIFEST"
echo "   2. Change 'type: git' to 'type: dir' and 'url/tag' lines to 'path: ../..'"
echo "   3. Run: flatpak-builder --user --install --force-clean build-dir $MANIFEST"
echo ""
echo "🚀 HOW TO PUBLISH:"
echo "   1. Ensure $MANIFEST uses 'type: git' with your GitHub URL and tag v$VERSION"
echo "   2. Commit & Push: git add . && git commit -m \"Prepare Flatpak release v$VERSION\""
echo "   3. Tag: git tag v$VERSION && git push origin v$VERSION"
echo "   4. Submit your pull request to Flathub."
