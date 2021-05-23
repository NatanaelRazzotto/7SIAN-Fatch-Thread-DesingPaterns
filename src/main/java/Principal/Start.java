package Principal;

import useCase.PlaceHolderUseCase;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		
		new PlaceHolderUseCase().execute("https://jsonplaceholder.typicode.com/");

	}

}
