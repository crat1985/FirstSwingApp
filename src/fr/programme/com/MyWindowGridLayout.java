package fr.programme.com;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowGridLayout extends JFrame{

	private static final long serialVersionUID = -4939544011287453046L;

	public MyWindowGridLayout() {
		super("First Application");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(720, 480);
		this.setLocationRelativeTo(null); //null = bureau //permet de mettre la JFrame au centre de l'écran //mettre ça après avoir défini la taille de la fenêtre
		this.setResizable(true);
		this.getMenuBar(); //récupérer la barre de menu (ex : "Fichier")
		this.getContentPane(); //récupérer le reste
		this.setBackground(Color.BLUE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		JButton button = new JButton("Hello World");
		contentPane.add(button);
		button.setBackground(Color.BLUE);
		button.setForeground(Color.WHITE);
		JButton button2 = new JButton("Hello World 2");
		contentPane.add(button2);
		button2.setBackground(Color.BLUE);
		button2.setForeground(Color.WHITE);
		JCheckBox checkBox = new JCheckBox("YouTube");
		contentPane.add(checkBox);
		checkBox.setBackground(Color.BLUE);
		checkBox.setForeground(Color.WHITE);
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(120,30));
		textField.setText("Edit me !");
//		textField.setEditable(true);
		contentPane.add(textField);
		textField.setBackground(Color.BLUE);
		textField.setForeground(Color.WHITE);
//		contentPane.setLayout(new FlowLayout());
//		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
//		contentPane.setLayout(new GridLayout(2, 2)); //2 ligne et 2 colonnes
		contentPane.setLayout(new GridLayout(2, 2, 20, 20)); //20 px d'espace ENTRE LES ELEMENTS (pas entre les éléments et le bord)
		contentPane.setBackground(Color.BLUE);
		
		//TODO 21:07 tuto 2/11
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		//Apply a look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		MyWindowGridLayout myWindow = new MyWindowGridLayout();
		myWindow.setVisible(true);
	}

}
