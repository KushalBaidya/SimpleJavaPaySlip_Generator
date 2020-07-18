package org.apache.maven.archetypes.maven_archetype_quickstart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import org.apache.poi.ss.usermodel.*;

import net.sf.jasperreports.engine.JRException;

public class ExcelReader{

	public static final String XLSX_FILE_PATH = "src/main/resources/employee-details-file.xlsx";

	public static void main(String args[]) throws IOException,InvalidFormatException, JRException
	{
		Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
		DataFormatter dataFormatter = new DataFormatter();
		Sheet sheet = workbook.getSheetAt(0);
		Scanner sc=new Scanner(System.in);
		System.out.println("Username: ");
		String user=sc.nextLine();
		System.out.println("Password: ");
		String password=sc.nextLine();
		sc.close();

		for (Row row: sheet) {
			if(row.getRowNum()==0)
				continue;
			else {
				Cell cell[]=new Cell[row.getPhysicalNumberOfCells()];
				for (int i=0;i<row.getPhysicalNumberOfCells();i++) {
					cell[i]=row.getCell(i);
				}
				List<Employee> emp=new ArrayList<Employee>();
				emp.add(new Employee(dataFormatter.formatCellValue(cell[0]),dataFormatter.formatCellValue(cell[1]),
						dataFormatter.formatCellValue(cell[2]),dataFormatter.formatCellValue(cell[3]),
						Integer.parseInt(dataFormatter.formatCellValue(cell[4])),Integer.parseInt(dataFormatter.formatCellValue(cell[5])),
						Integer.parseInt(dataFormatter.formatCellValue(cell[6])),Integer.parseInt(dataFormatter.formatCellValue(cell[7]))));
				new PdfGeneration();
				PdfGeneration.reportGeneration(emp);
				new EmailReceipt();
				EmailReceipt.sentMail(user,password,emp.get(0).getMail());
			}
		}
	}


}


