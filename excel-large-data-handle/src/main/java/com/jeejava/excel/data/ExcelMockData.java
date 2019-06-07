package com.jeejava.excel.data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.jeejava.excel.vo.ExcelVo;

public class ExcelMockData {

	private List<ExcelVo> excelData;

	public ExcelMockData() {
	}

	public List<ExcelVo> getExcelData() {
		if (excelData == null) {
			populateExcelData();
		}
		return excelData;
	}

	public void setExcelData(List<ExcelVo> excelData) {
		this.excelData = excelData;
	}

	private void populateExcelData() {
		excelData = new ArrayList<>();
		Class<ExcelVo> classz = (Class<ExcelVo>) ExcelVo.class;
		Method[] methods = classz.getMethods();
		for (int i = 0; i < 20000; i++) {
			ExcelVo model = new ExcelVo();
			for (Method method : methods) {
				String methodName = method.getName();
				if (methodName.startsWith("set")) {
					try {
						method.invoke(model, getRandomString());
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			excelData.add(model);
		}
	}

	private String getRandomString() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

}
