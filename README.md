# Appium an automation framework for Apps

***[Appium](https://appium.io) is an open source test automation framework for use with native, hybrid and mobile web apps.It drives iOS, Android, and Windows apps using the WebDriver protocol***

# Appium requirements
- Appium version needs to be above 1.22.3 for iOS
- Appium server
- Appium client
- selenium java libraries, since it appium is built around selenium
- TestNG

## Android requirements on Windows and Mac

The following are the system requirements for Appium on Android:
-   Java (version 7 or later)
-   Android SDK API (version 17 or later)
-   Android Virtual Device (AVD) or real device

## iOS requirements
These are the system requirements for iOS devices to start with Appium:
-   Mac OS X 10.7 or later
-   Xcode (greater than or equal to 13) with the command-line build tool
-   Java (version 7 or later)

### Get started with the required tools from this [site](https://www.swtestacademy.com/how-to-install-appium-on-mac/)
-   Java for JAVA_HOME
-   Android Studio for ANDROID_HOME
-   Homebrew if not yet on your system
-   Node.js and npm

### Environment Setup
- Install the required tools from this [site](https://www.swtestacademy.com/how-to-install-appium-on-mac/)
   - **Note**: The local set up may vary depending on the [shell](https://betterprogramming.pub/fish-vs-zsh-vs-bash-reasons-why-you-need-to-switch-to-fish-4e63a66687eb) type you are using. The most used shells
  are Bash, Zsh and Fish (Friendly interactive shell).
- Appium version needs to be above 1.22.3 for iOS
- Install it via command `npm install appium -g` on terminal (Mac/Linux)
- `appium --allow-insecure chromedriver_autodownload` run this in the CMD where you were running appium server.
- Install Appium inspector [Donload Link](https://github.com/appium/appium-inspector/releases)

### Run automated tests locally
- Pre-condition:
  - Create a file named ConstantUtil.java under the src/test/java/com/kfz24/util path
     - Ask any QA Automation Engineer for the content of this file, this file contains sensitive data hence it's not on GitHub.
  - Upload .apk (Android) or .app (iOS) file under src/apps
  - Update the `androidAppName` & `iosAppName` on `LocalEnvSetup.java`, it has to be the same name as the one under src/apps
  - Configure simulators & emulators
     - Android: Configure the devices type to `kfz24_emulator` via Intellij from Tools > Android > AVD Manager
     - iOS: Download iphone 13 with iOS 15 [How to](https://doc.arcgis.com/en/appstudio/extend-apps/installdevtoolsemulators.htm#:~:text=If%20you%20require%20a%20different,version%20you%20want%20to%20download.)
- Steps:
  - Right click on mouse on the `iosSmoketestng.xml` or `androidSmoketestng.xml` which is at the root of the project package and then clicking on run
[![Screenshot-2023-01-16-at-16-35-57.png](https://i.postimg.cc/sghn4cF2/Screenshot-2023-01-16-at-16-35-57.png)](https://postimg.cc/YvtfpQCc)

- Reports: After testing is completed, run `sh ./local_allure_generate.sh`
  
### Connect to AWS Device Farm, testing from the cloud
- Pre-condition:
   - Make sure you have permission for this [project](https://us-west-2.console.aws.amazon.com/devicefarm/home?region=us-east-1#/mobile/projects)
   If not, Please reach out to Cloud infrastructure team
   - Install python3 (version 3.9.10 or later)
   - Install python library for boto3 & requests,
     Using commands: 
      - `pip3 install boto3`
      - `pip3 install requests`
   - Export your `AWS_ACCESS_KEY_ID` & `AWS_SECRET_ACCESS_KEY` & `AWS_SESSION_TOKEN` in terminal
   
  [![Screenshot-2023-03-20-at-14-35-54.png](https://i.postimg.cc/FsTRVM59/Screenshot-2023-03-20-at-14-35-54.png)](https://postimg.cc/TpWfRH3S)
     **Warning**: You need to export your credential every 24 hours since after 24 hours the key will expire
   - Update the `appFilePath` from `schedule_run_get_result.py`
   - Update `.xml` file per your requirement from `src/test/resources`
   
- Steps:
   - Create a .zip package using script. Run `sh ./ziptestpackage.sh` from the root of this repo
   - Run 
       - `python3 run_mobile_test_device_farm.py android` for Android tests
       - `python3 run_mobile_test_device_farm.py ios` for iOS tests

- Report: After testing is completed, run `sh ./device_Farm_allure_results.sh`
### Reference:
- More Documentation about [Mobile Automation](https://kfzteile24.atlassian.net/wiki/spaces/IT/pages/3505324048/Mobile+Automation+Appium)
- Interested in building app from source code, then follow the [ReadMe](https://github.com/kfzteile24/ios-app) of iOS repo
- Interested in using the fish shell? [Then go for it!](https://hackercodex.com/guide/install-fish-shell-mac-ubuntu/)
  Bringing the terminal to modern age,it is recommended to replace the default terminal with [iTerm2](https://iterm2.com/)
