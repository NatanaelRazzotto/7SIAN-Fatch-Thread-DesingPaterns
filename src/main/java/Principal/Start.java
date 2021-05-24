package Principal;

import java.util.Scanner;

import useCase.PlaceHolderUseCase;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner ler = new Scanner(System.in);
		
		System.out.printf("Informe o tipo de dados solicitado para a API: \n");
		System.out.printf("1 - Todos; \n");
		System.out.printf("2 - Users; \n");
		System.out.printf("3 - Albums; \n");
		System.out.printf("4 - Photos; \n");
		System.out.printf("5 - Post; \n");
		System.out.printf("6 - Comments; \n");
		System.out.printf("Informe o tipo de dados solicitado para a API: \n");
		
		int dataURL = ler.nextInt();
		
		switch (dataURL) {
		case 1:
			new PlaceHolderUseCase().execute(tipoURL.TODOS,200);
			break;
		case 2:
			new PlaceHolderUseCase().execute(tipoURL.USERS,10);
			break;
		case 3:
			new PlaceHolderUseCase().execute(tipoURL.ALBUMS,100);
			break;
		case 4:
			new PlaceHolderUseCase().execute(tipoURL.PHOTOS,5000);
			break;
		case 5:
			new PlaceHolderUseCase().execute(tipoURL.POST,100);
			break;
		case 6:
			new PlaceHolderUseCase().execute(tipoURL.COMMENTS,500);
			break;

		default:
			break;
		}
	}

}
