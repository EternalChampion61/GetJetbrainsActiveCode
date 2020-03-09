package online.hugesea.scholar.jba.Layout;

import online.hugesea.scholar.jba.Processor.Processor;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class PlaceComponents {
    static Processor processor = new Processor();
    /**
     * @param panel: Panel.
     */
    public static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        // Add some components here.
        JLabel titleOfContent = new JLabel("Get Active Code From Here!");
        titleOfContent.setFont(new Font("Monospaced", Font.BOLD, 18));
        titleOfContent.setBounds(10, 10, 690, 50);
        panel.add(titleOfContent);

        // Show codes.
        JTextArea activeCodeFromAPI = new JTextArea();
        activeCodeFromAPI.setEditable(false);
        activeCodeFromAPI.setText(processor.GetContentOfAPI());
        activeCodeFromAPI.setFont(new Font("Monospaced", Font.BOLD, 12));
        activeCodeFromAPI.setBounds(10, 60, 680, 400);
        activeCodeFromAPI.setLineWrap(true);
        activeCodeFromAPI.setForeground(Color.blue);
        panel.add(activeCodeFromAPI);

        // Use this button and copy content to your clipboard.
        JButton contentToClipboard = new JButton("COPY");
        contentToClipboard.setFont(new Font("Monospaced", Font.BOLD, 15));
        contentToClipboard.setBounds(10, 490, 80, 50);
        contentToClipboard.addActionListener(actionEvent -> {
            Transferable transferable = new StringSelection(activeCodeFromAPI.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(transferable, null);
            try {
                transferable.isDataFlavorSupported(DataFlavor.stringFlavor);
                String content = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                if (content.equals(activeCodeFromAPI.getText())) {
                    JOptionPane.showMessageDialog(null, "Copy success!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        panel.add(contentToClipboard);

        // Use this button and save content to a file named "ActiveCode.txt"
        JButton saveToFile = new JButton("SAVE TO FILE");
        saveToFile.setFont(new Font("Monospaced", Font.BOLD, 15));
        saveToFile.setBounds(100, 490, 200, 50);
        saveToFile.addActionListener(actionEvent -> {
            try {
                File file = new File("ActiveCode.txt");
                Writer writer = new FileWriter(file);
                writer.write(activeCodeFromAPI.getText());
                // Check file "ActiveCode.txt" is exists.
                if (file.exists()) {
                    JOptionPane.showMessageDialog(null, "Save success!");
                } else {
                    JOptionPane.showMessageDialog(null, "Save failed.");
                }
                writer.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        panel.add(saveToFile);
    }
}