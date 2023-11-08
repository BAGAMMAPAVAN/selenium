package GenericLibraries;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewUserPage;
import pomPages.CategoryPage;
import pomPages.Loginpage;
import pomPages.usersPage;
import pomPages.welcomepage;


public class BaseClass {

		
//		@BeforeSuite
//		@BeforeTest
		
		protected propertiesUtility property;
		protected ExcelUtility excel;
		protected JavaUtility jutil;
		protected WebDriverUtility webUtil;
		protected WebDriver driver;
		
		public static WebDriver sdriver;
		public static JavaUtility sjutil;
		
		protected welcomepage welcome;
		protected Loginpage login;
		protected AdminHomePage home;
		protected usersPage users;
		protected CourseListPage course;
		protected CategoryPage category;
		protected AddNewUserPage addUser;
		protected AddNewCoursePage addCourse;
		protected AddNewCategoryPage addCategory;
		
		@BeforeClass
		public void classCongfig() {
			Property=new propertiesUtility();
			excel=new ExcelUtility();
			jutil=new JavaUtility();
			webUtil =new WebDriverUtility();
			
			property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
			driver=webUtil.launchBrowser(property.readFromProperties("browser"));
			
			sdriver=driver;
			sjutil=jutil;
					
		}
		@BeforeMethod
		public void methodConfig() {
			excel.excelInitialization(IConstantPath.EXCEL_PATH);
			
			welcome=new WelcomePage(driver);
			login =new LoginPage(driver);
			home=new AdminHomePage(driver);
			users=new UsersPage(driver);
			course=new CourseListPage(driver);
			category=new CategoryPage(driver);
			addUser=new AddNewUserPage(driver);
			addCourse=new AddNewCoursePage(driver);
			addCategory=new AddNewCategoryPage(driver);
			
			
			webUtil.navigateToApp(property.readFromProperties("url"));
			long time=Long.parseLong(property.readFromProperties("timeouts"));
			webUtil.waitTillElementFound(time);
			
			welcome.clickLoginButton();
			login.setEmail(property.readFromProperties("username"));
			login.setPassword(property.readFromProperties("password"));
			login.clickLogin();	
		}
		
		@AfterMethod
		public void mehtodTeardown() {
			excel.closeExcel();
			home.signOutOfApp();
		}
		
		@AfterClass
		public void classTeardown() {
			webUtil.closeAllWindows();
			
		}
		
//		@AfterTest
//		@AfterSuite


	}
