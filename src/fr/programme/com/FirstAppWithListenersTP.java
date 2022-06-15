package fr.programme.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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

public class FirstAppWithListenersTP extends JFrame{

	private static final long serialVersionUID = -1604835613830091415L;
	
	public FirstAppWithListenersTP() {
		this.setSize(new Dimension(720,480));
		this.setLocationRelativeTo(null);
		JPanel contentPane = (JPanel) this.getContentPane();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setBackground(Color.BLUE);
//		this.addWindowListener(new WindowAdapter() {
//
//			public void windowClosing(WindowEvent e) {
//				System.out.println("Fermeture...");
//				Timer t = new Timer();
//				t.schedule(new TimerTask() {
//					public void run() {
//						dispose();
//					}
//				}, 1000);
//			}
//		});
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Bienvenue !");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Fermeture...");
				int response = JOptionPane.showConfirmDialog(FirstAppWithListenersTP.this, "Voulez-vous vraiment quitter le programme ?","Confirmer",JOptionPane.YES_NO_OPTION);
				if(response==0) dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("Au revoir");
			}
		});		
		contentPane.add(createToolBar(),BorderLayout.NORTH);
		
		JTree tree1 = new JTree();
		tree1.setBackground(Color.BLUE);
		tree1.setForeground(Color.WHITE);
		JScrollPane tree = new JScrollPane(tree1);
		tree.setPreferredSize(new Dimension(200,0));
		tree.setBackground(Color.BLUE);
		tree.setForeground(Color.WHITE);
		contentPane.add(tree,BorderLayout.WEST);
		
		contentPane.add(createRightPanel(),BorderLayout.EAST);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBackground(Color.BLUE);
		textArea1.setForeground(Color.WHITE);
		JScrollPane textArea = new JScrollPane(textArea1);
		textArea.setBackground(Color.BLUE);
		textArea.setForeground(Color.WHITE);
		contentPane.add(textArea);
		
		contentPane.add(createStatusBar(),BorderLayout.SOUTH);
		contentPane.setBackground(Color.BLUE);
	}
	
	private JPanel createStatusBar() {
		JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ArrayList<JLabel> labels = new ArrayList<>();
		labels.add(new JLabel("info"));
		labels.add(new JLabel("info"));
		labels.add(new JLabel("info"));
		for(JLabel l : labels) {
			l.setForeground(Color.WHITE);
			statusBar.add(l);
		}
		statusBar.setPreferredSize(new Dimension(0,30));
		statusBar.setBackground(Color.BLUE);
		statusBar.setForeground(Color.WHITE);
		return statusBar;
	}

	private JPanel createRightPanel() {
		JPanel rightPanel = new JPanel(new GridLayout(4,1));
		ArrayList<JButton> buttons = new ArrayList<>();
		buttons.add(new JButton("slt"));
		buttons.add(new JButton("slt"));
		buttons.add(new JButton("slt"));
		buttons.add(new JButton("slt"));
		for(JButton b : buttons) {
			rightPanel.add(b);
			b.setForeground(Color.WHITE);
			b.setBackground(Color.BLUE);
			b.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					b.setForeground(Color.WHITE);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					b.setForeground(Color.BLACK);
				}
			});
		}
		rightPanel.setPreferredSize(new Dimension(100,0));
		rightPanel.setBackground(Color.BLUE);
		return rightPanel;
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		ArrayList<JButton> buttons = new ArrayList<>();
		buttons.add(new JButton("File"));
		buttons.add(new JButton("Edit"));
		buttons.add(new JButton("Source"));
		buttons.add(new JButton("Refactor"));
		buttons.add(new JButton("Navigate"));
		buttons.add(new JButton("Search"));
		buttons.add(new JButton("Project"));
		buttons.add(new JButton("Run"));
		buttons.add(new JButton("Window"));
		buttons.add(new JButton("Help"));
		toolBar.setBackground(Color.BLUE);
		for(JButton b : buttons) {
			toolBar.add(b);
			b.setBackground(Color.BLUE);
			b.setForeground(Color.WHITE);
			b.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					b.setForeground(Color.WHITE);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					b.setForeground(Color.BLACK);
				}
			});
		}
		return toolBar;
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		FirstAppWithListenersTP window = new FirstAppWithListenersTP();
		window.setVisible(true);
	}

}
