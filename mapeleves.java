/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesElevesProfesseurs;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author bhamd
 */
public class mapeleves {
    
    private static HashMap<Integer, Promotion> Eleves = new HashMap<Integer, Promotion>();//collection d'eleves
    private static HashMap<Integer, Eleve> Eleves2 = new HashMap<Integer, Eleve>();//collection d'eleves
    
    public HashMap collections()
    {
        return Eleves;
    }
    
    public HashMap collections2()
    {
        return Eleves2;
    }
}
