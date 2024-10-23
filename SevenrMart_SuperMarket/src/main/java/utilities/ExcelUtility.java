package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constants;

public class ExcelUtility {
	
	
		static FileInputStream f;
		static XSSFWorkbook w;
		static XSSFSheet sh;
		public static String getStringData(int a,int b,String sheet) throws IOException
		{
			String filepath = Constants.TESTDATAFILE;
			//String filepath=import constants.Constants;
			f=new FileInputStream(filepath);
					w=new XSSFWorkbook(f);
					sh= w.getSheet(sheet);
					XSSFRow r=sh.getRow(a);
					XSSFCell c=r.getCell(b);
					return c.getStringCellValue();
			}
			
		public static String getIntegerData(int a,int b,String sheet) throws IOException 
		
		{
			String filepath = Constants.TESTDATAFILE;
		f=new FileInputStream(filepath);
		w=new XSSFWorkbook(f);
		sh= w.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		int x=(int) c.getNumericCellValue();
		return String.valueOf(x);
	}
		}


