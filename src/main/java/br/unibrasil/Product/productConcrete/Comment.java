package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;

public class Comment implements ObjectData{
	private int postId;
	private int id;
	private String name;
	private String email;
	private String body;
	
	public Comment ()
	{
		System.out.println("Um item 'Comment' Instanciado ");		
	}
	
	public void listarDados() {
		System.out.println("------------Listando Comment------------ ");
		
		System.out.println((id != 0)?"Comment id: "+id:"???");
		System.out.println((postId != 0)?"Post id associado: " +postId:"???");
		System.out.println((name != null && !name.isEmpty())?"Name: "+name:"???");
		System.out.println((email != null && !email.isEmpty())?"E-mail: "+ email:"???");
		System.out.println((body != null && !body.isEmpty())?"Body: "+ body:"???");
		
	}

	public int getIdObject() {
		
		System.out.println("--------- Comment------------ ");
		System.out.println("Id Item Comment: "+ id);
		System.out.println("postId Associado a Comment: "+ postId);		
		return id;		
	}

	public String getNomeObject() {
		System.out.println("--------- Comment------------ ");
		System.out.println("Id Item Comment: "+ id);
		System.out.println("postId Associado a Comment: "+ postId);	
		System.out.println("Name: "+ name);		
		return name;		
		
	}

}
