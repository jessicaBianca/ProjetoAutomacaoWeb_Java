package properties;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

public class PropertiesLoad {
            FileInputStream fileInputStream = null;
            Properties props = new Properties();
            private String filePath;
            public PropertiesLoad(String filePath) {
                this.filePath = filePath;
            }

            public Properties getProps() {
                try {

                    File file = new File(this.filePath);
                    fileInputStream = new FileInputStream(file);
                    this.props.load(fileInputStream);
                    fileInputStream.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        } } }
                return this.props;
            }}



