/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesElevesProfesseurs;

/**
 *
 * @author bhamd
 */
public class Professeur extends Personne {
      
    public Professeur(String nom, String prenom) {
        super(nom, prenom);
    }
    
    public void setNote(Promotion p, int id, double valNote, int i) throws IllegalStateException
    {
        if(collections().containsKey(id) && collections().get(id) == p)
            rechercher(id).setEvaluations2(i-1, valNote);
    }
    
    public Eleve rechercher(int id)
    {
        return (Eleve) collections2().get(id);
    }
}
