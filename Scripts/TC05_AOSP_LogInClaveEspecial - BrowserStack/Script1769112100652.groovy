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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

RunConfiguration.setDriverPreferencesProperty('Remote', 'autoGrantPermissions', 'true')

RunConfiguration.setDriverPreferencesProperty('Remote', 'deviceName', 'Google Pixel 9 Pro XL')

RunConfiguration.setDriverPreferencesProperty('Remote', 'platformVersion', '15.0')

'Inicializar aplicación...'
Mobile.startApplication(GlobalVariable.G_androidAppBrowserStack, true)

'Esperar hasta que aparecezca selección de idioma...'
Mobile.waitForElementPresent(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_LongTime)

'Seleccionar radioButton de idioma español'
Mobile.tap(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_ShortTime)

'Esperar hasta que aparezca campo de usuario...'
Mobile.waitForElementPresent(findTestObject('Object Repository/Log in/CorreoElectronicoInicioSesion'), GlobalVariable.G_LongTime)

'Ingresar correo electrónico'
Mobile.setText(findTestObject('Object Repository/Log in/CorreoElectronicoInicioSesion'), L_CorreoElectronicoInicioSesion, 
    GlobalVariable.G_ShortTime)

'Ingresar contraseña'
Mobile.setText(findTestObject('Object Repository/Log in/Password'), L_Contrasena, GlobalVariable.G_ShortTime)

'Tomar captura'
Mobile.takeScreenshot()

'Boton Ingresar'
Mobile.tap(findTestObject('Object Repository/Log in/BotonIngresarInicioSesion'), GlobalVariable.G_ShortTime)

if (Mobile.verifyElementExist(findTestObject('Object Repository/Log in/IngresoClaveEspecial'), GlobalVariable.G_LongTime, 
    FailureHandling.OPTIONAL)) {

    'Ingresar clave especial'
    Mobile.setText(findTestObject('Object Repository/Log in/IngresoClaveEspecial'), L_ClaveEspecial, GlobalVariable.G_ShortTime)

    'Boton confirmar clave especial'
    Mobile.tap(findTestObject('Object Repository/Log in/BotonConfirmarClaveEspecial'), GlobalVariable.G_ShortTime)
}

'Esperar hasta que aparezca el ingreso a la clave acceso rapido...'
Mobile.waitForElementPresent(findTestObject('Object Repository/Log in/TituloClaveAccesoRapido'), GlobalVariable.G_LongTime)

char[] digitos = L_ClaveAccesoRapido.toCharArray()

for (char digito : digitos) {
    'Clickear en teclado clave especial rapida'
    Mobile.tap(findTestObject('Object Repository/Log in/TecladoNumerico', [('digitoTeclado') : digito.toString()]), GlobalVariable.G_ShortTime)
}

'Esperar hasta llegar al home'
Mobile.waitForElementPresent(findTestObject('Object Repository/Home/BotonEnviarHome'), GlobalVariable.G_LongTime)

