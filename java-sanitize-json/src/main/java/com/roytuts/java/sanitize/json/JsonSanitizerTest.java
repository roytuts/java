package com.roytuts.java.sanitize.json;

public class JsonSanitizerTest {

	public static void main(String[] args) {
		String jsonString = "{\"key1\":\"value1\",\"type\":\"Booking\",\"sid\":\"A43521\",\"region\":\"ASIA\","
				+ "\"fetchFromFile\":\"false\",\"service\":\"true\",\"isEom\":\"true\",*#@!}";

		String response = JsonSanitizer.sanitizeJson(jsonString);

		System.out.println(response);

		jsonString = "{\r\n" + 
				"    \"json_pino\" : {\r\n" + 
				"        \"title\" : \"JSON Pino log\",\r\n" + 
				"        \"description\" : \"JSON Pino log\",\r\n" + 
				"        \"hide-extra\": false,\r\n" + 
				"        \"multiline\": false,\r\n" + 
				"        \"json\" : true,\r\n" + 
				"        \"file-pattern\" : \"\\\\.json\",\r\n" + 
				"        \"level-field\" : \"level\",\r\n" + 
				"        \"level\": {\r\n" + 
				"            \"fatal\": 60,\r\n" + 
				"            \"error\": 50,\r\n" + 
				"            \"warning\": 40,\r\n" + 
				"            \"info\": 30,\r\n" + 
				"            \"debug\": 20,\r\n" + 
				"            \"trace\": 10\r\n" + 
				"        },\r\n" + 
				"        \"value\": {\r\n" + 
				"            \"pid\": { \"kind\": \"integer\", \"identifier\": true },\r\n" + 
				"            \"hostname\": { \"kind\": \"string\", \"identifier\": true },\r\n" + 
				"            \"level\": { \"kind\": \"integer\", \"identifier\": true },\r\n" + 
				"            \"time\": { \"kind\": \"integer\" },\r\n" + 
				"            \"msg\": { \"kind\": \"string\" },\r\n" + 
				"            \"v\": { \"kind\": \"integer\" },\r\n" + 
				"            \"responseTime\": { \"kind\": \"integer\" }\r\n" + 
				"        },\r\n" + 
				"        \"timestamp-field\": \"time\", hdjhdkjf\r\n" + 
				"        \"body-field\": \"msg\",\r\n" + 
				"        \"opid-field\": \"pid\",\r\n" + 
				"        \"line-format\" : [\r\n" + 
				"            { \"field\" : \"time\" , oiewui87325732},\r\n" + 
				"            \" \",\r\n" + 
				"            { \"field\" : \"msg\", \"default-value\": \"\" , jehjrgyutuew}\r\n" + 
				"        ],\r\n" + 
				"        \"sample\": [\r\n" + 
				"            {\r\n" + 
				"                \"line\": \"{\\\"pid\\\":31839,\\\"hostname\\\":\\\"ip-172-31-11-174\\\",\\\"level\\\":30,\\\"time\\\":1494255536591,\\\"msg\\\":\\\"request completed\\\",\\\"responseTime\\\":1,\\\"v\\\":1, hgdsfd7635732}\"\r\n" + 
				"            }\r\n" + 
				"        ]\r\n" + 
				"    }\r\n" + 
				"}";

		response = JsonSanitizer.sanitizeJson(jsonString);

		System.out.println(response);
	}

}
