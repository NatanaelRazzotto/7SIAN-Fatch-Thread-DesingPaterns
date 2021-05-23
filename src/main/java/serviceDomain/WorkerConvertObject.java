package serviceDomain;

import com.google.gson.Gson;

import Interface.IWorkerConvertObject;
import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.factory.ConverterData;
import br.unibrasil.factory.concrete.ConverterTodos;

public class WorkerConvertObject implements Runnable {

	private IWorkerConvertObject accessPlaceHolderUseCase;
	Gson gson = null;

	public WorkerConvertObject(IWorkerConvertObject accessPlaceHolderUseCase) {
		this.accessPlaceHolderUseCase = accessPlaceHolderUseCase;
		gson = new Gson();

	}

	public void run() {

		while (this.accessPlaceHolderUseCase.getContinua()) {
			String todostJson = this.accessPlaceHolderUseCase.getElementListPlaceHolderTodos();

			if (todostJson != null) {
				
				ConverterData creator = new ConverterTodos();
				ObjectData objectData = creator.createObjectData(todostJson);
				objectData.listDados();
				System.out.println("Teste");

			}

		}
	}

}
