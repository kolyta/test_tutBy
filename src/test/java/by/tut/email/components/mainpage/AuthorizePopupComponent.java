package by.tut.email.components.mainpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import base.selenium.AbstractPage;
import static base.selenium.BaseSettings.driver;
import by.tut.email.pages.InboxPage;
import by.tut.email.pages.MainPage;

public class AuthorizePopupComponent extends AbstractPage{
	private By authorizePopUp = By.className("b-popup-i");
	private By loginFieldTut = By.cssSelector(".auth-form input[name='login']");
	private By passwordFieldTut = By.cssSelector(".auth-form input[name='password']");
	private By enterButtonTut = By.className("auth__enter");
	private By emailLink = By.xpath("//ul[@class='b-auth-navigation']//li[2]//a");
	
	private By goToYandexLink = By.className("new-hr-auth-Form_Button-enter");
	private By loginFieldYandex = By.cssSelector(".passport-Input>input[name='login']");
	private By passwordFieldYandex = By.cssSelector(".passport-Input>input[name='passwd']");
	private By enterButtonYandex = By.xpath("//button[@class ='passport-Button']");
	
	public AuthorizePopupComponent(){
		super();
	}
	
	public boolean isAuthorizePopUpDisplayed(){
		return getAuthorizePopUp().isDisplayed();
	}
	
	public void fillLoginField(String login){
		getLoginField().sendKeys(login);
	}
	
	public void fillPasswordField(String password){
		getPasswordField().sendKeys(password);
	}
	
	public MainPage ckickEnterButton(){
		getEnterButton().click();
		return new MainPage();
	}
	
	public InboxPage openEmail(String login, String pass){
		if(!isAuthorizePopUpDisplayed()){
			new MainPage().mainToolbar.clickAutorizeLink();
		}
			driver.findElement(emailLink).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			for(String childHandle : driver.getWindowHandles()){
			      if (!childHandle.equals(driver.getWindowHandle())){
			          driver.switchTo().window(childHandle);
			      }          
			  }			
			if(driver.getTitle().equals("Яндекс.Почта — бесплатная электронная почта")){
				driver.findElement(goToYandexLink).click();
				fillLoginField(login);
				fillPasswordField(pass);
				ckickEnterButton();
			}
		return new InboxPage();
	}
	
	
	private WebElement getAuthorizePopUp(){
		return driver.findElement(authorizePopUp);
	}
	
	private WebElement getLoginField(){
		try{
			return getAuthorizePopUp().findElement(loginFieldTut);
		} catch (NoSuchElementException e) {
			return driver.findElement(loginFieldYandex);
		}
	}
	
	private WebElement getPasswordField(){
		try{
			return getAuthorizePopUp().findElement(passwordFieldTut);
		} catch (NoSuchElementException e) {
			return driver.findElement(passwordFieldYandex);
		}
	}
	
	private WebElement getEnterButton(){
		try{
			return getAuthorizePopUp().findElement(enterButtonTut);
		} catch (NoSuchElementException e) {
			return driver.findElement(enterButtonYandex);
		}
	}
	
}
