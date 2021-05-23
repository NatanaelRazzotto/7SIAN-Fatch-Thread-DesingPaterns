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
		System.out.println("User");
		
	}

	public void listDados() {
		// TODO Auto-generated method stub
		
	}
}
