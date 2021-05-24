package br.unibrasil.factory.concrete;

import com.google.gson.Gson;


import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.Album;
import br.unibrasil.Product.productConcrete.User;
import br.unibrasil.factory.ConverterData;

public class ConverterAlbum extends ConverterData{

	@Override
	public ObjectData createObjectData(String jsonString) {
		Gson gson = new Gson();
		Album user = gson.fromJson(jsonString, Album.class);		
		return user;	
	}

}
