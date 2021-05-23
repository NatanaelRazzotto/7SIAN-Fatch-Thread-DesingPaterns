package Principal;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import com.google.gson.Gson;

import ServiceApplication.Request;

public class Principal {

	public static void main(String[] args) throws IOException {
		new Principal().execute();
	}

	private void execute() throws IOException {
		Gson gson = new Gson();

//		String userJson = new Request().execute("https://jsonplaceholder.typicode.com/users/"+ this.getRandom(10));
//		User user = gson.fromJson(userJson, User.class);
//		System.out.println(userJson +"\n"+user);

//		Instant inicioA = Instant.now();
//		String todostJsonA = new Request().execute("https://jsonplaceholder.typicode.com/todos/" + this.getRandom(200));
//		Todos todosA = gson.fromJson(todostJsonA, Todos.class);
////			System.out.println(todos);
//		Instant inicioA = Instant.now();
//		Instant fimA = Instant.now();
//		Duration duracaoA = Duration.between(inicioA, fimA);
//		System.out.println("Duração:" + duracaoA.toMillis() + " milisegundos. ");
//
//		
			
		
		Instant inicio = Instant.now();

		for (int x = 1; x <= 100; x++) {
			String todostJson = new Request()
					.execute("https://jsonplaceholder.typicode.com/todos/" + this.getRandom(200));
			//Todos todos = gson.fromJson(todostJson, Todos.class);
//			System.out.println(todos);
		}

		Instant fim = Instant.now();
		Duration duracao = Duration.between(inicio, fim);
		System.out.println("Duração:" + duracao.toMillis() + " milisegundos. Tempo médio:" + duracao.toMillis() / 100);

	}

	private int getRandom(int max) {
		Random rd = new Random();
		return rd.nextInt(max) + 1;
	}

}
