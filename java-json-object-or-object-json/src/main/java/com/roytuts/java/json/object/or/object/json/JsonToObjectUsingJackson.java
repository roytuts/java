package com.roytuts.java.json.object.or.object.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObjectUsingJackson {

	public static void main(String[] args) {
		String json = "{\"id\":1, \"employees\":[{\"id\":1001,\"name\":\"Sumit\",\"email\":\"sumit.ghosh@email.com\"}, {\"id\":1002,\"name\":\"Soumitra\",\"email\":\"soumitra.sarkar@email.com\"}, {\"id\":1003,\"name\":\"Gourab\",\"email\":\"gourab.guha@email.com\"}, {\"id\":1004,\"name\":\"Debina\",\"email\":\"debina.guha@email.com\"}, {\"id\":1005,\"name\":\"Debabrata\",\"email\":\"debabrata.poddar@email.com\"}, {\"id\":1006,\"name\":\"Liton\",\"email\":\"liton.sarkar@email.com\"}, {\"id\":1007,\"name\":\"Souvik\",\"email\":\"souvik.sanyal@email.com\"}]}";

		ObjectMapper mapper = new ObjectMapper();

		Department department = null;
		try {
			department = mapper.readValue(json, Department.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		System.out.println(department);
	}
}
