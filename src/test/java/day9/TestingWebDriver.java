package day9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilities.Driver;

public class TestingWebDriver {
    @Before
    public void setUp() {
        Driver.getDriver();
    }

    @Test
    public void test1() {

    }
    @After
    public void afterMethod() {
        Driver.tearDown();
    }


}
