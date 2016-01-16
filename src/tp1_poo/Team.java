/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_poo;

/**
 *
 * @author Matthieu
 */
public class Team {
    private int id,played,tie,lost,goalsfor,goalsagainst, points,participations,championships,won;
    private String team,continent;

    public Team() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getGoalsfor() {
        return goalsfor;
    }

    public void setGoalsfor(int goalsfor) {
        this.goalsfor = goalsfor;
    }

    public int getGoalsagainst() {
        return goalsagainst;
    }

    public void setGoalsagainst(int goalsagainst) {
        this.goalsagainst = goalsagainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getParticipations() {
        return participations;
    }

    public void setParticipations(int participations) {
        this.participations = participations;
    }

    public int getChampionships() {
        return championships;
    }

    public void setChampionships(int championships) {
        this.championships = championships;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    
    
}
