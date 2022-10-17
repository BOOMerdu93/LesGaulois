package story;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class scenario {

	public static void main(String[] args) {
		Gaulois obelix;
		Gaulois asterix;
		Romain minus;
		Druide Panoramix;
		obelix = new Gaulois("Obélix",4);
		asterix= new Gaulois("Asterix",2);
		Panoramix = new Druide("panoramix", 5 , 10);
		Panoramix.parler("Je vais allé préparer une petite potion...");
		Panoramix.faireParler(Panoramix.preparerPotion(Panoramix.getMax()));
		Panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");
		Panoramix.booster(asterix);
		}

}
