package objects;

import java.util.HashMap;

public class PokeType{
	String name;
	HashMap<Element, Double> multipliers = new HashMap<Element, Double>();
	Element element;

	PokeType(Builder p) { name = p.name; multipliers = p.multipliers; element = p.element;	}

	static class Builder {
		final String name;
		HashMap<Element, Double> multipliers = new HashMap<Element, Double>();
		Element element;

		public Builder(Element element) {
			this.name = element.name;
			this.element = element;
			for (Element e : Element.values()) { multipliers.put(e, 1.0); }
		}

		public Builder vulnerableTo(Element... elements) {
			for (Element e : elements) { multipliers.put(e, 2.0); }
			return this;
		}
		public Builder immuneTo(Element... elements) {
			for (Element e : elements) { multipliers.put(e, 0.0); }
			return this;
		}
		public Builder resistantTo(Element... elements) {
			for (Element e : elements) { multipliers.put(e, 0.5); }
			return this;
		}
		public PokeType generate() { return new PokeType(this); }
	}
	public HashMap<Element, Double> getMultipliers() { return this.multipliers;	}
}
