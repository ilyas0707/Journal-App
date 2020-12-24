package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.print("Journal program started!\n");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Journal.fxml"));
        stage.setTitle("Journal app");
        stage.setScene(new Scene(root,600, 400));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.print("Journal closed!\n");
    }



}
