package org.uatransport.service.ewayutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class EwayConfig {
    static String getProperty(String property) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "eway.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProps.getProperty(property);
    }
}
