package org.example;

public class Player {
    private String name;
    private int ES; //Endurance and Speed
    private int BS; //Ball Skills
    private int SHO; //Shooting
    private int DEF; //Defense
    private int PHY; //Physique
    private int CON; //Consistency

    public Player(String name, int ES, int BS, int SHO, int DEF, int PHY, int CON) {
        this.name = name;
        this.ES = ES;
        this.BS = BS;
        this.SHO = SHO;
        this.DEF = DEF;
        this.PHY = PHY;
        this.CON = CON;
    }

    public String getName() { return name; }

    public int getES() {
        return ES;
    }

    public int getBS() {
        return BS;
    }

    public int getSHO() {
        return SHO;
    }

    public int getDEF() {
        return DEF;
    }

    public int getPHY() {
        return PHY;
    }

    public int getCON() {
        return CON;
    }

    public double getAVG() {
        return (int)(((double)(this.ES + this.BS + this.CON + this.DEF + this.SHO + this.PHY) / 6) + 0.5);
    }
}
