package org.example.project.service.toggleBtn;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Properties;

@Service
public class ToggleStateService {
    private static final String FILE_NAME = "toggle-state.properties";
    private static final String TOGGLE_KEY = "isToggled";

    public boolean getState() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(FILE_NAME)) {
            properties.load(input);
            return Boolean.parseBoolean(properties.getProperty(TOGGLE_KEY, "false"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveState(boolean toggled) {
        Properties properties = new Properties();
        properties.setProperty(TOGGLE_KEY, Boolean.toString(toggled));
        try (OutputStream output = new FileOutputStream(FILE_NAME)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
