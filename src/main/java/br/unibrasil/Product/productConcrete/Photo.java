package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;

public class Photo implements ObjectData{
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String thumbnailUrl;
	
	public Photo ()
	{
		System.out.println("Um item 'Photo' Instanciado ");		
	}
	
	public void listarDados() {
		System.out.println("------------Listando Photo------------ ");
		
		System.out.println((id != 0)?"Photo id: "+id:"???");
		System.out.println((albumId != 0)?"Album id associado: " +albumId:"???");
		System.out.println((title != null && !title.isEmpty())?"Titulo: "+title:"???");
		System.out.println((url != null && !url.isEmpty())?"URL: "+ url:"???");
		System.out.println((thumbnailUrl != null && !thumbnailUrl.isEmpty())?"thumbnailUrl: "+ thumbnailUrl:"???");				
	
	}
	public int getIdObject() {
		
		System.out.println("--------- Post------------ ");
		System.out.println("Id Item Posts: "+ id);
		System.out.println("albumId Associado a Posts: "+ albumId);		
		return id;		
	}

	public String getNomeObject() {
		System.out.println("--------- Post------------ ");
		System.out.println("Id Item Photo: "+ id);
		System.out.println("albumId Associado a Photo: "+ albumId);	
		System.out.println("Titulo: "+ title);		
		return title;		
		
	}
	

}
