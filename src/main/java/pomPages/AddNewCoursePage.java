package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCoursePage<WebDriverUtility> {
	// Declaration
		@FindBy(xpath = "//b[text()='Add New Course']")
		private WebElement pageHeader;

		@FindBy(xpath = "//input[@id ='name']")
		private WebElement nameTF;

		@FindBy(id = "category")
		private WebElement categoryDropDown;

		@FindBy(id = "price")
		private WebElement priceTF;

		@FindBy(xpath = "(//input[@id='photo'][2]")
		private WebElement photoButton;

		@FindBy(xpath = "/button[@name='add']")
		private WebElement saveButton;

		@FindBy(xpath = "//html/body/p")
		private WebElement descriptionTextArea;

		@FindBy(xpath = "//iframe[@title='Rich Text Editor, editor1']")
		private WebElement descriptionFrame;

		// Initialization
		public AddNewCoursePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Utilization

		public String getpageHeader() {
			return pageHeader.getText();
		}

		public void setName(String courseName) {
			nameTF.sendKeys(courseName);
		}

		public void selectCategory(WebDriverUtility web, String category) {
			web.handleDropdown(category, categoryDropDown);
		}

		public void setPrice(String price) {
			priceTF.sendKeys(price);
		}

		public void uploadPhoto(String photoPath) {
			photoButton.sendKeys(photoPath);
		}

		public void setDescription(WebDriverUtility web, String Text) {
			web.switchToFrame(descriptionFrame);
			descriptionTextArea.sendKeys(Text);
			web.switchBackFromFrame();
		}

		public void clickSaveButton() {
			saveButton.click();
		}
	}
}
