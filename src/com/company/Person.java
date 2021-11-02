package com.company;
import java.io.*;

public class Person implements java.io.Serializable {
    private int nr;
    private String navn;
    private float tal;

    public Person() {
    }

    public Person(int nr, String navn, float tal) {
        this.nr = nr;
        this.navn = navn;
        this.tal = tal;
    }

    public void printPerson() {
        System.out.println(this.nr + " " + this.navn + " " + this.tal);
    }

    public void printPersonArr(Person[] arr) {
        for (Person person : arr) {
            person.printPerson();
        }
    }

    public void printToFile(Person[] arr) {
        try {
            FileOutputStream fos = new FileOutputStream("personer.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Write object to file
            for (Person person : arr) {
                oos.writeObject(person);
                System.out.println("Person object created");
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personer.ser"));
        Person[] persons = new Person[3];
        for (int i = 0; i < 3; i++) {
            persons[i] = (Person) ois.readObject();
        }
        printPersonArr(persons);
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public float getTal() {
        return tal;
    }

    public void setTal(float tal) {
        this.tal = tal;
    }
}
