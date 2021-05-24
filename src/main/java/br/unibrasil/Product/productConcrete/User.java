package br.unibrasil.Product.productConcrete;

import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.subclass.Addres;
import br.unibrasil.Product.productConcrete.subclass.Company;

public class User implements ObjectData{
	 String id;
	 String name;
	 String username;
	 String email;
	 Addres address;
	 String phone;
	 String website;
	 Company company;
	 
	public User ()
	{
		System.out.println("Um item User Instanciado ");		
	}

	public void listDados() {
		System.out.println("Listando ------------ ");
		System.out.println("Todos id: "+ id);
		System.out.println("Nome: "+ name);
		System.out.println("Usuario Nome: "+ username);
		System.out.println("E-mail: "+ email);
		System.out.println("Phone: "+ phone);
		System.out.println("Website: "+ website);
		
	}

	public void getIdObject() {
		// TODO Auto-generated method stub
		
	}

	public void getNomeObject() {
		// TODO Auto-generated method stub
		
	}
}
