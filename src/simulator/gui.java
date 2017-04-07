package simulator;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Main class
public class gui{
	//Declare variables
	static JFrame frameInitial;
	static Container pane;
	static JButton btnSearch;
	static JLabel lblPkmnName, lblPkmnLvl;
	static JTextField txtPkmnName, txtPkmnLevel;
	static Insets insets;

	public static void main (String args[]){
		//Create the frame
		frameInitial = new JFrame ("Pokedex: Optimal Opponent Finder ALPHA");
		//Set its size to 500x100 pixels
		frameInitial.setSize (500,100);
		//Prepare panel
		pane = frameInitial.getContentPane();
		insets = pane.getInsets();
		//Apply the null layout
		pane.setLayout (null);
		

		//Create fields, buttons, and labels
		lblPkmnName = new JLabel ("Pokemon Name");
		txtPkmnName = new JTextField (15);
		lblPkmnLvl = new JLabel ("Level");
		txtPkmnLevel = new JTextField  (3);
		btnSearch = new JButton ("Search");
		
		
		//Add all components to panel
		pane.add (lblPkmnName);
		pane.add (lblPkmnLvl);
		pane.add (txtPkmnName);
		pane.add (txtPkmnLevel);
		pane.add (btnSearch);
		

		//Place all components
		lblPkmnName.setBounds (insets.left + 5, insets.top + 5, lblPkmnName.getPreferredSize().width, lblPkmnName.getPreferredSize().height);
		txtPkmnName.setBounds (lblPkmnName.getX() + lblPkmnName.getWidth() + 5, insets.top + 5, txtPkmnName.getPreferredSize().width, txtPkmnName.getPreferredSize().height);

		lblPkmnLvl.setBounds (txtPkmnName.getX() + txtPkmnName.getWidth() + 5, insets.top + 5, lblPkmnLvl.getPreferredSize().width, lblPkmnLvl.getPreferredSize().height);
		txtPkmnLevel.setBounds (lblPkmnLvl.getX() + lblPkmnLvl.getWidth() + 5, insets.top + 5, txtPkmnLevel.getPreferredSize().width, txtPkmnLevel.getPreferredSize().height);

		btnSearch.setBounds (txtPkmnLevel.getX() + txtPkmnLevel.getWidth() + 5, insets.top + 5, btnSearch.getPreferredSize().width, btnSearch.getPreferredSize().height);
		
		
		frameInitial.setVisible (true);
		
		
		//Set Look and Feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}
	}
}
