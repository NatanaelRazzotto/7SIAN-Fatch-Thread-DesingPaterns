package br.unibrasil.factory.concrete;

import com.google.gson.Gson;


import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.Post;
import br.unibrasil.Product.productConcrete.User;
import br.unibrasil.factory.ConverterData;

public class ConverterPost extends ConverterData{

	@Override
	public ObjectData createObjectData(String jsonString) {
		Gson gson = new Gson();
		Post user = gson.fromJson(jsonString, Post.class);		
		return user;	
	}

}
