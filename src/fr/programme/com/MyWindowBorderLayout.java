package fr.programme.com;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowBorderLayout extends JFrame{

	private static final long serialVersionUID = -4939544011287453046L;

	public MyWindowBorderLayout() {
		super("First Application");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.getMenuBar();
		this.getContentPane();
		this.setBackground(Color.BLUE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		JButton button = new JButton("Hello World");
		contentPane.add(button,BorderLayout.NORTH);
		button.setBackground(Color.BLUE);
		button.setForeground(Color.WHITE);
		JButton button2 = new JButton("Hello World 2");
		contentPane.add(button2, BorderLayout.WEST);
		button2.setBackground(Color.BLUE);
		button2.setForeground(Color.WHITE);
		button2.setPreferredSize(new Dimension(200,0));
		JCheckBox checkBox = new JCheckBox("YouTube");
		contentPane.add(checkBox, BorderLayout.SOUTH);
		checkBox.setBackground(Color.BLUE);
		checkBox.setForeground(Color.WHITE);
		JTextArea textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(120,30));
		textArea.setText("Edit me !");
		contentPane.add(textArea, BorderLayout.EAST);
		textArea.setBackground(Color.BLUE);
		textArea.setForeground(Color.WHITE);
//		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.BLUE);
		
		
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		//Apply a look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		MyWindowBorderLayout myWindow = new MyWindowBorderLayout();
		myWindow.setVisible(true);
	}

}
