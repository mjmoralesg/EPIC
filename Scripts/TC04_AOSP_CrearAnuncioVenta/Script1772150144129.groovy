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
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.TestData as TestData

WebUI.callTestCase(findTestCase('TC01_AOSP_LogIn'), [('CorreoElectronicoInicioSesion') : 'automationvicky@yopmail.com', ('Password') : 'Prueba1234!'],
	FailureHandling.STOP_ON_FAILURE)

def timestamp = new Date().format('YYYY-MM-dd HH:mm:ss')

TestData testData = findTestData(GlobalVariable.G_DataAnuncioCompra)
def rowCount = testData.getRowNumbers()

def sheetName = 'Anuncio'

def coll = 1


Mobile.comment('La cantidad de filas es: '+rowCount)

Mobile.waitForElementPresent(findTestObject('Object Repository/AnuncioVenta/TradesHome'), GlobalVariable.G_LongTime)

'Seleccionar el botón Tardes del Home'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/TradesHome'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Anuncios'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/Anuncios'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Nuevo Anuncio'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/NuevoAnuncio'), GlobalVariable.G_ShortTime)

'Seleccionar el Tipo de Anuncio'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/SeleccionarTipoAnuncio'), GlobalVariable.G_ShortTime)

'Seleccionar el Tipo Venta'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/SeleccionarTipoVenta'), GlobalVariable.G_ShortTime)

'Hacer click en  Moneda a Entregar'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/MonedaAEntregar'), GlobalVariable.G_ShortTime)

'Seleccionar moneda a entregar VES'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/MonedaVES'), GlobalVariable.G_ShortTime)

'Hacer click en  Moneda a Recibir'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/MonedaARecibir'), GlobalVariable.G_ShortTime)

'Seleccionar moneda a recibir USDT'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/RecibirUSDT'), GlobalVariable.G_ShortTime)

'Ingresar Tasa de Cambio'
for (int i = 1; i <= rowCount; i++) {
	
		String monto = testData.getValue('TasaCambio', i)
		char[] digitos = monto.toCharArray()
	
		for (char digito : digitos) {
			Mobile.tap(
				findTestObject(
					'Object Repository/Envio/TecladoNumerico',
					[('digitoTeclado') : digito.toString()]
				),
				GlobalVariable.G_ShortTime
			)
		}
	}
	
'Hacer click en  Monto'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/IngresarMonto'), GlobalVariable.G_ShortTime)

'Ingresar Monto'
for (int i = 1; i <= rowCount; i++) {
	
		String monto = testData.getValue('Monto', i)
		char[] digitos = monto.toCharArray()
	
		for (char digito : digitos) {
			Mobile.tap(
				findTestObject(
					'Object Repository/Envio/TecladoNumerico',
					[('digitoTeclado') : digito.toString()]
				),
				GlobalVariable.G_ShortTime
			)
		}
	}

'Seleccionar el botón Continuar'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/BotonContinuar'), GlobalVariable.G_ShortTime)

'Hacer click en  Tiempo Límite'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/TiempoLimite'), GlobalVariable.G_ShortTime)

'Seleccionar la opción 45 minutos de Tiempo Límite'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/Seleccionar45minutos'), GlobalVariable.G_ShortTime)

'Hacer click en  Método de Pago'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/MetodoDePago'), GlobalVariable.G_ShortTime)

'Seleccionar el único método de pago disponible'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/SeleccionarMetodoDePago'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Enviar'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/BotonEnviar'), GlobalVariable.G_ShortTime)

'Obtener clave OTP desde Yopmail'
codeOTP = CustomKeywords.'com.epic.yopmail.YopmailReader.getOTP'(CorreoOTP)
 
Mobile.comment('Clave obtenida: ' + codeOTP)

'Ingresar Código de Verificación'
Mobile.setText(findTestObject('Object Repository/Envio/CodigoVerificacion'),codeOTP , GlobalVariable.G_ShortTime)

'Seleccionar el botón Confirmar final'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/BotonConfirmarFinal'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Inicio'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/BotonInicio'), GlobalVariable.G_ShortTime)


