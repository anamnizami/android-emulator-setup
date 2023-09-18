set -ex
npm install -g appium@next
appium driver install uiautomator2
appium plugin install --source=npm appium-wait-plugin
appium -v
appium --use-plugin=element-wait --log appium.log &>/dev/null &
