package april15thDataProviderContinues;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderConcept {

    //Return Types of Data provider:
    //1. Object[] []
    //2. object []
    //3. Iterator < Object []>
    //4. Iterator <Object>

    //DataProvider -> it is used to represent the data provider which provides the required test data to test cases

    @DataProvider (name = "sampleData")
    public Object [][] getDummyData()
    {
        Object [][] data=new  Object[2][2];
        data[0][0]="Hello";
        data[0][1]="Chiru";
        data[1][0]="New";
        data[1][1]="year";

        return data;
    }

    @Test(description = "Sample Data provider Testing", dataProvider = "sampleData")
    public void sampleDataTest(String a, String b)
    {
        System.out.println(a+"--adding--"+b);
    }

    @DataProvider(name = "sampleDataSIngleDimention")
    public Object[] getDummyData_1DArray()
    {
        Object [] data= new Object[3];

        data[0]=123;
        data [1]=456;
        data[2]="chiruuuuuu";

        return data;
    }

    @Test(description = "Sample data one dimentional array", dataProvider ="sampleDataSIngleDimention")
    public void sampleDataOneDimentional(Object o1)
    {
        System.out.println(o1);
    }

    @DataProvider(name = "sampleDataCollection")

    public Iterator<Object> getDummyData_Collections() //if we wish we can use String too instead of Object
    {
        List<Object> l1=new ArrayList<Object>();

        l1.add("ChiranjiviSingh");
        l1.add("Gupta");
        l1.add("Ankit");
        l1.add("BijjurShiva");

        return l1.iterator();
    }

    @Test(description = " Sample Data test using Collection",dataProvider = "sampleDataCollection")
    public void sampleDataTestUsingCollection(Object O1)
    {
        System.out.println(O1);
    }

}
