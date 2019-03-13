package POO;

public class CadreDiplome extends Article {
	
	/*ATTRIBUTS*/
	private String categorie;
	private String couleur;
	
	/*CONSTRUCTEURS*/
	public CadreDiplome(String NumProduit, String nom, double prix, String couleur,String categorie){

		super(NumProduit, nom, prix);
		this.couleur = couleur;
		this.categorie = categorie;
	}
	
	public CadreDiplome(String NumProduit, String nom, double prix,String categorie){
		
		super(NumProduit, nom, prix);
		this.categorie = categorie;
		couleur = "Aucune couleur";
		
	}
	
	/*METHODES D'ACCES*/
	@Override
	public String getArticleType() {
		
		return super.getArticleType();
	}

	public String getCategorie() { // Il semble avoir un probleme ici, Pourquoi est-ce que la categorie est un "double" ? Je l'ai changée pour un String, ça fait plus de sens
		//completer
		return categorie;
	}
	
	/*METHODE DE MODIFICATION*/
	public void setCategorie(String categorie) {
                  
		this.categorie = categorie;
	}
	
}
