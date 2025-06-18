package frameworks;

import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.ls.LSInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ExcelUtils {

    @SneakyThrows
    public List<Map<String , String >> readCompleteDataFromExcelFile(String filePath, String sheetName)
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

        List<Map<String , String>> data=new ArrayList<>();// it is used to store multiple rows of data
        for (int i=1;i<noOfRows;i++)
        {
            Map<String ,String> record=new HashMap<>();//used to store that particular row of data in the form of key value pair
            for (int j=0;j<noOfColumns;j++)
            {
               // System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+ "\t");
                record.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i).getCell(j).getStringCellValue());
            }
            data.add(record);

        }
    return data;
}


@SneakyThrows
    public String readDataFromExcelFile(String filePath, String sheetName, String columnName){
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

        return sheet.getRow(noOfRows-1).getCell(columnNo).getStringCellValue();
    }

    @SneakyThrows
    public void writeDataToTheFile(String filePath, String sheetName, String columnName, String data)
    {
        File f1= new File(filePath);
        Workbook wb=null; // Represents an Excel workbook
        FileOutputStream fos=null;

        if(!f1.exists())
        {
            if(filePath.endsWith(".xlsx"))
            {
                wb=new XSSFWorkbook();
            }
            else if (filePath.endsWith(".xls")) {
                wb=new HSSFWorkbook();
            }
            fos=new FileOutputStream(filePath);
            wb.write(fos);

        }
        //Reading the existing data from the file
        if(filePath.endsWith(".xlsx"))
        {
            wb=new XSSFWorkbook(new FileInputStream(filePath));
        }//******************************************************************

        //checking the given sheet is present in the excel or not
        //if it is not resent then create the excel sheet

        Sheet sheet = wb.getSheet(sheetName);
        if (sheet == null) {
            sheet = wb.createSheet(sheetName);
        }
        //***********************************************************************
        //Checking if the desired column is present in the excel sheet or not
        //if it is nt present then create the column

        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            headerRow = sheet.createRow(0);
        }

// Find if column exists, else add it
        int columnNo = -1;
        int lastCellNum = headerRow.getLastCellNum(); // may return -1 if no cells

        if (lastCellNum < 0) lastCellNum = 0;

        for (int i = 0; i < lastCellNum; i++) {
            if (headerRow.getCell(i) != null) {
                String cellValue = headerRow.getCell(i).getStringCellValue();
                if (cellValue.equalsIgnoreCase(columnName)) {
                    columnNo = i;
                    break;
                }
            }
        }

        if (columnNo == -1) {
            columnNo = lastCellNum;
            headerRow.createCell(columnNo).setCellValue(columnName); // Add header
        }

        //**************************************************************************************************

        //Adding the data to the last row
        int noOfRows=sheet.getPhysicalNumberOfRows();

        Row newRow=sheet.createRow(noOfRows);

        newRow.createCell(columnNo).setCellValue(data);

        fos=new FileOutputStream(filePath);
        wb.write(fos);
        fos.close();
        wb.close();

    }

}
