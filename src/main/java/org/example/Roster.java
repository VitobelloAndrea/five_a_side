package org.example;

public class Roster {
    private Player[] roster;

    public Roster() {
        roster = new Player[13];
    }

    public Player[] getRoster() {
        return roster;
    }

    public void getAverages(){
        for (int i = 0; i < roster.length; i++){
            System.out.println(roster[i].getName() + " : " + roster[i].getAVG());
        }
    }
}
