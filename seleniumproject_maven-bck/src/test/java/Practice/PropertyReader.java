package Practice;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertyReader {

	 public static void main(String[] args) throws IOException {
	        readProperties();
	    }
	 
	    private static void readProperties() throws IOException {
	        InputStream inputStream = null;
	        try {
	            Properties properties = new Properties();
	            ClassLoader loader = Thread.currentThread().getContextClassLoader();
	            inputStream = loader.getResourceAsStream("Commondata.properties");
	            properties.load(inputStream);
	 
	            properties.forEach(
	                             (key, value)
	                                ->
	                            System.out.println(
	                                    key + "==" + value
	                            )
	                     );
	        } finally {
	            if (inputStream != null) {
	                inputStream.close();
	            }
	        }
	    }	
	
	
}
