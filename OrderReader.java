/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

/**
 *
 * @author bhamd
 */
public class OrderReader {
    
    public static String calculerString(int compteur, int i, String nom, String data)//la fonction retourne le String calcule a partir du positionnement dans le data, ici compteur et i sont utlise comme respectivement indice de debut et de fin
    {
        for(int j=compteur; j<i; j++)
        {
            nom = nom + data.charAt(j);
        }
        return nom;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Eleve e[] = new Eleve[1000];
        Professeur p[] = new Professeur[1000];
        Promotion a[] = new Promotion[1000];
        Evaluation q[] = new Evaluation[1000];
        ArrayList<String> matiere = new ArrayList();
        ArrayList<String> note = new ArrayList();
        ArrayList<Professeur> prof = new ArrayList();
        
        int g=0, cpt = 0, cptProf = 0, cptPromo = 0, cptEval = 0, nbEval = 0, premier = 0, premier1 = 0;
        File file = new File("C:\\Users\\bhamd\\Downloads\\a\\order1.csv");
        
        // -read from filePooped with Scanner class
        Scanner inputStream = new Scanner(file);
        // hashNext() loops line-by-line
        while(inputStream.hasNext()){
            //read single line, put in string
            int first = 0, compteur = 0;//compteur pour indiquer l'indice du mot a prendre, et i la fin
            String data = inputStream.next();
            String nom = "", prenom="", jour="", mois="", annee="", promo="";
            String nom_matiere="", note1="";
            String nom_correcteur1="", prenom_correcteur1="";
            System.out.println(data);
            if(cpt>0)//Pour lire a partir de la deuxieme ligne du tableur
            {
                for(int i=0; i< data.length(); i++)//Pour chaque ligne
                {
                    if(data.charAt(i) == '_' && first > 7 && (first-2)%3==0)//prenom correcteur, cas special a gerer
                    { 
                        prenom_correcteur1 = calculerString(compteur, i, prenom_correcteur1, data);
                        System.out.println(prenom_correcteur1);
                        compteur = i+1;
                        
                        while(data.charAt(i)!=',' && i< data.length()-1)//tant qu'on atteint pas la virgule, signifiant la fin du prenom_nom du correcteur et qu'on a pas atteint la fin, on continue
                        {
                            i++;
                        }
                        
                        if(i == data.length()-1)//Cas ou on arrive a la fin du String, on prend donc le i+1 caractere
                            nom_correcteur1 = calculerString(compteur, i+1, nom_correcteur1, data);
                        else
                            nom_correcteur1 = calculerString(compteur, i, nom_correcteur1, data);
                        
                        System.out.println(nom_correcteur1);
                        compteur = i+1;
                        
                        //Creation des objets prof a partir des correcteurs dans le .csv
                        if(premier1 == 0)
                        {
                            p[cptProf] = new Professeur(nom_correcteur1, prenom_correcteur1);
                            prof.add(p[cptProf]);
                            cptProf++;
                            nom_correcteur1="";
                            prenom_correcteur1="";
                            premier1++;
                        }else
                        {
                            for(int k=0; k<cptProf; k++)
                            {
                                if(p[k].getNom().hashCode() == nom_correcteur1.hashCode() && p[k].getPrenom().hashCode() == prenom_correcteur1.hashCode())//Cas ou la promo existe pour l'indice k
                                {
                                    k=(cptProf+1);
                                }
                                else if(k == (cptPromo-1))//Cas ou la promo n'existe pas pour l'indice k
                                {
                                    p[cptProf] = new Professeur(nom_correcteur1, prenom_correcteur1);
                                    prof.add(p[cptProf]);
                                    cptProf++;
                                    prenom_correcteur1="";//On le reinstalise car sinon le String ne fait qu'ajouter des string au string existant
                                    nom_correcteur1="";
                                    k=(cptPromo+1);
                                }
                            }
                        }
                    }
                    
                    if(data.charAt(i) == ',' && data.length() > i+1 && data.charAt(i+1) != ',' && first > 6 && (first-1)%3==0)//pour note de la matiere
                    {
                       note1 = calculerString(compteur, i, note1, data);
                       note.add(note1);
                       System.out.println(note1);
                       compteur = i+1;
                       note1="";
                    }

                    if(data.charAt(i) == ',' && data.length() > i+1 && data.charAt(i+1) != ',' && first > 5 && first%3==0)//pour nom de la matiere d'evaluation
                    {
                        nom_matiere = calculerString(compteur, i, nom_matiere, data);
                        matiere.add(nom_matiere);
                        System.out.println(nom_matiere);
                        compteur = i+1;
                        nom_matiere="";
                    }
                    
                    if(data.charAt(i) == ',' && data.length() > i+1 && data.charAt(i+1) != ',' && first == 5)//pour promotion
                    {
                        promo = calculerString(compteur, i, promo, data);
                        compteur = i+1;
                        if(premier == 0)
                        {
                           a[cptPromo] = new Promotion(promo);
                           cptPromo++;
                           premier++;
                        }
                        else
                        {
                            for(int k=0; k<cptPromo; k++)
                            {
                                if(a[k].getNom().hashCode() == promo.hashCode())//Cas ou la promo existe pour l'indice k
                                {
                                    k=(cptPromo+1);
                                }
                                else if(k == (cptPromo-1))//Cas ou la promo n'existe pas pour l'indice k
                                {
                                    a[cptPromo] = new Promotion(promo);
                                    cptPromo++;
                                    k=(cptPromo+1);
                                }
                            }
                        }
                    }
                    
                    if(data.charAt(i) == ',' && first == 4)//pour annee de date de naissance
                    {
                        annee = calculerString(compteur, i, annee, data);
                        compteur = i+1;
                    }
                    
                    if(data.charAt(i) == '/' && first == 3)//pour mois de date de naissance
                    {
                        mois = calculerString(compteur, i, mois, data);
                        compteur = i+1;
                    }

                    if(data.charAt(i) == '/' && first == 2)//pour jour de date de naissance
                    {
                        jour = calculerString(compteur, i, jour, data);
                        compteur = i+1;
                    }

                    if(data.charAt(i) == ',' && first == 1)//pour prenom
                    {
                        prenom = calculerString(compteur, i, prenom, data);
                        compteur = i+1;
                    }

                    if(data.charAt(i) == ',' && first == 0)//pour nom
                    {
                        nom = calculerString(compteur, i, nom, data);
                        compteur = i+1;
                    }
                    
                    if(data.charAt(i) == ',' || data.charAt(i) == '/')//cas pour les slashs dans la date de naissance
                    {
                        first++;
                        compteur = i+1;
                    }
                }
                e[g] = new Eleve(nom, prenom, parseInt(jour), parseInt(mois), parseInt(annee));
                
                for(int i=0; i<cptPromo; i++)
                {
                    if(a[i].getNom().hashCode() == promo.hashCode())
                    {
                        a[i].rangerPromotion(e[g]);
                    }
                }
                
                for(int i=0; i<note.size(); i++)
                {
                    q[cptEval] = new Evaluation(matiere.get(i), parseDouble(note.get(i)), e[g], prof.get(i));// revoir le i du prof
                    cptEval++;
                }
                g++;
                matiere.clear();
                note.clear();
                prof.clear();
                premier1=0;
                promo="";
                cptProf=0;//Car le compteur de du tableau prof s'initialise a chaque nouvel eleve
                
            }
            cpt++;
        }
        // after loop, close scanner
        inputStream.close();
    }
}