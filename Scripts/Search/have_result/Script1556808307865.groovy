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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.exception.StepErrorException as StepErrorException

WebUI.openBrowser('https://music-iteazy.herokuapp.com/')

WebUI.navigateToUrl('https://music-iteazy.herokuapp.com/')

WebUI.setText(findTestObject('Search/Page_App nghe nhc/input_Collection_search'), testTitle)

WebUI.sendKeys(findTestObject('Search/Page_App nghe nhc/input_Collection_search'), Keys.chord(Keys.ENTER))

WebUI.verifyElementVisible(findTestObject('Search/Page_App nghe nhc/Songs available'), FailureHandling.STOP_ON_FAILURE)

result = WebUI.getText(findTestObject('Search/Page_App nghe nhc/Songs available'))

WebUI.verifyMatch(result, "[0-9] Songs available", true)

String[] temp = result.split(" ")
Integer count = Integer.parseInt(temp[0])

for(int i = 1; i <= count; i++) {
	String xpath =  "/html[1]/body[1]/main[@class=\"container\"]/div[@class=\"content index\"]/div[@class=\"row\"]/div[@class=\"col-md-8\"]/ul[1]/li[" + i + "]/div[@class=\"row col-12\"]/div[@class=\"col-md-9\"]/div[@class=\"row col-12\"]/p[@class=\"song-title text-white\"]/a[1]"
	
	TestObject ob = findTestObject("Search/Page_App nghe nhc/div_title")
	ob.findProperty("xpath").setValue(xpath)
	
	title = WebUI.getText(ob)
	
	String[] arrTitle = title.split(" ")
	Boolean flags = false
	for (int j = 0; j < arrTitle.length; j++) {
		System.out.println(testTitle.toLowerCase())
		System.out.println(arrTitle[j].toLowerCase())
		if (testTitle.toLowerCase() == arrTitle[j].toLowerCase()) {
			flags = true
		}
	}
	if(flags == false) {
		throw new StepErrorException("Result not correct")
	}
}
