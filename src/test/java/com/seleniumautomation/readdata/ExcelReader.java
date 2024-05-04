package com.seleniumautomation.readdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {

		String projectlocation = System.getProperty("user.dir");

		FileInputStream fi = new FileInputStream(projectlocation + "\\Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fi);

		XSSFSheet sheet = workbook.getSheet("Login");

		String username = sheet.getRow(1).getCell(0).getStringCellValue();

		System.out.println("username is  "+username);

		String password = sheet.getRow(1).getCell(1).getStringCellValue();

		String usertype = sheet.getRow(1).getCell(2).getStringCellValue();

		String location = sheet.getRow(1).getCell(3).getStringCellValue();

		System.out.println("Password is  "+password);

		System.out.println("user type is "+usertype);

		System.out.println("Location is "+location);

	}

}
