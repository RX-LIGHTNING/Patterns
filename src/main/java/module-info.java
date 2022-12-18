module com.laba.laba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.laba.laba to javafx.fxml;
    exports com.laba.laba;
    exports com.laba.laba.controller;
    exports com.laba.laba.Entity;
    opens com.laba.laba.controller to javafx.fxml;
    exports com.laba.laba.Utils;
}