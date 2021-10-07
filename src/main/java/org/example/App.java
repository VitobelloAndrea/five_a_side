package org.example;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//FULL ROSTER:
//Cima, Simo, Pacio, Deda, Faez, GG, Vito, Pippo, Guerra, Conte, Paolino, Marco7Miglia, Ale

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {

        Gson gson = new Gson();
        Roster roster = gson.fromJson(new FileReader("src/Json/roster.json"), Roster.class);

        //roster.getAverages();

        ///////
        String[] players = {"Cima", "Paolino", "Marco7Miglia", "Ale", "Deda", "Conte", "Pippo", "Guerra", "Vito", "Simo"};
        Player[] nextGame = new Player[10];
        int counter = 0;
        for (int i = 0; i < roster.getRoster().length; i++){
            for (int j = 0; j < players.length; j++) {
                Player selected = roster.getRoster()[i];
                if (selected.getName().equals(players[j])) {
                    nextGame[counter] = new Player(players[j], selected.getES(), selected.getBS(), selected.getSHO(), selected.getDEF(), selected.getPHY(), selected.getCON());
                    counter += 1;
                }
            }
        }

        /*
        System.out.println();
        for (int i = 0; i < nextGame.length; i++)
            System.out.println(nextGame[i].getName() + " : " + nextGame[i].getAVG());
         */

        int ar[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(ar);

        /*
        for (int i = 0; i < ar.length; i++)
            System.out.print(ar[i] + ", ");
        System.out.println();
         */

        Player[] team1 = new Player[5];
        Player[] team2 = new Player[5];
        for (int i = 0; i < ar.length; i++){
            if (i < 5) team1[i] = nextGame[ar[i]];
            else team2[i-5] = nextGame[ar[i]];
        }

        int team1TOT = 0;
        int team2TOT = 0;

        for (int i = 0; i < team1.length; i++) {
            team1TOT += team1[i].getAVG();
        }

        for (int i = 0; i < team2.length; i++) {
            team2TOT += team2[i].getAVG();
        }

        System.out.println("\n\nTEAM1-AVG: " + team1TOT + "\nTEAM2-AVG: " + team2TOT);

        Random rand = new Random();
        while (team2TOT > team1TOT + 10 || team2TOT < team1TOT - 10){
            int index1 = rand.nextInt(5);
            int index2 = rand.nextInt(5);
            team1TOT -= team1[index1].getAVG();
            team2TOT -= team2[index2].getAVG();
            Player temp = team1[index1];
            team1[index1] = team2[index2];
            team2[index2] = temp;
            team1TOT += team1[index1].getAVG();
            team2TOT += team2[index2].getAVG();
        }

        System.out.println("\n\n\t\t---FINAL TEAMS---");
        System.out.println("\nTeam 1:");
        for (int i = 0; i < team1.length; i++) {
            System.out.println(team1[i].getName() + " : " + team1[i].getAVG());
        }

        System.out.println("\nTeam 2:");
        for (int i = 0; i < team2.length; i++) {
            System.out.println(team2[i].getName() + " : " + team2[i].getAVG());
        }

        System.out.println("\nTEAM1-AVG: " + team1TOT + "\nTEAM2-AVG: " + team2TOT);

    }


    static void shuffleArray(int[] ar)
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
