package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataModelGenerator {

    public static List<DataModel> generate() {
        List<DataModel> models = new ArrayList<>();
        {
            DataModel dataModel = new DataModel();
            dataModel.intValue = 1;
            dataModel.stringValue = "John Doe";
            dataModel.doubleValue = 1.2;
            dataModel.booleanValue = true;
            dataModel.dateTimeValue = LocalDateTime.now().minusDays(1);
            models.add(dataModel);
        }
        {
            DataModel dataModel = new DataModel();
            dataModel.intValue = 2;
            dataModel.stringValue = "Mary Poppins";
            dataModel.doubleValue = 2.3;
            dataModel.booleanValue = false;
            dataModel.dateTimeValue = LocalDateTime.now().plusDays(1);
            models.add(dataModel);
        }
        {
            DataModel dataModel = new DataModel();
            dataModel.intValue = 3;
            dataModel.stringValue = "Heisenberg";
            dataModel.doubleValue = -1.1;
            dataModel.booleanValue = true;
            dataModel.dateTimeValue = null;
            models.add(dataModel);
        }
        return models;
    }
}
