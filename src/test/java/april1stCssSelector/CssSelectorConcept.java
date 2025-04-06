package april1stCssSelector;

public class CssSelectorConcept {
    public static void main(String[] args) {
        //CSS --> Cascading Style Sheets (CSS) --> Styling the HTML Page

        //CSS Selectors is also one of the most powerful locators
        //It is faster than xpath --> Absolutely wrong statement

        //CSS Selectors are mostly used in:
        //1  Shadow DOM
        //2. SVG Elements

        //CSS Selectors does not support any text based locators

        //Syntax of basic css selector:
        //htmlTag[attribute='value']
        //input[placeholder='First Name']

        //Syntax of finding an element on the basis of ID:
        //#idValue
        //#email

        //Syntax of finding an element on the basis of class:
        //.classValue
        //.form-control

        //Syntax of using contains in css selector:
        //htmlTag[attribute*='value']
        //input[placeholder*='Mobile']

        //Syntax of using starts-with in css selector:
        //htmlTag[attribute^='value']
        //input[placeholder^='Enter']

        //Syntax of using ends-with in css selector:
        //htmlTag[attribute$='value']
        //option[value$='Pradesh']

        //Syntax of finding an element on the basis of multiple attributes:
        //htmlTag[attribute='value'][attributeOne='valueOne']
        //select[name='state'][id='state']

        //Syntax of finding the immediate/direct child:
        //htmlTag>childTag
        //div[class*=team-lft-item]>h2

        //Syntax of finding the indirect child:
        //htmlTag childTag
        //div[class*=team-lft-item] a

        //No Preceding Sibling in CSS Selector
        //No Ancesstor in CSS Selector

        //Syntax of using following sibling:
        //Refer to a direct sibling
        //htmlTag+htmlTag
        //option[value='NCR'] + option

        //Refer to an indirect sibling
        //htmlTag~htmlTag
        //option[value='NCR'] ~ option

        //Syntax of using nth-of-child: --> It is used to find the nth child of the parent
        //htmlTag:nth-child(value)
        //select[name='state'] > option:nth-child(4)

        //Syntax of using last-child: --> It is used to find the last child of the parent
        //htmlTag:last-child
        //select[name='state'] > option:last-child

        //Syntax of using nth-of-last-child: --> It is used to find the nth child from the last of the parent
        //htmlTag:nth-last-child(value)
        //select[name='state'] > option:nth-last-child(1)

        //Syntax of using nth-of-type: --> It is used to find the nth type of the element
        //htmlTag:nth-of-type(value)
        //select[name='state'] > option:nth-of-type(4)
        //input[id='email']:nth-of-type(1)
    }
}
