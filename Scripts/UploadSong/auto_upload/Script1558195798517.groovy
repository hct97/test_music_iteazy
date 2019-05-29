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

File folder = new File(folderUrl)
File[] listOfFiles = folder.listFiles()
List<String> songs = new ArrayList<String>()
List<String> imgs = new ArrayList<String>()

for (int i = 0; i < listOfFiles.length; i++) {
	if (listOfFiles[i].isFile()) {
	  String[] str =  listOfFiles[i].getName().split("\\.")
	  if (str[1] == "mp3") {
		  songs.add(listOfFiles[i].getName())
	  }
	  else if (str[1] == "jpg" || "png" || "jpeg") {
		  imgs.add(listOfFiles[i].getName())
	  }
	}
  }

WebUI.callTestCase(findTestCase('Login/login_successfully'), [:], FailureHandling.STOP_ON_FAILURE)

for (int i = 0; i < songs.size(); i++){
	songUrl = "" + folderUrl + songs[i]
	if (i >= imgs.size()) {
		imgUrl =  "" + folderUrl + imgs[0]
	}
	else {
		imgUrl =  "" + folderUrl + imgs[i]
	}
	String[] name = songs[i].split("-");
	WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/a_Upload'))
	
	WebUI.setText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Title_songtitle'), name[0])
	
	WebUI.uploadFile(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Img'), imgUrl)
	
	WebUI.uploadFile(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Song_songsong_url'), songUrl)
	
	WebUI.setText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/textarea_Lyrics_songlyrics'), 'abc')
	
	WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Singer description_commit'))
	
	result = WebUI.getText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/div_Upload success'))

	WebUI.verifyMatch(result, "Upload success", true)
}
