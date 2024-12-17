module com.empresa.systemerp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens com.empresa.systemerp to javafx.fxml;
    opens com.empresa.systemerp.controller to javafx.fxml;

    exports com.empresa.systemerp.controller;
    exports com.empresa.systemerp;
}