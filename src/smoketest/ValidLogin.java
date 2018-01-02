package smoketest;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import generic.Utilities;

public class ValidLogin extends BaseTest {
	final static String tcID = "001";
	String moduleName = "smoke";
	String testCaseName = "ValidLogin";
	public String fileName = tcID + "_" + moduleName + "_" + testCaseName; 
	
	
	@Test(priority=1, groups={"smoke","foundation"})
	public void testValidLogin() {
		String dataSet = Utilities.getPropertyValue(CONFIG_FILE_PATH, "DATA_SET");
		int col=1;
		switch(dataSet.toLowerCase()) {
			case "testdataset1":
			{
				col=1;
				break;			
			}
			case "testdataset2":
			{
				col=2;
				break;				
			}
			case "testdataset3":
			{
				col=3;
				break;
			}
			default:
			{
				col=1;
				break;
			}
		}
		String un = Excel.getCellValue(fileName, 1, col);
		String pw = Excel.getCellValue(fileName, 2, col);
		String expTitle = Excel.getCellValue(fileName, 3, col);
		
		
		
	}

}
