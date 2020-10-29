import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.openqa.selenium.Keys as Keys

class Common {

	String textInput
	String textValue

	/* The step definitions below match with Katalon sample Gherkin steps */

	@Given("I open default page")
	def I_open_default_page() {
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.maximizeWindow()
		sleep(4)
	}

	@When("I click '(.*)'")
	def I_click(String elme) {
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/'+elme))
	}

	@When("I select '(.*)' on '(.*)'")
	def I_select_on(String value, String elme) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/'+elme), 10)
		WebUI.selectOptionByValue(findTestObject(elme), value, false)
	}

	@When("I should see '(.*)'")
	def I_should_see(String txt) {
		WebUI.verifyTextPresent(txt, false)
	}

	@When("I type '(.*)' on '(.*)'")
	def I_type_on(String txt, String elme) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/'+elme), 10)
		WebUI.setText(findTestObject('Object Repository/'+elme), txt)
	}

	@When("I should see text '(.*)' on '(.*)'")
	def I_should_see_text_on(String txt, String elme) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/'+elme), 10)
		WebUI.verifyElementText(findTestObject('Object Repository/'+elme), txt)
	}
}