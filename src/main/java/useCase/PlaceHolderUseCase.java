package useCase;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import Interface.IWorkerConvertObject;
import Interface.IWorkerFetchData;
import serviceDomain.WorkerConvertObject;
import serviceDomain.WorkerFetchData;

public class PlaceHolderUseCase implements IWorkerFetchData, IWorkerConvertObject {
	private ArrayList<String> listPlaceHolderTodos = new ArrayList<String>();
	private boolean continua = true;
	private int totalIteracoes = 0;

	public void execute(String url) throws InterruptedException {
		Instant inicio = Instant.now();
		Thread threadTodos1 = this.initializesFetchData(url + "todos/", 200);
		Thread threadTodos2 = this.initializesFetchData(url + "todos/", 200);
		Thread threadTodos3 = this.initializesFetchData(url + "todos/", 200);

		Thread threadUsers1 = this.initializesFetchData(url + "users/", 10);
		Thread threadUsers2 = this.initializesFetchData(url + "users/", 10);
		Thread threadUsers3 = this.initializesFetchData(url + "users/", 10);
		
		Thread threadConvert1 = this.initializesConvertObject();

		threadTodos1.join();
		threadTodos2.join();
		threadTodos3.join();
		
		threadUsers1.join();
		threadUsers2.join();
		threadUsers3.join();
		
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

	private Thread initializesFetchData(String url, int max) {
		Thread thread = new Thread(new WorkerFetchData(url, max, this));
		thread.start();
		return thread;
	}

	public synchronized void setListPlaceHolderTodos(String todosJSon) {
		this.listPlaceHolderTodos.add(todosJSon);
		this.maximumIterations();
		this.totalIteracoes++;
		System.out.println(this.listPlaceHolderTodos.size());
	}

	public synchronized boolean getContinua() {
		return this.continua;
	}

	public synchronized String getElementListPlaceHolderTodos() {
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
