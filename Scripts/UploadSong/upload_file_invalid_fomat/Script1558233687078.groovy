import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Login/login_successfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/a_Upload'))

WebUI.setText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Title_songtitle'), "Test invalid fomat")

WebUI.uploadFile(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Song_songsong_url'), songUrl)

WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Singer description_commit'))

result = WebUI.getText(findTestObject("Object Repository/UploadSong/Page_App nghe nhc/div_Upload failed"))

WebUI.verifyMatch(result, "Upload failed", true)

String[] str = songUrl.split("\\.")

String fomat = "Song url You are not allowed to upload \"" + str[1] + "\" files, allowed types: mp3"

alert = WebUI.getText(findTestObject("Object Repository/UploadSong/Page_App nghe nhc/div_alert1"))

WebUI.verifyMatch(alert, fomat, true)
