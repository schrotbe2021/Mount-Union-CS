/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author schrotbe2021
 */
public class Goalie {
    
    private String name;
    private Integer gamesPlayed, saves, shots;
    private Boolean allStar;
    
  public Goalie(String n, Integer gp, Integer s, Integer sh, Boolean as) {
      name = n;
      gamesPlayed = gp;
      saves = s;
      shots = sh;
      allStar = as;
  } // end of constructor
  
  public String toString(){
        String answer;
        answer = name + " has " + saves + " saves facing " + shots + " shots in " + gamesPlayed
                + " games played. It is " + allStar + " that he made the All Star team in 2018.";
        return answer;         
    } //end of toString
  
  // getters
  
  public String getName(){
      return name;
  }
  public Integer getSaves(){
      return saves;
  }
  public Integer getShots(){
      return shots;
  }
  public Integer getgamesPlayed(){
      return gamesPlayed;
  }
  
  public Boolean getallStar() {
      return allStar;
  }
  //setters
  public void setName( String n ) {
      name = n;
  }
  public void setSaves( Integer s ){
      saves = s;
  }
  public void setShots( Integer sh ){
      shots = sh;
  }
  
  public void setgamesPlayed( Integer gp ){
      gamesPlayed = gp;
  }
  public void setallStar( Boolean as ){
      allStar = as;
  }
}
