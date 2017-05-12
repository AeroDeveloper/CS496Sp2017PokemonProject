package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PokeType implements Comparable<PokeType>{
	private Element element;
	private HashMap<Element, Double> multipliers = new HashMap<Element, Double>();

	public PokeType(String name){
		this.element = createElement(name);//USE element.elementName for comparison
		this.multipliers = generatetypeTraits(this.element);
	}
	
	private Element createElement(String name) {
		for (Element e : pokeTypesList) {
			if ((e.elementName).equals(name)) {
				return e;
			}
		}
		return (Element.NONE); // For default constructor
	}

	private HashMap<Element, Double> generatetypeTraits(Element e) {
		ArrayList<Element> vulnerableTo = new ArrayList<>();
		ArrayList<Element> resistantTo = new ArrayList<>();
		ArrayList<Element> immuneTo = new ArrayList<>();
		HashMap<Element, Double> typeTraits = new HashMap<Element, Double>();

		switch(e){
		case NORMAL: 
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.FIGHTING));
			immuneTo = new ArrayList<>(Arrays.asList(Element.GHOST));
			break;
		case FIRE:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.WATER, Element.GROUND, Element.ROCK));
			resistantTo = new ArrayList<>(Arrays.asList(Element.FIRE, Element.GRASS, Element.ICE, Element.BUG, Element.STEEL, Element.FAIRY));
			break;
		case WATER:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.ELECTRIC, Element.GRASS));
			resistantTo = new ArrayList<>(Arrays.asList(Element.FIRE, Element.WATER, Element.ICE, Element.STEEL));
			break;
		case ELECTRIC:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.GROUND));
			resistantTo = new ArrayList<>(Arrays.asList(Element.ELECTRIC, Element.STEEL, Element.FLYING));
			break;
		case GRASS:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.FIRE, Element.ICE, Element.POISON, Element.FLYING, Element.BUG));
			resistantTo = new ArrayList<>(Arrays.asList(Element.GRASS, Element.WATER, Element.GROUND, Element.ELECTRIC));
			break;
		case ICE:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.FIRE, Element.STEEL, Element.ROCK, Element.FIGHTING));
			resistantTo = new ArrayList<>(Arrays.asList(Element.ICE));
			break;
		case FIGHTING:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.PSYCHIC, Element.FLYING, Element.FAIRY));
			resistantTo = new ArrayList<>(Arrays.asList(Element.BUG, Element.ROCK, Element.DARK));
			break;
		case POISON:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.GROUND, Element.PSYCHIC));
			resistantTo = new ArrayList<>(Arrays.asList(Element.GRASS, Element.FIGHTING, Element.POISON,Element.BUG, Element.FAIRY));
			break;
		case GROUND:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.WATER, Element.GRASS, Element.ICE));
			resistantTo = new ArrayList<>(Arrays.asList(Element.POISON, Element.ROCK));
			immuneTo = new ArrayList<>(Arrays.asList(Element.ELECTRIC));
			break;
		case FLYING:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.ELECTRIC, Element.ICE, Element.ROCK));
			resistantTo = new ArrayList<>(Arrays.asList(Element.GRASS, Element.FIGHTING, Element.BUG));
			immuneTo = new ArrayList<>(Arrays.asList(Element.GROUND));
			break;
		case PSYCHIC:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.BUG, Element.DARK, Element.GHOST));
			resistantTo = new ArrayList<>(Arrays.asList(Element.FIGHTING, Element.PSYCHIC));
			break;
		case BUG:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.FIRE, Element.FLYING, Element.ROCK));
			resistantTo = new ArrayList<>(Arrays.asList(Element.GRASS, Element.FIGHTING, Element.GROUND));
			break;
		case ROCK:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.WATER, Element.GRASS, Element.FIGHTING, Element.GROUND, Element.STEEL));
			resistantTo = new ArrayList<>(Arrays.asList(Element.NORMAL, Element.FIRE, Element.POISON, Element.FLYING));
			break;
		case GHOST:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.GHOST, Element.DARK));
			resistantTo = new ArrayList<>(Arrays.asList(Element.BUG, Element.POISON));
			immuneTo = new ArrayList<>(Arrays.asList(Element.NORMAL, Element.FIGHTING));
			break;
		case DRAGON:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.ICE, Element.DRAGON, Element.FAIRY));
			resistantTo = new ArrayList<>(Arrays.asList(Element.WATER, Element.FIRE, Element.ELECTRIC, Element.GRASS));
			break;
		case DARK:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.FIGHTING, Element.BUG, Element.FAIRY));
			resistantTo = new ArrayList<>(Arrays.asList(Element.GHOST, Element.DARK));
			immuneTo = new ArrayList<>(Arrays.asList(Element.PSYCHIC));
			break;
		case STEEL:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.FIRE, Element.FIGHTING, Element.GROUND));
			resistantTo = new ArrayList<>(Arrays.asList(Element.NORMAL, Element.GRASS, Element.ICE, Element.FLYING, Element.PSYCHIC, Element.BUG, Element.ROCK, Element.DRAGON, Element.STEEL, Element.FAIRY));
			immuneTo = new ArrayList<>(Arrays.asList(Element.POISON));
			break;
		case FAIRY:
			vulnerableTo = new ArrayList<>(Arrays.asList(Element.STEEL, Element.POISON));
			resistantTo = new ArrayList<>(Arrays.asList(Element.FIGHTING, Element.DARK, Element.BUG));
			immuneTo = new ArrayList<>(Arrays.asList(Element.DRAGON));
			break;
		case NONE:
			break;
		}
		for (Element ele : pokeTypesList){
			if(vulnerableTo.contains(ele))
				typeTraits.put(ele, 2.0);
			else if(resistantTo.contains(ele))
				typeTraits.put(ele, 0.5); 
			else if(immuneTo.contains(ele))
				typeTraits.put(ele, 0.0); 
			else
				typeTraits.put(ele, 1.0); 
		}
		return typeTraits;
	}
	
	private ArrayList<Element> pokeTypesList = new ArrayList<>(Arrays.asList(Element.NORMAL,
			Element.FIGHTING, Element.FLYING, Element.FIRE, Element.WATER, Element.ELECTRIC, Element.GRASS, 
			Element.BUG, Element.POISON, Element.STEEL, Element.GROUND,Element.ROCK, Element.ICE, Element.DRAGON, 
			Element.FAIRY, Element.PSYCHIC, Element.DARK, Element.GHOST, Element.NONE));

	@Override
	public int compareTo(PokeType o) {
		return((this.element.elementName).compareTo(o.element.elementName));
	}
	
	public HashMap<Element,Double>getMultipliers(){ return this.multipliers;}
	public Element getElement(){return this.element;}
}
