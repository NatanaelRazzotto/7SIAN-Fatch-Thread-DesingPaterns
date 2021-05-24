package useCase;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import Interface.IWorkerConvertObject;
import Interface.IWorkerFetchData;
import Principal.DTOData;
import Principal.tipoURL;
import serviceDomain.WorkerConvertObject;
import serviceDomain.WorkerFetchData;

public class PlaceHolderUseCase implements IWorkerFetchData, IWorkerConvertObject {
	
	private String urlPlaceHolder = "https://jsonplaceholder.typicode.com/";
	
	private ArrayList<DTOData> listPlaceHolderTodos = new ArrayList<DTOData>();
	private boolean continua = true;
	private int totalIteracoes = 0;

	public void execute(tipoURL url, int limite) throws InterruptedException {
		
		String tipo = url.getURL();
		System.out.println(tipo);
		
		Instant inicio = Instant.now();
		Thread threadTodos1 = this.initializesFetchData(urlPlaceHolder,url, limite);
		Thread threadTodos2 = this.initializesFetchData(urlPlaceHolder,url, limite);
		Thread threadTodos3 = this.initializesFetchData(urlPlaceHolder,url, limite);
		
		Thread threadConvert1 = this.initializesConvertObject();

		threadTodos1.join();
		threadTodos2.join();
		threadTodos3.join();
		
		threadConvert1.join();
		
		Instant fim = Instant.now();
		Duration duracaoA = Duration.between(inicio, fim);
		System.out.println("Duração:" + duracaoA.toMillis());

	}

	private Thread initializesConvertObject() {
		Thread thread = new Thread(new WorkerConvertObject(this));
		thread.start();
		return thread;

	}

	private Thread initializesFetchData(String url,tipoURL tipoDataFetch, int max) {
		Thread thread = new Thread(new WorkerFetchData(url,tipoDataFetch, max,this));
		thread.start();
		return thread;
	}

	public synchronized void setListPlaceHolderTodos(DTOData todosJSon) {
		this.listPlaceHolderTodos.add(todosJSon);
		this.maximumIterations();
		this.totalIteracoes++;
	//	System.out.println(this.listPlaceHolderTodos.size());
	}

	public synchronized boolean getContinua() {
		return this.continua;
	}

	public synchronized DTOData getElementListPlaceHolderTodos() {
		if (this.listPlaceHolderTodos.size() > 0) {
			return this.listPlaceHolderTodos.remove(0);
		}
		return null;
	}

	public void maximumIterations() {
		if (this.listPlaceHolderTodos.size() >= 100 || this.totalIteracoes == 100) {
			this.continua = false;
		}
	}

}
