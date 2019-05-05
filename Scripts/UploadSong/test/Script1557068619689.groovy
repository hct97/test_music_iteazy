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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://music-iteazy.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/span_Login'))

WebUI.setText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Email_useremail'), 'huynhchitrung97@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Password_userpassword'), 'aeHFOx8jV/A=')

WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Remember me_commit'))

WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/a_Upload'))

WebUI.setText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Title_songtitle'), 'test')

WebUI.uploadFile(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Song_songsong_url'), 'E:\\Music\\Yeu Em Rat Nhieu - Hoang Ton [128kbps_MP3].mp3')

WebUI.setText(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/textarea_Lyrics_songlyrics'), 'abc')

WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/input_Singer description_commit'))

WebUI.click(findTestObject('Object Repository/UploadSong/Page_App nghe nhc/div_Upload success'))

