#!/usr/bin/env bash

echo  "⚠️  Starting the local simulator"
echo  "⚠️  Device name should match the UUID of chosen device for testing"

if [ "$1" ]
then
  echo "Your input UUID: $1"
  xcrun simctl boot "$1"

else

echo "Using my local set simulator iPhone 13"
  xcrun simctl boot 0E25AB55-0A94-4A21-8C57-48937D67BACF
end
sleep 4
open /Applications/Xcode.app/Contents/Developer/Applications/Simulator.app/
