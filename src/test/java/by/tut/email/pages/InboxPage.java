package by.tut.email.pages;

import base.selenium.AbstractPage;
import by.tut.email.components.inboxpage.LeftToolbarPanelComponent;
import by.tut.email.components.inboxpage.TableOfMesagesComponent;

public class InboxPage extends AbstractPage {
	public LeftToolbarPanelComponent leftToolbarPanel;
	public TableOfMesagesComponent tableOfMessages;
	
	public InboxPage(){
		super();
		leftToolbarPanel = new LeftToolbarPanelComponent();
		tableOfMessages = new TableOfMesagesComponent();
	}

}
