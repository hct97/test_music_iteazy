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

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/a_Playlist'))

xPath = "/html[1]/body[1]/main[@class=\"container\"]/div[@class=\"row\"]/div[@class=\"col-md-12\"]/ol[1]/li[" + 1 + "]/h5/a"
TestObject ob = findTestObject("Object Repository/Playlist/Page_App nghe nhc/a_playlistname")
ob.findProperty("xpath").setValue(xPath)
playlistName = WebUI.getText(ob)
WebUI.click(ob)

xPath1 = "/html[1]/body[1]/main[@class=\"container\"]/div[@class=\"content\"]/ul[1]/li[" + 1 + "]/div[@class=\"row col-12\"]/div[@class=\"col-md-9\"]/div[@class=\"row col-12\"]/p[@class=\"song-title text-white\"]/a[1]"
TestObject ob1 = findTestObject("Object Repository/Playlist/Page_App nghe nhc/a_title")
ob1.findProperty("xpath").setValue(xPath1)
title = WebUI.getText(ob1)
WebUI.click(ob1)


WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/a_ADD TO PLAYLIST'))

Thread.sleep(2000)

WebUI.selectOptionByValue(findTestObject('Object Repository/Playlist/Page_App nghe nhc/select_playlist'), playlistName, true)

WebUI.click(findTestObject('Object Repository/Playlist/Page_App nghe nhc/input_Select playlist_commit'))

Thread.sleep(2000)

result = WebUI.getText(findTestObject('Object Repository/Playlist/Page_App nghe nhc/div_Added to playlist'))

WebUI.verifyMatch(result, 'Can\'t Add To This Playlist', true)
