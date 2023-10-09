package IMC;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraIMC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculadora de IMC");

        // Crear etiquetas y campos de entrada
        Label pesoLabel = new Label("Peso (kg):");
        Label alturaLabel = new Label("Altura (cm):");
        Label imcLabel = new Label("IMC:");
        Label clasificacionLabel = new Label("Clasificación:");

        TextField pesoField = new TextField();
        TextField alturaField = new TextField();
        TextField imcField = new TextField();
        TextField clasificacionField = new TextField();
        imcField.setEditable(false);
        clasificacionField.setEditable(false);

        // Crear botón para calcular el IMC
        Button calcularButton = new Button("Calcular");

        // Manejador de eventos para el botón
        calcularButton.setOnAction(e -> {
            try {
                double peso = Double.parseDouble(pesoField.getText());
                double altura = Double.parseDouble(alturaField.getText()) / 100; // Convertir a metros
                double imc = peso / (altura * altura);
                imcField.setText(String.format("%.2f", imc));

                // Clasificar el IMC
                String clasificacion;
                if (imc < 18.5) {
                    clasificacion = "Bajo peso";
                } else if (imc < 25) {
                    clasificacion = "Normal";
                } else if (imc < 30) {
                    clasificacion = "Sobrepeso";
                } else {
                    clasificacion = "Obeso";
                }
                clasificacionField.setText(clasificacion);

            } catch (NumberFormatException ex) {
                // Manejar errores de entrada no válida
                imcField.setText("Error");
                clasificacionField.setText("");
            }
        });

        // Crear VBox para los campos de entrada y el resultado del IMC
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(pesoLabel, pesoField, alturaLabel, alturaField, calcularButton, imcLabel, imcField, clasificacionLabel, clasificacionField);

        // Crear escena
        Scene scene = new Scene(vbox, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



