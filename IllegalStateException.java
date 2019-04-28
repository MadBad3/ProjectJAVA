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
public class IllegalStateException extends Exception {
    public IllegalStateException()
    {
        super("L'élève n'a aucune note !");
    }
}
