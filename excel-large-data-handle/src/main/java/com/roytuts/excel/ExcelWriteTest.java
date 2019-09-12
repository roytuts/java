package com.roytuts.excel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.roytuts.excel.data.ExcelMockData;
import com.roytuts.excel.vo.ExcelVo;
import com.roytuts.excel.write.ExcelWriterAutoFlush;
import com.roytuts.excel.write.ExcelWriterManualFlush;

public class ExcelWriteTest {

	public static void main(String[] args) {

		ExcelMockData mockData = new ExcelMockData();
		List<ExcelVo> excelData = mockData.getExcelData();

		// using auto flush mode
		final long autoFlushStartTime = System.currentTimeMillis();

		String fileName = "C:/workspace/Excel-auto-flush.xlsx";
		ExcelWriterAutoFlush autoFlush = new ExcelWriterAutoFlush();
		autoFlush.writeToExcelAutoFlush(fileName, excelData);

		final long autoFlushEndTime = System.currentTimeMillis();

		final long autoFlushExeTime = autoFlushEndTime - autoFlushStartTime;

		final long hr = TimeUnit.MILLISECONDS.toHours(autoFlushExeTime);
		final long min = TimeUnit.MILLISECONDS.toMinutes(autoFlushExeTime)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(autoFlushExeTime));
		final long sec = TimeUnit.MILLISECONDS.toSeconds(autoFlushExeTime)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(autoFlushExeTime));
		final long ms = TimeUnit.MILLISECONDS.toMillis(autoFlushExeTime)
				- TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(autoFlushExeTime));

		System.out.println(String.format(
				"Total time taken to execute 20000 records using auto flush: %d Hours %d Minutes %d Seconds %d Milliseconds",
				hr, min, sec, ms));

		// using manual flush mode
		final long manualFlushStartTime = System.currentTimeMillis();

		fileName = "C:/workspace/Excel-manual-flush.xlsx";
		ExcelWriterManualFlush manualFlush = new ExcelWriterManualFlush();
		manualFlush.writeToExcelManualFlush(fileName, excelData);

		final long manualFlushEndTime = System.currentTimeMillis();

		final long manualFlushExeTime = manualFlushEndTime - manualFlushStartTime;

		final long manualFlushHr = TimeUnit.MILLISECONDS.toHours(manualFlushExeTime);
		final long manualFlushMin = TimeUnit.MILLISECONDS.toMinutes(manualFlushExeTime)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(manualFlushExeTime));
		final long manualFlushSec = TimeUnit.MILLISECONDS.toSeconds(manualFlushExeTime)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(manualFlushExeTime));
		final long manualFlushMs = TimeUnit.MILLISECONDS.toMillis(manualFlushExeTime)
				- TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(manualFlushExeTime));

		System.out.println(String.format(
				"Total time taken to execute 20000 records using manual flush: %d Hours %d Minutes %d Seconds %d Milliseconds",
				manualFlushHr, manualFlushMin, manualFlushSec, manualFlushMs));

	}

}
