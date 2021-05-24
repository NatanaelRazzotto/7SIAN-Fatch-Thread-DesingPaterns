package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;

public class Todos implements ObjectData{
	
	private int userId;
	private int id;
	private String title;
	private String completed;
	
	public Todos ()
	{
		System.out.println("Um item Todo(s) Instanciado ");
		
	}
	public void listDados() {
		System.out.println("Listando ------------ ");
	
		System.out.println((id != 0)?"Todos id: "+id:"???");
		System.out.println((userId != 0)?"Usuario id associado: " +userId:"???");
		System.out.println((title != null && !title.isEmpty())?"Titulo: "+title:"???");
		System.out.println((completed != null && !completed.isEmpty())?"Completed: "+ completed:"???");

	}
	public void getIdObject() {
		// TODO Auto-generated method stub
		
	}
	public void getNomeObject() {
		// TODO Auto-generated method stub
		
	}




	

}
