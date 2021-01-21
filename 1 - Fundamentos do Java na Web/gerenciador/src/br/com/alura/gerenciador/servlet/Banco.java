package br.com.alura.gerenciador.servlet;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static int chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa("Alura");
		empresa.setId(Banco.chaveSequencial++);
		Empresa empresa2 = new Empresa("Caelum");
		empresa2.setId(Banco.chaveSequencial++);
		
		empresas.add(empresa);
		empresas.add(empresa2);
	}
	
	
	public void adicionaEmpresa(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		empresas.add(empresa);
	}


	public static List<Empresa> getEmpresas() {
		return Banco.empresas;
	}


	public void removerEmpresa(Integer id) {
		
		Iterator<Empresa> it = empresas.iterator();
		
		while (it.hasNext())
			if (it.next().getId() == id)
				it.remove();	
	}


	public Empresa buscaPorId(Integer id) {
		for (Empresa empresa : empresas) {
			if (empresa.getId() == id)
				return empresa;
		}
		return null;
	}
}
