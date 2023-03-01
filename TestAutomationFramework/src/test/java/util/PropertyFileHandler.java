package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandler {

	private String sFilePath = null;
	private FileInputStream oFileInputStream = null;
	public Properties oProperties = null;

	public PropertyFileHandler(String sFilePath) {
		this.sFilePath = sFilePath;
	}

	public Properties LoadProperties() {
		try {
			oFileInputStream = new FileInputStream(new File(sFilePath));
			oProperties = new Properties();
			oProperties.load(oFileInputStream);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return oProperties;
	}

}
