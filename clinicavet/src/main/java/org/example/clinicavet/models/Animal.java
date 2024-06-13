package org.example.clinicavet.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class Animal {
    private final StringProperty nome;
    private final IntegerProperty idade;
    private final StringProperty especie;

    public Animal(String nome, int idade, String especie) {
        this.nome = new SimpleStringProperty(nome);
        this.idade = new SimpleIntegerProperty(idade);
        this.especie = new SimpleStringProperty(especie);
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public int getIdade() {
        return idade.get();
    }

    public String getEspecie() {
        return especie.get();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome'" + getNome() + '\'' +
                ", idade" + getIdade() +
                ", especie'" + getEspecie() + '\'' +
                '}';
    }
}