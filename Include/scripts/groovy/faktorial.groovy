import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class faktorial {

	String simbol, integer, decimal;

	@Given("Open browser")
	def Open_Browser() {
		WebUI.openBrowser('');
		WebUI.navigateToUrl('https://qa.putraprima.id/')
	}

	@When("Input value faktorial (.*)")
	def Input_value_faktorial(String value) {
		WebUI.delay(2);
		WebUI.verifyTextPresent('Kalkulator Faktorial', true);

		if(value == 'integer') {
			integer = '1';
			println integer;
			WebUI.setText(findTestObject('input_angka_faktorial'), integer);
		}
		if(value == 'decimal') {
			decimal = '2.3';
			WebUI.setText(findTestObject('input_angka_faktorial'), decimal);
		}
		if(value == 'simbol') {
			simbol = '!@#$%^&*()';
			WebUI.setText(findTestObject('input_angka_faktorial'), simbol);
		}
	}

	@And("Tap hitung faktorial the button")
	def Tap_hitung_faktorial_the_button() {
		WebUI.click(findTestObject('hitung_faktorial_button'));
	}
	@Then("Close Browser")
	def Close_Browser() {
		WebUI.closeBrowser();
	}

	@Then("Validation after input faktorial (.*)")
	def Validation_after_input_faktorial(String value) {

		if(value == 'Success') {
			String exData = 'Faktorial dari 1 adalah: ' + integer;
			println 'Success';
			String acData = WebUI.getText(findTestObject('validation_alert'));
			println acData;
			println exData;
			WebUI.verifyMatch(acData, exData, true)
			
		}else
		if(value == 'Failed') {
			println 'Failed';
			String acData = WebUI.getText(findTestObject('validation_alert'));
			WebUI.verifyMatch(acData, 'Please, enter an number only', FailureHandling.STOP_ON_FAILURE);
		}else {
			println 'Failed kosong';
			integer = 'Failed koson';
			WebUI.verifyElementNotVisible(findTestObject('validation_alert'));
		}
		Close_Browser();
	}

	@And("Tap terms of services")
	def Tap_terms_of_services() {
		WebUI.click(findTestObject('terms_of_services_text'));
	}

	@And("Validation link terms of services")
	def Validation_link_terms_of_services() {
		WebUI.verifyElementNotVisible(findTestObject('terms_of_services_text'));
		Close_Browser();
	}

	@And("Tap privacy policy")
	def Tap_privacy_policy() {
		WebUI.click(findTestObject('privacy_policy_text'));
	}

	@And("Validation link policy")
	def Validation_link_policy() {
		WebUI.verifyElementNotVisible(findTestObject('privacy_policy_text'));
		Close_Browser()
	}
}