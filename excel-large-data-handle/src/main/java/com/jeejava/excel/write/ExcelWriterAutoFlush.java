package com.jeejava.excel.write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.jeejava.excel.utils.ExcelUtil;
import com.jeejava.excel.vo.ExcelVo;

public class ExcelWriterAutoFlush {

	// using auto flush and default window size 100
	public void writeToExcelAutoFlush(String fileName, List<ExcelVo> excelData) {
		SXSSFWorkbook wb = null;
		FileOutputStream fos = null;
		try {
			// keep 100 rows in memory, exceeding rows will be flushed to disk
			wb = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE/* 100 */);
			Sheet sh = wb.createSheet();

			@SuppressWarnings("unchecked")
			Class<ExcelVo> classz = (Class<ExcelVo>) excelData.get(0).getClass();

			Field[] fields = classz.getDeclaredFields();
			int noOfFields = fields.length;

			int rownum = 0;
			Row row = sh.createRow(rownum);
			for (int i = 0; i < noOfFields; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(fields[i].getName());
			}

			for (ExcelVo excelModel : excelData) {
				row = sh.createRow(rownum + 1);
				int colnum = 0;
				for (Field field : fields) {
					String fieldName = field.getName();
					Cell cell = row.createCell(colnum);
					Method method = null;
					try {
						method = classz.getMethod("get" + ExcelUtil.capitalizeInitialLetter(fieldName));
					} catch (NoSuchMethodException nme) {
						method = classz.getMethod("get" + fieldName);
					}
					Object value = method.invoke(excelModel, (Object[]) null);
					cell.setCellValue((String) value);
					colnum++;
				}
				rownum++;
			}
			fos = new FileOutputStream(fileName);
			wb.write(fos);
		} catch (Exception ex) {

		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
			}
			try {
				if (wb != null) {
					wb.close();
				}
			} catch (IOException e) {
			}
		}
	}

}
