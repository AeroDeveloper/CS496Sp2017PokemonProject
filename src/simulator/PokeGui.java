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
	static JLabel lblId,lblName,lblSearchTerm,lblType1,lblType2,lblHp,lblAtk,lblDef,lblSpAtk,lblSpDef,lblSpd;
	static JTextField txtSearchField;//txtPkmnLevel
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

		lblId = new JLabel("");
		lblName = new JLabel("");
		lblSearchTerm = new JLabel("");
		lblType1 = new JLabel("");
		lblType2 = new JLabel("");
		lblHp = new JLabel("");
		lblAtk = new JLabel("");
		lblDef = new JLabel("");
		lblSpAtk = new JLabel("");
		lblSpDef = new JLabel("");
		lblSpd = new JLabel("");

		//Create fields, buttons, and labels
		lblSearchTerm = new JLabel ("Pokemon Name");
		txtSearchField = new JTextField (15);
		btnSearch = new JButton ("Search");


		//Add all components to panel
		pane.add (lblSearchTerm);
		//		pane.add (lblPkmnLvl);
		pane.add (txtSearchField);
		//		pane.add (txtPkmnLevel);
		pane.add (btnSearch);


		//Place all components
		lblSearchTerm.setBounds (insets.left + 5, insets.top + 5, lblSearchTerm.getPreferredSize().width, lblSearchTerm.getPreferredSize().height);
		txtSearchField.setBounds (lblSearchTerm.getX() + lblSearchTerm.getWidth() + 5, insets.top + 5, txtSearchField.getPreferredSize().width, txtSearchField.getPreferredSize().height);

		//lblPkmnLvl.setBounds (txtPkmnName.getX() + txtPkmnName.getWidth() + 5, insets.top + 5, lblPkmnLvl.getPreferredSize().width, lblPkmnLvl.getPreferredSize().height);
		//txtPkmnLevel.setBounds (lblPkmnLvl.getX() + lblPkmnLvl.getWidth() + 5, insets.top + 5, txtPkmnLevel.getPreferredSize().width, txtPkmnLevel.getPreferredSize().height);

		//btnSearch.setBounds (txtPkmnLevel.getX() + txtPkmnLevel.getWidth() + 5, insets.top + 5, btnSearch.getPreferredSize().width, btnSearch.getPreferredSize().height);
		btnSearch.setBounds (txtSearchField.getX() + txtSearchField.getWidth() + 5, insets.top + 5, btnSearch.getPreferredSize().width, btnSearch.getPreferredSize().height);

		frameInitial.setVisible (true);

		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
				String nameInquiry = txtSearchField.getText();

				Pokemon result = pl.searchByName(nameInquiry);
				if(result == null){
					txtSearchField.setText("ERROR");
					
					return;
				} else{
					txtSearchField.setText("");
					//FIXME
					updateResultsLabels(result.getId(), result.getName(),result.getType1(),result.getType2(),result.getHp(),result.getAtk(),result.getDef(),result.getSpAtk(),result.getSpDef(),result.getSpeed());
					frameInitial.setSize (400,100);//TODO
				}

			}

			private void updateResultsLabels(int id,String name,String type1,String type2, int hp,int atk,int def,int spAtk,int spDef,int spd) {
				lblId.setText("ID: " + Integer.toString(id));
				lblName.setText("Name: " + name);
				
				if(type2 == null){
					lblType1.setText("Type: " + type1);
					if(lblType2.isVisible())
						lblType2.setVisible(false);
				} else{
					lblType1.setText("Type 1: " + type1);
					lblType2.setText("Type 2: " + type2);
				}
				
				lblHp.setText("HP: " + Integer.toString(hp));
				lblAtk.setText("Atk: " + Integer.toString(atk));
				lblDef.setText("Def: " + Integer.toString(def));
				lblSpAtk.setText("Sp. Atk: " + Integer.toString(spAtk));
				lblSpDef.setText("Sp. Def: " + Integer.toString(spDef));
				lblSpd.setText("Spd: " + Integer.toString(spd));
			}
	});


		//Set Look and Feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
			throw e;
		}
}

}
