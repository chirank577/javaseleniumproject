package frameworks;

import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
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
                Cell headerCell = sheet.getRow(0).getCell(j);
                Cell dataCell = sheet.getRow(i).getCell(j);

                String key = (headerCell != null) ? headerCell.toString().trim() : "";
                String value = (dataCell != null) ? dataCell.toString().trim() : "";
               // System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+ "\t");
                record.put(key,value);
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
    public void writeDataToTheFile(String filePath, String sheetName, String columnName, String data, String... rowIdentifier) {
        File f1 = new File(filePath);
        Workbook wb;
        FileOutputStream fos;

        if (!f1.exists()) {
            if (filePath.endsWith(".xlsx")) {
                wb = new XSSFWorkbook();
            } else if (filePath.endsWith(".xls")) {
                wb = new HSSFWorkbook();
            } else {
                throw new IllegalArgumentException("Unsupported file type.");
            }
            fos = new FileOutputStream(filePath);
            wb.write(fos);
            fos.close();
        }

        if (filePath.endsWith(".xlsx")) {
            wb = new XSSFWorkbook(new FileInputStream(filePath));
        } else {
            wb = new HSSFWorkbook(new FileInputStream(filePath));
        }

        Sheet sheet = wb.getSheet(sheetName);
        if (sheet == null) {
            sheet = wb.createSheet(sheetName);
        }

        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            headerRow = sheet.createRow(0);
        }

        // Find the column number for the columnName (Execution Status)
        int executionStatusCol = -1;
        int lastCellNum = headerRow.getLastCellNum();
        if (lastCellNum < 0) lastCellNum = 0;

        for (int i = 0; i < lastCellNum; i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null && cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                executionStatusCol = i;
                break;
            }
        }

        // If Execution Status column doesn't exist, create it at the end
        if (executionStatusCol == -1) {
            executionStatusCol = lastCellNum;
            headerRow.createCell(executionStatusCol).setCellValue(columnName);
        }

        // Find the column number for "Test Case Name" column (to locate the row)
        int testCaseNameCol = -1;
        for (int i = 0; i < lastCellNum; i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null && cell.getStringCellValue().equalsIgnoreCase("Test Case Name")) {
                testCaseNameCol = i;
                break;
            }
        }
        if (testCaseNameCol == -1) {
            throw new RuntimeException("Test Case Name column not found in sheet!");
        }

        // Find the row where the test case name matches the identifier passed
        int targetRowNum = -1;
        if (rowIdentifier != null && rowIdentifier.length > 0) {
            String testCaseToFind = rowIdentifier[0].split("-")[1];
            int totalRows = sheet.getPhysicalNumberOfRows()+1;

            for (int i = 1; i < totalRows; i++) { // skip header row
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(testCaseNameCol);
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if (cellValue.equalsIgnoreCase(testCaseToFind)) {
                            targetRowNum = i;
                            break;
                        }
                    }
                }
            }
        }

        if (targetRowNum == -1) {
            // No matching row found, create a new one at the end
            targetRowNum = sheet.getPhysicalNumberOfRows();
        }

        Row rowToWrite = sheet.getRow(targetRowNum);
        if (rowToWrite == null) {
            rowToWrite = sheet.createRow(targetRowNum);
        }

        Cell statusCell = rowToWrite.getCell(executionStatusCol);
        if (statusCell == null) {
            statusCell = rowToWrite.createCell(executionStatusCol);
        }
        statusCell.setCellValue(data);

        // Optional: set color style for PASSED / FAILED
        CellStyle style = wb.createCellStyle();
        if (data.equalsIgnoreCase("PASSED")) {
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            statusCell.setCellStyle(style);
        } else if (data.equalsIgnoreCase("FAILED")) {
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            statusCell.setCellStyle(style);
        }

        fos = new FileOutputStream(filePath);
        wb.write(fos);
        fos.close();
        wb.close();
    }


    public void printAvailableSheets(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = filePath.endsWith(".xlsx") ? new XSSFWorkbook(fis) : new HSSFWorkbook(fis);
        System.out.println("Available sheet names:");
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            System.out.println("- " + workbook.getSheetName(i));
        }
        workbook.close();
    }
}
