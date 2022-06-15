package fr.programme.com;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyEclipse extends JFrame{

	private static final long serialVersionUID = -4939544011287453046L;

	public MyEclipse() {
		super("First Application");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.getMenuBar();
		this.getContentPane();
		this.setBackground(Color.BLUE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
//		JButton button = new JButton("Hello World");
		contentPane.add(createToolBar(),BorderLayout.NORTH);
//		button.setBackground(Color.BLUE);
//		button.setForeground(Color.WHITE);
//		JButton button2 = new JButton("Hello World 2");
		JScrollPane westComponent = new JScrollPane(new JTree());
		contentPane.add(westComponent, BorderLayout.WEST);
		westComponent.setPreferredSize(new Dimension(300,0));
//		westComponent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		westComponent.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		contentPane.add(createStatusBar(), BorderLayout.SOUTH);
		
		JTextArea textArea = new JTextArea("The content of this beautiful editor !");
//		contentPane.add(textArea, BorderLayout.EAST);
		JScrollPane scrArea = new JScrollPane(textArea);
		contentPane.add(scrArea);
		textArea.setBackground(Color.BLUE);
		textArea.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLUE);
		
		contentPane.add(createRightPanel(), BorderLayout.EAST);
	}
	
	private JPanel createStatusBar() {
		JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		statusBar.setLayout(new FlowLayout());
		JLabel lblStatus1 = new JLabel("Message 1");
		lblStatus1.setPreferredSize(new Dimension(100,30));
		statusBar.add(lblStatus1);
		
		JLabel lblStatus2 = new JLabel("Message 2");
		lblStatus2.setPreferredSize(new Dimension(100,30));
		statusBar.add(lblStatus2);
		
		JLabel lblStatus3 = new JLabel("Message 3");
		lblStatus3.setPreferredSize(new Dimension(100,30));
		statusBar.add(lblStatus3);
		
		return statusBar;
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.BLUE);
		toolBar.setForeground(Color.WHITE);
		JButton button = new JButton("Hello World");
		toolBar.add(button);
		button.setBackground(Color.BLUE);
		button.setForeground(Color.WHITE);
		JButton button2 = new JButton("Hello World 2");
		toolBar.add(button2);
		button2.setBackground(Color.BLUE);
		button2.setForeground(Color.WHITE);
		JCheckBox checkBox = new JCheckBox("YouTube");
		toolBar.add(checkBox);
		checkBox.setBackground(Color.BLUE);
		checkBox.setForeground(Color.WHITE);
		JTextField textField = new JTextField();
		textField.setText("Edit me !");
		toolBar.add(textField);
		textField.setBackground(Color.BLUE);
		textField.setForeground(Color.WHITE);
		
		
		
		
		return toolBar;
	}
	
	private JPanel createRightPanel() {
		JPanel panel = new JPanel(new GridLayout(4,1));
		panel.add(new JButton("Boutton 1"));
		panel.add(new JButton("Boutton 2"));
		panel.add(new JButton("Boutton 3"));
		panel.add(new JButton("Boutton 4"));
		return panel;
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		//Apply a look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		MyEclipse myWindow = new MyEclipse();
		myWindow.setVisible(true);
	}

}
