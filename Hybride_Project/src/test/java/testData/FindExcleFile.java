package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FindExcleFile {
	
	public static void main(String[] args) throws IOException {
		
		String path=System.getProperty("user.dir")+"/src/test/java/testData/LoginData1.xlsx";
		System.out.println(path);
		
		File file= new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int noOfrownum=sheet.getLastRowNum();
		int noOfcolumn=sheet.getRow(0).getLastCellNum();
		System.out.println(noOfrownum);
		System.out.println(noOfcolumn);
		
		for(int i=1;i<=noOfrownum;i++)
		{
			for(int j=0;j<noOfcolumn;j++)
			{
			System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}
		wb.close();
		fis.close();
		
	}

}
