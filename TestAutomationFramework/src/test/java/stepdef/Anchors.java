package stepdef;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import io.cucumber.datatable.DataTable;

public class Anchors {
	private static WebDriver oWebdriver = Base.oWebdriver;
	HomePage oHomePage = PageFactory.initElements(oWebdriver, HomePage.class);
	
	@Given("MVC_USER launch the url")
	public void mvc_user_launch_the_url() {
		oHomePage.launchUrl();
	}
	
	@When("MVC_USER add the ToDo item {string}")
	public void mvc_user_add_the_to_do_item(String sToDoItem) {
		oHomePage.addToDoITem(sToDoItem);
	}
	@Then("MVC_USER should be able to view the added ToDo item {string}")
	public void mvc_user_should_be_able_to_view_the_added_to_do_item(String sToDoItem) {
		oHomePage.viewToDoItem(sToDoItem);
	}
	@Then("MVC_USER clicks on active button and ToDo item count must be {string}")
	public void mvc_user_clicks_on_active_button_and_to_do_item_count_must_be(String sCount) {
		oHomePage.fetchToDoItemCount(sCount);
	}
	
	@When("MVC_USER delete the first ToDo item")
	public void mvc_user_delete_the_to_do_item() {
		oHomePage.deleteToDoItem();
	}
	@Then("MVC_USER should not be able to view the added ToDo item {string}")
	public void mvc_user_should_not_be_able_to_view_the_added_to_do_item(String sToDoItem) {
	   oHomePage.validateDroppedToDoItem(sToDoItem);
	}
	
	@When("MVC_USER complete the first ToDo item")
	public void mvc_user_complete_the_first_to_do_item() {
		oHomePage.MarkToDoItemAsComplete();
	}
	@Then("MVC_USER should be able to view the ToDo item under completed section {string}")
	public void mvc_user_should_be_able_to_view_the_to_do_item_under_completed_section(String sToDoItem) {
		oHomePage.viewToDoItemUnderCompletedSection(sToDoItem);
	}
	
	@Then("MVC_USER should be able to clear the completed items")
	public void mvc_user_should_be_able_to_clear_the_completed_items() {
		oHomePage.clearCompletedToDoItem();
	}
	
	
	@Then("MVC_USER should be able to view the ToDo item under active section {string}")
	public void mvc_user_should_be_able_to_view_the_to_do_item_under_active_section(String sToDoItem) {
		oHomePage.viewToDoItemUnderActiveSection(sToDoItem);
	}
	@Then("MVC_USER clicks on completed button and ToDo item count must be {string}")
	public void mvc_user_clicks_on_completed_button_and_to_do_item_count_must_be(String sCount) {
		oHomePage.fetchToDoItemCount(sCount);
	}
	
	
	@When("User add the ToDo item of different sizes")
	public void user_add_the_to_do_item_of_different_sizes(DataTable dataTable) {
		 List<List<String>> rows = dataTable.asLists(String.class);
		    
		    for (List<String> columns : rows) {
		    	
		    	oHomePage.AddToDoItemWithSize(Integer.parseInt(columns.get(0)));
		    }
	  
	}


	
	@Then("MVC_USER should be able to view {string} as heading")
	public void mvc_user_should_be_able_to_view_as_heading(String sHeading) {
		oHomePage.viewHeading(sHeading);
	}
	@Then("MVC_USER should be able to view {string} as placeholder for ToDoItem textbox")
	public void mvc_user_should_be_able_to_view_as_placeholder_for_to_do_item_textbox(String sPlaceHolder) {
		oHomePage.viewPlaceHolder(sPlaceHolder);
	}
	@Then("MVC_USER should be able to view the left pane with different sections")
	public void mvc_user_should_be_able_to_view_the_left_pane_with_different_sections(DataTable dataTable) {
		 List<List<String>> rows = dataTable.asLists(String.class);
		    
		    for (List<String> columns : rows) {
		    	
		    	oHomePage.viewLeftPaneSectionName(columns.get(0));
		    }
	  
	}
	@Then("MVC_USER should be able to view the footer with different sections")
	public void mvc_user_should_be_able_to_view_the_footer_with_different_sections(DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists(String.class);
	    
	    for (List<String> columns : rows) {
	    	
	    	oHomePage.viewFooterSectionName(columns.get(0));
	    }
	}

	

	@When("MVC_USER do the page refresh")
	public void mvc_user_do_the_page_refresh() {
	    oHomePage.performPageRefresh();
	}


	@When("MVC_USER clicks on completed button")
	public void mvc_user_clicks_on_completed_button() {
		oHomePage.selectCompletedSection();
	}
	@Then("MVC_USER edit the completed item")
	public void mvc_user_edit_the_completed_item() {
		oHomePage.editCompletedItem();
	}








}
