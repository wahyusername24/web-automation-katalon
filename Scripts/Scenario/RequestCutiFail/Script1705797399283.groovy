import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Test Cases/Page/PageSharingVision'),
	[('action') : 'ReqCuti Fail',
	('user') : 'TestAccountKaryawan1',
	('pass') : 'P@sswordK1', ('start_date') : 'Jan 21, 2024', ('end_date') : 'Feb 6, 2024', ('ket') : 'Hal cuti tahunan merupakan hak yang dimiliki oleh setiap karyawan di perusahaan. Pada dasarnya, karyawan yang mengambil cuti tahunan ini bisa mengambil cuti sebanyak 12 hari per tahun dengan syarat karyawan sudah bekerja minimal satu tahun. Namun, jumlah dan ketentuan ini tidak bersifat permanen karena bisa bergantung pada posisi yang diduduki dan ketentuan masing-masing perusahaan.'
	 ], FailureHandling.STOP_ON_FAILURE)