package serviceDomain;

import com.google.gson.Gson;

import Interface.IWorkerConvertObject;
import Principal.DTOData;
import Principal.tipoURL;
import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.factory.ConverterData;
import br.unibrasil.factory.concrete.ConverterTodos;
import br.unibrasil.factory.concrete.ConverterUser;
import useCase.PlaceHolderUseCase;

public class WorkerConvertObject implements Runnable {

	private IWorkerConvertObject accessPlaceHolderUseCase;
	
	private ConverterData fabrica;
	
	private tipoURL tipoObject = null;

	public WorkerConvertObject(IWorkerConvertObject accessPlaceHolderUseCase) {
		this.accessPlaceHolderUseCase = accessPlaceHolderUseCase;
	}

	public void run() {

		while (this.accessPlaceHolderUseCase.getContinua()) {
			DTOData todostJson = this.accessPlaceHolderUseCase.getElementListPlaceHolderTodos();	
			if (todostJson != null) {
				
				if (tipoObject == null)
				{				
					tipoObject = todostJson.tipoDado;
					fabrica = criarFabrica();
				}
				if (tipoObject != todostJson.tipoDado)
				{				
					tipoObject = todostJson.tipoDado;
					fabrica = criarFabrica();
				}				
				
				ObjectData objectData = fabrica.createObjectData(todostJson.content);
				objectData.listDados();
				System.out.println("Teste");

			}

		}
	}
	
	private ConverterData criarFabrica() {
		
		switch (tipoObject) {
		case TODOS:
			return new ConverterTodos();
		case USERS:
			return new ConverterUser();
		case ALBUMS:
			
			break;
		case PHOTOS:
			
			break;
		case POST:
			
			break;
		case COMMENTS:
			
			break;
		}
		return null;
	}

}
