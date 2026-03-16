module com.example.dc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dc to javafx.fxml;
    exports com.example.dc;
}