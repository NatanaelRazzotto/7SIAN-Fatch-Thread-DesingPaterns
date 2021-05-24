package br.unibrasil.factory.concrete;

import com.google.gson.Gson;


import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.Comment;
import br.unibrasil.Product.productConcrete.User;
import br.unibrasil.factory.ConverterData;

public class ConverterComment extends ConverterData{

	@Override
	public ObjectData createObjectData(String jsonString) {
		Gson gson = new Gson();
		Comment user = gson.fromJson(jsonString, Comment.class);		
		return user;	
	}

}
