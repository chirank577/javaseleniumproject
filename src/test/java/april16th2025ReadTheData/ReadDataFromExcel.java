package april16th2025ReadTheData;

import frameworks.GenericExceptions;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Optional;

public class ReadDataFromExcel {

    public static void main(String[] args) {
       // readDataFromExcelFile(System.getProperty("user.dir")+"//Reading_Data.xlsx","Sheet_1","Name");
        readCompleteDataFromExcelFile(System.getProperty("user.dir")+"//Reading_Data.xlsx","Sheet_1");
    }
    @SneakyThrows
    public static void readDataFromExcelFile(String filePath, String sheetName, String columnName){
        File f1=new File(filePath);
        Workbook wb=null;

        if(!f1.exists())
            throw new GenericExceptions("File not found for the path: "+filePath);

        else {
            wb = filePath.endsWith(".xlsx") ? new XSSFWorkbook(new FileInputStream(f1)) : new HSSFWorkbook(new FileInputStream(f1));
        }

        Sheet sheet= Optional.ofNullable(wb.getSheet(sheetName)).orElseThrow(()->new GenericExceptions("Sheet not found for :"+ sheetName));

        int noOfColumns=sheet.getRow(0).getPhysicalNumberOfCells();
        int columnNo=-1;
        for (int i=0;i<noOfColumns;i++)
        {
            if (columnName.equals(sheet.getRow(0).getCell(i).getStringCellValue()))
            {
                columnNo=i;
                break;
            }
        }
        if(columnNo==-1)
            throw new GenericExceptions("Column not found for " +columnName);
        int noOfRows=sheet.getPhysicalNumberOfRows();

        System.out.println(sheet.getRow(noOfRows-1).getCell(columnNo).getStringCellValue());


    }
    @SneakyThrows
    public static void readCompleteDataFromExcelFile(String filePath, String sheetName)
    {
        File f1=new File(filePath);
        Workbook wb=null;

        if(!f1.exists())
            throw new GenericExceptions("File not found for the path: "+filePath);

        else {
            wb = filePath.endsWith(".xlsx") ? new XSSFWorkbook(new FileInputStream(f1)) : new HSSFWorkbook(new FileInputStream(f1));
        }

        Sheet sheet= Optional.ofNullable(wb.getSheet(sheetName)).orElseThrow(()->new GenericExceptions("Sheet not found for :"+ sheetName));

        int noOfRows=sheet.getPhysicalNumberOfRows();
        int noOfColumns=sheet.getRow(0).getPhysicalNumberOfCells();

        for (int i=0;i<noOfRows;i++)
        {
            for (int j=0;j<noOfColumns;j++)
            {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+ "\t");
            }
            System.out.println();

        }
    }
}
