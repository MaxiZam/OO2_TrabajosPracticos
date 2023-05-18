package model;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestCall {

	private String url;
	private Guardar guardar;

	public RestCall(String url, Guardar guardar) {
		this.url = url;
		this.guardar = guardar;
	}

	public String run() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(this.url).build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
