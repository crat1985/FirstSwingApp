package fr.programme.com;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TutoPopupMenu extends JFrame{

	private static final long serialVersionUID = -222856028923733972L;

	public TutoPopupMenu() {
		super("Tuto JToolBar");
		this.setSize(720,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		
		JScrollPane leftScrollPane = new JScrollPane(new JTree());
		leftScrollPane.setPreferredSize(new Dimension(200,0));
		
		JTextArea txtArea = new JTextArea();
		JScrollPane rightScrollPane = new JScrollPane(txtArea);
		
		JSplitPane splitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,leftScrollPane,rightScrollPane
		);
		contentPane.add(splitPane);
		
		JPopupMenu popupMenu = this.createPopupMenu();
		txtArea.setComponentPopupMenu(popupMenu);
		txtArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.isPopupTrigger()) {
					popupMenu.setVisible(true);
				}
			}
		});
//		popupMenu.setVisible(true);
		
//		txtArea.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(e.isPopupTrigger()) {
//					popupMenu.show(txtArea,e.getX(),e.getY());
//				}
//			}
//		});
		
	}
	
	private JPopupMenu createPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenu file = new JMenu("slt");
		popupMenu.add(file);
		
		JMenuItem filei = new JMenuItem("slt2");
		file.add(filei);
		
		return popupMenu;
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		TutoPopupMenu window = new TutoPopupMenu();
		window.setVisible(true);
	}

}
