import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.model.MobileDisplayObjectTreeOption as MobileDisplayObjectTreeOption
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
'Seleccionar el botón Enviar del Home'
Mobile.tap(findTestObject('Object Repository/Home/BotonEnviarHome'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Epic a Epic'
Mobile.tap(findTestObject('Object Repository/Envio/EpicAEpic'), GlobalVariable.G_ShortTime)

'Esperar aparicion campo correo...'
Mobile.waitForElementPresent(findTestObject('Object Repository/Envio/CampoCorreo'), GlobalVariable.G_ShortTime)

'Esperar aparicion campo correo...'
Mobile.tap(findTestObject('Object Repository/Envio/CampoCorreo'), GlobalVariable.G_ShortTime)

'Ingresar correo electrónico al que se envía dinero'
Mobile.setText(findTestObject('Object Repository/Envio/Ingresar Correo'), L_CorreoElectronicoEnvio, GlobalVariable.G_ShortTime)

'Ingresar motivo'
Mobile.setText(findTestObject('Object Repository/Envio/IngresarMotivo'), L_Motivo, GlobalVariable.G_ShortTime)

'Seleccionar el botón Aceptar'
Mobile.tap(findTestObject('Object Repository/Envio/BotonAceptar'), GlobalVariable.G_ShortTime)

String monto = '500'

char[] digitos = monto.toCharArray()

for (char digito : digitos) {
    String numero = digito.toString()

    Mobile.tap(findTestObject('Object Repository/Envio/TecladoNumerico', [('digitoTeclado') : numero]), GlobalVariable.G_ShortTime)
}

'Seleccionar el botón Continuar'
Mobile.tap(findTestObject('Object Repository/Envio/BotonContinuar'), GlobalVariable.G_ShortTime)

'Esperar render campo clave especial...'
Mobile.waitForElementPresent(findTestObject('Object Repository/Envio/CodigoVerificacion'), GlobalVariable.G_LongTime)

'Ingresar Código de Verificación'
Mobile.setText(findTestObject('Object Repository/Envio/CodigoVerificacion'), L_ClaveEspecial, GlobalVariable.G_ShortTime)

'Ocultar teclado'
Mobile.pressBack()

'Seleccionar el botón Confirmar'
Mobile.tap(findTestObject('Object Repository/Envio/BotonConfirmar'), GlobalVariable.G_ShortTime)

'Toma de pantalla luego de confirmar'
Mobile.takeScreenshot()

'Esperar aparicion boton inicio...'
Mobile.waitForElementPresent(findTestObject('Object Repository/Envio/BotonInicio'), GlobalVariable.G_LongTime)

'Seleccionar el botón de Inicio'
Mobile.tap(findTestObject('Object Repository/Envio/BotonInicio'), GlobalVariable.G_ShortTime)



