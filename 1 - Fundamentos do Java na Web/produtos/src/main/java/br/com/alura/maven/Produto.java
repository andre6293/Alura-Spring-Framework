package br.com.alura.maven;

public class Produto {
    private final String nome;
    private final double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s, Preço: R$ %.2f", this.nome, this.preco);
    }

    public double getPrecoComImposto() {
        return preco * 1.01;
    }
}
