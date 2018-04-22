import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

ExcelData data = findTestData('Excel file')

for (def index : (1..data.getRowNumbers())) {
WebUI.openBrowser('https://pwa.earthsquad.global')

WebUI.delay(10)

WebUI.click(findTestObject('register_button'))

WebUI.delay(10)

WebUI.waitForElementPresent(findTestObject('Title_register'), 50)

WebUI.sendKeys(findTestObject('Username'), findTestData('Excel file').getValue('Username', index))

WebUI.sendKeys(findTestObject('Email'), findTestData('Excel file').getValue('E-Mail', index))

WebUI.sendKeys(findTestObject('Password'), findTestData('Excel file').getValue('PWD', index))

WebUI.sendKeys(findTestObject('Password_2'), findTestData('Excel file').getValue('PWD', index))

WebUI.click(findTestObject('Submit'))
WebUI.delay(20)
 String str=  WebUI.getText(findTestObject('Object Repository/Change_detail'))
 if (str.equals("Change Detail"))
 println "logged in"
 else
 println "failed to login"
WebUI.closeBrowser()
}
