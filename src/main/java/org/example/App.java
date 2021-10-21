package org.example;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;

//FULL ROSTER:
//Cima, Simo, Pacio, Deda, Faez, GG, Vito, Pippo, Guerra, Conte, Paolino, Marco7Miglia, Ale, Molina, Zulini, Tres

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
        //roster.printPlayersByAverage();


        /* *****************************************************************************/
        /* *****************************************************************************/
        /* *****************************************************************************/
        /* *****************************************************************************/
        /* this is the only part to modify since getting the players by input sucks kek*/
        String[] players = {"Cima", "Paolino", "Tres", "Faez", "Deda", "Conte", "Pippo", "Guerra", "Vito", "Simo", "GG", "Pacio", "Zulini", "Molina"};
        int teamsMaxAVGDifference = 3;
        /* *****************************************************************************/
        /* *****************************************************************************/
        /* *****************************************************************************/
        /* *****************************************************************************/



        teamFormation(roster, players, teamsMaxAVGDifference);
    }

    static void teamFormation(Roster roster, String[] players, int teamsMaxAVGDifference){
        Team team1 = new Team(players.length/2);
        Team team2 = new Team(players.length/2);
        roster.makeTeams(players, team1, team2, teamsMaxAVGDifference);


        System.out.println("\t\t---TEAMS---");
        team1.printTeam();
        System.out.println();
        team2.printTeam();
        System.out.println("\nTEAM1 - TOTAL AVG: " + team1.getTotal() + "\nTEAM2 - TOTAL AVG: " + team2.getTotal());
    }

}
