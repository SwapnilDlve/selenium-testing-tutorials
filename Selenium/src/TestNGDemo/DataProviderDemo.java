package TestNGDemo;

import org.testng.annotations.DataProvider;

public class DataProviderDemo {
		@DataProvider(name = "credentials")
		public Object[][] createDatasetInvalidUsers(){
			Object[][] data={
				{"jaya_garg","test@12345"},
				{"jaya_garg","test@12345"},
				{"jaya_garg","test@12345"}
			};
			
			return data;
		}
		
		@DataProvider(name = "credentials2")
		public Object[][] createDatasetvalidUsers(){
			Object[][] data={
				{"Caroline@forbes.com","ABCD1234"},
				{"Caroline@forbes.com","ABCD1234"},
				{"Caroline@forbes.com","ABCD1234"}
			};
			
			return data;
		}
		
}
