/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package converterframe1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eugene
 */
public class ConverterFrame1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConverterFrameMain frame = new ConverterFrameMain("Convert");
                frame.setVisible(true);
            }
        });
    }
    
    public static class ConverterFrameMain extends JFrame {
        private final JButton btnConvert;
        private final JButton btnConvert1;
        
        public ConverterFrameMain(String title) {
            super(title);
            this.setBounds(100, 100, 479, 179);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 2, 5, 10));
            
            btnConvert = new JButton("Convert Farenheight to Celsius");
            panel.add(btnConvert);
            
            btnConvert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConverterFrame2 ftoc = new ConverterFrame2("Convert Farenheight to Celsius", "Farenheit","Celsius") {
//                        @Override
//                        public double getOutput() {
////                        try {
//                            double celsius = getInputValue();
//                            return (celsius * 9.0 / 5.0) + 32;
////                        } catch (NumberFormatException e) {
////                            return 0;
////                        }
//                        }
                    };
                    ftoc.setVisible(true);
                    dispose();
                }
            });

            btnConvert1 = new JButton("Convert Celsius to Farenheight");
            panel.add(btnConvert1);
            
            btnConvert1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConverterFrame ctof = new ConverterFrame("Convert Celsius to Farenheight", "Celsius","Farenheit") {
//                        @Override
//                        public double getOutput() {
////                        try {
//                            double celsius = getInputValue();
//                            return (celsius * 9.0 / 5.0) + 32;
////                        } catch (NumberFormatException e) {
////                            return 0;
////                        }
//                        }
                    };
                    ctof.setVisible(true);
                    dispose();
                }
            });

            
            // Set 10% of the Height of the window as top and bottom margin
            final int topAndBottomPadding = (int) (this.getHeight() * .10); 
            // Set 10% of the Width of the window as left and right margin
            final int leftAndRightPadding = (int) (this.getWidth() * .10);        
            panel.setBorder(BorderFactory.createEmptyBorder(topAndBottomPadding, leftAndRightPadding, topAndBottomPadding, leftAndRightPadding));
            this.add(panel);
        }
    }
    
    public static abstract class ConverterFrame extends JFrame {
        private final JTextField txtInput;
        private final JLabel lblInput;
        private final JButton btnConvert;
        private final JLabel lblOutput;
        private final JButton btnBack;

        /**
         * ConverterFrame constructor. 
         * 
         * @param title - Title of the window.
         * @param inputText, will be set as the input label.
         * @param outputText, will be set as the output label suffix. 
         */
        public ConverterFrame(String title, String inputText, String outputText) {
            super(title);
            
            this.setBounds(100, 100, 479, 179);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2, 5, 10));
            
            txtInput = new JTextField();        
            txtInput.setColumns(10);
            panel.add(txtInput);
            
            lblInput = new JLabel(inputText);
            panel.add(lblInput);
            
            btnConvert = new JButton("Convert");
            panel.add(btnConvert);
            
            lblOutput = new JLabel(outputText);
            panel.add(lblOutput);
            
            // FIXED: Add the panel *after* components have been placed, or at the end of setup
            this.getContentPane().add(panel);

            btnConvert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final String output = getOutput() + " " + outputText;
                    lblOutput.setText(output);
                }
            });
            
            btnBack = new JButton("back");
            panel.add(btnBack);
            
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConverterFrameMain main = new ConverterFrameMain("Convert");
                    main.setVisible(true);
                    dispose();
                }
            });
            
            // Set 10% of the Height of the window as top and bottom margin
            final int topAndBottomPadding = (int) (this.getHeight() * .10); 
            // Set 10% of the Width of the window as left and right margin
            final int leftAndRightPadding = (int) (this.getWidth() * .10);        
            panel.setBorder(BorderFactory.createEmptyBorder(topAndBottomPadding, leftAndRightPadding, topAndBottomPadding, leftAndRightPadding));
        }
        
        public double getInputValue() {
            return Double.parseDouble(txtInput.getText());
        }
        
        /**
         * Abstract method will force you to make your own implementation of getOutput method. 
         * You must perform the conversion here and the returned value of this method will be displayed on output label.
         */
        public double getOutput() {
            double celsius = getInputValue();
                            // Formula: (C * 9/5) + 32
                            return (celsius * 9.0 / 5.0) + 32;
        };
    } 
    
    public static abstract class ConverterFrame2 extends JFrame {
        private final JTextField txtInput;
        private final JLabel lblInput;
        private final JButton btnConvert;
        private final JLabel lblOutput;
        private final JButton btnBack;

        /**
         * ConverterFrame constructor. 
         * 
         * @param title - Title of the window.
         * @param inputText, will be set as the input label.
         * @param outputText, will be set as the output label suffix. 
         */
        public ConverterFrame2(String title, String inputText, String outputText) {
            super(title);
            
            this.setBounds(100, 100, 479, 179);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2, 5, 10));
            
            txtInput = new JTextField();        
            txtInput.setColumns(10);
            panel.add(txtInput);
            
            lblInput = new JLabel(inputText);
            panel.add(lblInput);
            
            btnConvert = new JButton("Convert");
            panel.add(btnConvert);
            
            lblOutput = new JLabel(outputText);
            panel.add(lblOutput);
            
            // FIXED: Add the panel *after* components have been placed, or at the end of setup
            this.getContentPane().add(panel);

            btnConvert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final String output = String.format("%.2f", getOutput()) + " " + outputText;
                    lblOutput.setText(output);
                }
            });
            
            btnBack = new JButton("back");
            panel.add(btnBack);
            
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConverterFrameMain main = new ConverterFrameMain("Convert");
                    main.setVisible(true);
                    dispose();
                }
            });
            
            // Set 10% of the Height of the window as top and bottom margin
            final int topAndBottomPadding = (int) (this.getHeight() * .10); 
            // Set 10% of the Width of the window as left and right margin
            final int leftAndRightPadding = (int) (this.getWidth() * .10);        
            panel.setBorder(BorderFactory.createEmptyBorder(topAndBottomPadding, leftAndRightPadding, topAndBottomPadding, leftAndRightPadding));
        }
        
        public double getInputValue() {
            return Double.parseDouble(txtInput.getText());
        }
        
        /**
         * Abstract method will force you to make your own implementation of getOutput method. 
         * You must perform the conversion here and the returned value of this method will be displayed on output label.
         */
        public double getOutput() {
            double fahrenheit = getInputValue();
                            // Formula: (C * 9/5) + 32
                            return (fahrenheit - 32) * 5.0 / 9.0;
        };
    } 
}