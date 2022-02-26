package day10_TestNG;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dependsOnTest {
	
	
	
	@Test(dependsOnMethods = {"Smoke"})
	public void SignIn() {
		System.out.println("This will execute depending on the success of the Open Browser");

	}
	
	
	@Test(dependsOnGroups= {"Smoke"}, groups = {"Smoke"})
	public void OpenBrowser() {
		System.out.println("This will execute first (Open Browser)");
	//	AssertJUnit.assertTrue(false);

	}
	

}
