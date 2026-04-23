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

WebUI.callTestCase(findTestCase('TC05_AOSP_LogInClaveEspecial'), [('CorreoElectronicoInicioSesion') : 'testingstress3@yopmail.com'
        , ('Password') : 'Prueba1234!'], FailureHandling.STOP_ON_FAILURE)

def timestamp = new Date().format('YYYY-MM-dd HH:mm:ss')

TestData testData = findTestData(GlobalVariable.G_DataAnuncioCompra)

def rowCount = testData.getRowNumbers()

def sheetName = 'Anuncio'

def coll = 1

Mobile.comment('La cantidad de filas es: ' + rowCount)

'Seleccionar el botón Tardes del Home'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/TradesHome'), GlobalVariable.G_ShortTime)

'Seleccionar el botón P2P'
Mobile.tap(findTestObject('Object Repository/P2P/BotonP2P'), GlobalVariable.G_ShortTime)

'Seleccionar el botón Comprar para el anuncio generado'
Mobile.tap(findTestObject('Object Repository/P2P/BotonComprar'), GlobalVariable.G_ShortTime)

'Hacer click en  Método de Pago'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/MetodoDePago'), GlobalVariable.G_ShortTime)

'Seleccionar el Metodo de pago'
Mobile.tap(findTestObject('Object Repository/P2P/SeleccionarMetodoDePago'), GlobalVariable.G_ShortTime)

'Hacer click en  Monto'
Mobile.tap(findTestObject('Object Repository/AnuncioVenta/IngresarMonto'), GlobalVariable.G_ShortTime)

'Ingresar Monto'
for (int i = 1; i <= rowCount; i++) {
    String monto = testData.getValue('Monto', i)

    char[] digitos = monto.toCharArray()

    for (char digito : digitos) {
        Mobile.tap(findTestObject('Object Repository/Envío/TecladoNumerico', [('digitoTeclado') : digito.toString()]), GlobalVariable.G_ShortTime)
    }
}

'Hacer clic en el boton Comprar USDT'
Mobile.tap(findTestObject('Object Repository/P2P/BotonComprarUSDT'), GlobalVariable.G_ShortTime)

'Hacer clic en Clave Especial'
Mobile.tap(findTestObject('Object Repository/P2P/IngresarClaveEspecial'), GlobalVariable.G_ShortTime)

'Ingresar la Clave Especial'
Mobile.setText(findTestObject('Object Repository/P2P/IngresarClaveEspecial'), ClaveEspecial, GlobalVariable.G_ShortTime)

'Hacer clic en el boton confirmar'
Mobile.tap(findTestObject('Object Repository/P2P/BotonConfirmarFinal'), GlobalVariable.G_ShortTime)

'Hacer clic en el boton Pagada'
Mobile.tap(findTestObject('Object Repository/P2P/SeleccionarPagada'), GlobalVariable.G_ShortTime)

'Hacer clic en Aceptar en el mensaje de confirmacion '
Mobile.tap(findTestObject('Object Repository/P2P/SeleccionarAceptar'), GlobalVariable.G_ShortTime)

'Volver al home'
Mobile.tap(findTestObject('Object Repository/P2P/SeleccionarAtras'), GlobalVariable.G_ShortTime)

