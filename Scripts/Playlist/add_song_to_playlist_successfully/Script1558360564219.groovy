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

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/a_Songs'))

WebUI.click(findTestObject('Playlist/Page_App nghe nhc/a_title'))

song = WebUI.getText(findTestObject('Object Repository/Playlist/Page_App nghe nhc/h3_title'))

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/a_ADD TO PLAYLIST'))

Thread.sleep(2000)

WebUI.selectOptionByIndex(findTestObject('Object Repository/Playlist/Page_App nghe nhc/select_playlist'),2)

playlistName = WebUI.getAttribute(findTestObject('Object Repository/Playlist/Page_App nghe nhc/select_playlist'), 'value')

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/input_Select playlist_commit'))

Thread.sleep(2000)

result = WebUI.getText(findTestObject('Object Repository/Playlist/Page_App nghe nhc/div_Added to playlist'))

WebUI.verifyMatch(result, 'Added to playlist', true)

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/a_Playlist'))
for(int i =1;i<10;i++){
	xPath = "/html[1]/body[1]/main[@class=\"container\"]/div[@class=\"row\"]/div[@class=\"col-md-12\"]/ol[1]/li[" + i + "]/h5/a"
	TestObject ob = findTestObject("Object Repository/Playlist/Page_App nghe nhc/a_playlistname")
	ob.findProperty("xpath").setValue(xPath)
	
	name = WebUI.getText(ob)
	if (name == playlistName) {
		WebUI.click(ob)
		break
	}
}

for(int i=1; i < 10;i++) {
	xPath1 = "/html[1]/body[1]/main[@class=\"container\"]/div[@class=\"content\"]/ul[1]/li[" + i + "]/div[@class=\"row col-12\"]/div[@class=\"col-md-9\"]/div[@class=\"row col-12\"]/p[@class=\"song-title text-white\"]/a[1]"

	TestObject ob1 = findTestObject("Object Repository/Playlist/Page_App nghe nhc/a_title")
	ob1.findProperty("xpath").setValue(xPath1)
	
	title = WebUI.getText(ob1)
	
	Boolean flags = false

	if(title == song){
		flags = true;
		break
	}
	
	if(flags == false) {
		throw new StepErrorException("Result not correct")
	}
}
