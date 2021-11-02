package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        Person person1 = new Person(1, "Pernille" , 12.50F);
        Person person2 = new Person(2, "Peter" , 22.75F);
        Person person3 = new Person(3, "Christian" , 30.10F);
        Person[] arr = {person1, person2, person3};

        //person2.printPerson();
        person.printPersonArr(arr);
        person.printToFile(arr);
        person.readFromFile();
    }
}
