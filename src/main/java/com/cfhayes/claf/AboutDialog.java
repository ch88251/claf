package com.cfhayes.claf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public  final class AboutDialog extends JDialog {
	
    public AboutDialog(JFrame frame) {
    	super(frame);
    	
    	JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        this.add(infoPanel,BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new FlowLayout());
        this.add(bottomPanel, BorderLayout.SOUTH);

        infoPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        JPanel table = new JPanel(new GridLayout(3, 2));
        infoPanel.add(table);
        infoPanel.add(bottomPanel);
        
        table.add(new JLabel("Version: 1.0"));
        table.add(new JLabel("Author: Charles F. Hayes"));
        
        StringBuilder sb = new StringBuilder();
        sb.append("This project demonstrates how the look and feel<br/>");
        sb.append("can be <u>fully</u> customized.<br/>");
        JLabel info = new JLabel("<html><font color='Blue'>"+sb.toString()+"</font></html>");
        table.add(info);
        
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String command = event.getActionCommand();
                if (command.equals("Ok")) {
                	dispose();
                }
            }
        });
        
        bottomPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        bottomPanel.add(okButton);
        
        getContentPane().add(infoPanel);
        pack();
        setLocationRelativeTo(frame);
        setVisible(true);
        dispose();
    }

}
