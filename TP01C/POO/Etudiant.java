package POO;

import java.util.Comparator;

public class Etudiant {
	final int N = 10;
	private String Matr;
	private String nom;
	private String prenom;	
	private String email; 
	private int section; 
	
        private int n_des_notes;		//c'est quoi??
	private NoteCours [] notes;		//un tableau avec les notes
	
	
	
	 public Etudiant(String Matr,String nom, int section) {
              //completer
		 this.Matr = Matr;
		 this.nom = nom;
		 this.section = section;
	    }
        
         
	
	public void AjouterNote(String sigle, String titre, int note){ 
		//completer
		int i = NoteCours.length-1;
		notes[i].sigle = sigle;
		notes[i].titre = titre;
		notes[i].note = note;
	}
	
	public double NoteMoyenne(){
		//completer
		int moyenne =0;
		for(int i=0;i<NoteCours.length;i++) {
			moyenne += notes[i].note;
		}
		moyenne = moyenne/notes.length;
		return moyenne;
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
    	
    }
    
    public boolean equals(Object etudiant_x) {	//est-ce que l'etudaint est de type Etudiant??
            // completer 
    	if(etudiant_x.getMatr == this.Matr && etudiant_x.getEmail == this.email && etudiant_x.getNom == this.nom && 
    			etudiant_x.getPrenom == this.prenom && etudiant_x.section == this.section) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
   

}
