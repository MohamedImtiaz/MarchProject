package org.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BassFile {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor js;
	public static Alert al;
	public static GeckoDriverService gdriver;
	
	public static void browserLaunch(String browserName) {
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			System.out.println("chrome");
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//gdriver = new GeckoDriverService();
			System.out.println("firefox");
		}
		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("edge");
		}
		else {
			System.out.println("browser not found");
		}
	
	
	}
	public static void maxiWindow() {
		driver.manage().window().maximize();
	}
	public static String getlaunchUrl(String url) {
		driver.get(url);
		return url;
	}
	public static String getTheTitle() {
		String title = driver.getTitle();
        System.out.println(title);
        return title;
    }
	public static void getTheCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
     }
    public static void close() {
    	driver.close();
    }
    public static void quit() {
	   driver.quit();
	}
    public static void passingValue(WebElement element, String value) {
    element.sendKeys(value);	
	}
    public static void clickValue(WebElement element) {
	element.click();

	}
    public static void getTextValue(WebElement element) {
      String text = element.getText();
       System.out.println(text);
	}
    public static void getAttributeValue(WebElement element) {
	  String attribute = element.getAttribute("value");
	  System.out.println(attribute);
	}
    
    // Actions - for mouse related
    
	public static void actclickValue(WebElement element) {
		a = new Actions(driver);
		a.click(element).perform();
	}
	public static void actrightClick(WebElement element) {
		a = new Actions(driver);
	   a.contextClick(element).perform();	
	}
	public static void actMultipleClick(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	public static void actmouseMoving (WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	public static void actdragAndDrop(WebElement source, WebElement target) {
		a = new Actions(driver);
        a.dragAndDrop(source, target).perform();
	}
	// Javascript
	
    public static void jClick(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
    public static void jScroll( WebElement element  ) {
    	js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
    public static void jsetAttributeValue (String value, WebElement element) {
    	js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].setAttribute('value',"+value+")", element);
	}
    public static void jaScroll(WebElement element) {
    	js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
    public static void jGetValue(WebElement element, String value) {
    	js = (JavascriptExecutor)driver;
    	Object getValue = js.executeScript("returnarguments[0].getAttribute('value')", element);
    	System.out.println(getValue);
    }
    //Alert 
    	public static void atAccept() {
    	  Alert al = driver.switchTo().alert();
    	  al.accept();
	}
    public static void atedismiss() {
		 Alert dismiss = driver.switchTo().alert();
		 al.dismiss();
	}
    public static void ateGetText() {
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
	}
	public static void ateSendKeys(String value) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(value);
	}
	public static void robot() throws AWTException {
			 r = new Robot();
	}
    //  TakeScreenShot 
	
	public static void screenShot(String value) throws IOException {
		TakesScreenshot t = (TakesScreenshot)driver;
	    File sc = t.getScreenshotAs(OutputType.FILE);
		File g = new File("C:\\Users\\Admin\\eclipse-workspace\\MavenProject\\src\\test\\resources\\sc"+value+"");
        FileUtils.copyFile(sc, g);		
	} 
	// waits
	
	public static void tSleep(long L ) throws InterruptedException {
		 Thread.sleep(L);
	}
	public static void impWait(int time) {
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);		
	}
    public static void fluentWait(long wt,long pt,WebElement element) {
    	FluentWait f = new FluentWait(driver);
	    WebDriverWait e = new WebDriverWait(driver,10);
    	
	    f.withTimeout(Duration.ofSeconds(wt)).pollingEvery(Duration.ofNanos(pt)).ignoring(Throwable.class);
	    f.until(ExpectedConditions.elementToBeClickable(element));
    }  
    public static void webWaitalert() {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.alertIsPresent());    
	}
    public static void waitselector(WebElement locator, boolean selected) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));  	
	}
    public static void waitclickable(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.elementToBeClickable(locator));
	}
    public static void waitselected(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.elementToBeSelected(locator));
	}
    public static void waitFrame(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    public static void waitinvisiity(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.invisibilityOfElementLocated((By) locator));
	}
    public static void waitInvisibityText(WebElement locator,String text) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.invisibilityOfElementWithText((By) locator, text));
	}
    public static void waitpresenceAll(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) locator));
	}
    public static void waitpresence(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.presenceOfElementLocated((By) locator));
	}
    public static void waitText(WebElement element,String text) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.textToBePresentInElement(element, text));
   }
    public static void waitLocator(WebElement locator ,String text) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.textToBePresentInElementLocated((By) locator, text));
	}
    public static void waitValue(WebElement element,String text) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}
    public static void waitTil(String title) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.titleIs(title));
	}
    public static void waittilcon(String title) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.titleContains(title));
	}
    public static void waitVistof(WebElement element) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.visibilityOf(element));
	}
    public static void waitVisElem(WebElement element) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.invisibilityOfAllElements(element));
	}
    public static void waitVisLoco(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
	}
    public static void waitElelocat(WebElement locator) {
    	WebDriverWait e = new WebDriverWait(driver, 10);
    	e.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) locator));
	}
    public static String excelData(String path , String SheetName,int rowNo,int cellNo) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\ProgramProject\\datafiles\\"+path+".xlsx");
        
		FileInputStream fi = new FileInputStream(f);
		
		Workbook book = new XSSFWorkbook(fi);
		
		Sheet sheet = book.getSheet(SheetName);
		
		Row row = sheet.getRow(rowNo);
		
		Cell cell = row.getCell(cellNo);
		
		int type = cell.getCellType();
			
		String value="";
		if(type==1) {
		  value = cell.getStringCellValue();
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd, MMM, yyyy");
			 value =s.format(d);
		}
		else {
			double d = cell.getNumericCellValue();
			long l = (long)d;
			
			 value = String.valueOf(l);
		}
		return value;
		}
    public static void phyAllPrint (String path , String sheetName) throws IOException {
    	
File f = new File("C:\\Users\\Admin\\eclipse-workspace\\ProgramProject\\datafiles\\"+path+".xlsx");
        
		FileInputStream fi = new FileInputStream(f);
		
		Workbook book = new XSSFWorkbook(fi);
		
		Sheet sheet = book.getSheet(sheetName);
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	          Row row = sheet.getRow(i);
	          
	          
	    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
	    	  Cell cell = row.getCell(j);	
	    	 System.out.println(cell);
	    	 }
		}
    }
		public static void phyAllCount (String path , String sheetName) throws IOException {
	    	
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\ProgramProject\\datafiles\\"+path+".xlsx");
	        
			FileInputStream fi = new FileInputStream(f);
			
			Workbook book = new XSSFWorkbook(fi);
			
			Sheet sheet = book.getSheet(sheetName);
				
			
			int a = sheet.getPhysicalNumberOfRows();
	    	 System.out.println("no of rows = " +a);
	   
	    	 Row row1 = sheet.getRow(1);
	    	 
	    	 int b = row1.getPhysicalNumberOfCells();
	    	 System.out.println("no of cell = "+ b);
	  
	    	 Cell cell1 = row1.getCell(0);
	}
		
		public static void insertNewRow(String path , String sheetName) throws IOException {
			
            File f = new File("C:\\Users\\Admin\\eclipse-workspace\\ProgramProject\\datafiles\\"+path+".xlsx");
	        
			FileInputStream fi = new FileInputStream(f);
			
			Workbook book = new XSSFWorkbook(fi);
			
			Sheet sheet = book.getSheet(sheetName);
			
			Row c = sheet.getRow(1);
			Cell c0 = c.getCell(2);
			c0.setCellValue("successful login");
			
			
			FileOutputStream fo = new FileOutputStream(f);
			book.write(fo);
			System.out.println("finish");	
     }
		
	    public static void winHandl() {
	    
		String winHand = driver.getWindowHandle();
		
		Set<String> winHandles = driver.getWindowHandles();
		
		for (String itrId : winHandles) {
			driver.switchTo().window(itrId);
		}
	    }
	    public static void dateTime() {
			Date d = new Date();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			String da = s.format(d);
			System.out.println(da);

		}
	    public static void isDisplaySeleteEnable(String path, String value) throws InterruptedException {
			
	    	WebElement checkWorkingStatus = driver.findElement(By.xpath(path));

	    	if (checkWorkingStatus.isDisplayed() && checkWorkingStatus.isEnabled()) {
				
	    		checkWorkingStatus.click();
	    		tSleep(5000);
	    		
	    		WebElement button = driver.findElement(By.xpath(value));
	    		boolean selected = button.isSelected();
	    		
	    		if (!selected) {
	    		button.click();
	    		System.out.println("selected option " + button.isSelected());
					
				}
			}
	    	
	    	
		}
	    
	   
			

		}
		
	
		
	



