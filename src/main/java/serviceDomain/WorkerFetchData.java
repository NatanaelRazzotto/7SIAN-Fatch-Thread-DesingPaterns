package serviceDomain;

import java.io.IOException;
import java.util.Random;

import Interface.IWorkerFetchData;
import Principal.DTOData;
import Principal.tipoURL;
import ServiceApplication.Request;
import useCase.PlaceHolderUseCase;

public class WorkerFetchData implements Runnable {

	private String URL;
	private int max;
	private tipoURL tipoDataFetch;
	private IWorkerFetchData listPlaceHolderTodos;

	public WorkerFetchData(String url, tipoURL tipoDataFetch, int max, IWorkerFetchData listPlaceHolderTodos) {
		this.URL = url + tipoDataFetch.getURL();
		this.max = max;
		this.tipoDataFetch = tipoDataFetch;
		this.listPlaceHolderTodos = listPlaceHolderTodos;
	}

	public void run() {
		try {
			while (this.listPlaceHolderTodos.getContinua()) 
			{			
				DTOData data = new DTOData(tipoDataFetch, getContent());
				this.listPlaceHolderTodos.setListPlaceHolderTodos(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String getContent() throws IOException {
		String todostJson = new Request().execute(this.URL + this.getRandom(this.max));
		return todostJson;
	}

	private int getRandom(int max) {
		Random rd = new Random();
		return rd.nextInt(max) + 1;
	}

}
