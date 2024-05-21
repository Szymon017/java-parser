package szymon017.parser;

public class Data {
    private String round;
    private int alive_units;
    private int dead_units;
    private double average_hp;
    private int health_picked;
    private int evades;
    private int attacks;
    private double time_of_battle;
    private boolean win;

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public int getAlive_units() {
        return alive_units;
    }

    public void setAlive_units(int alive_units) {
        this.alive_units = alive_units;
    }

    public int getDead_units() {
        return dead_units;
    }

    public void setDead_units(int dead_units) {
        this.dead_units = dead_units;
    }

    public double getAverage_hp() {
        return average_hp;
    }

    public void setAverage_hp(double average_hp) {
        this.average_hp = average_hp;
    }

    public int getHealth_picked() {
        return health_picked;
    }

    public void setHealth_picked(int health_picked) {
        this.health_picked = health_picked;
    }

    public int getEvades() {
        return evades;
    }

    public void setEvades(int evades) {
        this.evades = evades;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public double getTime_of_battle() {
        return time_of_battle;
    }

    public void setTime_of_battle(double time_of_battle) {
        this.time_of_battle = time_of_battle;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}


