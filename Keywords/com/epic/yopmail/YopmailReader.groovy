package com.epic.yopmail

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword

import com.kms.katalon.core.checkpoint.Checkpoint

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.model.FailureHandling

import com.kms.katalon.core.testcase.TestCase

import com.kms.katalon.core.testdata.TestData

import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import org.w3c.dom.NodeList

import java.util.List

import org.openqa.selenium.By

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;

public class YopmailReader {

	@Keyword
	def String getOTP(String correo) {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless=new");

		options.addArguments("--disable-gpu");

		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		int intentosMaximos = 3;

		String codeOtp = null;

		try {

			def url = 'http://www.yopmail.com?'+ correo

			driver.get(url);

			for (int i = 0; i < intentosMaximos; i++) {

				Thread.sleep(5000);

				println("Paso:: 1 ")

				driver.switchTo().defaultContent();

				WebElement buttonRefrescar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='refresh']")));

				println("Paso:: 2 ")

				buttonRefrescar.click();

				Thread.sleep(5000);

				println("Paso:: 3 ")

				driver.switchTo().frame("ifmail");

				if (isElementPresent(driver, By.xpath("//td[normalize-space()='Advertencia de sesión duplicada']"))) {

					println("Paso:: 4 ")

					WebElement buttonEliminar = driver.findElement(By.xpath("//header/div[2]/button[2]"));

					buttonEliminar.click();

					Thread.sleep(5000);

					//println("Paso:: 5 ")

					//driver.switchTo().defaultContent();

					//buttonRefrescar.click();

					//Thread.sleep(5000);

					//println("Paso:: 6 ")

					//driver.switchTo().frame("ifmail");
				}


				println("Paso:: 7 ")

				WebElement strongInIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//b)[1]")));

				codeOtp = strongInIframe.getText();

				if (codeOtp != null && codeOtp.matches("\\d+")) {

					break;
				}
			}

			println("codeOtp:: "+ codeOtp)

			return codeOtp;
		} finally {

			driver.quit(); // Close the browser
		}
	}

	public static boolean isElementPresent(WebDriver driver, By by) {

		List<WebElement> elements = driver.findElements(by);

		return !elements.isEmpty();
	}
}
