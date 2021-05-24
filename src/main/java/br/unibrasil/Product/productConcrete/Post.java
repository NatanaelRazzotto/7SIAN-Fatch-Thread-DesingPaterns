package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;

public class Post implements ObjectData{
	private int userId;
	private int id;
	private String title;
	private String body;
	
	public Post ()
	{
		System.out.println("Um item 'Post' Instanciado ");		
	}
	
	public void listarDados() {
		
		System.out.println("------------Listando Post------------ ");
		
		System.out.println((id != 0)?"Post id: "+id:"???");
		System.out.println((userId != 0)?"Usuario id associado: " +userId:"???");
		System.out.println((title != null && !title.isEmpty())?"Titulo: "+title:"???");
		System.out.println((body != null && !body.isEmpty())?"Completed: "+ body:"???");
		
	}

	public int getIdObject() {
		
		System.out.println("--------- Post------------ ");
		System.out.println("Id Item Post: "+ id);
		System.out.println("UserId Associado a Post: "+ userId);		
		return id;		
	}

	public String getNomeObject() {
		System.out.println("--------- Post------------ ");
		System.out.println("Id Item Posts: "+ id);
		System.out.println("UserId Associado a Post: "+ userId);	
		System.out.println("Titulo: "+ title);		
		return title;		
		
	}

}
