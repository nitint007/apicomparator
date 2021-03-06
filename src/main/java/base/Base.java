/**
 * 
 */
package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author nitinthite
 *
 */
public class Base {
	
	public static Properties properties;
	
	// Class constructor for initialising objects
		public Base() throws FileNotFoundException, IOException {
			BufferedReader reader;
			try {
				String configFilePath = "./src/test/resources/configdata/Config.properties";
				reader = new BufferedReader(new FileReader(configFilePath));
				properties = new Properties();
				properties.load(reader);
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
				throw new RuntimeException("File Config.properties not found at given path.");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				throw new RuntimeException("Issue on reading file.");
			}
		}
}
