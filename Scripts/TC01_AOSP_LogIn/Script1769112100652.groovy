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
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

def timestamp = new Date().format('YYYY-MM-dd HH:mm:ss')

def path = (RunConfiguration.getProjectDir() + '/') + GlobalVariable.G_NombreAPK


'Inicializar aplicacion....'
Mobile.startApplication(path, true)

Mobile.waitForElementPresent(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_LongTime)

'Seleccionar radioButton de idioma español '
Mobile.tap(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_ShortTime)

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

Mobile.waitForElementPresent(findTestObject('Object Repository/Log in/CodigoOTP'), GlobalVariable.G_LongTime)

//Mobile.tap(findTestObject('Object Repository/Log in/CodigoOTP'), GlobalVariable.G_ShortTime)

'Obtener clave OTP desde Yopmail'
codeOTP = CustomKeywords.'com.epic.yopmail.YopmailReader.getOTP'(L_CorreoElectronicoInicioSesion)

Mobile.comment('Clave obtenida: ' + codeOTP)

'Ingresar Código de Verificación'
Mobile.setText(findTestObject('Object Repository/Log in/CodigoOTP'), codeOTP, GlobalVariable.G_ShortTime)

'Seleccionar el botón Confirmar'
Mobile.tap(findTestObject('Object Repository/Log in/BotonConfirmarOTP'), GlobalVariable.G_ShortTime)

char[] digitos = L_ClaveEspecial.toCharArray()

for (char digito : digitos) {
    Mobile.tap(findTestObject('Object Repository/Log in/TecladoNumerico', [('digitoTeclado') : digito.toString()]), GlobalVariable.G_ShortTime)
}
