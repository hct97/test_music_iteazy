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
import com.kms.katalon.core.exception.StepErrorException as StepErrorException

WebUI.callTestCase(findTestCase('Login/login_successfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/a_Playlist'))

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/span_Add Playlist'))

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/Playlist/Page_App nghe nhc/input_Playlist name_playlistname'), playlist_name)

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/input_Playlist name_commit'))

result = WebUI.getText(findTestObject('Object Repository/Playlist/Page_App nghe nhc/div_Playlist created'))

WebUI.verifyMatch(result, 'Playlist created', true)

playlistName = WebUI.getText(findTestObject('Object Repository/Playlist/Page_App nghe nhc/div_Playlist created'))

Boolean flags = false
if(playlist_name.contains(playlist_name)){
	flags = true
}
if(flags == false){
	throw new StepErrorException("Result not correct")
}