/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.IllegalStateException;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

/**
 *
 * @author bhamd
 */
public class test2 {
        
    public test2() throws IllegalStateException
    {   
        //Creation de plusieurs eleves
        Eleve e1 = new Eleve("HAMDI", "Badr", 06, 06, 1997);
        Eleve e2 = new Eleve("JIN", "Edouard", 15, 04, 2005);
        Eleve e3 = new Eleve("DEPARDIEU", "Gerard", 01, 02, 1969);
        Eleve e4 = new Eleve("DESPIEU", "Manon", 14, 11, 1942);
        Eleve e5 = new Eleve("POLIN", "Marc", 16, 10, 1999);
        Eleve e6 = new Eleve("SALHI", "Idriss", 19, 03, 1994);
        Eleve e7 = new Eleve("TACCOLA", "Aless", 10, 07, 1935);
        Eleve e8 = new Eleve("BIZET", "Thibaut", 01, 01, 1994);
        
        //Creation de plusieurs professeurs
        Professeur p1 = new Professeur("HAMON", "Nicolas");
        Professeur p2 = new Professeur("COPE", "Benoit");
        Professeur p3 = new Professeur("FILLON", "Mathieu");
        Professeur p4 = new Professeur("SARKOZY", "Gerard");
        Professeur p5 = new Professeur("HOLLANDE", "Jean");
        
        //Creation de plusieurs promotions
        Promotion a = new Promotion("2019");
        Promotion b = new Promotion("2020");
        Promotion c = new Promotion("2021");
        
        //Rangement des eleves dans les differentes promotions
        a.rangerPromotion(e1);
        c.rangerPromotion(e2);
        b.rangerPromotion(e3);
        a.rangerPromotion(e4);
        b.rangerPromotion(e5);
        c.rangerPromotion(e6);
        b.rangerPromotion(e7);
        a.rangerPromotion(e8);
        
        //Creation des evaluations ainsi que des profs correcteurs
        Evaluation q1 = new Evaluation("Maths", 11.555, e1, p1);
        Evaluation q2 = new Evaluation("Physique", 13.855, e1, p2);
        Evaluation q3 = new Evaluation("Com", 10.37, e1, p2);
        
        Evaluation q4 = new Evaluation("Pave", 20, e2, p3);
        Evaluation q5 = new Evaluation("Droit", 5.354, e2, p5);
        
        Evaluation q6 = new Evaluation("Canaux", 6.678, e3, p5);
        Evaluation q7 = new Evaluation("Anglais", 15, e3, p4);
        Evaluation q8 = new Evaluation("Com", 10.37, e3, p2);
        
        Evaluation q9 = new Evaluation("Canaux", 8.244, e4, p1);
        Evaluation q10 = new Evaluation("Anglais", 17.378, e4, p4);
        
        Evaluation q11 = new Evaluation("Francais", 8.469, e5, p3);
        Evaluation q12 = new Evaluation("Anglais", 14.896, e5, p2);
        Evaluation q13 = new Evaluation("Japonais", 17.37, e5, p1);
        
        Evaluation q14 = new Evaluation("Russe", 10.678, e6, p1);
        Evaluation q15 = new Evaluation("Physique", 16.795, e6, p5);
        
        Evaluation q16 = new Evaluation("Chimie", 18.469, e7, p3);
        Evaluation q17 = new Evaluation("Droit", 3.896, e7, p2);
        Evaluation q18 = new Evaluation("Maths", 14.784, e7, p2);
        
        Evaluation q19 = new Evaluation("Philo", 11.678, e8, p1);
        Evaluation q20 = new Evaluation("Russe", 5.795, e8, p4);
        
        //Affichage d'un eleve avec son nom, sa promotion, ses correcteurs, ses notes, leur moyenne et mediane
        /*System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println(e4.toString());
        System.out.println(e5.toString());
        System.out.println(e6.toString());
        System.out.println(e7.toString());
        System.out.println(e8.toString());*/
        
        //Affichage des differentes promotions
        /*a.getEleve();
        b.getEleve();
        c.getEleve();*/
        
        //Rechercher un eleve par son identifiant
        /*System.out.println(a.rechercher(5));
        System.out.println(a.rechercher(2));
        System.out.println(a.rechercher(8));*/
        
        //Afficher tous les eleves par ordre croissant puis decroissant en fonction de leurs moyennes et medianes
        /*e1.classementCroissant();
        e2.classementDecroissant();*/
        
        //Afficher tous les eleves d'une promotion selon le classement choisit
        /*a.classementCroissant();
        b.classementCroissant();
        c.classementCroissant();
        
        a.classementDecroissant();
        b.classementDecroissant();
        c.classementDecroissant();*/
        
    }
}

