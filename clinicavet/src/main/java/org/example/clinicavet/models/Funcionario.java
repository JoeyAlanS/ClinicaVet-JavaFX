package org.example.clinicavet.models;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;

public abstract class Funcionario {
    private final StringProperty nome;
    private final StringProperty cpf;
    private final DoubleProperty salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.salario = new SimpleDoubleProperty(salario);
    }

    public String getNome() {
        return nome.get();
    }


    public String getCpf() {
        return cpf.get();
    }


    public double getSalario() {
        return salario.get();
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome '" + getNome() + '\'' +
                ", cpf '" + getCpf() + '\'' +
                ", salario " + getSalario() +
                '}';
    }
}