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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
/*
WebUI.callTestCase(findTestCase('TC05_AOSP_LogInClaveEspecial - BrowserStack'), [('L_CorreoElectronicoInicioSesion') : 'annabella181@hotmail.com'
        , ('L_Contrasena') : 'abC.12345', ('L_ClaveEspecial') : '1912', ('L_ClaveAccesoRapido') : '3333'], FailureHandling.STOP_ON_FAILURE)
*/
'Icono Ingresar Dinero'
Mobile.tap(findTestObject('Object Repository/Ingresar dinero/IconoIngresarDinero'), GlobalVariable.G_ShortTime)

'Boton Cripto'
Mobile.tap(findTestObject('Object Repository/Ingresar dinero/BotonCripto'), GlobalVariable.G_ShortTime)

'Opcion USDT'
Mobile.tap(findTestObject('Object Repository/Ingresar dinero/OpcionUSDT'), GlobalVariable.G_ShortTime)

'Seleccion Red Tron Testnet Nile'
Mobile.tap(findTestObject('Object Repository/Ingresar dinero/SeleccionRedTronTestnetNile'), GlobalVariable.G_ShortTime)

Mobile.waitForElementPresent(findTestObject('Object Repository/Ingresar dinero/BotonCopiarDireccion'), GlobalVariable.G_LongTime)

'Boton copiar direccion'
Mobile.tap(findTestObject('Object Repository/Ingresar dinero/BotonCopiarDireccion'), GlobalVariable.G_ShortTime)

'Ir atras Flecha del Back'
Mobile.tap(findTestObject('Object Repository/Ingresar dinero/FlechaBack1'), GlobalVariable.G_ShortTime)

'Ir atras Flecha del Back'
Mobile.tap(findTestObject('Object Repository/Ingresar dinero/FlechaBack2'), GlobalVariable.G_ShortTime)

'Tomar captura'
Mobile.takeScreenshot()

