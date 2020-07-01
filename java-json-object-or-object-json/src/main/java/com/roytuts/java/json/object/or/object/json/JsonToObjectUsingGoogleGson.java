package com.roytuts.java.json.object.or.object.json;

import com.google.gson.Gson;

public class JsonToObjectUsingGoogleGson {

	public static void main(String[] args) {
		String json = "{\"id\":1, \"employees\":[{\"id\":1001,\"name\":\"Sumit\",\"email\":\"sumit.ghosh@email.com\"}, {\"id\":1002,\"name\":\"Soumitra\",\"email\":\"soumitra.sarkar@email.com\"}, {\"id\":1003,\"name\":\"Gourab\",\"email\":\"gourab.guha@email.com\"}, {\"id\":1004,\"name\":\"Debina\",\"email\":\"debina.guha@email.com\"}, {\"id\":1005,\"name\":\"Debabrata\",\"email\":\"debabrata.poddar@email.com\"}, {\"id\":1006,\"name\":\"Liton\",\"email\":\"liton.sarkar@email.com\"}, {\"id\":1007,\"name\":\"Souvik\",\"email\":\"souvik.sanyal@email.com\"}]}";

		Gson gson = new Gson();

		Department department = gson.fromJson(json, Department.class);

		System.out.println(department);
	}
}
