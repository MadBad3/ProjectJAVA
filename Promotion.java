/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesElevesProfesseurs;

import java.util.HashMap;

/**
 *
 * @author bhamd
 */
public class Promotion extends mapeleves {
    
    private String nom;
    

    public Promotion(String nom) {
        this.nom = nom;
    }

    private HashMap collection()
    {
        return collections();
    }
    
    private HashMap collection2()
    {
        return collections2();
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void rangerPromotion(Eleve e)//On ajoute les differents eleve dans les hashtable avec sa promo identifiee
    {
        collection().put(e.getIdentifiant(), this);
        collection2().put(e.getIdentifiant(), e);
        e.setPromotion(this.nom);
    }
    
    public void getEleve()//Il retourne la collection d'Eleves de la promotion
    {
        for(int j =1; j<=collection().size(); j++)
        {
            if(collections().get(j) == this)
            {
                System.out.println(collections2().get(j));
            }
        }
    }     
                
    public Eleve rechercher(int id)
    {
        return (Eleve) collections2().get(id);
    }
    
    public void classementCroissant() throws IllegalStateException
    {
        HashMap<Integer, Eleve> ElevesCroissant = new HashMap<Integer, Eleve>();//collection d'eleves
        int cpt= 1;
        for(int i = 1; i<=collections().size(); i++)
        {
            if(collections().get(i) == this)
            {
                ElevesCroissant.put(cpt, (Eleve) collections2().get(i));
                cpt++;
            }
        }
        Eleve da;
        
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            for(int j = ElevesCroissant.size(); j>=2; j--)
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
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            for(int j = ElevesCroissant.size(); j>=2; j--)
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
        int cpt= 1;
        for(int i = 1; i<=collections().size(); i++)
        {
            if(collections().get(i) == this)
            {
                ElevesCroissant.put(cpt, (Eleve) collections2().get(i));
                cpt++;
            }
        }
        Eleve da;
        
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            for(int j = ElevesCroissant.size(); j>=2; j--)
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
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            for(int j = ElevesCroissant.size(); j>=2; j--)
            {
                if(ElevesCroissant.get(j).mediane() > ElevesCroissant.get(j-1).mediane())
                {
                    da = ElevesCroissant.get(j);
                    ElevesCroissant.put(j, ElevesCroissant.get(j-1));
                    ElevesCroissant.put(j-1, da);
                }
            }
        }
        System.out.println("Classement decroissant de tous les etudiants en fonction de leurs medianes: ");
        for(int i = 1; i<=ElevesCroissant.size(); i++)
        {
            System.out.println(ElevesCroissant.get(i));
        }
    }
    
}
