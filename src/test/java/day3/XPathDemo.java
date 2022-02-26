package day3;

public class XPathDemo {

    public void testXPathMethod(){
        String url ="http://practice.automationtesting.in/my-account/";
        //Relative
        // "//tagName[@attribute='value']-->xpath
        String absolutePath = "//input[@id='reg_password']";

        //tagName[attribute='value']-->CSS
        String css = "input[name='username']";
        //tagname#id--CSS
        String cssId = "input#username";


        String containXpath = "//input[contains(@id,'remember')]";


        String inputXpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]";





    }


}
