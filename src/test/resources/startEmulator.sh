#!/usr/bin/env bash

# Show all environmental variables involved
set -xg

echo  "⚠️  Starting the local emulator"
echo  "⚠️  Make sure your emulator's name matches"


if [ "$1" ]; then
  echo "Your input emulator: $1"
  emulator -avd "$1"
else
  echo "Using my local set emulator"
  emulator -avd  Pixel_XL_Android_12
fi
