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
	public Gaulois trouverHabitant(int numero)
	{
		return villageois[numero];
	}
	
	public void afficherVillageois()
	{
		System.out.println("Dans le village du chef " + chef.getNom()+" vivent les légendaires Gaulois :");
		for (int i=0; i<nbVillageois; i++)
		{
			System.out.println("\n");
			System.out.println("-" + trouverHabitant(i));
		}
	}
	
	public static void main(String[] args) {
	Village villageDesIrreductibles;
	Gaulois asterix;
	asterix= new Gaulois("asterix",2);
	villageDesIrreductibles= new Village("villageDesIrr�ductibles",30);
	//Gaulois gaulois = villageDesIrreductibles.trouverHabitant(30);
	//il tente de lire au-dessus de la taille du tab//
	Chef abraracourcix;
	abraracourcix= new Chef("abraracourcix",3,1,villageDesIrreductibles);
	Gaulois obelix;
	obelix = new Gaulois("obelix",25);
	villageDesIrreductibles.ajouterHabitant(obelix);
	villageDesIrreductibles.setChef(abraracourcix);
	villageDesIrreductibles.ajouterHabitant(asterix);
	System.out.println(villageDesIrreductibles.trouverHabitant(0));
	villageDesIrreductibles.afficherVillageois();
	}	
}
