package march31stXpath;

public class XpathConcept {
    public static void main(String[] args) {
        //Xpath --> XML path
        //applied for XML or HTML based documents

        //locate the complex elements and it is the most powerful locators
        //XPath --> XML Path
        //Applied for XML or HTML based documents

        //Locate the complex elements and it is the most powerful locator

        //There are two types of xpath:
        //1. Absolute xpath: We write the locator starting from html tag onwards
        // /html/body/section/div/div/div[2]/form/div[12]/label --> Most prone to changes

        //2. Relative xpath:
        //We find the locator with a reference of others

        // ---> in xpath means scan the whole HTML Page

        //Syntax of writing the basic xpath:
        //htmlTag[@attribute='value']
        //input[@ng-model='FirstName']

        //Syntax of using contains in xpath:
        //htmlTag[contains(@attribute,'value')]
        //select[contains(@ng-init,'Skill')]
        //option[contains(@value,'Photoshop')]

        //Syntax of using starts-with in xpath:
        //htmlTag[starts-with(@attribute,'value')]
        //option[starts-with(@value,'Adobe')]
        //option[starts-with(@value,'Corel')]

        //Syntax of using ends-with in xpath:
        //It is not supported in xpath 1.0 version
        //Supported since xpath 2.0

        //What is version of xpath that browser engines generally support??
        //V1.0

        //Syntax of finding xpath on the basis of text:
        //htmlTag[text()='value']
        //label[text()='Hobbies']

        //Syntax of finding xpath on the basis of text and normalize-space():
        //htmlTag[normalize-space(text())='value']
        //label[normalize-space(text())='Cricket']

        //Syntax of using "and" in xpath:
        //htmlTag[@attribute='value' and @attributeOne='ValueOne']
        //option[@value='Certifications' and text()='Certifications']
        //a[@class='ui-corner-all' and text()='Arabic']

        //Syntax of using "or" in xpath:
        //htmlTag[@attribute='value' or @attributeOne='ValueOne']
        //input[@id='firstpassword' or @ng-model='Password']

        //Syntax of using "not" in xpath:
        //htmlTag[not(@attribute='value')]
        //option[not(@value='Android')]
    }
}
