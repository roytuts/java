package com.roytuts.java.iterate.map.of.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapIteratorApp {

	public static void main(String[] args) {
		List<ProgInfo> javaList = Arrays.asList(new ProgInfo("1000", "Java"), new ProgInfo("1001", "JEE"));

		List<ProgInfo> frameworkList = Arrays.asList(new ProgInfo("1002", "Spring"), new ProgInfo("1003", "JSF"),
				new ProgInfo("1004", "Hibernate"), new ProgInfo("1005", "JPA"));

		List<ProgInfo> databaseList = Arrays.asList(new ProgInfo("1006", "Oracle"), new ProgInfo("1007", "PostgreSQL"),
				new ProgInfo("1008", "MySQL"), new ProgInfo("1009", "Sybase"), new ProgInfo("1010", "DB2"));

		List<ProgInfo> uiList = Arrays.asList(new ProgInfo("1011", "HTML"), new ProgInfo("1012", "CSS"));

		List<ProgInfo> jsList = Arrays.asList(new ProgInfo("1013", "JavaScript"), new ProgInfo("1014", "jQuery"),
				new ProgInfo("1015", "ExtJS"), new ProgInfo("1016", "AngularJS"));

		Map<String, List<ProgInfo>> map = new HashMap<>();
		map.put("java", javaList);
		map.put("framework", frameworkList);
		map.put("db", databaseList);
		map.put("ui", uiList);
		map.put("js", jsList);

		Map<String, String> idMap = new HashMap<>();

		map.forEach((id, progList) -> progList.forEach(prog -> idMap.put(prog.getId(), prog.getName())));

		idMap.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
	}

}
