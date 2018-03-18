package ru.job4j.inheritance;

public class Doctor extends Profession {
    Doctor(String name, String profession) {
        super(name, profession);
    }

    public Diagnose heal(Pacient pacient) {
        return new Diagnose(pacient.getDisease());
    }
}
