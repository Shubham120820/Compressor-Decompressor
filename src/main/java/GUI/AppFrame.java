package GUI;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    public AppFrame() {
        // Set the close operation for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the "Compress" button
        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(20, 10, 200, 30);

        compressButton.addActionListener(this);

        // Create the "Decompress" button
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(20, 50, 200, 30);

        decompressButton.addActionListener(this);

        // Add the buttons to the frame
        this.add(compressButton);
        this.add(decompressButton);

        // Set frame
        this.setTitle("Compressor Decompressor");
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
        this.setSize(1000, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            // Create a file chooser dialog to select a file to compress
            JFileChooser fileChooser = new JFileChooser("C:");
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                // Get the selected file and its absolute path
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                // Print the selected file for debugging
                System.out.print(file);

                try {
                    // Call the compressor method to compress the selected file
                    Compressor.method(file);
                } catch (Exception ee) {
                    // Display an error message if compression fails
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            // Create a file chooser dialog to select a file to decompress
            JFileChooser fileChooser = new JFileChooser("C:");
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                // Get the selected file and its absolute path
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                // Print the selected file for debugging
                System.out.print(file);

                try {
                    // Call the decompressor method to decompress the selected file
                    Decompressor.method(file);
                } catch (Exception ee) {
                    // Display an error message if decompression fails
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
