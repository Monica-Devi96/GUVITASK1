package task8;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\Smart\\eclipse-workspace\\ExcelReadAndWrite\\src\\main\\java\\Sheet1.xlsx");
		XSSFSheet sheet=book.getSheet("Sheet1");
	int rowCount=sheet.getLastRowNum();
	int columnCount=sheet.getRow(0).getLastCellNum();
	String[][] data=new String[rowCount][columnCount];
	for(int i=1;i<=rowCount;i++) {
		XSSFRow row=sheet.getRow(i);
	for(int j=0;j<columnCount;j++) {
			XSSFCell cell=row.getCell(j);
			System.out.print(cell.getStringCellValue()+" ");
			data[i-1][j]=cell.getStringCellValue();
			}
		System.out.println();
	}
	System.out.println();
	System.out.println("Printing from an array");
	for(String[] row:data) {
		for(String x:row) {
			System.out.print(x+" ");
		}
		System.out.println();
}
	book.close();
}
}
