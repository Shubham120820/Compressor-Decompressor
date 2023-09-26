package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    // Method for decompressing a GZIP file
    public static void method(File file) throws IOException {
        // Get the directory where the compressed file is located
        String fileDirectory = file.getParent();

        // Create input and output streams
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile");
        GZIPInputStream gzip = new GZIPInputStream(fis);

        byte[] buffer = new byte[1024];
        int len;

        // Read from the compressed file and write to the decompressed file
        while ((len = gzip.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // Close the streams
        gzip.close();
        fos.close();
        fis.close();
    }

    // Main method for testing the decompressor
    public static void main(String[] args) throws IOException {
        // Specify the path to the compressed file you want to decompress
        File file = new File("");

        // Call the decompression method
        method(file);
    }
}