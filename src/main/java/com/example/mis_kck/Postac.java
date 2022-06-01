package com.example.mis_kck;
import java.util.Random;


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
    private byte stat_HP_fight = (byte)(10*stat_HP);
    int flag=0;


    public byte getStat_HP() {
        return stat_HP;
    }

    public void setStat_HP(byte stat_HP) { this.stat_HP = stat_HP;}

    public byte getStat_HP_fight() {return stat_HP_fight;}

    public void setStat_HP_fight(byte stat_HP) { this.stat_HP_fight = (byte)(10*stat_HP); }

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
        Random rand = new Random();
        int damage = 0;
        int chance = rand.nextInt(100);
        int atak = rand.nextInt(3) + 1;
        if(typ == Rodzaj_ataku.QUICK ){
            if(chance<70+(5*this.stat_ZWINNOSC)) {
                damage = (atak*(this.stat_SILA)) / przeciwnik.stat_OBRONA;
                przeciwnik.stat_HP_fight -= damage;
            }
        }
        else if(typ == Rodzaj_ataku.MEDIUM ){
            if(chance<50+(5*this.stat_ZWINNOSC)) {
                damage = (3*atak*(this.stat_SILA)) / przeciwnik.stat_OBRONA;
                przeciwnik.stat_HP_fight -= damage;
            }
        }
        else if(typ == Rodzaj_ataku.POWER ){
            if(chance<30+(5*this.stat_ZWINNOSC)) {
                damage = (6*atak*(this.stat_SILA)) / przeciwnik.stat_OBRONA;
                przeciwnik.stat_HP_fight -= damage;
            }
        }
        return damage;

    }
    public void blok() {
        if(flag==0)
        {
            this.stat_OBRONA *=2;
            flag=1;
        }
        else
        {
            this.stat_OBRONA/=2;
            flag=0;
        }
    }
    public void sleep(){
        byte count = getStat_ENERGIA();
        count+=3;
        setStat_ENERGIA(count);
    }
}

