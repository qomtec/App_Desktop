package com.DentApp.controllers;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class FrmOpciones extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    private void mostrarformulario(String formulario, String titulo){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root1 = (Parent) loader.load();
            Scene scene = new Scene(root1);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.initStyle(StageStyle.UTILITY);
            stage.showAndWait();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public void im_tratamiento_opcionesOnAction(Event e){
        mostrarformulario("../frm_tipo_tratamiento.fxml","Tipos de tratamiento::.");
    }
}
