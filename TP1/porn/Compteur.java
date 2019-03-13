//package ADT;

import java.util.Random;

public class Compteur implements Comparable<Compteur> {

    private final String nom;        // nom du compteur
    private int compteur = 0;        // initialisation la valeur courant est 0

    
    public Compteur(String id) {
         // completer
    	compteur = 0;
    	nom = id;
    } 

   
    public void increment() {
         // completer
    	compteur++;
    } 

   
    public int score() {
         // completer
    	return compteur;
    } 

   
    public String toString() {
         // completer
    	return "nom: " + nom + ", compteur: " + compteur; 
    } 

  
    public int compareTo(Compteur x) { //pas sur si c'est la bonne notation ou non... genre ca peut etre l'inverse si x>this retourne -1...
                 // completer
    	if(x.compteur < this.compteur) {
    		return -1;
    	}
    	else if(x.compteur > this.compteur) {
    		return 1;
    	}
    	else {
    		return 0;
    	}
    }
    
	
      
        private static Random random=new Random(10000);
    
      //Retourne un nombre entier aléatoire uniformément dans [0,n[
        
	 public static int uniform(int n) {		
	        // completer
		 //Random random = new Random(n);
		 int a = random.nextInt(n);
		 return a;
	    }


   
    public static void main(String[] args) { 
        int n = 6;
        int essais = 60000;

        // Creation n compteurs
        Compteur a = new Compteur("a");
        Compteur b = new Compteur("b");
        Compteur c = new Compteur("c");
        Compteur d = new Compteur("d");
        Compteur e = new Compteur("e");
        Compteur f = new Compteur("f");
 
         // incrémente les compteurs d'essais au hasard	
        for(int i=0; i<a.uniform(essais);i++) {
        	a.increment();
        }
        
        for(int i=0; i<b.uniform(essais);i++) {
        	b.increment();
        }
        
        for(int i=0; i<c.uniform(essais);i++) {
        	c.increment();
        }
        
        for(int i=0; i<d.uniform(essais);i++) {
        	d.increment();
        }
        
        for(int i=0; i<e.uniform(essais);i++) {
        	e.increment();
        }
        
        for(int i=0; i<f.uniform(essais);i++) {
        	f.increment();
        }
        	
        

        // Affichage des resultat
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
    }
}

