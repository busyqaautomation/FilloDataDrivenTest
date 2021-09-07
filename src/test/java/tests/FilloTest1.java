package tests;

import java.util.ArrayList;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import filloReader.FilloUtility;


public class FilloTest1 {
	
	ArrayList<String> test_data = new ArrayList<String>();
    String name="";
    String subject = "";
	String filepath=System.getProperty("user.dir") + "\\src\\main\\java\\dataManager\\";
	FilloUtility fillo;
	
	
	@Test
	public void testFillo() throws FilloException {
		fillo = new FilloUtility();
		test_data=fillo.getData(filepath,"Test1.xlsx", "Sheet1",1); 
		name=test_data.get(0);
		subject=test_data.get(1);
		
		System.out.println("Name is: " + name);
		System.out.println("Subject is: " + subject);
	}
}
