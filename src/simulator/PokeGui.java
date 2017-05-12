package simulator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;

import objects.Element;
import objects.PokeType;
import objects.Pokemon;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.ComponentOrientation;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PokeGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3575832388251719986L;
	private boolean insertNameFirst = true;
	private ArrayList<Pokemon> masterlist = new ArrayList<Pokemon>();
	private ArrayList<Pokemon> displayList = new ArrayList<Pokemon>();
	Pokemon currentPokemon,otherPokemon;
//	private JPanel contentPane;
	JList<String> displayJList;
	DefaultListModel<String> displayModel;
	JLabel lblCurrName = new JLabel();
	JLabel lblCurrHP = new JLabel();
	JLabel lblCurrType = new JLabel();
	JLabel lblCurrAtk = new JLabel();
	JLabel lblCurrDef = new JLabel();
	JLabel lblCurrSpAtk = new JLabel();
	JLabel lblCurrSpDef = new JLabel();
	JLabel lblCurrSpd = new JLabel();
	JLabel lblOtherName = new JLabel();
	JLabel lblOtherType = new JLabel();
	JLabel lblOtherAtk = new JLabel();
	JLabel lblOtherDef = new JLabel();
	JLabel lblOtherSpAtk = new JLabel();
	JLabel lblOtherSpDef = new JLabel();
	JLabel lblOtherHP = new JLabel();
	JLabel lblOtherSpd = new JLabel();

	/**
	 * Create the frame.
	 */
	public PokeGui() {
		setTitle("Pokedex: Optimal Opponent Finder BETA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panelSearch = new JPanel();
		panelSearch.setName("panelSearch");
		panelSearch.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.add(panelSearch,"panelSearch");
		JLabel lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setHorizontalAlignment(SwingConstants.LEFT);

		JTextField txtInsertNameHere = new JTextField();

		txtInsertNameHere.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (getFirstTime()){
					txtInsertNameHere.setText("");
					repaint();
					setFirstTime(false);
				}
			}
		});



		txtInsertNameHere.setText("Insert Name Here");
		txtInsertNameHere.setColumns(10);

		JButton btnSearch = new JButton("Search");
		JButton btnNewSearch = new JButton("New Search");
		getRootPane().setDefaultButton(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSearch.requestFocus();
				Pokemon search = new Pokemon(txtInsertNameHere.getText());
				ArrayList<Pokemon> temp = getMasterList();
				setFirstTime(true);
				boolean isFound = false;
				for(Pokemon curr: temp){
					if((curr.compareTo(search)) == 0){
						setCurrentPokemon(curr);
						findCompetitors(curr);
						setFirstTime(true);
						isFound = true;
						txtInsertNameHere.setText("Insert Name Here");
						CardLayout cl = (CardLayout)(contentPane.getLayout());
						cl.show(contentPane, "panelResults");
						getRootPane().setDefaultButton(btnNewSearch);
						displayModel.clear();
						for(Pokemon display : getDisplayList())
							displayModel.addElement(display.getName());
						displayJList.setModel(displayModel);
						break;
					}
				}
				if(!isFound)
					txtInsertNameHere.setText("NOT FOUND");
				txtInsertNameHere.requestFocus();
			}});
		GroupLayout gl_panelSearch = new GroupLayout(panelSearch);
		gl_panelSearch.setHorizontalGroup(
				gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearch.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblSearchByName)
						.addGap(18)
						.addComponent(txtInsertNameHere, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSearch)
						.addContainerGap())
				);
		gl_panelSearch.setVerticalGroup(
				gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearch.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelSearch.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSearch.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSearch)
										.addComponent(txtInsertNameHere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSearchByName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(217, Short.MAX_VALUE))
				);
		panelSearch.setLayout(gl_panelSearch);
		panelSearch.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnSearch, txtInsertNameHere}));
		
		
		JPanel panelResults = new JPanel();
		contentPane.add(panelResults,"panelResults");
		lblCurrName.setText("Name:");
		lblCurrHP.setText("HP:");
		lblCurrType.setText("Type:");
		lblCurrAtk.setText("ATK: ");
		lblCurrDef.setText("DEF: ");
		lblCurrSpAtk.setText("SP. ATK: ");
		lblCurrSpDef.setText("SP. Def: ");
		lblCurrSpd.setText("SPD: ");
		SpringLayout sl_panelResults = new SpringLayout();
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrDef, 5, SpringLayout.SOUTH, lblCurrType);
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrAtk, 5, SpringLayout.SOUTH, lblCurrType);
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrType, 5, SpringLayout.SOUTH, lblCurrName);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrType, 10, SpringLayout.WEST, panelResults);
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrSpd, 5, SpringLayout.SOUTH, lblCurrSpAtk);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrSpd, 5, SpringLayout.EAST, lblCurrHP);
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrHP, 5, SpringLayout.SOUTH, lblCurrSpAtk);
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrSpDef, 5, SpringLayout.SOUTH, lblCurrAtk);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrSpDef, 5, SpringLayout.EAST, lblCurrSpAtk);
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrSpAtk, 5, SpringLayout.SOUTH, lblCurrAtk);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrDef, 5, SpringLayout.EAST, lblCurrAtk);
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblCurrName, 10, SpringLayout.NORTH, panelResults);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrHP, 10, SpringLayout.WEST, panelResults);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrSpAtk, 10, SpringLayout.WEST, panelResults);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrAtk, 10, SpringLayout.WEST, panelResults);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblCurrName, 10, SpringLayout.WEST, panelResults);
		panelResults.setLayout(sl_panelResults);
		panelResults.add(lblCurrName);
		panelResults.add(lblCurrType);
		panelResults.add(lblCurrAtk);
		panelResults.add(lblCurrDef);
		panelResults.add(lblCurrSpAtk);
		panelResults.add(lblCurrSpDef);
		panelResults.add(lblCurrHP);
		panelResults.add(lblCurrSpd);

		JScrollPane scrollPaneOptions = new JScrollPane();
		sl_panelResults.putConstraint(SpringLayout.NORTH, scrollPaneOptions, 10, SpringLayout.NORTH, panelResults);
		sl_panelResults.putConstraint(SpringLayout.WEST, scrollPaneOptions, -200, SpringLayout.EAST, panelResults);
		sl_panelResults.putConstraint(SpringLayout.SOUTH, scrollPaneOptions, -50, SpringLayout.SOUTH, panelResults);
		sl_panelResults.putConstraint(SpringLayout.EAST, scrollPaneOptions, -10, SpringLayout.EAST, panelResults);
		panelResults.add(scrollPaneOptions);

		displayJList = new JList<String>();
		displayJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String name = displayModel.getElementAt(
						displayJList.getSelectedIndex()).toString();
				for(Pokemon other: getDisplayList()){
					if ((other.getName()).equals(name))
						setOtherPokemon(other);
				}
			}
		});
		displayModel = new DefaultListModel<String>();
		displayJList.setModel(displayModel);
		displayJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneOptions.setViewportView(displayJList);

		lblOtherName.setText("Name:");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherName, 190, SpringLayout.NORTH, panelResults);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherName, 10, SpringLayout.WEST, panelResults);
		panelResults.add(lblOtherName);

		lblOtherType.setText("Type:");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherType, 5, SpringLayout.SOUTH, lblOtherName);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherType, 10, SpringLayout.WEST, panelResults);
		panelResults.add(lblOtherType);

		lblOtherAtk.setText("ATK: ");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherAtk, 5, SpringLayout.SOUTH, lblOtherType);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherAtk, 10, SpringLayout.WEST, panelResults);
		panelResults.add(lblOtherAtk);

		lblOtherDef.setText("DEF: ");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherDef, 5, SpringLayout.SOUTH, lblOtherType);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherDef, 5, SpringLayout.EAST, lblOtherAtk);
		panelResults.add(lblOtherDef);

		lblOtherSpAtk.setText("SP. ATK: ");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherSpAtk, 5, SpringLayout.SOUTH, lblOtherAtk);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherSpAtk, 10, SpringLayout.WEST, panelResults);
		panelResults.add(lblOtherSpAtk);

		lblOtherSpDef.setText("SP. Def: ");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherSpDef, 5, SpringLayout.SOUTH, lblOtherDef);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherSpDef, 5, SpringLayout.EAST, lblOtherSpAtk);
		panelResults.add(lblOtherSpDef);

		lblOtherHP.setText("HP:");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherHP, 5, SpringLayout.SOUTH, lblOtherSpAtk);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherHP, 10, SpringLayout.WEST, panelResults);
		panelResults.add(lblOtherHP);

		lblOtherSpd.setText("SPD: ");
		sl_panelResults.putConstraint(SpringLayout.NORTH, lblOtherSpd, 5, SpringLayout.SOUTH, lblOtherSpDef);
		sl_panelResults.putConstraint(SpringLayout.WEST, lblOtherSpd, 5, SpringLayout.EAST, lblOtherHP);
		panelResults.add(lblOtherSpd);


		btnNewSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getRootPane().setDefaultButton(btnSearch);
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "panelSearch");
			}
		});
		sl_panelResults.putConstraint(SpringLayout.WEST, btnNewSearch, 10, SpringLayout.WEST, scrollPaneOptions);
		sl_panelResults.putConstraint(SpringLayout.SOUTH, btnNewSearch, -10, SpringLayout.SOUTH, panelResults);
		sl_panelResults.putConstraint(SpringLayout.EAST, btnNewSearch, -10, SpringLayout.EAST, scrollPaneOptions);
		panelResults.add(btnNewSearch);
	}



	public ArrayList<Pokemon> getMasterList() {
		return masterlist;
	}

	public void setMasterList(ArrayList<Pokemon> masterlist) {
		this.masterlist = masterlist;
	}

	public void setCurrentPokemon(Pokemon p){
		this.currentPokemon= p;
		lblCurrName.setText("Name: " + p.getName());
		lblCurrHP.setText("HP: " + Integer.toString(p.getHp()));
		if(p.getType2().getElement().compareTo(Element.NONE) == 0)
			lblCurrType.setText("Type: " + p.getType1().getElement().elementName);
		else
			lblCurrType.setText("Type: " + p.getType1().getElement().elementName + " " + p.getType2().getElement().elementName);
		lblCurrAtk.setText("ATK: " + Integer.toString(p.getAtk()));
		lblCurrDef.setText("DEF: " + Integer.toString(p.getDef()));
		lblCurrSpAtk.setText("SP. ATK: " + Integer.toString(p.getSpAtk()));
		lblCurrSpDef.setText("SP. Def: " + Integer.toString(p.getSpDef()));
		lblCurrSpd.setText("SPD: " + Integer.toString(p.getSpeed()));	
	}

	public Pokemon getCurrentPokemon(){
		return this.currentPokemon;
	}
	public boolean getFirstTime(){
		return insertNameFirst;
	}

	public void setFirstTime(boolean status){
		this.insertNameFirst = status;
	}

	public void findCompetitors(Pokemon player){
		PokeType type1 = player.getType1();
		PokeType type2 = player.getType2();
		double topValue = 0;
		ArrayList<Element> topType = new ArrayList<>();
		for(Map.Entry<Element, Double> entry : type1.getMultipliers().entrySet()){
			for(Map.Entry<Element, Double> entry2 : type2.getMultipliers().entrySet()) {
				if ((entry.getKey()).compareTo(entry2.getKey()) == 0) {
					if (entry.getValue() * entry2.getValue() > topValue) {
						topValue = entry.getValue() * entry2.getValue();
						topType.clear();
						topType.add(entry.getKey());
					} else if(entry.getValue() * entry2.getValue() == topValue){
						topType.add(entry.getKey());
					}
					break;
				}
			}
		}
		ArrayList<Pokemon> reference = getMasterList();
		ArrayList<Pokemon> standard = new ArrayList<Pokemon>();
		ArrayList<Pokemon> effective = new ArrayList<Pokemon>();
		for(Pokemon curr : reference){
			for(Element ele : topType){
				if((curr.getType1().getElement().elementName).compareTo(ele.elementName)*(curr.getType2().getElement().elementName).compareTo(ele.elementName) == 0)
					if(standard.contains(curr)){
						standard.remove(curr);
						effective.add(curr);					
					}else{
						standard.add(curr);
					}
			}
		}
		effective.addAll(standard);
		setOtherList(effective);
	}
	
	public void setOtherList(ArrayList<Pokemon> list){
		this.displayList = list;
		
	}
	public ArrayList<Pokemon> getDisplayList(){
		return (this.displayList);
	}
	public void setOtherPokemon(Pokemon other){
		this.otherPokemon = other;
		lblOtherName.setText("Name: " + other.getName());
		lblOtherHP.setText("HP: " + Integer.toString(other.getHp()));
		if(other.getType2().getElement().compareTo(Element.NONE) == 0)
			lblOtherType.setText("Type: " + other.getType1().getElement().elementName);
		else
			lblOtherType.setText("Type: " + other.getType1().getElement().elementName + " " + other.getType2().getElement().elementName);
		lblOtherAtk.setText("ATK: " + Integer.toString(other.getAtk()));
		lblOtherDef.setText("DEF: " + Integer.toString(other.getDef()));
		lblOtherSpAtk.setText("SP. ATK: " + Integer.toString(other.getSpAtk()));
		lblOtherSpDef.setText("SP. Def: " + Integer.toString(other.getSpDef()));
		lblOtherSpd.setText("SPD: " + Integer.toString(other.getSpeed()));		
	}
	public Pokemon getOtherPokemon(){
		return this.otherPokemon;
	}
}
