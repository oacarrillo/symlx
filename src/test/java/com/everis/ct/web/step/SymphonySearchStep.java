package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@ScreenShot
@Component
public class SymphonySearchStep {

    @Autowired
    private StepPages page;

    public void writeData(String data, String path, String locatorType) {
        page.searchPage().textInput(data, path, locatorType);
    }

    public void sendClick(String path, String locatorType) {
        page.searchPage().clickButton(path, locatorType);
    }


    public void validateResults(int count) {
        Assert.assertTrue("Resultado esperado menor o igual 0.", page.resultsPage().getSearchResults().length() > count);
    }
    public void pageLocation(String tittle, String path, String locatorType, String currentURL, String webPage) {
        page.searchPage().verifyPage(tittle, path, locatorType, currentURL, webPage);
    }
    public void newTab(String url){
        page.searchPage().newTabURL(url);
    }
    public void selectTab(String tab){
        page.searchPage().openTab(tab);
    }
    public void refreshTab(){
        page.searchPage().refreshPage();
    }
    public void actionHover(String path, String locatorType) {
        page.searchPage().actionHoverElement(path, locatorType);
    }
    public void actionRelease(String path, String locatorType) {
        page.searchPage().actionReleaseElement(path, locatorType);
    }
    public void pseudoElement(String script, String value){
        page.searchPage().pseudoElementFind(script, value);
    }
    public void sendKeyboard(Keys key, String path, String locatorType){
        page.searchPage().sendKeyboardKey(key, path, locatorType);
    }
    public void back(){
        page.searchPage().backPage();
    }
    public void forward(){
        page.searchPage().forwardPage();
    }
    public void needTime(Integer mileSeconds){
        page.searchPage().needTimeFor(mileSeconds);
    }
    public void elementPresence(String path, String locatorType, Boolean present){
        page.searchPage().elementPresent(path, locatorType, present);
    }
    public int findLast(int startNum, String firstHalfPath, String secondHalfPath){
        return page.searchPage().findLastElement(startNum, firstHalfPath, secondHalfPath);
    }
    public void clearElement(String path, String locatorType){
        page.searchPage().clearElementText(path, locatorType);
    }
    public void copyText(String path, String locatorType){
        page.searchPage().copyElementText(path, locatorType);
    }
    public void pasteText(String path, String locatorType){
        page.searchPage().pasteElementText(path, locatorType);
    }
    public void compareText(String text, Boolean equals, String path, String locatorType){
        page.searchPage().compareElementText(text, equals, path, locatorType);
    }
    public void switchToTab(int position){
        page.searchPage().switchToTabPosition(position);
    }
    public void clickOn(String path, String locatorType, int x, int y){
        page.searchPage().clickOnCoordinates(path, locatorType, x, y);
    }
    public void clickOnJs(String path, String locatorType){
        page.searchPage().clickOnJsElement(path, locatorType);
    }
    public void checkBoxState(String path, String locatorType, Boolean checked){
        page.searchPage().checkBoxSelected(path, locatorType, checked);
    }
    public void dragAndDrop(String pathDraggable, String locatorTypeDraggable, String pathTarget, String locatorTypeTarget){
        page.searchPage().dragAndDropElement(pathDraggable, locatorTypeDraggable, pathTarget, locatorTypeTarget);
    }
    public void sendFile(String pathFile, String path, String locatorType){
        page.searchPage().sendFilePath(pathFile, path, locatorType);
    }
    public void sendKeysWE(Keys key){
        page.searchPage().sendKeysNE(key);
    }
    public void sendKeyComb(Keys key, String character, String path, String locatorType){
        page.searchPage().sendKeyboardComb(key, character, path, locatorType);
    }
    public void pageLoad(){
        page.searchPage().pageLoadCompleted();
    }
    public void switchTab(Integer tab){
        page.searchPage().switchToTab(tab);
    }
    public void sendPathToOpenFile(String path) throws AWTException{
        page.searchPage().sendPathToOpenFileWindows(path);
    }
    public void clickOnImage(String imagePath) throws AWTException{
        page.searchPage().clickOnImageCenter(imagePath);
    }
    public void setProxy(String proxyAddress, int proxyPort){
        page.searchPage().setProxyBrowser(proxyAddress, proxyPort);
    }
    public Boolean isElement(String path, String locatorType){
        return page.searchPage().isElementPresent(path, locatorType);
    }

}
