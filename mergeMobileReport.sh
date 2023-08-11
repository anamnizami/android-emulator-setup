#!/usr/bin/env bash

# Exits on error
set -e

echo  "Checkout the mobile repository and merge the reports"

cd "$HOME/mobileResultsFolder"

git clone git@github.com:kfzteile24/mobile-automation-reports.git

sleep 1

cp -r ./*complete.html mobile-automation-reports/mobile-report-bucket

cd mobile-automation-reports/mobile-report-bucket

git status

git add .

git commit -m "Mobile report results"

git push --force-with-lease origin

