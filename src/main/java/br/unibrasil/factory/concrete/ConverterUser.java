package br.unibrasil.factory.concrete;

import com.google.gson.Gson;


import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.User;
import br.unibrasil.factory.ConverterData;

public class ConverterUser extends ConverterData{

	@Override
	public ObjectData createObjectData(String jsonString) {
		Gson gson = new Gson();
		User user = gson.fromJson(jsonString, User.class);		
		return user;	
	}

}
