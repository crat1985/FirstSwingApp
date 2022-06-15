package fr.programme.com;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyEclipseTP extends JFrame{

	private static final long serialVersionUID = 3514604708196823099L;

	public MyEclipseTP() {
		super("TP Java Swing");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(720, 480);
		this.setLocationRelativeTo(null); //au millieu de l'écran
		this.setBackground(Color.BLUE);
		this.setForeground(Color.WHITE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(createToolBar(),BorderLayout.NORTH);
		
		JTree tree = new JTree();
//		tree.setBackground(Color.BLUE);
//		tree.setForeground(Color.WHITE);
		JScrollPane westComponent = new JScrollPane(tree);
		contentPane.add(westComponent, BorderLayout.WEST);
		westComponent.setPreferredSize(new Dimension(300,0));
		westComponent.setBackground(Color.BLUE);
		westComponent.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLUE);
		
		contentPane.add(createRightPanel(),BorderLayout.EAST);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBackground(Color.BLUE);
		txtArea.setForeground(Color.WHITE);
		JScrollPane scrTxtArea = new JScrollPane(txtArea);
		contentPane.add(scrTxtArea);
		scrTxtArea.setBackground(Color.BLUE);
		scrTxtArea.setForeground(Color.WHITE);
		
		contentPane.add(createStatusBar(),BorderLayout.SOUTH);
	}
	
	private JPanel createStatusBar() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("Info n°1"));
		panel.add(new JLabel("Info n°2"));
		panel.add(new JLabel("Info n°3"));
		panel.add(new JLabel("Info n°4"));
		return panel;
	}

	private JPanel createRightPanel() {
		JPanel panel = new JPanel(new GridLayout(4,1));
		panel.add(new Button("Button 1"));
		panel.add(new Button("Button 2"));
		panel.add(new Button("Button 3"));
		panel.add(new Button("Button 4"));
		panel.setPreferredSize(new Dimension(125,0));
		return panel;
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		JButton button1 = new JButton("slt");
		toolBar.add(button1);
		return toolBar;
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		MyEclipseTP myWindow = new MyEclipseTP();
		myWindow.setVisible(true);
	}

}
