package village;
import personnages.Chef;
import personnages.Gaulois;
import personnages.Romain;


public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois=0;
	private Gaulois[] villageois;
	
	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMax];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois)
	{
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
	}
	public Gaulois trouverHabitant(int numéro)
	{
		return villageois[numéro];
	}
	
	public static void main(String[] args) {
	Village villageDesIrreductibles;
	villageDesIrreductibles= new Village("villageDesIrréductibles",30);
	Gaulois gaulois = villageDesIrreductibles.trouverHabitant(30);
	//il tente de lire au-dessus de la taille du tab//
	}	
}
