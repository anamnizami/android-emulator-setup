#!/usr/bin/env bash

# Exits on error
set -e

echo  "⚠️  Allure reports are generated after a suite run"
echo  "⚠️  Make sure to delete the allure_results folder before another run so as to avoid mismatch reports"

DIR=allure-report

if [ -d "$DIR" ]; then
  cp -r "$DIR"/history  allure-results/history
fi
cp src/test/resources/categories.json  allure-results
allure generate --clean allure-results
allure open allure-report
