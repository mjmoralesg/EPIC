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

def timestamp = new Date().format('YYYY-MM-dd HH:mm:ss')

def path = (RunConfiguration.getProjectDir() + '/') + GlobalVariable.G_NombreAPK

'Inicializar aplicacion....'
Mobile.startApplication(path, true)

if (Mobile.verifyElementExist(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_LongTime, 
    FailureHandling.OPTIONAL)) {
    'Seleccionar radioButton de idioma español '
    Mobile.tap(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_ShortTime)
}

Mobile.waitForElementPresent(findTestObject('Object Repository/Log in/CorreoElectronicoInicioSesion'), GlobalVariable.G_LongTime)

'Ingresar correo electrónico'
Mobile.setText(findTestObject('Object Repository/Log in/CorreoElectronicoInicioSesion'), CorreoElectronicoInicioSesion, 
    GlobalVariable.G_ShortTime)

'Ingresar contraseña'
Mobile.setText(findTestObject('Object Repository/Log in/Password'), Contrasena, GlobalVariable.G_ShortTime)

'Tomar captura'
Mobile.takeScreenshot()

'Boton Ingresar'
Mobile.tap(findTestObject('Object Repository/Log in/BotonIngresarInicioSesion'), GlobalVariable.G_ShortTime)

if (Mobile.verifyElementExist(findTestObject('Object Repository/Log in/IngresoClaveEspecial'), GlobalVariable.G_LongTime, 
    FailureHandling.OPTIONAL)) {
    Mobile.delay(GlobalVariable.G_ShortTime)

    'Ingresar clave especial'
    Mobile.setText(findTestObject('Object Repository/Log in/IngresoClaveEspecial'), IngresoClaveEspecial, GlobalVariable.G_ShortTime)

    Mobile.takeScreenshot()

    'Boton confirmar clave especial'
    Mobile.tap(findTestObject('Object Repository/Log in/BotonConfirmarClaveEspecial'), GlobalVariable.G_ShortTime)
}

Mobile.waitForElementPresent(findTestObject('Object Repository/Home/BotonEnviarHome'), GlobalVariable.G_LongTime)