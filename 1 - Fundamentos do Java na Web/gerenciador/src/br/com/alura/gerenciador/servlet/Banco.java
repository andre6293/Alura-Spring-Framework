package br.com.alura.gerenciador.servlet;

import java.util.List;
import java.util.ArrayList;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa("Alura");
		Empresa empresa2 = new Empresa("Caelum");
		
		empresas.add(empresa);
		empresas.add(empresa2);
	}
	
	
	public void adicionaEmpresa(Empresa empresa) {
		empresas.add(empresa);
	}


	public static List<Empresa> getEmpresas() {
		return Banco.empresas;
	}
}
