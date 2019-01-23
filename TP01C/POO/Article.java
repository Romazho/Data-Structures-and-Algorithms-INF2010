package POO;

public class Article {	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;


        public Article(String NumProduit, String nom){
                    //completer
        	this.NumProduit = NumProduit;
        	this.nom = nom;
	}
	
	public Article(String np, String nom, double prix){		
		//completer
		
	}
	

	public String getNumProduit() {
		//completer
		return NumProduit;
	}	
	public String getNom() {
		//completer
	}
	public void setNom(String nom) {
		//completer
	}
	public double getPrixNet() {
		//completer
	}
	public void setPrixNet(double prix_net) {
		//completer
		
	}
	public double getVAT(){
		//completer
	}
	public double getPrix(int count){
		//completer
	}
	public String getArticleType(){
		//completer
	}
	public String toString() {
		//completer
	}
}
