package HoMinhHau_Lab1.Exercise4;

import javax.swing.*;
import java.io.*;
import java.util.concurrent.ExecutionException;

class CopyTask extends SwingWorker<Long, Long> {
    private String from;
    private String to;
    private JProgressBar progressBar;

    public CopyTask(String from, String to, JProgressBar progressBar) {
        this.from = from;
        this.to = to;
        this.progressBar = progressBar;
    }

    @Override
    protected Long doInBackground() throws Exception {

        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(from));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(to));
        ) {
            byte[] buffer = new byte[1024];

            long total = new File(from).length();
            long currentLength = 0;
            int len = 0;

            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
                currentLength += len;
                // publish(currentLength);
                progressBar.setValue((int) (currentLength * 100 / total));
                Thread.sleep(1);
            }
            // in.close();
            // out.close();
            return currentLength;
        }

    }

    @Override
    protected void done() {
        try {
            long total = get();
            JOptionPane.showMessageDialog(null, "Copy completed! " + "Total: " + total + " bytes ");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
