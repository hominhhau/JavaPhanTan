package HoMinhHau_Lab1.Exercrise5;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader extends SwingWorker<String, Object> {
    private File file;

    public FileLoader(File file) {
        this.file = file;
    }

    @Override
    protected String doInBackground() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void done() {
        try {
            String content = get();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}