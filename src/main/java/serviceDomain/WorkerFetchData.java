package serviceDomain;

import java.io.IOException;
import java.util.Random;

import Interface.IWorkerFetchData;
import ServiceApplication.Request;
import useCase.PlaceHolderUseCase;

public class WorkerFetchData implements Runnable {

	private String URL;
	private int max;
	private IWorkerFetchData listPlaceHolderTodos;

	public WorkerFetchData(String url, int max, IWorkerFetchData listPlaceHolderTodos) {
		this.URL = url;
		this.max = max;
		this.listPlaceHolderTodos = listPlaceHolderTodos;

	}

	public void run() {

		while (this.listPlaceHolderTodos.getContinua()) {
			try {
				String todostJson = new Request().execute(this.URL + this.getRandom(this.max));
				this.listPlaceHolderTodos.setListPlaceHolderTodos(todostJson);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private int getRandom(int max) {
		Random rd = new Random();
		return rd.nextInt(max) + 1;
	}

}
