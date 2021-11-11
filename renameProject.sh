#!/usr/bin/env bash

package_name=$1
directory=$(echo $package_name | tr "." "/")

mkdir -p src/$directory
mkdir -p test/$directory

find src/ test/ -type f -exec sed -i s/ad.template.gradle.kotlin/$package_name/g {} +
sed -i s/ad.template.gradle.kotlin/$package_name/g build.gradle.kts
sed -i s/ad.template.gradle.kotlin/$package_name/g settings.gradle.kts

mv src/ad/template/gradle/kotlin/* src/$directory
mv test/ad/template/gradle/kotlin/* test/$directory

rm $0
find src/ test/ -type d -empty -delete
