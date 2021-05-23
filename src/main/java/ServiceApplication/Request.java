package ServiceApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

	public String execute(String URL) throws IOException {
		StringBuffer Response = new StringBuffer();
		String output;
		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((output = br.readLine()) != null) {
			Response.append(output);
		}
		br.close();
		return Response.toString();
	}
}
