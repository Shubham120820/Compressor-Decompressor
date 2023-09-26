package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    // Method for compressing a file using GZIP
    public static void method(File file) throws IOException {
        // Get the directory where the original file is located
        String fileDirectory = file.getParent();

        // Create input and output streams
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;

        // Read from the original file and write to the compressed file
        while ((len = fis.read(buffer)) != -1) {
            gzip.write(buffer, 0, len);
        }

        // Close the streams
        gzip.close();
        fos.close();
        fis.close();
    }

    // Main method for testing the compressor
    public static void main(String[] args) throws IOException {
        // Specify the path to the file you want to compress
        File path = new File("");

        // Call the compression method
        method(path);
    }
}