module org.example.clinicavet {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.example.clinicavet.models to javafx.base;
    opens org.example.clinicavet to javafx.fxml;
    exports org.example.clinicavet;
    exports org.example.clinicavet.models;
    exports org.example.clinicavet.services;
    opens org.example.clinicavet.services to javafx.base;
}