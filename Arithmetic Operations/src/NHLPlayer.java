/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author schrotbe2021
 */
public class NHLPlayer {
     private String name;
    private Integer gamesPlayed, goals, assists;
    private Boolean allStar;
    
    public NHLPlayer(String n, Integer gp, Integer g, Integer a, Boolean as) {
        
        name = n;
        gamesPlayed = gp;
        goals = g;
        assists = a;
        allStar = as;
    } // end of constructor
    
    public String toString(){
        String answer;
        answer = name + " has " + goals + " goals and " + assists + " assists in " + gamesPlayed
                + " games played. It is " + allStar + " that he made the All Star team in 2018.";
        return answer;         
    } //end of toString
    
    // getters
    
    public String getName() {
        return name;
    }
    public Integer getgamesPlayed() {
        return gamesPlayed;
    }
    public Integer getGoals() {
        return goals;
    }
    public Integer getAssists() {
        return assists;
    }
    public Boolean getallStar() {
        return allStar;
    }
    
    //setters
    
    public void setName( String n ) {
        name = n;
    }
    public void setgamesPlayed( Integer gp ) {
        gamesPlayed = gp;
    }
    public void setGoals ( Integer g ) {
        goals = g;
    }
    public void setAssists( Integer a ) {
        assists = a;
    }
    public void setallStar ( Boolean as ) {
        allStar = as;
    }
} //end of NHLPlayer
