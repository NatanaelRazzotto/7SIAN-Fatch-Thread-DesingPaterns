package br.unibrasil.factory.concrete;

import com.google.gson.Gson;


import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.Photo;
import br.unibrasil.Product.productConcrete.User;
import br.unibrasil.factory.ConverterData;

public class ConverterPhoto extends ConverterData{

	@Override
	public ObjectData createObjectData(String jsonString) {
		Gson gson = new Gson();
		Photo user = gson.fromJson(jsonString, Photo.class);		
		return user;	
	}

}
