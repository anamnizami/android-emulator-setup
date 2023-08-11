#!/usr/bin/env bash

# Exits on error
set -e

echo  "ℹ️️  Allure report generated after device farm schedule test run"

declare -a dirs
cd AutomatedTests*

i=1
for d in */
do
    dirs[i++]="${d%/}"
done
echo "ℹ️  There were ${#dirs[@]} devices during test run but only the first one's report is displayed"
for((i=1;i<=${#dirs[@]};i++)) do
    echo "$i ${dirs[i]}"
    [[ -d Host_Machine_Files ]] && rm -r Host_Machine_Files
    echo "ℹ️  Unzipping and publishing allure report from ${dirs[i]} device"
    unzip "${dirs[$i]}"/*/*/**Artifacts.zip
    sleep 2

    allure generate -c Host_Machine_Files/*/*/allure-results/ -o "${dirs[i]}-"allure-results-html

    sleep 2
    #To run this command to make html report to a single html: https://github.com/MihanEntalpo/allure-single-html-file
    echo "${dirs[i]}-"allure-results-html
    ls "${dirs[i]}-"allure-results-html
    allure-combine "${dirs[i]}-"allure-results-html


done

#Create a folder, to later copy renamed complete.html into it
mkdir "$HOME/mobileResultsFolder"

#To generate a unique file all the time, the complete.html file has to be renamed, hence using random letters and digits
for D in ./*allure-results-html; do
  if [ -d "$D" ]; then
    cd "$D"
    set="abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    n=15
    rand=""

    for i in $(seq 1 $n); do
      char=${set:$RANDOM % ${#set}:1}
      rand+=$char
    done

    echo "Random string --> $rand"

    mv complete.html "${rand}_"complete.html

    cp "${rand}_complete.html" "$HOME/mobileResultsFolder"
  fi
done

# For now, it is limited to publish only a single device's report, because more terminal will be needed.
# It is also possible to extend this script to choose which device's allure report to display
# This could be done manually as well once the scheduleRun script is complete. IE, device farm tests is executed and
# download the Files of executed devices.
# Unzip on root project named AutomatedTest***/choose device/Tests suites/Test/Customer**Artifacts.zip
# The unzipped file will be known as Host_Machine_Files
# allure-results folder is found in Host_Machine_Files/$DEVICEFARM_LOG_DIR/test-output/allure-results
# So just serve that path