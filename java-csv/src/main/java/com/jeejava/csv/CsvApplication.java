package com.jeejava.csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jeejava.csv.parser.CsvParser;
import com.jeejava.csv.vo.CsvVo;

public class CsvApplication {

	public static void main(String[] args) throws IOException {
		File csv1 = new File("C:/csv/csv1.csv");
		File csv2 = new File("C:/csv/csv2.csv");

		List<String> csv1Headers = CsvParser.getHeadersFromACsv(csv1);
		//csv1Headers.forEach(h -> System.out.print(h + " "));
		//System.out.println();
		List<String> csv2Headers = CsvParser.getHeadersFromACsv(csv2);
		//csv2Headers.forEach(h -> System.out.print(h + " "));
		//System.out.println();

		List<String> allCsvHeaders = new ArrayList<>();
		allCsvHeaders.addAll(csv1Headers);
		allCsvHeaders.addAll(csv2Headers);
		//allCsvHeaders.forEach(h -> System.out.print(h + " "));
		//System.out.println();

		Set<String> uniqueHeaders = new HashSet<>(allCsvHeaders);
		//uniqueHeaders.forEach(h -> System.out.print(h + " "));
		//System.out.println();

		List<CsvVo> csv1Records = CsvParser.getRecodrsFromACsv(csv1, csv1Headers);
		List<CsvVo> csv2Records = CsvParser.getRecodrsFromACsv(csv2, csv2Headers);

		List<CsvVo> allCsvRecords = new ArrayList<>();
		allCsvRecords.addAll(csv1Records);
		allCsvRecords.addAll(csv2Records);

		CsvParser.writeToCsv(new File("C:/csv/csv.csv"), uniqueHeaders, allCsvRecords);
	}

}
