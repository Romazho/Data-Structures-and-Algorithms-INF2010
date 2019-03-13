//package ADT;

import java.util.Random;

public class Simulation {
	 private static Random random;  

	 //Retourne un nombre réel aléatoire uniformément dans [0,1[
	    public static double uniform() {
	        //completer
	    	return random.nextDouble();
	    }

	 
	 
	 //Retourne un nombre entier aléatoire uniformément dans [0,n[
	    public static int uniform(int n) {
	        //completer
	    	return random.nextInt(n);
	    }

	//Retourne un entier long aléatoire uniformément dans [0, n[.
        // Vous pouviez trouver le code https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
    public static long uniform(long n) {
        if (n <= 0L) throw new IllegalArgumentException("Argument doit etre positive: " + n);


        long r = random.nextLong();
        long m = n - 1;

        
        if ((n & m) == 0L) {
            return r & m;
        }

      
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }
    
    //Retourne avec succès un booléen true si p suit d'une distribution de Bernoulli
    public static boolean bernoulli(double p) {
       //completer
    	//pas sur du tout!... 
    	if(p == 1) {
    		return true;
    	}
    	else if(p == 0) {
    		return false;
    	}
    	else {
    		return false;
    	}
    }
    
    public static Compteur max(Compteur x, Compteur y) {
      // completer
    	int  i = x.compareTo(y);
    	if(i == 1)
    		return y;
    	else if(i == -1)
    		return x;
    	else
    		return x;
    }
	
	 public static void main(String[] args) {
		 
	        int n = 10;	//ca sert � quoi ce chiffre????????????
	        
	        Compteur pile = new Compteur("pile");
	        Compteur face = new Compteur("face");
	       
              //Les instructions du simulation
                   //completer
	        int a = pile.uniform(n);
	        for(int i=0; i<a; i++)
	        	pile.increment();
	        
	        int b = face.uniform(n);
	        for(int i=0; i<b; i++)
	        	face.increment();
	        
            //afficher la différence entre les score des compteur
	        System.out.println(pile.toString());
	        System.out.println(face.toString());
	        System.out.println("La diff�rence entre les scores est: " + Math.abs(pile.score() - face.score()));
	        
	        Compteur pile_c = new Compteur("pile_c");
	        Compteur face_c = new Compteur("face_C");
		        
	        //Les instructions du simulation
                   //completer
	        int A = pile_c.uniform(n);
	        for(int i=0; i<A; i++)
	        	pile_c.increment();
	        
	        int B = face_c.uniform(n);
	        for(int i=0; i<B; i++)
	        	face_c.increment();
	        
            //afficher le maximum entre les score des compteur
	        
	        System.out.println(pile_c.toString());
	        System.out.println(face_c.toString());
	        System.out.println("Le compteur maximale est: " + Simulation.max(pile_c,face_c).toString());

	        }
	    
	         
	    }



