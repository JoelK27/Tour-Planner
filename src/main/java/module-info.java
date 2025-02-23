module helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens at.fhtw.tourplanner to javafx.graphics, javafx.fxml;
    exports at.fhtw.tourplanner;
    exports at.fhtw.tourplanner.controller;
    opens at.fhtw.tourplanner.controller to javafx.fxml, javafx.graphics;
    exports at.fhtw.tourplanner.viewmodel;
    opens at.fhtw.tourplanner.viewmodel to javafx.fxml, javafx.graphics;
}
