package apk;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import web.Create_trip;

public class FTA_app extends Create_trip {
	static WebDriver driver;
	static WebElement Proceed;
	static int i = 1;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
//		public static void Executive() throws InterruptedException {

//		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nokia");
//		dc.setCapability("appPackage", "com.blubirch.ftabb");
//		dc.setCapability("appActivity", "com.blubirch.ftabb.MainActivity");
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);
//		Thread.sleep(3000);
//		WebElement user = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='ion-input-0']"));
//		user.click();
//		user.sendKeys("chetan_fileds@yopmail.com");
//		WebElement pass = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='ion-input-1']"));
//		pass.click();
//		pass.sendKeys("blubirch@123");
//		Thread.sleep(1500);
//		driver.findElement(By.xpath("//android.widget.Button[@text='Sign In']")).click();

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://whirlpool-fta.web.app/login");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ion-input-0']")).sendKeys("ch_015");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ion-input-1']")).sendKeys("blubirch@123");
		driver.findElement(By.xpath("//ion-button")).click();
		Thread.sleep(500);
		WebElement logisticsr = driver.findElement(By.xpath("(//ion-col[@class='cat-item md hydrated'])[1]"));
//		WebElement Logistics = driver.findElement(By.xpath(logisticsr));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logisticsr);
		Thread.sleep(1500);

		WebElement Rep = driver.findElement(By.xpath("(//ion-col[@class='padding5 md hydrated'])[3]//div"));
		Rep.click();
		System.out.println(Rep.getText());
		Proceed = driver.findElement(By.xpath(
				"//ion-button[@class='next-btn md button button-full button-solid ion-activatable ion-focusable hydrated']"));
		js.executeScript("arguments[0].click();", Proceed);
		Thread.sleep(1000);
		WebElement searial = driver.findElement(By.xpath("//input[@placeholder='Scan Serial Number*']"));
		searial.sendKeys("SRN35042847");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);

		WebElement nextElement = driver.switchTo().activeElement();
		nextElement.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"(//ion-button[@class='question-btn md button button-block button-outline ion-activatable ion-focusable hydrated'])[1]"))
				.click();
		driver.findElement(By.xpath("(//ion-col[@class='md hydrated'])[1]//img")).click();
		
	}

}
