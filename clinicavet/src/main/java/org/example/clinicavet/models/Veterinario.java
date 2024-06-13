package org.example.clinicavet.models;

public class Veterinario extends Funcionario{
    private static double SALARIO_PADRAO = 5000.00;

    public Veterinario(String nome, String cpf) {
        super(nome, cpf, SALARIO_PADRAO);
    }

    public Veterinario(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
}
