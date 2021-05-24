package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;

public class Album implements ObjectData{
	private int userId;
	private int id;
	private String title;
	
	public Album ()
	{
		System.out.println("Um item 'Album' Instanciado ");		
	}
	
	public void listarDados() {		
		System.out.println("------------Listando Album------------ ");
		
		System.out.println((id != 0)?"Album id: "+id:"???");
		System.out.println((userId != 0)?"Usuario id associado: " +userId:"???");
		System.out.println((title != null && !title.isEmpty())?"Titulo: "+title:"???");		
	}

	public int getIdObject() {
		
		System.out.println("--------- Album------------ ");
		System.out.println("Id Item Album: "+ id);
		System.out.println("userId Associado a Album: "+ userId);		
		return id;		
	}

	public String getNomeObject() {
		System.out.println("--------- Album------------ ");
		System.out.println("Id Item Album: "+ id);
		System.out.println("userId Associado a Album: "+ userId);	
		System.out.println("Title: "+ title);		
		return title;		
		
	}

}
