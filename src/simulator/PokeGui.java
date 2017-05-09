package simulator;


import java.awt.Insets;
import java.awt.event.*;

import objects.Pokemon;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


//Main class
public class PokeGui extends JFrame{

	//Declare variables
	private JFrame frame;
	private PokemonList master;
	private Pokemon currentPokemon;//otherPokemon;
	JTextField txtSearchField;
	private JButton btnSearch, btnNewSearch;
	JLabel lblId,lblName,lblType,lblHp, lblAtk, lblDef, lblSpAtk, lblSpDef, lblSpd, lblSearch;
	JLabel lblIdOther,lblNameOther,lblTypeOther,lblHpOther, lblAtkOther, lblDefOther, lblSpAtkOther, lblSpDefOther, lblSpdOther, lblSearchOther;
	JPanel searchPanel, resultsPanel;
	private Insets insets;
	JList<Pokemon> options;

	public void setup()  throws Exception {
		frame = new JFrame("Pokedex: Optimal Opponent Finder BETA");
		frame.setSize(375, 80);
		//frame.pack();

		searchPanel = new JPanel();
		lblSearch = new JLabel("Search by Name");
		txtSearchField = new JTextField(15);

		searchPanel.setLayout(null);
		insets = frame.getInsets();

		searchPanel.add(lblSearch);
		searchPanel.add(txtSearchField);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(searchName(txtSearchField.getText())){
					frame.setSize(400, 400);;
					goToResults();
				} else {
					txtSearchField.setText("NOT FOUND!");
				}
			}
		});
		searchPanel.add(btnSearch);

		lblSearch.setBounds (insets.left + 5, insets.top + 5, lblSearch.getPreferredSize().width, lblSearch.getPreferredSize().height);
		txtSearchField.setBounds (lblSearch.getX() + lblSearch.getWidth() + 5, insets.top + 5, txtSearchField.getPreferredSize().width, txtSearchField.getPreferredSize().height);
		btnSearch.setBounds (txtSearchField.getX() + txtSearchField.getWidth() + 5, insets.top + 5, btnSearch.getPreferredSize().width, btnSearch.getPreferredSize().height);

		frame.add(searchPanel);
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
			throw e;
		}
		frame.setVisible(true);
	}
	
	public void setPokemon(Pokemon p){this.currentPokemon = p; }
	public Pokemon getPokemon(){ return this.currentPokemon; }
	public void setList(PokemonList list){ this.master = list; }
	public PokemonList getList(){ return this.master; }
	public boolean searchName(String name){
		if((master.contains(name))){
			setPokemon(master.searchByName(name));
			return true;} 
		else { return false; }
	}
	public PokeGui(PokemonList list) throws Exception {
		setList(list);
		setup();
	}

	public void goToResults() {
		insets = frame.getInsets();
		resultsPanel = new JPanel();
		lblId = new JLabel("ID: " + Integer.toString(currentPokemon.getId()));
		lblName = new JLabel("Name: " + currentPokemon.getName());
		if(currentPokemon.getType2() == null)
			lblType = new JLabel("Type: " + currentPokemon.getType1());
		else
			lblType = new JLabel("Type: " + currentPokemon.getType1() + "/" + currentPokemon.getType2());//May need to address
		resultsPanel.setLayout(null);

		lblHp = new JLabel("HP: " +  Integer.toString(currentPokemon.getHp()));
		lblAtk = new JLabel("Atk: " +  Integer.toString(currentPokemon.getAtk()));
		lblDef = new JLabel("Def: " +  Integer.toString(currentPokemon.getDef()));
		lblSpAtk = new JLabel("Sp.Atk: " +  Integer.toString(currentPokemon.getSpAtk()));
		lblSpDef = new JLabel("Sp.Def: " +  Integer.toString(currentPokemon.getSpDef()));
		lblSpd = new JLabel("Spd: " +  Integer.toString(currentPokemon.getSpeed()));
		resultsPanel.add(lblId);
		resultsPanel.add(lblName);
		resultsPanel.add(lblType);
		resultsPanel.add(lblHp);
		resultsPanel.add(lblAtk);
		resultsPanel.add(lblDef);
		resultsPanel.add(lblSpAtk);
		resultsPanel.add(lblSpDef);
		resultsPanel.add(lblSpd);

		btnNewSearch = new JButton("New Search");

		btnNewSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newSearch();
			}
		});
		resultsPanel.add(btnNewSearch);

		lblName.setBounds(insets.left + 5, insets.top + 5, lblName.getPreferredSize().width, lblName.getPreferredSize().height);
		lblId.setBounds(lblName.getX() + lblName.getWidth() + 5, insets.top + 5, lblId.getPreferredSize().width, lblId.getPreferredSize().height);
		lblType.setBounds(insets.left + 5, lblName.getY() + lblName.getHeight() + 5, lblType.getPreferredSize().width, lblType.getPreferredSize().height);
		lblAtk.setBounds(insets.left + 5, lblType.getY() + lblType.getHeight() + 5, lblAtk.getPreferredSize().width, lblAtk.getPreferredSize().height);
		lblDef.setBounds(lblAtk.getX() + lblAtk.getWidth() + 5, lblAtk.getY(), lblDef.getPreferredSize().width, lblDef.getPreferredSize().height);
		lblSpAtk.setBounds(insets.left + 5, lblAtk.getY() + lblAtk.getHeight() + 5, lblSpAtk.getPreferredSize().width, lblSpAtk.getPreferredSize().height);
		lblSpDef.setBounds(lblSpAtk.getX() + lblSpAtk.getWidth() + 5, lblSpAtk.getY(), lblSpDef.getPreferredSize().width, lblSpDef.getPreferredSize().height);
		lblHp.setBounds(insets.left + 5, lblSpAtk.getY() + lblSpAtk.getHeight() + 5, lblHp.getPreferredSize().width, lblHp.getPreferredSize().height);
		lblSpd.setBounds(lblHp.getX() + lblHp.getWidth() + 5, lblHp.getY(), lblSpd.getPreferredSize().width, lblSpd.getPreferredSize().height);


				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						frame.remove(searchPanel);
						frame.add(resultsPanel);
						frame.invalidate();
						frame.revalidate();
					}
				});
	}


	void newSearch(){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.getContentPane().removeAll();
				frame.add(searchPanel);
				frame.invalidate();
				frame.revalidate();
			}
		});
	}

}


