package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author kundan kumar 
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // Set layout to null
        this.setTitle("Compressor-Decompressor");
        
        JLabel headingLabel = new JLabel("Compressor-Decompressor");
        headingLabel.setBounds(250, 20, 300, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        
        compressButton=new JButton("Select file to compress");
        compressButton.setBounds(10,100,200,30);
        compressButton.addActionListener(this);
        
        
        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(250, 100, 200, 30);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
        
        
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                compressor.method(file);
                
                JOptionPane.showMessageDialog(null, "File compressed successfully!",
                            "Compression Success", JOptionPane.INFORMATION_MESSAGE);
                
            }
            catch(IOException ee){
                    JOptionPane.showMessageDialog(null, "Error compressing file: " + ee.toString(),
                            "Compression Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
                
            
        }
        if(e.getSource()==decompressButton){
           // if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                decompressor.method(file);
                JOptionPane.showMessageDialog(null, "File decompressed successfully!",
                            "Decompression Success", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(IOException ee){
                    JOptionPane.showMessageDialog(null, "Error decompressing file: " + ee.toString(),
                            "Decompression Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
            
        }
        
    }
    
    
}
