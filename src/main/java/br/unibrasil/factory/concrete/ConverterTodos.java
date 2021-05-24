package br.unibrasil.factory.concrete;

import com.google.gson.Gson;

import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.Product.productConcrete.Todos;
import br.unibrasil.factory.ConverterData;

public class ConverterTodos extends ConverterData{

	@Override
	public ObjectData createObjectData(String jsonString) {
		Gson gson = new Gson();
		Todos todos = gson.fromJson(jsonString, Todos.class);		
		return todos;		
	}

}
