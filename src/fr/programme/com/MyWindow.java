package fr.programme.com;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindow extends JFrame{

	private static final long serialVersionUID = -4939544011287453046L;

	public MyWindow() {
		super("First Application");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(720, 480);
		this.setLocationRelativeTo(null); //null = bureau //permet de mettre la JFrame au centre de l'écran //mettre ça après avoir défini la taille de la fenêtre
		this.setResizable(true);
		this.getMenuBar(); //récupérer la barre de menu (ex : "Fichier")
		this.getContentPane(); //récupérer le reste
		
		JPanel contentPane = (JPanel) this.getContentPane();
		JButton button = new JButton("Hello World");
		button.setSize(100, 30);
		button.setLocation(0, 0);
		JButton button2 = new JButton("Hello World 2");
		button2.setBounds(0, 35, 110, 30);
		JCheckBox checkBox = new JCheckBox("YouTube");
		checkBox.setBounds(0, 65, 120, 30);
		JTextField textField = new JTextField();
		textField.setText("Hello World");
		textField.setEditable(true);
		textField.setBounds(0, 100, 120, 30);
		contentPane.add(button);
		contentPane.add(button2);
//		contentPane.setLayout(new FlowLayout());
		contentPane.setLayout(null);
		contentPane.add(checkBox);
		contentPane.add(textField);
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		//Apply a look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		MyWindow myWindow = new MyWindow();
		myWindow.setVisible(true);
	}

}
