module com.crownhounds.montunofrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.crownhounds.montunofrontend to javafx.fxml;
    exports com.crownhounds.montunofrontend;
}