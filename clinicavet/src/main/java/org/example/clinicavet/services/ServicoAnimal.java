package org.example.clinicavet.services;

public abstract class ServicoAnimal {
    private String descricao;
    private double preco;

    public ServicoAnimal(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    protected ServicoAnimal() {
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}


