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
# Update the git tag version
sed -i "s/tag: v.*/tag: v$VERSION/" "$MANIFEST"

# 3. Update Metainfo (XML)
METAINFO="distribution/flatpak/com.ktvincco.openaudiotools.metainfo.xml"
# Update the release tag version and date (handles <release version="X" date="Y" />)
sed -i "s/release version=\"[^\"]*\" date=\"[^\"]*\"/release version=\"$VERSION\" date=\"$TODAY\"/" "$METAINFO"

echo "✅ Manifest and Metainfo updated to v$VERSION"

# 4. Handle Offline Dependencies
GENERATOR_URL="https://raw.githubusercontent.com/flatpak/flatpak-builder-tools/master/gradle/flatpak-gradle-generator.py"
GENERATOR_SCRIPT="scripts/flatpak-gradle-generator.py"

if [ ! -f "$GENERATOR_SCRIPT" ]; then
    echo "📥 Downloading Flatpak Gradle Generator..."
    curl -sL "$GENERATOR_URL" -o "$GENERATOR_SCRIPT"
    chmod +x "$GENERATOR_SCRIPT"
fi

echo "🔍 Generating offline dependency list (this may take a few minutes)..."
# We run it for the specific gradle task
python3 "$GENERATOR_SCRIPT" -o distribution/flatpak/generated-sources.json :app:openaudiotools:createDistributable

# 5. Ensure the manifest includes the generated sources
if ! grep -q "generated-sources.json" "$MANIFEST"; then
    echo "🔗 Linking generated-sources.json to manifest..."
    # Add generated-sources.json right after the sources: line
    sed -i "/sources:/a \      - generated-sources.json" "$MANIFEST"
fi

echo "✨ Done! All files are ready for release v$VERSION."
echo "👉 Next steps:"
echo "   1. Commit the changes: git add . && git commit -m \"Prepare Flatpak release v$VERSION\""
echo "   2. Tag the release: git tag v$VERSION && git push origin v$VERSION"
echo "   3. Submit your pull request to Flathub."
