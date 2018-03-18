package ru.job4j.inheritance;

public class Profession {
     String name;
     String profession;

     Profession(String name, String profession) {
         this.name = name;
         this.profession = profession;
     }

    public String getName() {
         return this.name;
    }
}
