package ru.job4j.inheritance;

public class Teacher extends Profession{

    Teacher(String name, String profession) {
        super(name, profession);
    }

    public void teachStudent(Student student){}
}
