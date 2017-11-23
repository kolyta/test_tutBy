package base.selenium;

import static base.selenium.BaseSettings.driver;

import org.openqa.selenium.By;

public abstract class AbstractPage {

	public boolean isElenentPresent(By by){
	   	 return !driver.findElements(by).isEmpty();
	 }


}
