package day10_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class orderOfTests {

	@Test(priority=3)
	public void TestSelenium() {
		System.out.println("Selenium");
	}

	@Test(priority=4, enabled=true)
	public void TestJava() {
		System.out.println("Java");

	}
	
	@Test(priority=1)
	public void TestAPI() {
		System.out.println("API");

	}
	
	@Test(priority=1)
	public void TestSQL() {
		System.out.println("SQL");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");

	}

}
