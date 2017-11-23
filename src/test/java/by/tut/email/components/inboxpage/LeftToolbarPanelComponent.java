package by.tut.email.components.inboxpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.selenium.AbstractPage;

import static base.selenium.BaseSettings.driver;

public class LeftToolbarPanelComponent extends AbstractPage{
	private By leftPanel = By.className("ns-view-left-box");
	private By inboxFolderNumber = By.cssSelector(".mail-NestedList-Item_current div .mail-NestedList-Item-Info-Extras");

	public LeftToolbarPanelComponent (){
		super();
	}
	
	public boolean isLeftPanelContainerDisplayed(){
		return getLeftPanelContainer().isDisplayed();
	}
	
	public String getInboxMessagesValue(){
		return getLeftPanelContainer().findElement(inboxFolderNumber).getText().trim().substring(1);
	}
	
	private WebElement getLeftPanelContainer(){
		return driver.findElement(leftPanel);
	}
}
