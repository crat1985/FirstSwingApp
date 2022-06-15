package fr.programme.com;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TutoMenuBar extends JFrame{

	private static final long serialVersionUID = -4039871290626025647L;

	public TutoMenuBar() throws MalformedURLException{
		super("Tuto Menu Bar");
		this.setSize(720,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		
		this.setJMenuBar(createJMenuBar());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeWindow();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("Au revoir !");
			}
		});
	}
	
	private void closeWindow() {
		int response = JOptionPane.showConfirmDialog(TutoMenuBar.this, "Voulez-vous vraiment quitter le programme ?","Confirmation",JOptionPane.YES_NO_OPTION);
		if(response==0) {
			dispose();
		}
	}
	
	private JMenuBar createJMenuBar() throws MalformedURLException {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		fileMenu.setMnemonic('F');
		JMenu newButton = new JMenu("New");
		fileMenu.add(newButton);
		newButton.setMnemonic('N');
//		newButton.setIcon(new ImageIcon(new URL("http://localhost/new.png")));
		newButton.setIcon(new ImageIcon(this.getClass().getResource("icons/new.png")));
		JMenuItem javaProjectButton = new JMenuItem("Java Project");
		newButton.add(javaProjectButton);
		javaProjectButton.setIcon(new ImageIcon(this.getClass().getResource("icons/java-project-icon.png")));
		JMenuItem projectButton = new JMenuItem("Project...");
		newButton.add(projectButton);
		newButton.addSeparator();
		JMenuItem otherButton = new JMenuItem("Other...");
		newButton.add(otherButton);
		otherButton.addActionListener((e)->{
			JOptionPane.showMessageDialog(TutoMenuBar.this, "En cours de développement...");
		});
		JMenuItem openFileButton = new JMenuItem("Open File...");
		fileMenu.add(openFileButton);
		openFileButton.addActionListener((e)->{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(TutoMenuBar.this);
			File file = fileChooser.getSelectedFile();
			System.out.println(file==null ? "[LOG] Vous n'avez pas choisi de fichier..." : "[LOG] Fichier choisi : "+file);
		});
//		openFileButton.setMnemonic('O');
		openFileButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
//		openFileButton.setEnabled(false);
		openFileButton.setIcon(new ImageIcon(this.getClass().getResource("icons/open.png")));
		JMenuItem openProjectsFromFileSystem = new JMenuItem("Open Projects from File System...");
		fileMenu.add(openProjectsFromFileSystem);
		openProjectsFromFileSystem.setEnabled(false);
		JMenuItem exitButton = new JMenuItem("Exit");
		fileMenu.add(exitButton);
		exitButton.addActionListener((e)->{
			closeWindow();
		});
//		URL i = this.getClass().getResource("exit.png");
//		ImageIcon a = new ImageIcon(this.getClass().getResource("exit.png"));
		exitButton.setIcon(new ImageIcon(this.getClass().getResource("icons/exit.png")));
		return menuBar;
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException, MalformedURLException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		TutoMenuBar window = new TutoMenuBar();
		window.setVisible(true);
	}

}
