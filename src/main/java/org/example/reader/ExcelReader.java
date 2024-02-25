package org.example.reader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.DataModel;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public void read() {

        // need to manually parse sheet into data
        List<DataModel> data = new ArrayList<>();

        try {

            // read workbook from file
            FileInputStream file = new FileInputStream(Paths.get("e:", "output.xlsx").toFile());
            Workbook workbook = new XSSFWorkbook(file);

            // read sheet
            Sheet sheet = workbook.getSheet("data");// by name or by position

            // skip header
            boolean header = true;
            for (Row row : sheet) {

                // skip header
                if (header) {
                    header = false;
                    continue;
                }

                // skip footer
                if (row.getLastCellNum() == 1) {
                    break;// expected EOF exactly 1 text
                }

                // parse line
                DataModel dataModel = new DataModel();
                dataModel.intValue = (int) row.getCell(0).getNumericCellValue();
                dataModel.stringValue = row.getCell(1).getStringCellValue();
                dataModel.doubleValue = row.getCell(2).getNumericCellValue();
                dataModel.booleanValue = row.getCell(3).getBooleanCellValue();
                dataModel.dateTimeValue = row.getCell(4).getLocalDateTimeCellValue();

                // add parsed data to final result
                data.add(dataModel);

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(data);

    }

}
