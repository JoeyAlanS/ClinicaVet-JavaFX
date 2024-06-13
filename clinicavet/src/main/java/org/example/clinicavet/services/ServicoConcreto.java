package org.example.clinicavet.services;

public class ServicoConcreto extends ServicoAnimal {
    private String descricao;
    private double preco;

    public ServicoConcreto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
