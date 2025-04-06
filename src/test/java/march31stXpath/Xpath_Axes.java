package march31stXpath;

public class Xpath_Axes {
    public static void main(String[] args) {
        //Axes: An axis defines a node-set relative to the current node.

        //Following-sibling: Selects all siblings after the current node
        //htmlTag[@attribute='value']/following-sibling::anotherHtmlTag[@attribute='value']
        //label[text()='Address']/following-sibling::div/textarea

        //Following: Selects everything in the document after the closing tag of the current node
        //htmlTag[@attribute='value']/following::anotherHtmlTag[@attribute='value']
        //label[text()='Address']/following::input[@type='email']
        //div[contains(@class,'sortBy')]/following::ul[@class='results-base']/li/a

        //parent: Selects the parent of the current node
        //htmlTag[@attribute='value']/parent::anotherHtmlTag[@attribute='value']
        //input[@placeholder='Last Name']/parent::div

        //preceding-sibling: Selects all siblings before the current node
        //htmlTag[@attribute='value']/preceding-sibling::anotherHtmlTag[@attribute='value']
        //input[@placeholder='Last Name']/parent::div/preceding-sibling::div/input

        //descendant: Selects all descendants (children, grandchildren, etc.) of the current node
        //htmlTag[@attribute='value']/descendant::anotherHtmlTag[@attribute='value']
        //form[@id='basicBootstrapForm']/descendant::input[@type='text' or @type='email' or @type='number']

        //preceding: Selects all nodes that appear before the current node in the document
        //htmlTag[@attribute='value']/preceding::anotherHtmlTag[@attribute='value']
        //label[text()='Country*']/preceding::select[@id='Skills']

        //ancestor: Selects all ancestors (parent, grandparent, etc.) of the current node
        //htmlTag[@attribute='value']/ancestor::anotherHtmlTag[@attribute='value']
        //select[@id='Skills']/ancestor::div[@class='form-group']
    }
}
