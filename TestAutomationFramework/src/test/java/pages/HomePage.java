package pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import stepdef.Base;
import stepdef.Hooks;
import util.Locators;

public class HomePage {

	@FindBy(xpath = Locators.HomePage_ToDoItem_TextBox)
	WebElement oHomePage_ToDoItem_TextBox;
	@FindBys(@FindBy(xpath = Locators.HomePage_ToDoItemView_TextElement))
	List<WebElement> oHomePage_ToDoItemView_TextElement;
	@FindBy(xpath = Locators.HomePage_ToDoItemCount_TextElement)
	WebElement oHomePage_ToDoItemCount_TextElement;
	@FindBy(xpath = Locators.HomePage_Delete_ToDoItem)
	WebElement oHomePage_Delete_ToDoItem;
	@FindBy(xpath = Locators.HomePage_ToDoItemMark_Checkbox)
	WebElement oHomePage_ToDoItemMark_Checkbox;
	@FindBy(xpath = Locators.HomePage_ViewCompletedItems_Button)
	WebElement oHomePage_ViewCompletedItems_Button;
	@FindBy(xpath = Locators.HomePage_ClearCompletedItems_Button)
	WebElement oHomePage_ClearCompletedItems_Button;
	@FindBy(xpath = Locators.HomePage_ViewActiveItems_Button)
	WebElement oHomePage_ViewActiveItems_Button;
	@FindBy(xpath = Locators.HomePage_Header_TextElement)
	WebElement oHomePage_Header_TextElement;
	@FindBy(xpath = Locators.HomePage_Footer_TextElement)
	WebElement oHomePage_Footer_TextElement;
	@FindBys(@FindBy(xpath = Locators.HomePage_LeftPaneSection2_TextElement))
	List<WebElement> oHomePage_LeftPaneSection2_TextElement;
		
	
	private static WebDriver oWebdriver = Base.oWebdriver;

	public void launchUrl() {
		oWebdriver.get(Hooks.oConfig.getProperty("BASE_URL"));
		System.out.println("browser launch");
	}
	
	
	
	

	public void addToDoITem(String sToDoItem) {
		oHomePage_ToDoItem_TextBox.sendKeys(sToDoItem+Keys.ENTER);
	}
	
	
	

	public void viewToDoItem(String sToDoItem) {
		boolean bStatus=false;
		for(WebElement oWebElement : oHomePage_ToDoItemView_TextElement) {
			if(oWebElement.getText().contains(sToDoItem)) {
				bStatus=true;
			}
		}
		assertEquals("Not able to view ToDoItem", true, bStatus); 
		
	}
	
	
	

	public void fetchToDoItemCount(String sCount) {
		assertEquals("count displayed",sCount, oHomePage_ToDoItemCount_TextElement.getText());
	}

	
	
	public void deleteToDoItem() {
		JavascriptExecutor executor = (JavascriptExecutor) oWebdriver;
		executor.executeScript("arguments[0].click();", oHomePage_Delete_ToDoItem);    
	}
	
	
	
	

	public void validateDroppedToDoItem(String sToDoItem) {
		boolean bStatus=false;
		for(WebElement oWebElement : oHomePage_ToDoItemView_TextElement) {
			if(oWebElement.getText().contains(sToDoItem)) {
				bStatus=true;
			}
		}
		assertEquals("able to view dropped ToDoItem", false, bStatus); 
	}
	
	
	
	
	

	public void MarkToDoItemAsComplete() {
		oHomePage_ToDoItemMark_Checkbox.click();
		
	}
	
	

	public void viewToDoItemUnderCompletedSection(String sToDoItem) {
		oHomePage_ViewCompletedItems_Button.click();
		boolean bStatus=false;
		for(WebElement oWebElement : oHomePage_ToDoItemView_TextElement) {
			if(oWebElement.getText().contains(sToDoItem)) {
				bStatus=true;
			}
		}
		assertEquals("Not able to view ToDoItem", true, bStatus); 			
	}





	public void clearCompletedToDoItem() {
		oHomePage_ClearCompletedItems_Button.click();
	}





	public void viewToDoItemUnderActiveSection(String sToDoItem) {
		oHomePage_ViewActiveItems_Button.click();
		boolean bStatus=false;
		for(WebElement oWebElement : oHomePage_ToDoItemView_TextElement) {
			if(oWebElement.getText().contains(sToDoItem)) {
				bStatus=true;
			}
		}
		assertEquals("Not able to view ToDoItem", true, bStatus); 	
		
	}





	public void AddToDoItemWithSize(int iSize) {
		String sToDoItem= RandomStringUtils.randomAlphanumeric(iSize);
		addToDoITem(sToDoItem);
		
	}





	public void viewHeading(String sHeading) {
		String sActualHeader = oHomePage_Header_TextElement.getText();
	assertEquals("Header displayed in the H1 section", sHeading, sActualHeader); 
	}





	public void viewPlaceHolder(String sPlaceHolder) {
		String sActualPlaceHolder= oHomePage_ToDoItem_TextBox.getAttribute("placeholder");
		assertEquals("Placeholder assertion", sPlaceHolder, sActualPlaceHolder);
	}





	public void viewLeftPaneSectionName(String sSectionHeading) {
		boolean bStatus=false;
		for(WebElement oWebElement : oHomePage_LeftPaneSection2_TextElement) {
			if(oWebElement.getText().contains(sSectionHeading)) {
				bStatus=true;
			}
		}
		assertEquals("Left pane section heading assertion", true, bStatus); 	
		
	}





	public void viewFooterSectionName(String sFooter) {
		String sActualFooterText = oHomePage_Footer_TextElement.getText();
		assertEquals("Footer assertion", sFooter, sActualFooterText);
	}





	public void performPageRefresh() {
		oWebdriver.navigate().refresh();
		
	}





	public void selectCompletedSection() {
		oHomePage_ViewCompletedItems_Button.click();
		
	}





	public void editCompletedItem() {
		Actions oActions = new Actions(oWebdriver);
		oActions.doubleClick(oHomePage_ToDoItemView_TextElement.get(0)).sendKeys("bug item"+Keys.ENTER).build().perform();
		
	}
	
	
	
}
