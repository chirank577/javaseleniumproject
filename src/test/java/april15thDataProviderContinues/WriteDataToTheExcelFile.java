package april15thDataProviderContinues;

import frameworks.PathUtils;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.PublicKey;
import java.util.Optional;

public class WriteDataToTheExcelFile {
    public static void main(String[] args) {

        writeDataToTheExcelFile(System.getProperty("user.dir")+"//Sample_Data.xlsx","Sample_Sheet","Name","Admin");
    }
    @SneakyThrows
    public static void writeDataToTheExcelFile( String filePath, String sheetName, String column, String data )
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
                    if (cellValue.equalsIgnoreCase(column)) {
                        columnNo = i;
                        break;
                    }
                }
            }

            if (columnNo == -1) {
                columnNo = lastCellNum;
                headerRow.createCell(columnNo).setCellValue(column); // Add header
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
