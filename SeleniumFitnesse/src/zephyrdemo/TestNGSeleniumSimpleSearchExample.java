package zephyrdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import fit.ColumnFixture;

public class TestNGSeleniumSimpleSearchExample extends ColumnFixture {
	WebDriver driver;
	String urlGiven;
	String username;
	String password;
	String expected = "tester";

	public String loginApp() throws Exception {
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver",
				"D:\\rcworksp\\SeleniumFitnesse\\BrowserDrivers\\chromedriver 86.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

		driver.get(urlGiven);
		WebElement element = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
		element.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
		return "Login-success";
	}

	public String Logout() throws Exception {
		driver.findElement(By.xpath("//a[@id='ctl00_logout']")).click();
		return "Logout-success";
	}
	public String closeBrowser() throws Exception {
		driver.close();
		return "closing Browser-success";
	}

	/*
	 * public static void main(String args[]) throws Exception {
	 * TestNGSeleniumSimpleSearchExample var = new
	 * TestNGSeleniumSimpleSearchExample(); var.openApp(); }
	 */

}