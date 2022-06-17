module ru.zaza.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.zaza.calculator to javafx.fxml;
    exports ru.zaza.calculator;
}