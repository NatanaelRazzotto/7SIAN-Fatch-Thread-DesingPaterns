package br.unibrasil.factory;

import br.unibrasil.Product.productAbstract.ObjectData;

public abstract class ConverterData {//implements Runnable 
	
	public abstract ObjectData createObjectData(String jsonString);
	
	public String exibeMensage() {
			return "Conversor de Objetos Place Holder";
		
	}

}
