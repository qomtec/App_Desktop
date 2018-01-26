package com.DentApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.Console;
import java.io.IOException;

public class JfrmPrincipal extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @FXML private Button btn_salir = new Button();
    @FXML private TextField txt_usuario;
    @FXML private PasswordField txt_pass;
    @FXML private ImageView im_clinica;
    @FXML private Pane p_principal;
    @Override
    public void start(Stage primaryStage) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/DentApp/views/frm_Principal.fxml"));
            primaryStage.setTitle("Ingreso::.");
            primaryStage.setScene(new Scene(root,900,600));
//        primaryStage.resizableProperty().setValue(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Muestra los formularios segun la dirección del formulario y el titulo
     * @param formulario direccion del formulario
     * @param titulo nombre de la ventana a mostrar
     */
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
    public void im_clinicaOnAction (Event e){
        mostrarformulario("/com/DentApp/views/frm_clinica.fxml","Clinica::.");
    }
    public void im_odontologOnAction (Event e){
        mostrarformulario("/com/DentApp/views/frm_odontologo.fxml","Odontólogo");
    }
    public void im_pacienteOnAction (Event e){
        mostrarformulario("/com/DentApp/views/frm_paciente.fxml","Paciente");
    }
    public void im_tratamientoOnAction (Event e){
        mostrarformulario("/com/DentApp/views/frm_tipo_tratamiento.fxml","Tipos de tratamiento::.");
    }
    public void im_pagoOnAction (Event e){
        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setContentText("odontologo");
        mensaje.showAndWait();
    }
    public void im_opcionesOnAction (Event e){
        mostrarformulario("/com/DentApp/views/frm_opciones.fxml","Opciones::.");
    }
    public void btn_salirOnAction (Event e){
        Stage stage = (Stage) btn_salir.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    public void btn_ingresarOnAction(Event e) throws IOException {
        p_principal.setDisable(false);
    }

}
