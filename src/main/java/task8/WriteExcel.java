package task8;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFWorkbook book=new XSSFWorkbook();
		XSSFSheet sheet=book.createSheet("Sheet1");
		Object[][] data= {{"Name","Age","Email"},
				{"John Doe",30,"john@test.com"},
				{"Jane Doe",28,"john@test.com"},
				{"Bob Smith",35,"jacky@example.com"},
				{"Swapnil",37,"swapnil@example.com"}};
		int rowcount=0;
		for(Object[] row1:data) {
			XSSFRow row=sheet.createRow(rowcount++);
			int columncount=0;
		for(Object col:row1) {
			XSSFCell cell=row.createCell(columncount++);
		if(col instanceof String) {
			cell.setCellValue((String)col);
		}
		else if(col instanceof Integer) {
			cell.setCellValue((Integer)col);
		}
		}
		}
		try {
			FileOutputStream output=new FileOutputStream("C:\\Users\\Smart\\eclipse-workspace\\ExcelReadAndWrite\\src\\main\\java\\Sheet1.xlsx");
			book.write(output);
		}
        catch(Exception e) {
        	e.printStackTrace();
        }
		book.close();
	}
	}

}
