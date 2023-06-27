package com.shamilla.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {
    private Label lblWidth;
    private Label lblHeight;
    private Label lblArea;
    private TextField txtWidth;
    private TextField txtHeight;
    private TextField txtArea;
    private Button btnCalculate;
    private Button btnClear;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(5);

        lblWidth = new Label("Width");
        lblWidth.setPrefWidth(100);
        txtWidth = new TextField();
        grid.add(lblWidth, 0, 0, 1, 1);
        grid.add(txtWidth, 1, 0, 1, 1);

        lblHeight = new Label("Height");
        txtHeight = new TextField();
        grid.add(lblHeight, 0, 1, 1, 1);
        grid.add(txtHeight, 1, 1, 1, 1);

        lblArea = new Label("Area");
        txtArea = new TextField();
        txtArea.setEditable(false);
        grid.add(lblArea, 0, 2, 1, 1);
        grid.add(txtArea, 1, 2, 1, 1);

        btnCalculate = new Button("Calculate");
        btnCalculate.setPrefWidth(100);
        btnClear = new Button("Clear");
        btnClear.setPrefWidth(100);

        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int width = Integer.parseInt(txtWidth.getText());
                int height = Integer.parseInt(txtHeight.getText());

                int area = width * height;

                txtArea.setText(area+"");
            }
        });

        btnClear.setOnAction(e -> {
            txtWidth.setText("");
            txtHeight.setText("");
            txtArea.setText("");

        });

        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().addAll(btnCalculate, btnClear);
        grid.add(hb, 1, 3, 1, 1);

        Scene scene = new Scene(grid);
        stage.setTitle("Calculate Rectangle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}