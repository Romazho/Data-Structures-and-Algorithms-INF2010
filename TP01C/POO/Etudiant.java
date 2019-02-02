package POO;

import java.util.Comparator;

public class Etudiant {
	final int N = 20;
	private String Matr; // 
	private String nom; //
	private String prenom; //	
	private String email; 
	private int section; 
	
        private int n_des_notes;		//c'est quoi?? nombre de notes 
	private NoteCours [] notes;		//un tableau avec les notes
	
	
	
	 public Etudiant(String Matr,String nom, int section) {
              //completer
		 this.Matr = Matr;
		 this.nom = nom;
		 this.section = section;
		 notes = new NoteCours[N];
		 n_des_notes =0;
	    }
        
         
	
	public void AjouterNote(String sigle, String titre, int note){ 
		//completer
		
		int i = notes.length-1;
		NoteCours objet = new NoteCours();
		objet.sigle = sigle;
		objet.titre = titre;
		objet.note = note;
		//n_des_notes++;
		notes[i] = objet;
		
		/*
		notes[i].sigle = sigle; 
		notes[i].titre = titre;
		notes[i].note = note;*/
	}
	
	public double NoteMoyenne(){
		//completer
		int somme = 0;
		for(int i=0;i<n_des_notes;i++) {
			somme =  somme + notes[i].note;
			
		}
		return (somme/notes.length);
	}

	public String getMatr() {
		//completer
		return Matr;
	}

	public void setMatr(String matr) {
		//completer
		this.Matr = matr;
	}

        public String getEmail() {
                   //completer
        	return email;
	}

	public void setEmail(String email) {
                      //completer
		this.email = email;
	}

	public String getNom() {
		//completer
		return nom;
	}
    
	
	public void setNom(String nom) {
		//completer
		this.nom = nom;
	}

	public String getPrenom() {
		//completer
		return prenom;
	}

	public void setPrenom(String prenom) {
		//completer
		this.prenom = prenom;
	}
	
	public int getSection() {
		return section;
	}
	//il n'y a pas de setSection??
	
    public String toString() {	//il faut faire quoi?????
        // completer
    	return (this.Matr + " " + this.prenom + " " + this.nom);
    	
    }
    
    public boolean equals(Object etudiant_x) {	//est-ce que l'etudaint est de type Etudiant??
            // completer 
    	if(this == etudiant_x) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
   

}
