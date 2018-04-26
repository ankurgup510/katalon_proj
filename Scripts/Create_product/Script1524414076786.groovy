import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.remote.server.handler.SendKeys as SendKeys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory



ExcelData data = findTestData('Sign_in/Excel_file')

ExcelData data_1 = findTestData('Create_product/product_new')

for (def index : (1..data.getRowNumbers())) {
    WebUI.openBrowser('https://pwa.earthsquad.global')

	WebDriver driver = DriverFactory.getWebDriver()
    WebUI.delay(10)

    WebUI.sendKeys(findTestObject('Sign-in/Username'), findTestData('Sign_in/Excel_file').getValue('Username', index))

    WebUI.sendKeys(findTestObject('Sign-in/Password'), findTestData('Sign_in/Excel_file').getValue('PWD', index))

    WebUI.click(findTestObject('Sign-in/Submit'))

    WebUI.delay(20)

    String str = WebUI.getText(findTestObject('Sign-in/Change_detail'))
	println(str )
    if (str.equals('Change details')) {
        println('logged in')

        WebUI.click(findTestObject('Object Repository/Create_product/Scan_page'))

        WebUI.delay(10)

        WebUI.click(findTestObject('Object Repository/Create_product/Scan_page2'))

        WebUI.delay(10)

        WebUI.sendKeys(findTestObject('Object Repository/Create_product/Bar_code'), findTestData('Create_product/product_new').getValue(
                'Barcode', index))

        WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Create_product/Continue'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Create_product/Continue_2'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Create_product/Yes'))
		WebUI.delay(10)
		
		WebUI.click(findTestObject('Object Repository/Create_product/Snap'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Create_product/Done'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Create_product/Product_button'))
				WebUI.delay(5)
		
	    WebUI.sendKeys(findTestObject('Object Repository/Create_product/Input_search'), findTestData('Create_product/product_new').getValue(
						'Product_type', index))
		
	    WebUI.delay(5)
	   
	    WebUI.sendKeys(findTestObject('Object Repository/Create_product/Product_Name'), findTestData('Create_product/product_new').getValue(
					   'Name', index))
	   
	    WebUI.delay(5)
	
	    str = findTestData('Create_product/product_new').getValue('Generic', index)
		if(str.equals("true"))
		{
	     WebUI.click(findTestObject('Object Repository/Create_product/Toggle'))
	     println(str)
		}
		 if(!str.equals("true"))
		{
			println("NOT TRUE")
		}
		WebUI.delay(5)
		
	   WebUI.sendKeys(findTestObject('Object Repository/Create_product/Product_description'), findTestData('Create_product/product_new').getValue(
						'Description', index))
	 WebUI.delay(5)
	 WebUI.click(findTestObject('Object Repository/Create_product/Recycling_material'))
	 WebUI.delay(5)
	 
	
	 WebUI.sendKeys(findTestObject('Object Repository/Create_product/Recycle_search'), findTestData('Create_product/product_new').getValue(
						'PackMat1', index))
	 
	
	 WebUI.delay(5)
	 println (WebUI.getText(findTestObject('Object Repository/Registration/Recycle_key1')))
	 println (findTestData('Create_product/product_new').getValue('PackMat1', index))
	 
	 if (WebUI.getText(findTestObject('Object Repository/Registration/Recycle_key1')).contentEquals(findTestData('Create_product/product_new').getValue(
						'PackMat1', index))) {
		 WebUI.click(findTestObject('Object Repository/Registration/Recycle_key1'))
	}
						
	WebUI.delay(5)
						
	println (WebUI.getText(findTestObject('Object Repository/Registration/Recycle_key2')))
	println (findTestData('Create_product/product_new').getValue('PackMat1', index))
						
	if (WebUI.getText(findTestObject('Object Repository/Registration/Recycle_key2')).contentEquals(findTestData('Create_product/product_new').getValue( 'PackMat1', index))) {
		WebUI.click(findTestObject('Object Repository/Registration/Recycle_key2'))
	  }
	WebUI.delay(5)
	
	println(findTestData('Create_product/product_new').getValue('Packmat2', index).length()) 
	if(findTestData('Create_product/product_new').getValue('Packmat2', index).length()>0)
	{
		WebUI.sendKeys(findTestObject('Object Repository/Create_product/Recycle_search'), findTestData('Create_product/product_new').getValue(
			'Packmat2', index))

		WebUI.delay(5)
		println (WebUI.getText(findTestObject('Object Repository/Registration/Recycle_key1')))
		println (findTestData('Create_product/product_new').getValue('Packmat1', index))
		
		
		   
	}
	
	
	 WebUI.click(findTestObject('Object Repository/Create_product/Save'))
	 WebUI.delay(15)
		} else {
        println('failed to login')
    }
    
    WebUI.closeBrowser()
}

