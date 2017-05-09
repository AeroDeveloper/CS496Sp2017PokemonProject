package simulator;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import objects.Pokemon;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Main class
public class PokeGui{
	//Declare variables
	static JFrame frameInitial;
	static Container pane;
	static JButton btnSearch;
	static JLabel lblId,lblPkmnName,lblType1,lblType2,lblAtk,lblDef,lblSpAtk,lblSpDef,lblSpd;
	static JTextField txtPkmnName;//txtPkmnLevel
	static Insets insets;

	public List<Pokemon> masterList;

	public PokeGui(PokemonList pl) throws NullPointerException, IOException, IllegalArgumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		masterList = pl.result;

		//Create the frame
		frameInitial = new JFrame ("Pokedex: Optimal Opponent Finder ALPHA");
		//Set its size to 500x100 pixels
		frameInitial.setSize (400,100);
		//Prepare panel
		pane = frameInitial.getContentPane();
		insets = pane.getInsets();
		//Apply the null layout
		pane.setLayout (null);



		//Create fields, buttons, and labels
		lblPkmnName = new JLabel ("Pokemon Name");
		txtPkmnName = new JTextField (15);
		//		lblPkmnLvl = new JLabel ("Level");
		//		txtPkmnLevel = new JTextField  (3);
		btnSearch = new JButton ("Search");


		//Add all components to panel
		pane.add (lblPkmnName);
		//		pane.add (lblPkmnLvl);
		pane.add (txtPkmnName);
		//		pane.add (txtPkmnLevel);
		pane.add (btnSearch);


		//Place all components
		lblPkmnName.setBounds (insets.left + 5, insets.top + 5, lblPkmnName.getPreferredSize().width, lblPkmnName.getPreferredSize().height);
		txtPkmnName.setBounds (lblPkmnName.getX() + lblPkmnName.getWidth() + 5, insets.top + 5, txtPkmnName.getPreferredSize().width, txtPkmnName.getPreferredSize().height);

		//lblPkmnLvl.setBounds (txtPkmnName.getX() + txtPkmnName.getWidth() + 5, insets.top + 5, lblPkmnLvl.getPreferredSize().width, lblPkmnLvl.getPreferredSize().height);
		//txtPkmnLevel.setBounds (lblPkmnLvl.getX() + lblPkmnLvl.getWidth() + 5, insets.top + 5, txtPkmnLevel.getPreferredSize().width, txtPkmnLevel.getPreferredSize().height);

		//btnSearch.setBounds (txtPkmnLevel.getX() + txtPkmnLevel.getWidth() + 5, insets.top + 5, btnSearch.getPreferredSize().width, btnSearch.getPreferredSize().height);
		btnSearch.setBounds (txtPkmnName.getX() + txtPkmnName.getWidth() + 5, insets.top + 5, btnSearch.getPreferredSize().width, btnSearch.getPreferredSize().height);

		frameInitial.setVisible (true);

		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
				String nameInquiry = txtPkmnName.getText();

				Pokemon result = pl.searchByName(nameInquiry);
				if(result == null)
					txtPkmnName.setText("ERROR");
				else{
					lblId.setText("ID: " + result.getID());
					if(result.getType2() == null){
						lblType1.setText("Type: " + result.getType1());
						if(lblType2.isVisible())
							lblType2.setVisible(false);
					} else{
						lblType1.setText("Type 1: " + result.getType1());
						lblType2.setText("Type 2: " + result.getType2());
					}
				
				}

					//					lblAtk = new JLabel("Atk: " + Integer.toString(result.atk));
					//					lblDef = new JLabel("Def: " + Integer.toString(result.def));
					//					lblSpAtk = new JLabel("Sp.Atk: " + Integer.toString(result.spAtk));
					//					lblSpDef = new JLabel("Sp.Def: " + Integer.toString(result.spDef));
					//					lblAglty = new JLabel("Agility: " + Integer.toString(result.aglty));

					frameInitial.setSize (400,100);//TODO

				}



			}
		});


		//Set Look and Feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
			throw e;
		}
	}

}
