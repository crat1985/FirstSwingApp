package fr.programme.com;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TutoToolBar extends JFrame{

	private static final long serialVersionUID = -222856028923733972L;

	public TutoToolBar() {
		super("Tuto JToolBar");
		this.setSize(720,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(createToolBar(),BorderLayout.NORTH);
		
		JTree tree = new JTree();
	}
	
	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		
		JButton btnNew = new JButton(new ImageIcon(this.getClass().getResource("icons/new.png")));
		btnNew.addActionListener((e)->{
			JOptionPane.showMessageDialog(TutoToolBar.this, "New document is required");
		});
		toolBar.add(btnNew);
		btnNew.setToolTipText("New File");
		toolBar.addSeparator();
		JButton btnExit = new JButton(new ImageIcon(this.getClass().getResource("icons/exit.png")));
		btnExit.setToolTipText("Exit");
		btnExit.addActionListener((e)->{
			System.out.println("Au revoir");
			dispose();
		});
		toolBar.add(btnExit);
		
		
		return toolBar;
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		TutoToolBar window = new TutoToolBar();
		window.setVisible(true);
	}

}
