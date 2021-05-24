package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.subclass.Addres;
import br.unibrasil.Product.productConcrete.subclass.Company;
import br.unibrasil.Product.productConcrete.subclass.Geo;

public class User implements ObjectData{
	 private int id;
	 private String name;
	 private String username;
	 private String email;
	 private Addres address;
	 private String phone;
	 private String website;
	 private Company company;
	 
	public User ()
	{
		System.out.println("Um item 'User' Instanciado ");		
	}

	public void listarDados() {
		System.out.println("---------Listando Usuário------------ ");
		
		System.out.println("id: "+ id);
		System.out.println("Nome: "+ name);
		System.out.println("Usuario Nome: "+ username);
		System.out.println("E-mail: "+ email);
		System.out.println("Phone: "+ phone);
		System.out.println("Website: "+ website);	
		listarEndereço();
		listarCompanhia();
	}
	
	public void listarEndereço() {
		
		System.out.println("****Listando Endereço Usuário***** ");
		
		System.out.println("Street: "+ address.getStreet());
		System.out.println("Suite: "+ address.getSuite());
		System.out.println("City: "+ address.getCity());
		System.out.println("Zipcode: "+ address.getZipcode());
		System.out.println("Geo: "+ address.getGeo());		
		Geo coordenada  = address.getGeo();	
		listarGeo(coordenada);
	}
	
	public void listarGeo(Geo coordenadas) {
		System.out.println("****Listando Coordenadas do Endereço***** ");		
		System.out.println("Latitude: "+ coordenadas.getLat());
		System.out.println("Latitude: "+ coordenadas.getLng());
		
	}
	
	public void listarCompanhia() {
		System.out.println("****Listando Companhia do Usuário***** ");		
		System.out.println("Nome: "+ company.getName());
		System.out.println("Nome: "+ company.getCatchPhrase());
		System.out.println("Nome: "+ company.getBs());		
	}	

	public int getIdObject() {
		
		System.out.println("--------- Usuário------------ ");
		System.out.println("id do usuário: "+ id);		
		return id;		
	}

	public String getNomeObject() {
		System.out.println("--------- Usuário------------ ");
		System.out.println("id do usuário: "+ id);
		System.out.println("Nome do usuário: "+ name);		
		return name;		
		
	}
}
