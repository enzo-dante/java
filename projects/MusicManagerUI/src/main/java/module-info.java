module com.crownhoundz.musicmanagerui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.crownhoundz.musicmanagerui.model;
    opens com.crownhoundz.musicmanagerui to javafx.fxml;
    exports com.crownhoundz.musicmanagerui;
}



