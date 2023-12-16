module agh.ics.oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports agh.ics.oop;
    exports agh.ics.oop.model to javafx.graphics;
    opens agh.ics.oop.presenter to javafx.fxml;
    exports agh.ics.oop.presenter to javafx.fxml, javafx.graphics;

}