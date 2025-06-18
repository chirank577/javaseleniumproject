package april16th2025ReadTheData;

import frameworks.ExcelUtils;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataProviderWithExcel {


    @DataProvider(name = "testDataWithExcel")
    public Iterator<Map<String ,String >> getData()
    {
        ExcelUtils excelUtils=new ExcelUtils();
        List<Map<String,String>> completeData = excelUtils.readCompleteDataFromExcelFile(System.getProperty("user.dir")+"//Reading_Data.xlsx","Sheet_1");;

        return completeData.iterator();
    }

    @Test(description = "Printing data From Excel",dataProvider = "testDataWithExcel")
    public void printDatafromExcel(Map<String ,String >data){
        System.out.println(data);

    }
}
