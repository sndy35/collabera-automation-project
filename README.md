# collabera-automation-project
Automation Framework Sample

Run a Test

Make sure Appium server is started(If appium server is not started locally, provider ip and port using -DappiumServer and -DappiumPort)

Run adb devices to get the udid of connected android device

Run the below command from the project root folder

java -cp target/collabera-automation-project-0.0.1-SNAPSHOT-tests.jar:target/libs/*:target/collabera-automation-project-0.0.1-SNAPSHOT.jar -Dplatform=android -DplatformVersion=androidVersion -Dudid=udid -DdeviceName=udid -DappPackage=com.amazon.mShop.android.shopping -DappActivity=com.amazon.mShop.splashscreen.StartupActivity -DnewCommandTimeout=5000 org.testng.TestNG testng_files/testng.xml

Note: Code has retry logic to run the test if it fails. max number of retries configured is 2.
