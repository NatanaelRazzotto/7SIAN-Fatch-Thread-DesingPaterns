package Principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import useCase.PlaceHolderUseCase;

public class Start {

	public static void main(String[] args){
		
		try {
			Scanner ler = new Scanner(System.in);
				
			boolean next = true;
			while (next)
			{
				System.out.printf("Informe o tipo de dados solicitado para a API: \n");
				System.out.printf("1 - Todos; \n");
				System.out.printf("2 - Users; \n");
				System.out.printf("3 - Albums; \n");
				System.out.printf("4 - Photos; \n");
				System.out.printf("5 - Post; \n");
				System.out.printf("6 - Comments; \n");
				System.out.printf("7 - EXIT; \n");
				System.out.printf("Digite um valor: \n");
				
				int dataURL = ler.nextInt();
				System.out.printf("Tecla de Inserida :" + dataURL + "\n");
				if (dataURL != 7)
				{				
					new PlaceHolderUseCase().execute(dataURL);				
				}
				else
				{
					System.out.printf("EXIT;");
					next = false;				
				}			
			}
		
		} catch (InputMismatchException  e) {
			System.out.println("Você digitou caracteres. Precisamos que digite apenas números.");
		}
		
	}

}
