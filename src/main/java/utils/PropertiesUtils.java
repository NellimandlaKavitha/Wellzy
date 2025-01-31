package utils;
import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Properties;
	import org.testng.annotations.Test;
	 


	public class PropertiesUtils  {
		
		public void addValueInPropertyFile(String propertyFileName,String Key, String Value) throws IOException  {
			
			String pathofProperties =  System.getProperty("user.dir") +  "\\PropertyFiles\\" + propertyFileName + ".properties";
			Properties properties = new Properties();	
			FileInputStream FIS = new FileInputStream(pathofProperties);
			properties.load(FIS);
		
			properties.put(Key,Value);
		    FileOutputStream stream = new FileOutputStream(pathofProperties);
			properties.store(stream, "Adding Dynamic Created Values");
			properties.clear();
			
		
		}
		
		@Test
		public void demo() throws Exception {
			addValueInPropertyFile("credentials","DEGAContractName", "Vacation");
		}
	}



