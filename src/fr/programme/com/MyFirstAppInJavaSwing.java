package fr.programme.com;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyFirstAppInJavaSwing extends JFrame{

	private static final long serialVersionUID = -15317841865922170L;
	private int score = 0;
	public MyFirstAppInJavaSwing() {
		super("My app XD");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setCursor(Cursor.CROSSHAIR_CURSOR);
		this.setVisible(true);
		this.setSize(720, 480);
		this.setLayout(new BorderLayout());
		JPanel contentPane = (JPanel) this.getContentPane();
		JButton button1 = new JButton("Clique !");
		contentPane.add(button1,BorderLayout.CENTER);
		button1.setPreferredSize(new Dimension(200,200));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.printf("Score : %d\n",++score);
			}
		});
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		MyFirstAppInJavaSwing root = new MyFirstAppInJavaSwing();
	}

}
