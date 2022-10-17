package personnages;

public class Romain {
	private String nom;
	private int force;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public int getForce()
	{
		return force;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + ">");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
	}
	public static void main(String[] args) {
		Gaulois asterix;
		Romain soldat;
		soldat= new Romain("Soldat",3);
		asterix= new Gaulois("Asterix",8);
		System.out.println(asterix.toString());
		System.out.println(asterix.prendreParole());
		asterix.parler("Je suis astérix");
		soldat.recevoirCoup(4);

	}
}