package fr.programme.com;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
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
import javax.swing.text.html.HTMLEditorKit;

public class MyEclipseTP2 extends JFrame{

	private static final long serialVersionUID = -1408157077817325761L;

	public MyEclipseTP2() {
		super("First app in Java Swing TP");
		this.setSize(new Dimension(720,480));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		this.add(rootPane);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(createToolBar(),BorderLayout.NORTH);
		
		JScrollPane tree = new JScrollPane(new JTree());
		tree.setPreferredSize(new Dimension(200,0));
		contentPane.add(tree,BorderLayout.WEST);
		
		JScrollPane textArea = new JScrollPane(new JTextArea());
		contentPane.add(textArea);
		
		contentPane.add(createRightPanel(),BorderLayout.EAST);
		
		contentPane.add(createStatusBar(),BorderLayout.SOUTH);
	}
	
	private JPanel createStatusBar() {
		JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusBar.add(new JLabel("slt"));
		statusBar.add(new JLabel("info inutile"));
		statusBar.add(new JLabel("jsp"));
		statusBar.setPreferredSize(new Dimension(0,50));
		return statusBar;
	}

	private JPanel createRightPanel() {
		JPanel rightPanel = new JPanel(new GridLayout(4,1));
		rightPanel.add(new Button("Bouton inutile"));
		rightPanel.add(new Button("Bouton inutile"));
		rightPanel.add(new Button("Bouton inutile"));
		rightPanel.add(new Button("Bouton inutile"));
//		rightPanel.setPreferredSize(new Dimension(100,0));
		return rightPanel;
	}

	public JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.add(new JButton("File"));
		toolBar.add(new JButton("Edit"));
		toolBar.add(new JButton("Source"));
		toolBar.add(new JButton("Refactor"));
		toolBar.add(new JButton("Navigate"));
		toolBar.add(new JButton("Search"));
		toolBar.add(new JButton("Project"));
		toolBar.add(new JButton("Run"));
		toolBar.add(new JButton("Window"));
		toolBar.add(new JButton("Help"));
		return toolBar;
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		MyEclipseTP2 window = new MyEclipseTP2();
		window.setVisible(true);
	}

}
