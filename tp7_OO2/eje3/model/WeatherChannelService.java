package model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class WeatherChannelService implements ClimaOnline {

	private String apiKey;

	public WeatherChannelService(String apiKey) {
		this.apiKey = apiKey;
	}

//	@Override
//	public String temperatura() {
//		int temp = new Random().nextInt(100);
//		return temp + " c";
//	}

	public int temperatura() {
		// mi key =
		String url = "https://api.openweathermap.org/data/2.5/weather?q=viedma,032&lang=sp&APPID=" + apiKey;
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String jsonString = response.body();
		Gson gson = new GsonBuilder().create();
		var jsonObject = gson.fromJson(jsonString, JsonObject.class);
		int temp = jsonObject.getAsJsonArray("weather").asList().get(0).getAsJsonObject().get("main.temp").getAsInt();
		return temp;
	}

}
