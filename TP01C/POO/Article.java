package POO;

public class Article {	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;


        public Article(String NumProduit, String nom){
                    //completer
        	this.NumProduit = NumProduit;
        	this.nom = nom;
        	Prix_net = 0;
	}
	
	public Article(String np, String nom, double prix){		
		//completer
		NumProduit = np;
		this.nom = nom;
		Prix_net = prix;
	}
	

	public String getNumProduit() {
		//completer
		return NumProduit;
	}	
	public String getNom() {
		//completer
		return nom;
	}
	public void setNom(String nom) {
		//completer
		this.nom = nom;
	}
	public double getPrixNet() {
		//completer
		return Prix_net;
	}
	public void setPrixNet(double prix_net) {
		//completer
		Prix_net = prix_net;
	}
	public double getVAT(){
		//completer
		return 0.15;
	}
	public double getPrix(int count){ // WTF is count ? Nb de fois que tu l'achètes ??? 
		//completer
		return (this.getPrixNet()*this.getVAT()*count); // Prix * taxes * nb
	}
	public String getArticleType(){
		//completer
		return this.getClass().toString() ; // Retourne un string du type de la classe de l'objet
	}
	public String toString() { // Il faut afficher le contenu de l'article ? 
		return "A FAIRE !!";
	}
}
