package POO;

public class Vetement extends Article {
	private double taille;
	
	public Vetement(String NumProduit, String nom, double taille){
		//completer
		super(NumProduit, nom);
		this.taille = taille;
	}
	
	public Vetement(String NumProduit, String nom, double prix, double taille){
				//completer
		super(NumProduit, nom, prix);
		this.taille = taille;
	}
	
	@Override
	public String getArticleType() { // Il y avait 2 () "()()" j'en ai enlevé une 
				//completer
		return super.getArticleType();
	}

	public double getTaille() {
				//completer
		return taille;
	}

	public void setTaille(double taille) {
				//completer
		this.taille = taille;
	}
	
}
