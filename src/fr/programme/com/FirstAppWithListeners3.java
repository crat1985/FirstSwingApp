package fr.programme.com;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class FirstAppWithListeners3 extends JFrame implements ActionListener{

	private static final long serialVersionUID = -1408157077817325761L;

	public FirstAppWithListeners3() {
		super("First app in Java Swing TP");
		this.setSize(new Dimension(720,480));
		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int response = JOptionPane.showConfirmDialog(FirstAppWithListeners3.this, "Voulez-vous vraiment quitter ?","Etes-vous sûr ?",JOptionPane.YES_NO_OPTION);
				if(response==JOptionPane.YES_OPTION) {
//					FirstAppWithListeners3.this.dispose();
					dispose();
				}
			}
		});
	}
	
	private JPanel createStatusBar() {
		JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusBar.add(new JLabel("slt"));
		statusBar.add(new JLabel("info inutile"));
		statusBar.add(new JLabel("jsp"));
		statusBar.setPreferredSize(new Dimension(0,50));
		return statusBar;
	}
	private JButton rightButton1 = new JButton("Useful Button !");
	private JPanel createRightPanel() {
		JPanel rightPanel = new JPanel(new GridLayout(4,1));
		rightPanel.add(rightButton1);
		System.out.println(rightButton1.getBackground());
		rightButton1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				rightButton1.setBackground(new Color(214, 217, 223));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				rightButton1.setBackground(Color.BLUE);
			}
		});
		rightPanel.add(new Button("Bouton inutile"));
		rightPanel.add(new Button("Bouton inutile"));
		rightPanel.add(new Button("Bouton inutile"));
//		rightPanel.setPreferredSize(new Dimension(100,0));
		return rightPanel;
	}
	
	private void fileButtonClicked(ActionEvent e) {
		System.out.println("Button \"File\" pressed");
	}
	
	private JButton sourceButton = new JButton("Source");
	
	public JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		JButton fileButton = new JButton("File");
//		fileButton.addActionListener((e)->{
//			System.out.println(e.getSource().);
//		});
		fileButton.addActionListener(this::fileButtonClicked);
		toolBar.add(fileButton);
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(this);
		toolBar.add(editButton);
//		sourceButton.addMouseListener(new MouseListener() {
//			public void mouseReleased(MouseEvent e) {}
//			public void mousePressed(MouseEvent e) {}
//			public void mouseExited(MouseEvent e) {
//				sourceButton.setForeground(Color.BLACK);
//			}
//			public void mouseEntered(MouseEvent e) {
//				sourceButton.setForeground(Color.BLUE);
//			}
//			public void mouseClicked(MouseEvent e) {}
//		});
		//plus court
		sourceButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				sourceButton.setForeground(Color.BLUE);
			}
			public void mouseExited(MouseEvent e) {
				sourceButton.setForeground(Color.BLACK);
			}
		});
		toolBar.add(sourceButton);
		toolBar.add(new JButton("Refactor"));
		toolBar.add(new JButton("Navigate"));
		toolBar.add(new JButton("Search"));
		toolBar.add(new JButton("Project"));
		toolBar.add(new JButton("Run"));
		toolBar.add(new JButton("Window"));
		helpButton.addActionListener(this);
		toolBar.add(helpButton);
		return toolBar;
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		FirstAppWithListeners3 window = new FirstAppWithListeners3();
		window.setVisible(true);
	}

	JButton helpButton = new JButton("Help");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == helpButton) {
			System.out.println("Bouton d'aide pressé !");
		} else {
			System.out.println("En cours de développement...");
		}
	}
	//TODO 9:06
}
