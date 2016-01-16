/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Matthieu
 */
public class Data {
    ArrayList<Team> equipe;

    public Data() {
        equipe = new ArrayList<Team>();
        try{
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection c = DriverManager.getConnection("jdbc:sqlite:statistics.sqlite");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM worldcup;");
            
            
            for(int i=0;rs.next();i++){
                
                equipe.add(new Team());
                
                equipe.get(i).setId(Integer.parseInt(rs.getString("id")));
                equipe.get(i).setTeam(rs.getString("team"));
                equipe.get(i).setContinent(rs.getString("continent"));
                equipe.get(i).setPlayed(Integer.parseInt(rs.getString("played")));
                equipe.get(i).setLost(Integer.parseInt(rs.getString("lost")));
                equipe.get(i).setTie(Integer.parseInt(rs.getString("tie")));
                equipe.get(i).setGoalsfor(Integer.parseInt(rs.getString("goalsfor")));
                equipe.get(i).setGoalsagainst(Integer.parseInt(rs.getString("goalsagainst")));
                equipe.get(i).setPoints(Integer.parseInt(rs.getString("points")));
                equipe.get(i).setParticipations(Integer.parseInt(rs.getString("participations")));
                equipe.get(i).setChampionships(Integer.parseInt(rs.getString("championships")));
                equipe.get(i).setWon(Integer.parseInt(rs.getString("won")));
                System.out.println(equipe.get(i).getContinent());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
