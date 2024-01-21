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
import org.apache.poi.ss.usermodel.*


WebUI.openBrowser(GlobalVariable.PageUrl)

WebUI.maximizeWindow()


if (action == 'Login Success'){
	WebUI.waitForElementPresent(findTestObject('Object Repository/LoginPageHRSV/welcome_page'),2)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/username'), user)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/password'), pass)
	
	WebUI.click(findTestObject('Object Repository/LoginPageHRSV/button_login'))
	
	WebUI.delay(2)

	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/page_title'))
	
	WebUI.delay(5)
	
	WebUI.verifyElementText(findTestObject('Object Repository/HomePageHRSV/profile_name'), 'TestAccountKaryawan1')
		
	WebUI.closeBrowser()	
}

if (action == 'Login Fail') {
	WebUI.waitForElementPresent(findTestObject('Object Repository/LoginPageHRSV/welcome_page'),2)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/username'), user)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/password'), pass)
	
	WebUI.click(findTestObject('Object Repository/LoginPageHRSV/button_login'))
	
	WebUI.delay(2)
	
	x = WebUI.verifyElementPresent(findTestObject('Object Repository/LoginPageHRSV/invalid_message'),2)
	
	if(x) {
		WebUI.comment('Negative Case Pass')
	}else{
		WebUI.comment('Negative Case Fail')
	}	
	
	WebUI.closeBrowser()	
}

if(action == 'Add Logbook') {
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/LoginPageHRSV/welcome_page'),2)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/username'), user)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/password'), pass)
	
	WebUI.click(findTestObject('Object Repository/LoginPageHRSV/button_login'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/page_title'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/logbook_menu'))
	
	WebUI.delay(1)
	
	WebUI.verifyElementText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/logbook_title'), 'History Logbook')
			
	WebUI.delay(2)
	
	// Read Test Data Excel
	def testData = findTestData('Data Files/Data')
	def DataSize = testData.getRowNumbers()
	
	for (def i = 1; i <= DataSize; i++) {
		def tgl = testData.getValue('tgl', i)
		def j_mulai = testData.getValue('j_mulai', i)
		def j_selesai = testData.getValue('j_selesai', i)
		def mode_kerja = testData.getValue('mode_kerja', i)
		def project = testData.getValue('project', i)
		def nama_tim = testData.getValue('nama_tim', i)
		def use_case = testData.getValue('use_case', i)
		def kegiatan = testData.getValue('kegiatan', i)
		def hasil = testData.getValue('hasil', i)
		def capaian = testData.getValue('capaian', i)
		def next_step = testData.getValue('next_step', i)
		def path = testData.getValue('path', i)
		def detail_pekerjaan = testData.getValue('detail_pekerjaan', i)
		def w_kerja = testData.getValue('w_kerja', i)
		
		// Click "Add Logbook" button
		WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/addlogbook_btn'))
		WebUI.delay(2)
		
		// Input form data
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/clickdate'), tgl)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/jam_mulai'), j_mulai)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/jam_selesai'), j_selesai)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/mode_kerja'), mode_kerja)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/project'), project)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/nama_tim'), nama_tim)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/use_case'), use_case)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/kegiatan'), kegiatan)		
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/hasil'), hasil)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/capaian'), capaian)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/next_step'), next_step)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/path_filename'), path)
		WebUI.setText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/detail_pekerjaan'), detail_pekerjaan)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/waktu_kerja'), w_kerja)
		
		// Click "Submit" button
		WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/logbook_submit_btn'))
		WebUI.delay(1)
		
		try {
			// Assuming wait for success message
			WebUI.waitForElementVisible(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/popup_success'), 10)
						
			// Handle success popup
			WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/ok_popup'))
		} catch (Exception e) {
			// Handle error popup
			WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/InputForm/ok_popup_error'))
		}
	}
	WebUI.closeBrowser()
}

if(action == 'Delete Logbook') {
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/LoginPageHRSV/welcome_page'),2)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/username'), user)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/password'), pass)
	
	WebUI.click(findTestObject('Object Repository/LoginPageHRSV/button_login'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/page_title'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/logbook_menu'))
	
	WebUI.verifyElementText(findTestObject('Object Repository/HomePageHRSV/LogbookPage/logbook_title'), 'History Logbook')
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/checkbox1'),2)
	WebUI.check(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/checkbox1'))
	WebUI.check(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/checkbox1'))
	WebUI.delay(1)
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/delete_btn'))
	WebUI.delay(1)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/confirmation_del'))
	WebUI.delay(1)
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/delete_final'))
	WebUI.delay(2)
	WebUI.waitForElementPresent(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/final_success'),3)
	WebUI.delay(1)

	WebUI.click(findTestObject('Object Repository/HomePageHRSV/LogbookPage/DeleteLogbook/close_popup'))
	WebUI.closeBrowser()
}

if(action == 'ReqCuti Success') {
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/LoginPageHRSV/welcome_page'),2)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/username'), user)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/password'), pass)
	
	WebUI.click(findTestObject('Object Repository/LoginPageHRSV/button_login'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/page_title'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/cutilembur_menu'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/cuti_menu'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/page_title_cuti'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/cuti_btn'))
	
	WebUI.verifyElementText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/form_cuti'), 'Form Pengajuan Cuti')
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/tgl'))
	WebUI.setText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/tgl_start'),start_date)
	WebUI.setText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/tgl_finish'), end_date)
	WebUI.doubleClick(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/tap_outside_box'))
	WebUI.delay(1)
	WebUI.verifyElementPresent(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/count_days'), 17)

	WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/jenis_cuti'), 1); 	
	WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/nama_pic'), 2);
	WebUI.setText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/keterangan'),ket)

	WebUI.dragAndDropByOffset(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/ttd'), 10, 150)
	WebUI.delay(1)
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/submit_btn'))
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/success_message'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Cuti/close_popup'))
	WebUI.delay(3)
	
	WebUI.closeBrowser()	
}

if(action == 'ReqLembur Success') {
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/LoginPageHRSV/welcome_page'),2)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/username'), user)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/password'), pass)
	
	WebUI.click(findTestObject('Object Repository/LoginPageHRSV/button_login'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/page_title'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/cutilembur_menu'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/lembur_menu'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/riwayat_lembur_title'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/lembur_btn'))
	
	WebUI.verifyElementText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/form_lembur_title'), 'Form Pengajuan Lembur')
	
	WebUI.setText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/input_tgl'), tgl)
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/input_jam_mulai'))
	
	WebUI.setText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/input_jam_mulai'), clock_in)
	
	WebUI.setText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/input_jam_selesai'), clock_out)
	
	WebUI.verifyElementText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/total_jam'), verify_hours)

	WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/jenis_lembur'), 2)

	WebUI.selectOptionByIndex(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/pic'), 4)
	
	
	WebUI.setText(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/ket'), ket)
	
	WebUI.doubleClick(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/ttd'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/submit_btn'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/success_message'))
	
	WebUI.click(findTestObject('Object Repository/HomePageHRSV/CutidanLemburPage/Lembur/okay_btn'))
	WebUI.delay(3)
	
	WebUI.closeBrowser()
}

if(action == 'Logout') {
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/LoginPageHRSV/welcome_page'),2)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/username'), user)
	
	WebUI.setText(findTestObject('Object Repository/LoginPageHRSV/password'), pass)
	
	WebUI.click(findTestObject('Object Repository/LoginPageHRSV/button_login'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePageHRSV/page_title'))
	
}
	

