/*
--------------------------------------------------------------------------------
Author   : Lynn Harris, lharris40@cnm.edu
Course   : CIS 2235, Java Programming I
Project  : E3 - ColorBuilder Class
Document : ColorBuilderFrame.java
--------------------------------------------------------------------------------
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ColorBuilderFrame extends JFrame {

	private ColorBuilder builder = new ColorBuilder();
	private JTextArea txtDescr = new JTextArea(builder.toString());
	private JButton btnChange = new JButton("Change color");

	// constructor
	public ColorBuilderFrame() {
		// initialize the frame
		setSize(400, 200);
		setTitle("Lynn Harris, Color Builder Class");  // put your info here
		setLocationRelativeTo(null);  // center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize the controls
		txtDescr.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtDescr.setSize(350, 100);
		txtDescr.setText(builder.toString());
		btnChange.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnChange.setPreferredSize(new Dimension(300, 50));
		btnChange.setForeground(builder.getMainColor());
		btnChange.setBackground(builder.getContrastColor());

		// create a panel to display color values
		JPanel formPanel = new JPanel();
		TitledBorder box = new TitledBorder("Current color values are ");
		box.setTitleFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		formPanel.setBorder(box);
		formPanel.add(txtDescr);

		// create a panel to hold button
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(btnChange);

		add(formPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		// create and register anonymous inner-class listener
		btnChange.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					changeColors();
				}
			}
		);
	}

	private void changeColors() {
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);
		builder.setRGB(r, g, b);
		btnChange.setForeground(builder.getMainColor());
		btnChange.setBackground(builder.getContrastColor());
		// btnChange.setOpaque(true);
		// btnChange.setBorderPainted(false);
		txtDescr.setText(builder.toString());
	}
}
