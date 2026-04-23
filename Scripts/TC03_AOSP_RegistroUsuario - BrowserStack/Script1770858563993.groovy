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

RunConfiguration.setDriverPreferencesProperty('Remote', 'autoGrantPermissions', 'true')

RunConfiguration.setDriverPreferencesProperty('Remote', 'deviceName', 'Google Pixel 9 Pro XL')

RunConfiguration.setDriverPreferencesProperty('Remote', 'platformVersion', '15.0')

'Inicializar aplicación...'
Mobile.startApplication(GlobalVariable.G_androidAppBrowserStack, true)

'Esperar hasta que aparecezca selección de idioma...'
Mobile.waitForElementPresent(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_LongTime)

'Seleccionar radioButton de idioma español'
Mobile.tap(findTestObject('Object Repository/Log in/RadioButtonIdiomaEspanol'), GlobalVariable.G_ShortTime)


'Seleccionar la opción Regístrate'
Mobile.tap(findTestObject('Object Repository/Registro Usuario/BotonRegistrate'), GlobalVariable.G_ShortTime)

'Aceptar los Términos y Condiciones'
Mobile.tap(findTestObject('Object Repository/Registro Usuario/AceptarTerminosyCondiciones'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Aceptar'
Mobile.tap(findTestObject('Object Repository/Registro Usuario/BotonAceptarModal'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Crear Cuenta'
Mobile.tap(findTestObject('Object Repository/Registro Usuario/BotonCrearCuenta'), GlobalVariable.G_ShortTime)

'Ingresar Nombre del usuario'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/CampoNombre'),Nombre , GlobalVariable.G_ShortTime)

'Ingresar Apellido del usuario'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/CampoApellido'),Apellido , GlobalVariable.G_ShortTime)

def numero = new Random().nextInt(900) + 100

String email = 'testingepic' + numero + '@yopmail.com'

'Ingresar correo electronico'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/CampoCorreoElectronico'), email, GlobalVariable.G_ShortTime)


'Ingresar Contraseña del usuario'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/Password'),Password , GlobalVariable.G_ShortTime)

'Confirmar Contraseña del usuario'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/ConfirmarPassword'),Password , GlobalVariable.G_ShortTime)

'Ingresar Código de registro del usuario'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/CodigoRegistro'),CodigoRegistro , GlobalVariable.G_ShortTime)

'Seleccionar el botón Crear Cuenta'
Mobile.tap(findTestObject('Object Repository/Registro Usuario/CrearCuenta'), GlobalVariable.G_ShortTime)

Mobile.waitForElementPresent(findTestObject('Object Repository/Registro Usuario/ClaveAccesoRapido'),  GlobalVariable.G_LongTime)

'Ingresar la Clave de Acceso Rápido'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/ClaveAccesoRapido'),ClaveAccesoRapido , GlobalVariable.G_ShortTime)

'Confirmar la Clave de Acceso Rápido'
Mobile.setText(findTestObject('Object Repository/Registro Usuario/ConfirmarClaveAccesoRapido'),ClaveAccesoRapido , GlobalVariable.G_ShortTime)

'Seleccionar el botón Continuar'
Mobile.tap(findTestObject('Object Repository/Registro Usuario/BotonContinuarFinal'), GlobalVariable.G_ShortTime)


'Seleccionar el botón Inicio'
Mobile.tap(findTestObject('Object Repository/Registro Usuario/BotonInicio'), GlobalVariable.G_ShortTime)

