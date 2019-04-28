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
public class Evaluation {
    
    private String matiere;
    private double note;
    private Eleve eleve;
    private Professeur correcteur;
    
    public Evaluation(String matiere, double note, Eleve eleve, Professeur professeur) {
        this.matiere = matiere;
        this.note = (double) Math.round(note * 100) / 100;
        this.eleve = eleve;
        this.correcteur = professeur;
        eleve.setCorrecteurs(this.correcteur);//Ici on rajoute a chaque instance d'Evaluation, le prof correcteur pour la table de correcteur de l'Eleve en qeustion
        eleve.setNomEvaluations(this.matiere);
        eleve.setEvaluations(this.note);
    }
    
    @Override
    public String toString() {
        return eleve.toString() + " " + correcteur.toString() + " " + matiere + " " + note;
    }
    
    
}
