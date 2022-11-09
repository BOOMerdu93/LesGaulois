package personnages;
import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller de force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	
	public int getMax() {
		return effetPotionMax;
	}
		
	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	public int preparerPotion()
	{
		Random objet = new Random();
		forcePotion= objet.nextInt((getMax()-effetPotionMin)+1)+effetPotionMin;
		return forcePotion;
	}
	
	public void faireParler(int forcePotion)
	{
		if (forcePotion > 7)
		{
			parler("J'ai préparé une super potion de force");
		}
		else
		{
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois)
	{
		if (!"Obélix".equals(gaulois.getNom()))
		{
			gaulois.boirePotion(forcePotion);
		}
		else
		{
			System.out.println("Non, Obélix !... Tu n'auras pas de potion magique");
		}

	}
	
	public static void main(String[] args) {
		Druide panoramix;
		panoramix= new Druide("Panoramix", 5 , 10);
		for (int i=0 ; i< 10; i++)
		{
			panoramix.faireParler(panoramix.preparerPotion());
		}
	}
}