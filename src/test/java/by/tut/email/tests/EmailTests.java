package by.tut.email.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.selenium.BaseSettings;
import by.tut.email.pages.InboxPage;
import by.tut.email.pages.MainPage;

public class EmailTests extends BaseSettings {
	MainPage mainPage = new MainPage();	
	InboxPage inboxPage = new InboxPage();
	
	String USER_LOGIN = "kolyta111@tut.by";
	String USER_PASS = "kolyta111";
	
	@Test()
	public void emailCheck() {
		mainPage.userAuthorization(USER_LOGIN, USER_PASS);
		mainPage.mainToolbar.clickAutorizeLink();
		mainPage.authorizePopup.openEmail(USER_LOGIN, USER_PASS);
		Assert.assertTrue(inboxPage.tableOfMessages.isContainerOfMessagesDisplayed() 
				&& inboxPage.leftToolbarPanel.isLeftPanelContainerDisplayed(), "The Ibox page wasn't opened");
		Assert.assertEquals(inboxPage.leftToolbarPanel.getInboxMessagesValue(), " 2", "The number of incoming letters isn't correct");
	}

	public void userSignOut() {
		super.testClose();
	}
}
