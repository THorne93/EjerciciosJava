
package capitulo06.bloque01.wrappers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {

    public static void main(String[] args) {

        try (InputStream input = new FileInputStream("./src/capitulo06/bloque01/wrappers/test.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("DAY"));
            System.out.println(prop.getProperty("NUMBER"));
            System.out.println(prop.getProperty("TEMPERATURE"));
            System.out.println(prop.getProperty("HOT"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
