package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Roster {
    private Player[] roster;

    public Roster() {
        roster = new Player[16];
    }

    public Player[] getRoster() {
        return roster;
    }

    public void getAverages(){
        for (int i = 0; i < roster.length; i++){
            System.out.println(roster[i].getName() + " : " + roster[i].getAVG());
        }
    }

    public void printPlayersByAverage(){
        Player[] orderedRoster = new Player[roster.length];
        Set<String> alreadyAdded = new HashSet<>();
        for (int i = 0; i < roster.length; i++){
            int index = -1;
            double maxAvg = 0;
            String maxPlayer = "";
            for (int j = 0; j < roster.length; j++){
                if (!alreadyAdded.contains(roster[j].getName()) && maxAvg < roster[j].getAVG()){
                    maxAvg = roster[j].getAVG();
                    maxPlayer = roster[j].getName();
                    index = j;
                }
            }
            orderedRoster[i] = roster[index];
            alreadyAdded.add(maxPlayer);
        }

        for (int i = 0; i < orderedRoster.length; i++){
            System.out.println(orderedRoster[i].getName() + " : " + orderedRoster[i].getAVG());
        }
    }

    public void makeTeams(String[] players, Team team1, Team team2, int maxTeamDifference){
        int size = players.length;

        Player[] nextGame = new Player[size];
        int counter = 0;
        for (int i = 0; i < roster.length; i++){
            for (int j = 0; j < size; j++) {
                Player selected = roster[i];
                if (selected.getName().equals(players[j])) {
                    nextGame[counter] = new Player(players[j], selected.getES(), selected.getBS(), selected.getSHO(), selected.getDEF(), selected.getPHY(), selected.getCON());
                    counter += 1;
                }
            }
        }

        int ar[] = new int[size];
        for (int i = 0; i < ar.length; i++)
            ar[i] = i;
        shuffleArray(ar);

        for (int i = 0; i < ar.length; i++){
            if (i < size/2) team1.setPlayer( i, nextGame[ar[i]]);
            else team2.setPlayer(i- size/2, nextGame[ar[i]]);
        }

        Random rand = new Random();
        while (team2.getTotal() > team1.getTotal() + maxTeamDifference || team2.getTotal() < team1.getTotal() - maxTeamDifference){
            int index1 = rand.nextInt(size/2);
            int index2 = rand.nextInt(size/2);
            team1.switchPlayers(index1, index2, team2);
        }
    }

    private static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
