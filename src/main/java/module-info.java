module com.shamilla.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.shamilla.calculator to javafx.fxml;
    exports com.shamilla.calculator;
}