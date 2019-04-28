/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bhamd
 */
public class Eleve extends Personne {
    
    private static final int NB_EVALUATIONS = 10;
    private int numEvaluation = 0;
    private int numNomEvaluation = 0;
    private int identifiant = 1;//pas de static sinon, tout les identifiants seront les memes, car elle sera un attribut commun aux differents objets de la classe
    private static ArrayList<Integer> listeIdentifiant = new ArrayList<Integer>();
    private double listeEvaluations [] = new double [NB_EVALUATIONS];
    private String listeNomEvaluations [] = new String [NB_EVALUATIONS];
    private int jour;
    private int mois;
    private int annee;
    private double moyenneFinale = 0.0;
    private double medianeFinale = 0.0;
    private HashSet Prof = new HashSet<>() ;//Ici on cree le HashSet pour l'eleve en tant qu'attribut pour pouvoir l'utiliser dans 2 methodes differents, une getCorrecteur et une setCorrecteur
    private String Promotion;
    
    public void classementCroissant() throws IllegalStateException
    {
        HashMap<Integer, Eleve> ElevesCroissant = new HashMap<Integer, Eleve>();//collection d'eleves
        ElevesCroissant = collections2();
        Eleve da;
        for(int i = 1; i<=collections().size(); i++)
        {
            for(int j = collections().size(); j>=2; j--)
            {
                if(ElevesCroissant.get(j).moyenne() < ElevesCroissant.get(j-1).moyenne())
                {
                    da = ElevesCroissant.get(j);
                    ElevesCroissant.put(j, ElevesCroissant.get(j-1));
                    ElevesCroissant.put(j-1, da);
                }
            }
        }
        System.out.println("Classement croissant de tous les etudiants en fonction de leurs moyennes: ");
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            System.out.println(ElevesCroissant.get(i));
        }
        for(int i = 1; i<=collections().size(); i++)
        {
            for(int j = collections().size(); j>=2; j--)
            {
                if(ElevesCroissant.get(j).mediane() < ElevesCroissant.get(j-1).mediane())
                {
                    da = ElevesCroissant.get(j);
                    ElevesCroissant.put(j, ElevesCroissant.get(j-1));
                    ElevesCroissant.put(j-1, da);
                }
            }
        }
        System.out.println("Classement croissant de tous les etudiants en fonction de leurs medianes: ");
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            System.out.println(ElevesCroissant.get(i));
        }
    }
    
    public void classementDecroissant() throws IllegalStateException
    {
        HashMap<Integer, Eleve> ElevesCroissant = new HashMap<Integer, Eleve>();//collection d'eleves
        ElevesCroissant = collections2();
        Eleve da;
        for(int i = 1; i<=collections().size(); i++)
        {
            for(int j = collections().size(); j>=2; j--)
            {
                if(ElevesCroissant.get(j).moyenne() > ElevesCroissant.get(j-1).moyenne())
                {
                    da = ElevesCroissant.get(j);
                    ElevesCroissant.put(j, ElevesCroissant.get(j-1));
                    ElevesCroissant.put(j-1, da);
                }
            }
        }
        System.out.println("Classement decroissant de tous les etudiants en fonction de leurs moyennes: ");
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            System.out.println(ElevesCroissant.get(i));
        }
        for(int i = 1; i<=collections().size(); i++)
        {
            for(int j = collections().size(); j>=2; j--)
            {
                if(ElevesCroissant.get(j).mediane() > ElevesCroissant.get(j-1).mediane())
                {
                    da = ElevesCroissant.get(j);
                    ElevesCroissant.put(j, ElevesCroissant.get(j-1));
                    ElevesCroissant.put(j-1, da);
                }
            }
        }
        System.out.println("Classement croissant de tous les etudiants en fonction de leurs medianes: ");
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            System.out.println(ElevesCroissant.get(i));
        }
    }
    
    protected void setPromotion(String P)
    {
        this.Promotion = P;
    }
    
    public Eleve(String nom, String prenom, int jour, int mois, int annee) {
        super(nom, prenom);
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        
        for(int i=0; i<NB_EVALUATIONS; i++)//Initialisation du tableau d'evaluation a 0
        {
            listeEvaluations[i] = 0.0;
        }
        
        for(int i=0; i<NB_EVALUATIONS; i++)//Initialisation du tableau des noms d'evaluation a null
        {
            listeNomEvaluations[i] = "null";
        }
        
        for(int i=0; i<listeIdentifiant.size(); i++)
        {
            if(listeIdentifiant.contains(identifiant))
            {
                do
                {
                    identifiant++;
                }while(listeIdentifiant.contains(identifiant)==true);
                this.identifiant = identifiant;//On rajoute l'Id une fois qu'il a ete incremente pour que ca soit un nouveau Id unique
            }
        }
        
        this.identifiant = identifiant;//On rajoute l'Id dans l'attribut de l'objet cree, quand celui-ci est unique
        listeIdentifiant.add(identifiant);
    }

    public int getIdentifiant() {
        return identifiant;
    }
    
    public double moyenne() throws IllegalStateException
    {
        double somme = 0.0, moyenne = 0.0;
        int i;
        double cpt = 0.0;
        for(i=0; i<NB_EVALUATIONS; i++)
        {
            if(listeEvaluations[i] != 0.0)
            {
                somme += listeEvaluations[i];
                cpt++;
            }
        }
        if(somme == 0.0)
        {
            throw new IllegalStateException();
        }
        moyenne = somme / cpt;
        moyenne = (double) Math.round(moyenne * 100) / 100;
        moyenneFinale = moyenne;
        return moyenne;
    }
    
    private void moyenneFinale()//Pour la fct toString et le return pour eviter l'exception
    {
        double somme = 0.0, moyenne = 0.0;
        int i;
        double cpt = 0.0;
        for(i=0; i<NB_EVALUATIONS; i++)
        {
            if(listeEvaluations[0] == 0.0)
            {
                return;
            }
            if(listeEvaluations[i] != 0.0)
            {
                somme += listeEvaluations[i];
                cpt++;
            }
        }
        moyenne = somme / cpt;
        moyenne = (double) Math.round(moyenne * 100) / 100;
        moyenneFinale = moyenne;
    }
    
    public double mediane() throws IllegalStateException
    {
        double mediane = 0.0;
        int cpt = 0;
        for(int i=0; i<NB_EVALUATIONS; i++)
        {
            if(listeEvaluations[i] != 0.0)
            {
                cpt++;
            }
        }
        
        if(cpt == 0)
        {
            throw new IllegalStateException();
        }
        if(cpt % 2 == 0)
        {
            mediane = (listeEvaluations[cpt/2-1] + listeEvaluations[(cpt/2)])/2;//si mediane est un nbe pair alors
        }else
        {
            mediane = listeEvaluations[(cpt/2)];//si mediane est impair
        }
        mediane = (double) Math.round(mediane * 100) / 100;
        medianeFinale = mediane;
        return mediane;
     }
     
     private void medianeFinale()//Pour la fct toString et le return pour eviter l'exception
     {
        double mediane = 0.0;
        int cpt = 0;
        for(int i=0; i<NB_EVALUATIONS; i++)
        {
            if(listeEvaluations[0] == 0.0)
            {
                return;
            }
            if(listeEvaluations[i] != 0.0)
            {
                cpt++;
            }
        }
        if(cpt % 2 == 0)
        {
            mediane = (listeEvaluations[cpt/2-1] + listeEvaluations[(cpt/2)])/2;//si mediane est un nbe pair alors
        }else
        {
            mediane = listeEvaluations[(cpt/2)];//si mediane est impair
        }
        mediane = (double) Math.round(mediane * 100) / 100;
        medianeFinale = mediane;
     }
    
     public void setCorrecteurs(Professeur mat)//Cette methode de la classe Eleve est appelle dans le contructeur de la classe Evaluation a chaque instanciation
     {
         Prof.add(mat);
     }
     
     public Set<Professeur> getCorrecteurs()
     {
         return Prof;
     }
     
     public void setEvaluations2(int indice, double note)
     {
         if(indice+1 <=numEvaluation)
            listeEvaluations[indice] = note;
         else
         {
             listeEvaluations[numEvaluation] = note;
             listeNomEvaluations[numEvaluation] = "Nouvelle matiere";
             numEvaluation++;
             numNomEvaluation++;
         }
     }
     
     public void setEvaluations(double note)
     {
         if(numEvaluation < NB_EVALUATIONS)
            listeEvaluations[numEvaluation] = note;
         numEvaluation++;
     }
     
     public void setNomEvaluations(String nomMatiere)
     {
         if(numNomEvaluation < NB_EVALUATIONS)
            listeNomEvaluations[numNomEvaluation] = nomMatiere;
         numNomEvaluation++;
     }
     
     public String getNomEvaluations(int num)
     {
            return listeNomEvaluations[num];
     }
     
     public double getEvaluations(int num)
     {
         return listeEvaluations[num];
     }
     
     private String getTotalEvaluation(int j)
     {
        if(listeNomEvaluations[j] != "null" && j<NB_EVALUATIONS)
        {
            return listeNomEvaluations[j] + " " + listeEvaluations[j] + " " + getTotalEvaluation(j+1) ;
        }
        return "\n";
     }
     
     @Override
     public String toString()
     {
         moyenneFinale();
         medianeFinale();
         return "(" + getPrenom() + ", " + getNom() + ")" + " id: " + identifiant + "\nnotes: " + getTotalEvaluation(0) + "moyenne = " + moyenneFinale + "\nmediane = " + medianeFinale + "\nCorrecteur(s): " + getCorrecteurs() + "\nPromotion: " + this.Promotion + "\n";
     }
    
}
