package personnages;

public class Gaulois {
	private String nom;;
	private int effetPotion=1;
	private int force, nb_trophees;
	private Equipement[] trophees;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.trophees=new Equipement[100];
	}

	public String getNom() {
		return nom;
	}
	
//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//		
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
 
	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");

	}
	
//	public void frapper(Romain romain,int effetPotion) {
//	System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//	romain.recevoirCoup(force / 3 * effetPotion );
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
		nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
	}
	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion)
	{
		effetPotion = forcePotion;
		System.out.println("Merci Druide, je sens que ma force est "+ forcePotion + " fois décuplée.");
	}
	public static void main(String[] args) {
		Gaulois asterix;
		Romain soldat;
		soldat= new Romain("Soldat",3);
		asterix= new Gaulois("Asterix",8);
		System.out.println(asterix.toString());
		System.out.println(asterix.prendreParole());
		asterix.parler("Je suis astérix");
		asterix.frapper(soldat);
	}
}
