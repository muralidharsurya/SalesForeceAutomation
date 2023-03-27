/**
 * 
 */
package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic method related to property file
 * @author Dell
 *
 */
public class PropertyFileUtility {
	/**
     * This method will read data from property file
     * @param key
     * @return
     * @throws IOException
     */
    public String readDataFromPropertyFile(String key) throws IOException
    {
        FileInputStream fis = new FileInputStream(".\\src\\properties\\login.propertie");
        Properties pobj = new Properties();
        pobj.load(fis);
        String value = pobj.getProperty(key);
        return value;

    }}
