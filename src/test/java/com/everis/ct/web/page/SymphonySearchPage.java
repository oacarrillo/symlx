package com.everis.ct.web.page;

import com.everis.ct.web.base.WebBase;
import com.everis.ct.web.lib.WebDriverManager;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.Rectangle;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SymphonySearchPage extends WebBase {
    protected By elementBy;
    protected Actions action;
    protected Integer time = 10;
    public void textInput(String data, String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        type(element, data);
    }
    public void clickButton(String path, String locatorType) {
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        click(element);
    }
    public void verifyPage(String tittle, String path, String locatorType, String currentURL, String webPage) {
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementType(path, locatorType)));
        Assert.assertEquals(driver().getTitle(),tittle);
        if(ExpectedConditions.visibilityOfElementLocated(elementType(path, locatorType)).equals(false)){
            driver().quit();
        }
        Assert.assertEquals(currentURL, webPage);
    }
    public void newTabURL(String url){
        //var wait = webDriverWait(Duration.ofSeconds(time));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(elementType(path, locatorType)));
        WebDriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
        WebDriverManager.getDriver().navigate().to(url);
    }
    public void openTab(String tab){
        driver().switchTo().window(tab);
    }
    public void refreshPage(){
        driver().navigate().refresh();
    }
    public void actionHoverElement(String path, String locatorType) {
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(WebDriverManager.getDriver());
        action.moveToElement(WebDriverManager.getDriver().findElement(elementType(path, locatorType))).build().perform();
    }
    public void actionReleaseElement(String path, String locatorType) {
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action = new Actions(WebDriverManager.getDriver());
        action.release(WebDriverManager.getDriver().findElement(elementType(path, locatorType))).perform();
    }
    public void pseudoElementFind(String script, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver();
        String text = js.executeScript(script).toString();
        if (!Objects.equals(text, value)) {
            System.out.println("text = " + text + "    value = " + value);
            driver().quit();
        }
        System.out.println("text = " + text + "    value = " + value);
    }
    public void sendKeyboardKey(Keys key, String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(key);
    }
    public void backPage(){
        driver().navigate().back();
    }
    public void forwardPage(){
        driver().navigate().forward();
    }
    public void needTimeFor(Integer mileSeconds){
        try {
            Thread.sleep(mileSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void elementPresent(String path, String locatorType, Boolean present){
        if(present.equals(true)){
            WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
            var wait = webDriverWait(Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("TERMINA LA ESPERA DE CARGA DEL ELEMENTO");
            //Assert.assertEquals(ExpectedConditions.visibilityOf(element), true);
            element.isDisplayed();
        }else if(present.equals(false)){
            needTimeFor(10000);
            List<WebElement> elem = driver().findElements(elementType(path, locatorType));
            if(elem.size() > 0){
                System.out.println("VA A EJECUTAR EL QUIT()");
                driver().quit();
            }
        }
    }
    public int findLastElement(int startNum, String firstHalfPath, String secondHalfPath){
        int cuenta = startNum;
        boolean flag = true;
        String path = firstHalfPath + cuenta + secondHalfPath;
        while (flag){
            try {
                WebDriverManager.getDriver().findElement(By.xpath(path));
                cuenta ++;
                path = firstHalfPath + cuenta + secondHalfPath;
                System.out.println("La cuenta va en: " + cuenta);
            }catch(NoSuchElementException e){
                flag = false;
            }
        }
        cuenta = cuenta-1;
        //path = firstHalfPath + cuenta + secondHalfPath;
        //clickButton(path, "xPath");
        return cuenta;
    }
    public void clearElementText(String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void copyElementText(String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        element.sendKeys(Keys.chord(Keys.CONTROL,"c"));
    }
    public void pasteElementText(String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(Keys.chord(Keys.CONTROL,"v"));
    }
    public void compareElementText(String text, Boolean equals, String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if(equals){
            Assert.assertEquals(element.getText(), text);
        }
        else{
            Assert.assertNotEquals(element.getText(), text);
        }
    }
    public void switchToTabPosition(int position){
        int size = WebDriverManager.getDriver().getWindowHandles().size();
        if(position > size){
            System.out.println("La posición " + position + " que ha ingresado no existe porque es mayor a la cantidad de pestañas");
            driver().quit();
        }else{
            String tab = WebDriverManager.getDriver().getWindowHandles().toArray()[position].toString();
            openTab(tab);
        }
    }
    public void clickOnCoordinates(String path, String locatorType, int x, int y){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        Actions action = new Actions(WebDriverManager.getDriver());
        //action.moveToElement(element, 0, 0);
        //action.moveByOffset(x, y).contextClick().build().perform();
        action.moveByOffset(x, y).click().build().perform();
    }
    public void clickOnJsElement(String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor ex=(JavascriptExecutor)driver();
        ex.executeScript("arguments[0].click()", element);
    }
    public void checkBoxSelected(String path, String locatorType, Boolean checked){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        if(element.isSelected()!=checked){
            System.out.println("CHECK BOX STATES ARE DIFFERENT");
            driver().quit();
        }else{
            System.out.println("CHECK BOX STATES ARE THE SAME");
        }
    }
    public void dragAndDropElement(String pathDraggable, String locatorTypeDraggable, String pathTarget, String locatorTypeTarget){
        WebElement elementDraggable = WebDriverManager.getDriver().findElement(elementType(pathDraggable, locatorTypeDraggable));
        WebElement elementTarget = WebDriverManager.getDriver().findElement(elementType(pathTarget, locatorTypeTarget));
        Actions action = new Actions(WebDriverManager.getDriver());
        action.dragAndDrop(elementDraggable, elementTarget).build().perform();
    }
    public void sendFilePath(String filePath, String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        File file = new File (filePath);
        filePath = file.getAbsolutePath();
        element.sendKeys(filePath);
    }
    public void sendKeysNE(Keys key){
        Actions action = new Actions(WebDriverManager.getDriver());
        action.sendKeys(key).perform();
    }
    public void sendKeyboardComb(Keys key, String character, String path, String locatorType){
        WebElement element = WebDriverManager.getDriver().findElement(elementType(path, locatorType));
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(key + character);
    }
    public void pageLoadCompleted() {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        var wait = webDriverWait(Duration.ofSeconds(time));
        wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
    }
    public void switchToTab(Integer tab){
        ArrayList<String> tabs = new ArrayList<>(driver().getWindowHandles());
        driver().switchTo().window(tabs.get(tab));
    }
    public void modifyElementStyle(WebElement element) {
        String xpath = element.toString().replace("By.xpath: ", "");
        String strID = element.getAttribute("id").toString();
        String jsConsole = "document.getElementById('";
        ((JavascriptExecutor) driver()).executeScript(jsConsole + strID + "').style.display = 'block';");
        ((JavascriptExecutor) driver()).executeScript(jsConsole + strID + "').style.position = 'unset';");
        ((JavascriptExecutor) driver()).executeScript(jsConsole + strID + "').style.overflow = 'visible';");
        ((JavascriptExecutor) driver()).executeScript(jsConsole + strID + "').style.opacity = 'unset';");
        ((JavascriptExecutor) driver()).executeScript(jsConsole + strID + "').style.height = '10px';");
        ((JavascriptExecutor) driver()).executeScript(jsConsole + strID + "').style.width = '10px';");
    }
    public void sendPathToOpenFileWindows(String path) throws AWTException {
        // Ruta local del archivo que se desea abrir
        //String filePath = "C:\\Users\\dninocam\\Documents\\AUTOMATIZACION\\images\\file_name.png";

        //Esta línea es para que no aparezca el error de "Headless Environment"
        System.setProperty("java.awt.headless", "false");

        // Crea un objeto Robot para simular la entrada de teclado y ratón
        Robot robot = new Robot();

        // Espera 2 segundos para que la ventana emergente aparezca
        robot.delay(2000);

        StringSelection selection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);

        // Coloca el foco en el campo "Nombre de archivo" y pega la ruta del archivo
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // Presiona la tecla ENTER para enviar la dirección del archivo
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Espera 1 segundo para que la ventana cargue la información del archivo
        robot.delay(1000);

        // Presiona la tecla TAB dos veces para mover el foco al botón "Abrir"
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // Presiona la tecla ENTER para hacer clic en el botón "Abrir"
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void clickOnImageCenter(String imagePath) throws AWTException {
        System.load("C:\\Users\\dninocam\\Documents\\AUTOMATIZACION\\everis-app-web-selenium-java-master-coe-1\\opencv\\build\\java\\x64\\opencv_java470.dll");

        // Cargamos la imagen que queremos encontrar en la pantalla
        Mat template = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);

        System.setProperty("java.awt.headless", "false");

        // Capturamos la pantalla y la convertimos a escala de grises
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(1920, 1080);  // Cambia estos valores según la resolución de tu pantalla
        BufferedImage screenshot = robot.createScreenCapture(screenRect);

        // Convertimos la captura de pantalla a un formato compatible con Mat
        BufferedImage convertedImage = new BufferedImage(screenshot.getWidth(), screenshot.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        convertedImage.getGraphics().drawImage(screenshot, 0, 0, null);

        // Obtenemos los bytes de la imagen convertida
        byte[] pixels = ((DataBufferByte) convertedImage.getRaster().getDataBuffer()).getData();

        // Creamos la matriz de OpenCV y asignamos los píxeles
        Mat screenMat = new Mat(screenshot.getHeight(), screenshot.getWidth(), CvType.CV_8UC3);
        screenMat.put(0, 0, pixels);

        // Convertimos la imagen a escala de grises
        Mat grayMat = new Mat();
        Imgproc.cvtColor(screenMat, grayMat, Imgproc.COLOR_BGR2GRAY);

        // Buscamos la imagen en la pantalla
        Mat result = new Mat();
        Imgproc.matchTemplate(grayMat, template, result, Imgproc.TM_CCOEFF_NORMED);
        Core.MinMaxLocResult minMaxLocResult = Core.minMaxLoc(result);
        if (minMaxLocResult.maxVal > 0.4) {  // Cambia este valor según la similitud de la imagen
            int x = (int) minMaxLocResult.maxLoc.x;
            int y = (int) minMaxLocResult.maxLoc.y;
            int w = template.width();
            int h = template.height();
            int center_x = x + (w / 2);
            int center_y = y + (h / 2);

            // Movemos el mouse al centro de la imagen y hacemos clic
            Robot clicker = new Robot();
            clicker.mouseMove(screenRect.x + center_x, screenRect.y + center_y);
            clicker.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            clicker.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }
    public void setProxyBrowser(String proxyAddress, int proxyPort){
                // Configura las opciones del navegador
        EdgeOptions options = new EdgeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyAddress + ":" + proxyPort);
        proxy.setSslProxy(proxyAddress + ":" + proxyPort);
        options.setCapability("proxy", proxy);
    }
    public Boolean isElementPresent(String path, String locatorType){
        return WebDriverManager.getDriver().findElement(elementType(path, locatorType)).isDisplayed();
    }

    public By elementType(String path, String locatorType){
        if(Objects.equals(locatorType, "xPath")){
            elementBy = By.xpath(path);
        }
        else if(Objects.equals(locatorType, "cssSelector")) {
            elementBy = By.cssSelector(path);
        }
        else if(Objects.equals(locatorType, "id")){
            elementBy = By.id(path);
        }
        else if(Objects.equals(locatorType, "name")){
            elementBy = By.name(path);
        }
        else if(Objects.equals(locatorType, "className")){
            elementBy = By.className(path);
        }
        else if(Objects.equals(locatorType, "tagName")){
            elementBy = By.tagName(path);
        }
        else if(Objects.equals(locatorType, "linkText")){
            elementBy = By.linkText(path);
        }
        else if(Objects.equals(locatorType, "partialLinkText")){
            elementBy = By.partialLinkText(path);
        }else{
            driver().quit();
        }
        return elementBy;
    }
}