/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.util.Scanner;
import notesElevesProfesseurs.Eleve;
import static java.lang.Integer.parseInt;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

/**
 *
 * @author bhamd
 */
public class main
{
    
    
    public static void main(String[] args){
        
        //test1 t = new test1();
        //Utiliser la classe Scanner pour remplir le .csv
        //Utiliser juste la lecture du .csv et entrer dedans les donnees
        //To modify a CSV file
        Eleve e[] = new Eleve[1000];
        Professeur p[] = new Professeur[1000];
        Promotion a[] = new Promotion[1000];
        Evaluation q[] = new Evaluation[1000];
        int i = 0, j = 0, cpt_eval = 0, cpt_promo = 0, indice1 = 0, indice2 = 0, indice3 = 0;
        
        String tempFile = "order1.csv";
        File oldFile = new File("order1.csv");
        File newFile = new File("order2.csv");
        try{
            
            FileWriter fw = new FileWriter("C:\\Users\\bhamd\\Downloads\\a\\order12.csv", true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            int cpt = 0;
            x = new Scanner(new File("C:\\Users\\bhamd\\Downloads\\a\\order1.csv"));
            
            x.useDelimiter("[,\n]");

            //x.next();
            while(x.hasNext())
            {
                String nom = x.next();
                String prenom = x.next();
                String date = x.next();
                String promo = x.next();
                String eval1 = x.next();
                String note1 = x.next();
                String correcteur1 = x.next();
                String eval2 = x.next();
                String note2 = x.next();
                String correcteur2 = x.next();
                String eval3 = x.next();
                String note3 = x.next();
                String correcteur3 = x.next();
                
                //System.out.println("NOOOOOOOOOM: " + nom);
                if(nom.hashCode() != "Nom".hashCode())
                {    
                    if(nom.contains("BIZET"))//La ou on modifie
                    {
                        pw.println("HUM");
                    }
                    else
                    {
                        if(eval1 != "" && eval2 != "" && eval3 != "")//eleve avec 3 eval
                        {
                            pw.print(nom + "," + prenom + "," + date + "," + promo + "," + eval1 + "," + note1 + "," + correcteur1 + "," + eval2 + "," + note2 + "," + correcteur2 + "," + eval3 + "," + note3 + "," + correcteur3);
                            e[i] = new Eleve(nom, prenom, parseInt((String) date.subSequence(0, 1)), parseInt((String) date.subSequence(3, 4)), parseInt((String) date.subSequence(6, 9)));
                            for(int y=0; y<correcteur1.length(); y++)
                            {
                                if(correcteur1.charAt(y) == '_')
                                {
                                    indice1 = y;
                                }
                            }
                            for(int y=0; y<correcteur2.length(); y++)
                            {
                                if(correcteur2.charAt(y) == '_')
                                {
                                    indice2 = y;
                                }
                            }
                            for(int y=0; y<correcteur3.length(); y++)
                            {
                                if(correcteur3.charAt(y) == '_')
                                {
                                    indice3 = y;
                                }
                            }
                            p[j] = new Professeur(correcteur1.substring(indice1+1), correcteur1.substring(0, indice1));
                            q[cpt_eval] = new Evaluation(eval1, parseDouble(note1), e[i], p[j]);
                            j++;
                            cpt_eval++;
                            p[j] = new Professeur(correcteur2.substring(indice2+1), correcteur2.substring(0, indice2));
                            q[cpt_eval] = new Evaluation(eval2, parseDouble(note2), e[i], p[j]);
                            j++;
                            cpt_eval++;
                            p[j] = new Professeur(correcteur3.substring(indice3+1), correcteur3.substring(0, indice3));
                            q[cpt_eval] = new Evaluation(eval3, parseDouble(note3), e[i], p[j]);
                            a[cpt_promo] = new Promotion(promo);
                            j++;
                            cpt_eval++;
                            cpt_promo++;
                        }
                        if(eval1 != "" && eval2 != "" && eval3 == "")//eleve avec 2 eval
                        {
                            pw.print(nom + "," + prenom + "," + date + "," + promo + "," + eval1 + "," + note1 + "," + correcteur1 + "," + eval2 + "," + note2 + "," + correcteur2);
                            e[i] = new Eleve(nom, prenom, parseInt((String) date.subSequence(0, 1)), parseInt((String) date.subSequence(3, 4)), parseInt((String) date.subSequence(6, 9)));
                            for(int y=0; y<correcteur1.length(); y++)
                            {
                                if(correcteur1.charAt(y) == '_')
                                {
                                    indice1 = y;
                                }
                            }
                            for(int y=0; y<correcteur2.length(); y++)
                            {
                                if(correcteur2.charAt(y) == '_')
                                {
                                    indice2 = y;
                                }
                                
                            }
                            p[j] = new Professeur(correcteur1.substring(indice1+1), correcteur1.substring(0, indice1));
                            q[cpt_eval] = new Evaluation(eval1, parseDouble(note1), e[i], p[j]);
                            j++;
                            cpt_eval++;
                            p[j] = new Professeur(correcteur2.substring(indice2+1), correcteur2.substring(0, indice2));
                            q[cpt_eval] = new Evaluation(eval2, parseDouble(note2), e[i], p[j]);
                            j++;
                            a[cpt_promo] = new Promotion(promo);
                            cpt_eval++;
                            cpt_promo++;
                        }
                        if(eval1 != "" && eval2 == "" && eval3 == "")//eleve avec 1 eval
                        {
                            pw.print(nom + "," + prenom + "," + date + "," + promo + "," + eval1 + "," + note1 + "," + correcteur1);
                            e[i] = new Eleve(nom, prenom, parseInt((String) date.subSequence(0, 1)), parseInt((String) date.subSequence(3, 4)), parseInt((String) date.subSequence(6, 9)));
                            for(int y=0; y<correcteur1.length(); y++)
                            {
                                if(correcteur1.charAt(y) == '_')
                                {
                                    indice1 = y;
                                }
                            }
                            p[j] = new Professeur(correcteur1.substring(indice1+1), correcteur1.substring(0, indice1));
                            q[cpt_eval] = new Evaluation(eval1, parseDouble(note1), e[i], p[j]);
                            j++;
                            cpt_eval++;
                            a[cpt_promo] = new Promotion(promo);
                            cpt_promo++;
                        }
                        if(eval1 =="")//juste un eleve
                            pw.print(nom + "," + prenom + "," + date + "," + promo);
                        i++;
                    }
                }else
                {
                    pw.print(nom + "," + prenom + "," + date + "," + promo + "," + eval1 + "," + note1 + "," + correcteur1 + "," + eval2 + "," + note2 + "," + correcteur2 + "," + eval3 + "," + note3 + "," + correcteur3);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File("C:\\Users\\bhamd\\Downloads\\a\\order1.csv");
            newFile.renameTo(dump);
        }
        catch(Exception r)
        {
            System.out.println("ERROR !");
        }
        System.out.println(e[2].toString());

    }
    private static Scanner x;
        
}

