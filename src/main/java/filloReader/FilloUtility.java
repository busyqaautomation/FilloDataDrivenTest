package filloReader;

import java.util.ArrayList;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class FilloUtility {

	ArrayList<String> row= new ArrayList<String>();
	ArrayList<String> testData=new ArrayList<String>();
	public String filepath;
	
	public ArrayList<String> getData(String filepath,String excelName,String sheetName, int rowNumber) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		String strQuery="Select * from" +" "+sheetName+" "+ "where TestNumber ='"+rowNumber+"' "; // Writing SQL Query
		
		Recordset recordset=connection.executeQuery(strQuery); // Execute Query and store result in Record set
    
		while(recordset.next()){  // Condition till record set has values
        
			row=recordset.getFieldNames(); // get column names
          
			for (int i=1;i<=row.size()-1;i++) {  // run for loop for desired column values
                testData.add(recordset.getField(row.get(i)));  // add row values to ArrayList
            }
        } 
		recordset.close();
		connection.close();
		return testData;
    }
}
