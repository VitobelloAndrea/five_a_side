package org.example;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

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

        //teamFormation(roster);

        //roster.printPlayersByAverage();
    }

    static void teamFormation(Roster roster){
        String[] players = {"Cima", "Paolino", "Marco7Miglia", "Ale", "Deda", "Conte", "Pippo", "Guerra", "Vito", "Simo"};
        Team team1 = new Team();
        Team team2 = new Team();
        roster.makeTeams(players, team1, team2);

        System.out.println("\n\n\t\t---FINAL TEAMS---");
        team1.printTeam();
        System.out.println();
        team2.printTeam();
        System.out.println("\nTEAM1-AVG: " + team1.getTotal() + "\nTEAM2-AVG: " + team2.getTotal());
    }

}
