/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rayanmehdi1
 */
public class Data {
    Connection c;
    ArrayList<Professeur> prof = new ArrayList<>();
    ArrayList<Eleves> el=new ArrayList<>();
    ArrayList<Reponses> rep=new ArrayList<>();
    
   public void recupProf () throws SQLException{
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from Professeur");
        while(rs.next())
            prof.add(new Professeur(rs.getInt("idProfesseur"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mdp"),rs.getString("matiere")));       
    }
   
    public void recupEleve() throws SQLException{
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from Eleves");
        while(rs.next())
            el.add(new Eleves(rs.getInt("idEleve"),rs.getString("nomEleve"),rs.getString("prenomEleve"),rs.getString("mdpEleve")));       
    }
    
    public void recupRep() throws SQLException{
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from Reponses");
        while(rs.next())
            rep.add(new Reponses(rs.getInt("idQcm"), rs.getInt("idQuestion"), rs.getInt("idReponse"),rs.getString("intituleRep"),rs.getBoolean("bonneReponse")));       
    }
    
   
    
    public Data()
    {
        try
        {
            Class.forName( "org.sqlite.JCBD").newInstance();
            c=DriverManager.getConnection("jdbc:sqlite:QCM.sqlite");
            recupProf();
            recupEleve();
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException |SQLException e){
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
        }    
    }

    public ArrayList<Professeur> getProf() {
        return prof;
    }

    public ArrayList<Eleves> getEl() {
        return el;
    }
    
    
    
}


