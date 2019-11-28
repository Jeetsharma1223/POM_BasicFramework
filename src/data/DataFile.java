package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("C:\\Testing\\Login.xlsx");
	
	public String ValidEmail = d.getCellData("Sheet1", 0, 2);
	public String WrongPassword = d.getCellData("Sheet1", 2, 2);
	public String InvalidEmail = d.getCellData("Sheet1", 1, 2);
	public String PasswordErrorMessage = d.getCellData("Sheet1", 3, 2);
	public String EmailErrorMessage = d.getCellData("Sheet1", 4, 2);

}
