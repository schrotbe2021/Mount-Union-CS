/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class PlayerRecord 
{
    // Data read from file.
    private final String 
            name, 
            team, 
            position;
    
    private final Integer
            goals,
            assists,
            points,
            penaltyMin;

    
    public PlayerRecord(String n, String t, String p, int g, int a, int ps, int pM)
    {
        name = n;
        team = t;
        position = p;
        goals = g;
        assists = a;
        points = ps;
        penaltyMin = pM;    
    } // End of constructor
    
    // Getters
    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getPosition() { return position; }
    public Integer getGoals() { return goals; }
    public Integer getAssists() { return assists; }
    public Integer getPoints() { return points; }
    public Integer getPenaltyMin() { return penaltyMin; }
    
    /*
        Given a parameter of category choice from the category combo box.
        Switch statement then returns the correct category value to display.
        Format is {player name} ({category})
    */
    public String toString(String s)
    {
        String result = name + " (";
        switch(s)
        {
            case "goals":
                result += goals + ")";
                break;
            case "assists":
                result += assists + ")";
                break;
            case "points":
                result += points + ")";
                break;
            case "penalty minutes":
                result += penaltyMin + ")";
                break;
        }
        
        return result;
    }
} // End of PlayerRecord
