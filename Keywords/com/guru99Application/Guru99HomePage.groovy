package com.guru99Application

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

@Keyword
def addCustomer(){

	WebUI.click(findTestObject('Object Repository/Page_Guru99 Bank Manager HomePage/a_New Customer'))

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/input_Customer Name_name'), "Saurabh")

	TestObject gender = new TestObject();

	gender.addProperty("xpath", ConditionType.EQUALS, "//input[@value='f']")

	WebUI.click(gender)

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/input_Date of Birth_dob'), '21-06-1989')

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/textarea_Address_addr'), 'Gurgaon')

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/input_City_city'), "Gurgaon")

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/input_State_state'), "Haryana")

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/input_PIN_pinno'), "122001")

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/input_City_city'), "Gurgaon")

	WebUI.sendKeys(findTestObject('Object Repository/Page_Guru99 Bank New Customer Entry Page/input_Mobile Number_telephoneno'), "9560666952")

	def emailId = String.format("test.%s@test.com", System.currentTimeMillis().toString())

	println emailId

	WebUI.sendKeys(findTestObject("Object Repository/Page_Guru99 Bank New Customer Entry Page/input_E-mail_emailid"), emailId)


	WebUI.sendKeys(findTestObject("Object Repository/Page_Guru99 Bank New Customer Entry Page/input_Password_password"), "Test@123")

	TestObject submitButton = new TestObject();

	submitButton.addProperty("name", ConditionType.EQUALS, "sub")

	WebUI.click(submitButton)
}

@Keyword
def getCustomerId(){

	TestObject customerId = new TestObject();

	customerId.addProperty("xpath", ConditionType.EQUALS, "//table[@id='customer']//td[text()='Customer ID']//following-sibling::td")

	def sCustomerId = WebUI.getText(customerId)

	return sCustomerId
}








