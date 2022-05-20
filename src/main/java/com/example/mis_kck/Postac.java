package com.example.mis_kck;

public class Postac {
    enum Rodzaj_ataku {
        QUICK,
        MEDIUM,
        POWER
    }
    private byte stat_SILA = 1;
    private byte stat_ZWINNOSC = 1;
    private byte stat_OBRONA = 1;
    private byte stat_HP = 1;
    private byte stat_ENERGIA = 1;

    public byte getStat_HP() {
        return stat_HP;
    }

    public void setStat_HP(byte stat_HP) {
        this.stat_HP = stat_HP;
    }

    public byte getStat_SILA() {
        return stat_SILA;
    }

    public void setStat_SILA(byte stat_SILA) {
        this.stat_SILA = stat_SILA;
    }

    public byte getStat_ENERGIA() {
        return stat_ENERGIA;
    }

    public void setStat_ENERGIA(byte stat_ENERGIA) {
        this.stat_ENERGIA = stat_ENERGIA;
    }

    public byte getStat_ZWINNOSC() {
        return stat_ZWINNOSC;
    }

    public void setStat_ZWINNOSC(byte stat_ZWINNOSC) {
        this.stat_ZWINNOSC = stat_ZWINNOSC;
    }

    public byte getStat_OBRONA() {
        return stat_OBRONA;
    }

    public void setStat_OBRONA(byte stat_OBRONA) {
        this.stat_OBRONA = stat_OBRONA;
    }

    public int atak(Postac przeciwnik,Rodzaj_ataku typ) {
        //  todo radnom 1/5
            int damage = 0;
        if(typ == Rodzaj_ataku.QUICK ){
            damage = (this.stat_SILA )/przeciwnik.stat_OBRONA;
            przeciwnik.stat_HP-= damage;
        }
        else if(typ == Rodzaj_ataku.MEDIUM ){
            damage = (this.stat_SILA * 2)/przeciwnik.stat_OBRONA;
            przeciwnik.stat_HP-= damage;
        }
        else if(typ == Rodzaj_ataku.POWER ){
            damage = (this.stat_SILA * 3)/przeciwnik.stat_OBRONA;

            przeciwnik.stat_HP-= damage;
        }
        return damage;

    }
    public void blok() {
       this.stat_OBRONA *=2; // todo trzeba usunac tego busta po rundzie
    }
    public void sleep(){
        byte count = getStat_ENERGIA();
        count++;
        setStat_ENERGIA(count);
    }
}

