package serviceDomain;

import com.google.gson.Gson;

import Interface.IWorkerConvertObject;
import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.factory.ConverterData;
import br.unibrasil.factory.concrete.ConverterAlbum;
import br.unibrasil.factory.concrete.ConverterComment;
import br.unibrasil.factory.concrete.ConverterPhoto;
import br.unibrasil.factory.concrete.ConverterPost;
import br.unibrasil.factory.concrete.ConverterTodo;
import br.unibrasil.factory.concrete.ConverterUser;
import br.unibrasil.util.DTOData;
import br.unibrasil.util.tipoURL;
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
			DTOData todostJson = this.accessPlaceHolderUseCase.getElementListPlaceHolderDTOData();	
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
				this.accessPlaceHolderUseCase.setListPlaceHolderObjectData(objectData);
			}

		}
	}
	
	private ConverterData criarFabrica() {
		
		switch (tipoObject) {
		case TODOS:
			return new ConverterTodo();
		case USERS:
			return new ConverterUser();
		case ALBUMS:
			return new ConverterAlbum();
		case PHOTOS:
			return new ConverterPhoto();
		case POST:
			return new ConverterPost();
		case COMMENTS:
			return new ConverterComment();
		}
		return null;
	}

}
