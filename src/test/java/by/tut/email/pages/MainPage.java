package by.tut.email.pages;

import base.selenium.AbstractPage;
import by.tut.email.components.mainpage.AuthorizePopupComponent;
import by.tut.email.components.mainpage.MainToolbarComponent;

public class MainPage extends AbstractPage{
	public AuthorizePopupComponent authorizePopup;
	public MainToolbarComponent mainToolbar;
 
	 public MainPage(){
		 super();
		 authorizePopup = new AuthorizePopupComponent(); 
		 mainToolbar = new MainToolbarComponent();
	 }
	 
	 public MainPage userAuthorization(String name, String password){
		if(!authorizePopup.isAuthorizePopUpDisplayed()){
			mainToolbar.clickAutorizeLink();
		}
		authorizePopup.fillLoginField(name);
		authorizePopup.fillPasswordField(password);
		return	authorizePopup.ckickEnterButton(); 
	}	
}
