package com;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class JournalController {
    @FXML
    Label console;
    @FXML
    TextField nameField;
    @FXML
    TextField pointsField;
    @FXML
    Label name1;
    @FXML
    Label name2;
    @FXML
    Label name3;
    @FXML
    Label name4;
    @FXML
    Label name5;
    @FXML
    Label point1;
    @FXML
    Label point2;
    @FXML
    Label point3;
    @FXML
    Label point4;
    @FXML
    Label point5;

    public void loadDB(){
        DBAccess dbAccess = new DBAccess();
        List<Data> dataList = dbAccess.fetchData();
        try{
            name1.setText(dataList.get(0).getName());
            point1.setText(dataList.get(0).getPoints());
            name2.setText(dataList.get(1).getName());
            point2.setText(dataList.get(1).getPoints());
            name3.setText(dataList.get(2).getName());
            point3.setText(dataList.get(2).getPoints());
            name4.setText(dataList.get(3).getName());
            point4.setText(dataList.get(3).getPoints());
            name5.setText(dataList.get(4).getName());
            point5.setText(dataList.get(4).getPoints());
        }
        catch (IndexOutOfBoundsException ex){
            switch (dataList.size()){
                case 0: name1.setText("");
                    point1.setText("");
                case 1: name2.setText("");
                    point2.setText("");
                case 2: name3.setText("");
                    point3.setText("");
                case 3: name4.setText("");
                    point4.setText("");
                case 4: name5.setText("");
                    point5.setText("");
            }
        }
    }
    public void save(){
        DBAccess dbAccess = new DBAccess();
        dbAccess.addData(new Data(nameField.getText(), pointsField.getText()));
        loadDB();
    }
    public void clearAll(){
        DBAccess dbAccess = new DBAccess();
        dbAccess.reset();
        loadDB();
    }


}
