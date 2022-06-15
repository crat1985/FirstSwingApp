package fr.programme.com;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ToolBar_PopupMenu_and_MenuBarTP extends JFrame{

	private static final long serialVersionUID = 5655358399168915609L;

	public JTextArea textArea = new JTextArea();
	
	public ToolBar_PopupMenu_and_MenuBarTP() {
		super("TP ToolBar, PopupMenu and MenuBar");
		this.setSize(720,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.setJMenuBar(createJMenuBar());
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(createToolBar(),BorderLayout.NORTH);
		
		contentPane.add(textArea);
		
		JPopupMenu popupMenu = this.createPopupMenu();
		textArea.setComponentPopupMenu(popupMenu);
		
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if((e.isPopupTrigger()&&textArea.getSelectedText()=="")||(e.isPopupTrigger()&&textArea.getSelectedText()==null)) {
					copyButton.setEnabled(false);
				} else if(e.isPopupTrigger()) {
					copyButton.setEnabled(true);
					System.out.println(textArea.getSelectedText());
				}
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Fermeture en cours...");
				dispose();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("Au revoir !");
			}
		});
	}
	JMenuItem copyButton = null;
	JMenuItem pasteButton = null;
	private JPopupMenu createPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		copyButton = new JMenuItem("Copier");
		copyButton.addActionListener((e)->{
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(this.textArea.getSelectedText()), null);
//			System.out.println(this.textArea.getSelectedText());
			System.out.println("Copié !");
		});
		pasteButton = new JMenuItem("Coller");
		pasteButton.addActionListener((e)->{
			String test = "";
			Toolkit.getDefaultToolkit().getSystemClipboard().getContents(test);
		});
		popupMenu.add(copyButton);
		popupMenu.add(pasteButton);
		return popupMenu;
	}
	
	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		JButton newButton = new JButton(new ImageIcon(this.getClass().getResource("icons/new.png")));
		newButton.setToolTipText("New File");
		toolBar.add(newButton);
		JButton exitButton = new JButton(new ImageIcon(this.getClass().getResource("icons/exit.png")));
		exitButton.setToolTipText("Exit");
		toolBar.add(exitButton);
		exitButton.addActionListener((e)->{
			System.out.println("Fermeture en cours...");
			dispose();
		});
		return toolBar;
	}

	private JMenuBar createJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu newMenu = new JMenu("New");
		newMenu.setIcon(new ImageIcon(this.getClass().getResource("icons/new.png")));
		fileMenu.add(newMenu);
		
		JMenuItem newJavaFile = new JMenuItem("Java File");
		newJavaFile.setIcon(new ImageIcon(this.getClass().getResource("icons/java-project-icon.png")));
		newMenu.add(newJavaFile);
		
		return menuBar;
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		ToolBar_PopupMenu_and_MenuBarTP window = new ToolBar_PopupMenu_and_MenuBarTP();
		window.setVisible(true);
	}

}
