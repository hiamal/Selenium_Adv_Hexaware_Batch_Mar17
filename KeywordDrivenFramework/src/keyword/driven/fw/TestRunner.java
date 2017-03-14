package keyword.driven.fw;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class TestRunner extends Base{
	static Keywords keywordObject = new Keywords();

	public static void main(String[] args) throws IOException, InterruptedException {
		loadConfig();
		initDriver();
		for(Row row1: workbook.getSheet("TestData")){

			if(row1 == workbook.getSheet("TestData").getRow(0))
				continue;
		
			for(Row row2: workbook.getSheet("TestCase")){
				if(row2 == workbook.getSheet("TestCase").getRow(0))
					continue;
				
				String locator =row2.getCell(0).getStringCellValue();
				String locatorValue = row2.getCell(1).getStringCellValue();
				String keyword = row2.getCell(2).getStringCellValue();
				String parameter;
				
				if(row2.getCell(3)!=null)
					parameter = getParameterValue(row1.getRowNum(), row2.getCell(3).getStringCellValue());
				else
					parameter = "";
				
				keywordObject.performAction(locator, locatorValue, keyword, parameter);
			}
			Thread.sleep(1000);
		}
	}
	
	public static String getParameterValue(int rowNo, String value){
		String text;
		if(value.charAt(0) != '<')
			text = value;
		else{
			int colNo = getColNo(value.substring(1, value.length()-1)); 
			text = workbook.getSheet("TestData").getRow(rowNo).getCell(colNo).getStringCellValue();
		}
		
		return text;
	}
	
	public static int getColNo(String text){
		int columnNo = -1;
		for(Cell cell: workbook.getSheet("TestData").getRow(0))
			if(cell.getStringCellValue().equals(text))
				columnNo =  cell.getColumnIndex();
		 return columnNo;
	}
	

}
