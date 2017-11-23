package by.tut.email.components.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.selenium.AbstractPage;

import static base.selenium.BaseSettings.driver;

import by.tut.email.pages.MainPage;

public class MainToolbarComponent extends AbstractPage{
	private By toolbarContainer = By.className("b-topbar-h");
	private By authorizeLink = By.cssSelector(".b-auth-i a");
	
	public MainToolbarComponent(){
		super();
	}
	public MainPage clickAutorizeLink(){
		getToolbarContainer().findElement(authorizeLink).click();
		return new MainPage();
	}
	
	private WebElement getToolbarContainer(){
		return driver.findElement(toolbarContainer);
	}
}
