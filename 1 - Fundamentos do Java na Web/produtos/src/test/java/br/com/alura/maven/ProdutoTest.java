package br.com.alura.maven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProdutoTest {

    @Test
    public void verificaPrecoComImposto() {
        Produto mesa = new Produto("Mesa", 400D);
        assertEquals(404, mesa.getPrecoComImposto(), 0.0001);
    }

    @Test
    public void toStringTeste() {
        Produto abajur = new Produto("Abajur", 90);
        assertEquals("Produto: Abajur, Preço: R$ 90,00", abajur.toString());
    }
}
