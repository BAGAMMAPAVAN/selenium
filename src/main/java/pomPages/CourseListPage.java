package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseListPage {
	//Declaration
		@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
		private WebElement pageHeader;
		
		@FindBy(xpath ="//a[text()=' New'")
		private WebElement newButton;
		
		@FindBy(xpath ="//table/tbody/tr/td[1]")
		private List<WebElement> courseList;
		
		@FindBy(xpath = "//h4[text()=' Success!']")
		private WebElement successMessage;
	    
		
		private String deletePath="//td[text()=%s]/following-sibling::td/button[text()=' Delete']";
		
		@FindBy(xpath="//button[@name='delete']")
		private WebElement deleteButton;
		
		//Initialization
		public CourseListPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		//Utilization
			
	    public String getPageHeader() {
				return pageHeader.getText();
		}
				
		public void clicknewButton() {
					 newButton.click();
		}
					
		public List<WebElement > getCourseList(){
			return courseList;
		}
		public String getSuccessMessage() {
			return successMessage.getText();
		}
		public void clickDeleteButton(String courseName,WebDriver driver) {
			String requiredPath = String.format(deletePath,courseName);
		driver.findElement(By.xpath(requiredPath)).click();
		}
		public void delete() {
			deleteButton.click();
		}
			
	}

