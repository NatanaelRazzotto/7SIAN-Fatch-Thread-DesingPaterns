package useCase;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import Interface.IWorkerConvertObject;
import Interface.IWorkerFetchData;
import Interface.IWorkerFetchObjectData;
import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.util.DTOData;
import br.unibrasil.util.tipoURL;
import serviceDomain.WorkerConvertObject;
import serviceDomain.WorkerFetchData;

public class PlaceHolderUseCase implements IWorkerFetchData, IWorkerConvertObject, IWorkerFetchObjectData {
	
	private String urlPlaceHolder = "https://jsonplaceholder.typicode.com/";
	
	private ArrayList<DTOData> listPlaceHolderDTOData = new ArrayList<DTOData>();
	private ArrayList<ObjectData> listPlaceHolderObjectData = new ArrayList<ObjectData>();
	private boolean continua = true;
	private int totalIteracoes = 0;
	private int limite = 100; 
	
	public void execute(int tipoDataURL)
	{
		try {		
			switch (tipoDataURL) {
			case 1:
				executePlaceHolder(tipoURL.TODOS,200);
				break;
			case 2:
				executePlaceHolder(tipoURL.USERS,10);
				break;
			case 3:
				executePlaceHolder(tipoURL.ALBUMS,100);
				break;
			case 4:
				executePlaceHolder(tipoURL.PHOTOS,5000);
				break;
			case 5:
				executePlaceHolder(tipoURL.POST,100);
				break;
			case 6:
				executePlaceHolder(tipoURL.COMMENTS,500);
				break;
			default:
				System.out.println("O Valor informado é invalido");
				break;
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
	}

	public void executePlaceHolder(tipoURL url, int limite) throws InterruptedException {
		
		String tipo = url.getURL();
		System.out.println(tipo);
		
		this.limite = limite;
		
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
		
		getElementListPlaceHolderDTOData(listPlaceHolderObjectData);

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

	public synchronized void setListPlaceHolderDTOData(DTOData stringJSon) {
		this.listPlaceHolderDTOData.add(stringJSon);
		this.maximumIterations();
		this.totalIteracoes++;
	}
	
	public synchronized DTOData getElementListPlaceHolderDTOData() {
		if (this.listPlaceHolderDTOData.size() > 0) {
			return this.listPlaceHolderDTOData.remove(0);
		}
		return null;
	}
	
	public synchronized void setListPlaceHolderObjectData(ObjectData objectData) {
		this.listPlaceHolderObjectData.add(objectData);
	}

	public synchronized boolean getContinua() {
		return this.continua;
	}

	public void maximumIterations() {
		if (this.listPlaceHolderDTOData.size() >= limite || this.totalIteracoes == limite) {
			this.continua = false;
		}
	}

	public boolean getElementListPlaceHolderDTOData(ArrayList<ObjectData> objectsData) {
		
		for (ObjectData objectData : objectsData) {
			objectData.listarDados();
		}		
		return true;
	}


}
