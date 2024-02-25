package org.example.writer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.DataModel;
import org.example.model.DataModelGenerator;

import java.io.FileOutputStream;
import java.nio.file.Paths;

public class ExcelWriter {

    public void write() {

        // create workbook
        Workbook workbook = new XSSFWorkbook();

        // create sheet
        Sheet sheet = workbook.createSheet("data");

        // write header
        int rownum = 0;
        {
            Row headerRow = sheet.createRow(rownum);
            Cell cellInt = headerRow.createCell(0);
            cellInt.setCellValue("int");
            Cell cellString = headerRow.createCell(1);
            cellString.setCellValue("String");
            Cell cellDouble = headerRow.createCell(2);
            cellDouble.setCellValue("Double");
            Cell cellBoolean = headerRow.createCell(3);
            cellBoolean.setCellValue("Boolean");
            Cell cellDateTime = headerRow.createCell(4);
            cellDateTime.setCellValue("DateTime");
        }

        // write data
        {
            for (DataModel dataModel : DataModelGenerator.generate()) {

                rownum++;
                Row row = sheet.createRow(rownum);

                {
                    Cell cell = row.createCell(0);
                    cell.setCellValue(dataModel.intValue);
                }
                {
                    Cell cell = row.createCell(1);
                    cell.setCellValue(dataModel.stringValue);
                }
                {
                    Cell cell = row.createCell(2);
                    cell.setCellValue(dataModel.doubleValue);
                }
                {
                    Cell cell = row.createCell(3);
                    cell.setCellValue(dataModel.booleanValue);
                }
                {
                    Cell cell = row.createCell(4);
                    cell.setCellValue(dataModel.dateTimeValue);
                }

            }
        }

        // write footer
        {
            rownum++;
            Row row = sheet.createRow(rownum);
            Cell cell = row.createCell(0);
            cell.setCellValue("EOF");
        }

        // write workbook to a file
        try {
            FileOutputStream outputStream = new FileOutputStream(Paths.get("e:", "output.xlsx").toFile());
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
