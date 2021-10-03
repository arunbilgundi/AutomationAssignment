import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\eclps\\arun\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // creating the instance of chromedriver.
		driver.get("http://www.qaclickacademy.com/practice.php "); // we access the given link.
		AutomationDriver.exerciseone(driver); // accessing the static method function.
		AutomationDriver.exercisetwo(driver);
		AutomationDriver.exercisethree(driver);
		AutomationDriver.exercisefour(driver);
		AutomationDriver.exerciseFive(driver);
		AutomationDriver.exerciseSix(driver);
		AutomationDriver.exerciseSeven(driver);
		AutomationDriver.exerciseEight(driver);
		AutomationDriver.exerciseNine(driver);

	}

	static void exerciseone(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//*[@value='radio1']")).click(); // we go the radio button using its 'xpath' and
																		// click using inbuilt method called click().
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio1']")).isSelected());
		Thread.sleep(1000); // Assert.assertTrue() is used to check and return boolean value as t or f.
		driver.findElement(By.xpath("//*[@value='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio2']")).isSelected());
		Thread.sleep(1000);// by using this method the execution will be at sleep for 1sec
		driver.findElement(By.xpath("//*[@value='radio3']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio3']")).isSelected());

	}

	static void exercisetwo(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("autocomplete")).sendKeys("United State"); // similar to 'xpath' here we are using 'id'
																			// locator tplocate
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//input[@type='text']"));
		for (WebElement option : options) { // this is advanced for which we use for collection or lists
			if (option.getText().equalsIgnoreCase("United State")) {
				option.click();
				break;
			}

		}

	}

	static void exercisethree(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("dropdown-class-example")).click(); // just like 'xpath' and 'id' we have another
																		// locator called 'name' even this can be used
																		// for locating.
		driver.findElement(By.xpath("//option[@value='option1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option3']")).click();
	}

	static void exercisefour(WebDriver driver) throws InterruptedException { // we userd throws keyword to handle
																				// exception thrown by Thread.sleep() we
																				// can handle this exception by
																				// surrounding it by try and catch
																				// block.

		driver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		driver.findElement(By.name("checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		driver.findElement(By.name("checkBoxOption3")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointtwo(driver);
	}

	public static void exerciseFourPointOne(WebDriver driver) {
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption2")).isSelected());
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption3")).isSelected());

	}

	private static void exerciseFourPointtwo(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption3")).isSelected());

	} 

	public static void exerciseFive(WebDriver driver) throws InterruptedException {



		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://www.qaclickacademy.com/practice.php");

		driver.findElement(By.id("openwindow")).click();



		Set<String> Windows = driver.getWindowHandles();

		Iterator<String> iter = Windows.iterator();

		String parentid = iter.next();

		Thread.sleep(2000);

		 

		driver.switchTo().window(parentid);



		}
	public static void exerciseSix(WebDriver driver) throws InterruptedException {



		driver.findElement(By.id("opentab")).click();

		Thread.sleep(2000);

		Set<String> window = driver.getWindowHandles();



		Iterator<String> it = window.iterator();



		String parent = it.next();

		String child = it.next();

		String daughter = it.next();

		Thread.sleep(2000);

		driver.switchTo().window(daughter);

		driver.close();

		driver.switchTo().window(parent);
	}

	

	public static void exerciseSeven(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("name")).sendKeys("Qualitest");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@value='Alert']")).click();
		Thread.sleep(2000);

		//System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

	}

	public static void exerciseEight(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,5000)");
	}

	private static void exerciseNine(WebDriver driver) throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).click().build().perform();
		Thread.sleep(5000);
		a.moveToElement(driver.findElement(By.cssSelector("a[href='#top']"))).click().build().perform();

	}

}
