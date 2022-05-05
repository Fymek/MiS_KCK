module com.example.mis_kck {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mis_kck to javafx.fxml;
    exports com.example.mis_kck;
}