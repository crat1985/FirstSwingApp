package fr.programme.com;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindowFlowLayout extends JFrame{

	private static final long serialVersionUID = -4939544011287453046L;

	public MyWindowFlowLayout() {
		super("First Application");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(720, 480);
		this.setLocationRelativeTo(null); //null = bureau //permet de mettre la JFrame au centre de l'écran //mettre ça après avoir défini la taille de la fenêtre
		this.setResizable(true);
		this.getMenuBar(); //récupérer la barre de menu (ex : "Fichier")
		this.getContentPane(); //récupérer le reste
		
		JPanel contentPane = (JPanel) this.getContentPane();
		JButton button = new JButton("Hello World");
		contentPane.add(button);
		JButton button2 = new JButton("Hello World 2");
		contentPane.add(button2);
		JCheckBox checkBox = new JCheckBox("YouTube");
		contentPane.add(checkBox);
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(120,30));
		textField.setText("Edit me !");
//		textField.setEditable(true);
		contentPane.add(textField);
//		contentPane.setLayout(new FlowLayout());
//		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); //100 px de marge entre chaque élément et entre chaque élément et le bord
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		//Apply a look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		MyWindowFlowLayout myWindow = new MyWindowFlowLayout();
		myWindow.setVisible(true);
	}

}
