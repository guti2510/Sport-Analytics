package PruebasSistema;

import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SystemTest1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  File file = new File("C:\\Selenium\\geckodriver.exe");
	  System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8081/Sport-Analytics/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAnalisisExtensionIncorrecta() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.name("upload")).clear();
    Thread.sleep(2000);
    driver.findElement(By.name("upload")).sendKeys("F:\\Cursos\\II Semestre 2016\\Aseguramiento de software\\Proyectos\\Proyecto_Web\\Sport-Analytics\\capaH.jpg");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.button")).click();
    Thread.sleep(2000);
    assertEquals("Tipo de archivo incorrecto", closeAlertAndGetItsText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
