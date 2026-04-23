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

Mobile.waitForElementPresent(findTestObject('Object Repository/Retiro/IconoRetirar'), GlobalVariable.G_LongTime)

'Icono Retirar'
Mobile.tap(findTestObject('Object Repository/Retiro/IconoRetirar'), GlobalVariable.G_LongTime)

Mobile.waitForElementPresent(findTestObject('Object Repository/Retiro/BotonRedBlockchain'), GlobalVariable.G_LongTime)

'Boton Red Blockchain'
Mobile.tap(findTestObject('Object Repository/Retiro/BotonRedBlockchain'), GlobalVariable.G_LongTime)

'Seleccionar campo cuenta cripto'
Mobile.tap(findTestObject('Object Repository/Retiro/CampoCuentaCripto'), GlobalVariable.G_LongTime)

'Ingresar cuenta cripto'
Mobile.setText(findTestObject('Object Repository/Retiro/IngresoCTACripto'), CuentaCripto, GlobalVariable.G_LongTime)

'Tomar captura'
Mobile.takeScreenshot()

'Boton Aceptar'
Mobile.tap(findTestObject('Object Repository/Retiro/BotonAceptar'), GlobalVariable.G_ShortTime)

'Campo seleccion de Red'
Mobile.tap(findTestObject('Object Repository/Retiro/CampoSeleccioneRed'), GlobalVariable.G_ShortTime)

Mobile.waitForElementPresent(findTestObject('Object Repository/Retiro/BotonSeleccionRedTron'), GlobalVariable.G_LongTime)

'Boton seleccion Red Tron'
Mobile.tap(findTestObject('Object Repository/Retiro/BotonSeleccionRedTron'), GlobalVariable.G_ShortTime)

'Ingresar primer digito del monto'
Mobile.tap(findTestObject('Object Repository/Envio/TecladoNumerico', [('digitoTeclado') : '1']), GlobalVariable.G_ShortTime)

'Ingresar segundo digito del monto'
Mobile.tap(findTestObject('Object Repository/Envio/TecladoNumerico', [('digitoTeclado') : '0']), GlobalVariable.G_ShortTime)

'Ingresar tercer digito del monto'
Mobile.tap(findTestObject('Object Repository/Envio/TecladoNumerico', [('digitoTeclado') : '0']), GlobalVariable.G_ShortTime)

'Ingresar cuarto digito del monto'
Mobile.tap(findTestObject('Object Repository/Envio/TecladoNumerico', [('digitoTeclado') : '0']), GlobalVariable.G_ShortTime)

'Boton Continuar'
Mobile.tap(findTestObject('Object Repository/Retiro/BotonContinuar'), GlobalVariable.G_ShortTime)

'Ingresar Clave Especial'
Mobile.setText(findTestObject('Object Repository/Retiro/IngresoCE'), ClaveEspecial, GlobalVariable.G_ShortTime)

'Ocultar teclado'
Mobile.pressBack()

'Boton Confirmar'
Mobile.tap(findTestObject('Object Repository/Retiro/BotonConfirmar'), GlobalVariable.G_ShortTime)

Mobile.waitForElementPresent(findTestObject('Object Repository/Retiro/CerrarModal'), GlobalVariable.G_LongTime)


'Tomar captura'
Mobile.takeScreenshot()

'Cerrar modal de exito'
Mobile.tap(findTestObject('Object Repository/Retiro/CerrarModal'), GlobalVariable.G_ShortTime)



