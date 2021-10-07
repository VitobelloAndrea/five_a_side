package org.example;

public class Team {
    private Player[] players;

    public Team(){
        players = new Player[5];
    }

    public void setPlayer(int index, Player player){
        players[index] = new Player(player.getName(), player.getES(), player.getBS(), player.getSHO(), player.getDEF(), player.getPHY(), player.getCON());
    }

    public int getTotal() {
        int tot = 0;
        for (int i = 0; i < players.length; i++)
            tot += players[i].getAVG();
        return tot;
    }

    public void switchPlayers(int index1, int index2, Team opponents){
        Player temp = this.players[index1];
        this.players[index1] = opponents.players[index2];
        opponents.players[index2] = temp;
    }

    public void printTeam(){
        System.out.println("Team1: ");
        for (int i = 0; i < players.length; i++)
            System.out.println(players[i].getName() + " : " + players[i].getAVG());
    }
}
