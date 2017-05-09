package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class DamageModifier {
	static PokeType normal = new PokeType.Builder(Element.NORMAL)
			.vulnerableTo(Element.FIGHTING).immuneTo(Element.GHOST).generate();

	static PokeType fire = new PokeType.Builder(Element.FIRE)
			.vulnerableTo(Element.WATER, Element.GROUND, Element.ROCK)
			.resistantTo(Element.FIRE, Element.GRASS, Element.ICE,
					Element.BUG, Element.STEEL, Element.FAIRY)
			.generate();

	static PokeType water = new PokeType.Builder(Element.WATER)
			.vulnerableTo(Element.ELECTRIC, Element.GRASS)
			.resistantTo(Element.FIRE, Element.WATER, Element.ICE, Element.STEEL)
			.generate();

	static PokeType electric = new PokeType.Builder(Element.ELECTRIC)
			.resistantTo(Element.ELECTRIC, Element.STEEL, Element.FLYING)
			.vulnerableTo(Element.GROUND).generate();

	static PokeType grass = new PokeType.Builder(Element.GRASS)
			.resistantTo(Element.GRASS, Element.WATER, Element.GROUND, Element.ELECTRIC)
			.vulnerableTo(Element.FIRE, Element.ICE,
					Element.POISON, Element.FLYING, Element.BUG)
			.generate();

	static PokeType ice = new PokeType.Builder(Element.ICE)
			.vulnerableTo(Element.FIRE, Element.STEEL, Element.ROCK, Element.FIGHTING)
			.resistantTo(Element.ICE).generate();

	static PokeType fighting = new PokeType.Builder(Element.FIGHTING)
			.vulnerableTo(Element.PSYCHIC, Element.FLYING, Element.FAIRY)
			.resistantTo(Element.BUG, Element.ROCK, Element.DARK)
			.generate();

	static PokeType poison = new PokeType.Builder(Element.POISON)
			.resistantTo(Element.GRASS, Element.FIGHTING, Element.POISON,
					Element.BUG, Element.FAIRY)
			.vulnerableTo(Element.GROUND, Element.PSYCHIC).generate();

	static PokeType ground = new PokeType.Builder(Element.GROUND)
			.resistantTo(Element.POISON, Element.ROCK)
			.vulnerableTo(Element.WATER, Element.GRASS, Element.ICE)
			.immuneTo(Element.ELECTRIC).generate();

	static PokeType flying = new PokeType.Builder(Element.FLYING)
			.resistantTo(Element.GRASS, Element.FIGHTING, Element.BUG)
			.vulnerableTo(Element.ELECTRIC, Element.ICE, Element.ROCK)
			.immuneTo(Element.GROUND).generate();

	static PokeType psychic = new PokeType.Builder(Element.PSYCHIC)
			.vulnerableTo(Element.BUG, Element.DARK, Element.GHOST)
			.resistantTo(Element.FIGHTING, Element.PSYCHIC).generate();

	static PokeType bug = new PokeType.Builder(Element.BUG)
			.vulnerableTo(Element.FIRE, Element.FLYING, Element.ROCK)
			.resistantTo(Element.GRASS, Element.FIGHTING, Element.GROUND)
			.generate();

	static PokeType rock = new PokeType.Builder(Element.ROCK)
			.vulnerableTo(Element.WATER, Element.GRASS, Element.FIGHTING,
					Element.GROUND, Element.STEEL)
			.resistantTo(Element.NORMAL, Element.FIRE, Element.POISON, Element.FLYING)
			.generate();

	static PokeType ghost = new PokeType.Builder(Element.GHOST)
			.vulnerableTo(Element.GHOST, Element.DARK)
			.resistantTo(Element.BUG, Element.POISON)
			.immuneTo(Element.NORMAL, Element.FIGHTING)
			.generate();

	static PokeType dragon = new PokeType.Builder(Element.DRAGON)
			.vulnerableTo(Element.ICE, Element.DRAGON, Element.FAIRY)
			.resistantTo(Element.WATER, Element.FIRE, Element.ELECTRIC, Element.GRASS)
			.generate();

	static PokeType dark = new PokeType.Builder(Element.DARK)
			.vulnerableTo(Element.FIGHTING, Element.BUG, Element.FAIRY)
			.resistantTo(Element.GHOST, Element.DARK)
			.immuneTo(Element.PSYCHIC).generate();

	static PokeType steel = new PokeType.Builder(Element.STEEL)
			.vulnerableTo(Element.FIRE, Element.FIGHTING, Element.GROUND)
			.resistantTo(Element.NORMAL, Element.GRASS, Element.ICE, Element.FLYING,
					Element.PSYCHIC, Element.BUG, Element.ROCK, Element.DRAGON,
					Element.STEEL, Element.FAIRY)
			.immuneTo(Element.POISON).generate();

	static PokeType fairy = new PokeType.Builder(Element.FAIRY)
			.vulnerableTo(Element.STEEL, Element.POISON)
			.resistantTo(Element.FIGHTING, Element.DARK, Element.BUG)
			.immuneTo(Element.DRAGON).generate();

	static PokeType none = new PokeType.Builder(Element.NONE).generate();

	static ArrayList<PokeType> pokeType = new ArrayList<>(Arrays.asList(normal,
			fighting, flying, fire, water, electric, grass, bug, poison, steel, ground,
			rock, ice, dragon, fairy, psychic, dark, ghost, none));



	public static void displayAttributes(PokeType primary, PokeType secondary) {
		if (primary == secondary) { secondary = none; }

		StringBuilder immuneBuilder = new StringBuilder(""),
				vulnerableBuilder = new StringBuilder(""),
				resistBuilder = new StringBuilder("");

		for(Map.Entry<Element, Double> entry : primary.getMultipliers().entrySet()){
			for(Map.Entry<Element, Double> entry2 : secondary.getMultipliers().entrySet()) {
				if (entry.getKey() == entry2.getKey()) {

					if (entry.getValue() * entry2.getValue() == 0.0) {
						immuneBuilder.append(entry.getKey().name).append(", ");
					}
					else if (entry.getValue() * entry2.getValue()  <= 0.5 ) {
						resistBuilder.append(entry.getKey().name).append(", ");
					}
					else if (entry.getValue() * entry2.getValue()  >= 2.0) {
						vulnerableBuilder.append(entry.getKey().name).append(", ");
					}
				}
			}
		}
	}


	public static PokeType getPokeType(String name) {
		for (PokeType p : pokeType) {
			if (p.element.name == name) {
				return p;
			}
		}
		return none; // should never be the case
	}

}
