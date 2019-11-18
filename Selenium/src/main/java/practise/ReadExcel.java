package practise;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public Object[][] readExcel(String fileName)
	{
		String text;
		
		Object[][] data=null;
		
		XSSFWorkbook wb;
		
		try 
		
		{
			wb=new XSSFWorkbook("./data/"+fileName+".xlsx");
			XSSFSheet sheet=wb.getSheetAt(0);
			
			int rowSize=sheet.getLastRowNum();
			int colSize=sheet.getRow(0).getLastCellNum();
			
			data = new Object[rowSize][colSize];
			
			for(int i=1;i<=rowSize;i++)
			{
				XSSFRow row=sheet.getRow(i);
				for(int j=0;j<colSize;j++)
				{
					text=row.getCell(j).getStringCellValue();
					
					if(!(text.equals("")))
						data[i-1][j]=text;
					else
						data[i-1][j]="";
				}
			}
			
			wb.close();
			
		}
		
		catch (IOException e) {
			System.out.println("Issue in reading the values from the excel: "+fileName);
		}
		
		return data;
		
	}

}
