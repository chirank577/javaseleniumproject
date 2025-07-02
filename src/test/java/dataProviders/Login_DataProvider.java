package dataProviders;

import frameworks.PathUtils;
import frameworks.ReusableLibrary;
import frameworks.constants.AppConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Login_DataProvider extends ReusableLibrary {

    @DataProvider(name = "loginTestData")
    public Iterator<Map<String ,String>>getData()
    {
        List <Map<String,String>> data=excelUtils.readCompleteDataFromExcelFile(PathUtils .getTestDataFolder()+"Login_Test_Data.xlsx", AppConstants.LOGIN_SHEET);

        return data.iterator();
    }

    @DataProvider(name = "testDataExecution")
    public Iterator<Map<String ,String>>getTestData(Method m)
    {
        List <Map<String,String>> data = excelUtils.readCompleteDataFromExcelFile(PathUtils.getTestDataFolder() + "Sample_Execution.xlsx", AppConstants.INDEX_SHEET);

        String  sheetName=data.stream().filter(s->
                (s.get("Test Case Name").equalsIgnoreCase(m.getName()) && s.get("Run Mode").equalsIgnoreCase("Y")))
                .map(s-> s.get("Sheet Name")).collect(Collectors.joining());

        if(sheetName.isBlank()){
           return new ArrayList<Map<String ,String >>().iterator();
        }
        else {
            data = excelUtils.readCompleteDataFromExcelFile(PathUtils.getTestDataFolder() + "Sample_Execution.xlsx", sheetName);
            return data.iterator();
        }
    }




}
