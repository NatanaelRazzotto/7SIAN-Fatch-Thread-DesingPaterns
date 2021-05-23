package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;

public class Todos implements ObjectData{
	
	private String userId;
	private String id;
	private String title;
	private String completed;
	
	public Todos ()
	{
		System.out.println("Um item Todo(s) Instanciado ");
		
	}
	public void listDados() {
		System.out.println("Listando ---- ");
		System.out.println("Todos id: " + id);
		// TODO Auto-generated method stub
		
	}




	

}
