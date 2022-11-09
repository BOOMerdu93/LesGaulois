package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement=0;
	private Equipement[] equipements;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
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
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forceInitial = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force < forceInitial;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
			Equipement[] equipementEjecte = null;
			// précondition
			assert force > 0;
			int oldForce = force;
			forceCoup = Calcul_Resistance_Equipement(forceCoup);
			force -= forceCoup;
			// if (force > 0) {
			// parler("Aïe");
			// } else {
			// equipementEjecte = ejecterEquipement();
			// parler("J'abandonne...");
			// }
			if (force==0)
			{
				parler("Aïe");
			}
			else {
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			}
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
	}
	
	private int Calcul_Resistance_Equipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + getNom() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
			return equipementEjecte;
		}

	
	public void sEquiper(Equipement equipement)
	{
		switch (nbEquipement)
		{
			case 2:
			{
				System.out.println("Le soldat "+ getNom() + " est déjà bien protégé !");
				break;
			}
			case 1:
			{
				if (equipements[0].equals(equipement))
				{
					System.out.println("Le soldat "+ getNom() + " possède déjà un " + equipement + " !");
				}
				else
				{
					equipements[nbEquipement]=equipement;
					nbEquipement++;
					System.out.println("Le soldat " + getNom() + " s'équipe d'un "+ equipement +" !");
				}
				break;
			}
			default:
			{
				equipements[nbEquipement]=equipement;
				nbEquipement++;
				System.out.println("Le soldat " + getNom() + " s'équipe d'un "+ equipement +" !");
			}
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix;
		Romain soldat;
		soldat= new Romain("Soldat",6);
		asterix= new Gaulois("Asterix",8);
		System.out.println(asterix.toString());
		asterix.parler("Je suis astérix");
		soldat.recevoirCoup(4);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		soldat.sEquiper(Equipement.CASQUE);
		soldat.sEquiper(Equipement.CASQUE);
		soldat.sEquiper(Equipement.BOUCLIER);
		soldat.sEquiper(Equipement.BOUCLIER);
	}
}