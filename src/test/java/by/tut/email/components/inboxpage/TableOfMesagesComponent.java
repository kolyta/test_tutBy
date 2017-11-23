package by.tut.email.components.inboxpage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.selenium.AbstractPage;
import static base.selenium.BaseSettings.driver;

public class TableOfMesagesComponent extends AbstractPage{
	private By containerOfMessages = By.className("ns-view-right-box");
	
	public TableOfMesagesComponent(){
		super();
	}
	
	public boolean isContainerOfMessagesDisplayed(){
		return getContainerOfMessages().isDisplayed();
	}
	
	private WebElement getContainerOfMessages(){
		return driver.findElement(containerOfMessages);
	}
}
