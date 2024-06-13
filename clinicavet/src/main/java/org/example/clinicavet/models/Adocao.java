package org.example.clinicavet.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adocao {
    private final StringProperty especie;

    public Adocao(String especie) {
        this.especie = new SimpleStringProperty(especie);
    }

    public String getEspecie() {
        return especie.get();
    }

    public StringProperty especieProperty() {
        return especie;
    }

    @Override
    public String toString() {
        return "Adocao{" +
                "especie='" + getEspecie() + '\'' +
                '}';
    }
}