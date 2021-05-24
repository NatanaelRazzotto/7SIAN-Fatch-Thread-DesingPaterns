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
	public void listarDados() {
		System.out.println("------------Listando Todos------------ ");
	
		System.out.println((id != 0)?"Todos id: "+id:"???");
		System.out.println((userId != 0)?"Usuario id associado: " +userId:"???");
		System.out.println((title != null && !title.isEmpty())?"Titulo: "+title:"???");
		System.out.println((completed != null && !completed.isEmpty())?"Completed: "+ completed:"???");

	}
	public int getIdObject() {
		
		System.out.println("--------- Todos------------ ");
		System.out.println("Id Item Todos: "+ id);
		System.out.println("UserId Associado a Todos: "+ userId);		
		return id;		
	}

	public String getNomeObject() {
		System.out.println("--------- Todos------------ ");
		System.out.println("Id Item Todos: "+ id);
		System.out.println("UserId Associado a Todos: "+ userId);	
		System.out.println("Titulo: "+ title);		
		return title;		
		
	}




	

}
