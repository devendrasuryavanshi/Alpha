package OOPS;

import java.util.Scanner;

public class OOPS {
    public static void main(String[] args) {
        Pen p1 = new Pen(); //created a pen object called p1
        // Student s1 = new Student();
        // s1.name = "Devendra";
        // s1.roll = 205;
        // s1.password = "abcd";
        // s1.marks[0] = 100;
        // s1.marks[1] = 90;
        // s1.marks[2] = 80;
        // Student s2 = new Student(s1); //copy
        // s2.password = "xyz";
        // s1.marks[1] = 100;
        // for(int i=0; i<s2.marks.length; i++) {
        //     System.out.print(s2.marks[i]+" ");
        // }

        // Dog pup = new Dog();
        // pup.eat();
        // pup.legs = 4;
        // Human h1 = new Human();
        // h1.iq = 7;
        // Cat kitty = new Cat();
        // kitty.color = "brown";
        // System.out.println(pup.legs);
        // System.out.println(kitty.color);

        // Horse h = new Horse();
        // h.walk();
        // Human doraemon = new Human();
        // System.out.println(doraemon.color);

        // Bear b = new Bear();
        // b.nonVeg();
        // b.veg();

        // Vehical v1 = new Car();
        // v1.print();

        // Vehical v2 = new Vehical();
        // v2.print();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int a = sc.nextInt();
        System.out.println("Enter second number");
        int b = sc.nextInt();
        Complex op = new Complex();
        op.a = a;
        op.b = b;
        op.sum(a, b);
        op.difference(a, b);
        op.product(a, b);
        op.changeC(7);
        System.out.println("c "+op.c);
    }
}

class Complex {
    int a;
    int b;

    int c = 1;

    void changeC(int newC) {
        this.c = newC;
    }
    void sum(int a, int b) {
        System.out.println("Sum of "+a+" and "+b+" = "+(a+b));
    }

    void difference(int a, int b) {
        System.out.println("Difference of "+a+" and "+b+" = "+(a-b));
    }

    void product(int a, int b) {
        System.out.println("Product of "+a+" and "+b+" = "+(a*b));
    }
}

class Vehical {
    void print() {
        System.out.println("Base class(Vehical)");
    }
}

class Car extends Vehical {
    void print() {
        System.out.println("Derived class(Car)");
    }
}

//Interfaces

interface Herbivore {
    void veg();
}

interface Carnivore {
    void nonVeg();
}

class Bear implements Herbivore, Carnivore {
    public void veg() {
        System.out.println("i eat veg");
    }

    public void nonVeg() {
        System.out.println("i eat non veg");
    }
}

//Abstract Classes
abstract class Animal2 {
    String color;
    
    Animal2() {
        color = "Brown";
    }
    void eat() {
        System.out.println("Animal eats");
    }

    abstract void walk();
}

class Horse extends Animal2 {
    void walk() {
        System.out.println("walk on 4 legs");
    }
}

class Human2 extends Animal2 {
    void walk() {
        System.out.println("walk on 2 legs");
    }
}

//Base Class
class Animal {
    String color;

    // Animal() {
    //     color = "Brown";
    // }

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

class Mammal extends Animal {
    int legs;
}

class Fish extends Animal {
    int fins;
}

class Bird extends Animal {
    void fly() {
        System.out.println("flying");
    }
}

class Dog extends Mammal {

    String breed;
}

class Cat extends Mammal {
    String breed;
}

class Human extends Mammal {
    int iq;
}

class Tuna extends Fish {
    void tuna() {
        System.out.println("I Am Tuna");
    }
}

class Shark extends Fish {
    int size;
}

class Peecock extends Bird {
    void peecock() {
        System.out.println("Hey, I Am Peecock");
    }
}


//Derived class / subclass
// class Fish extends Animal {
//     int fins;

//     void swim() {
//         System.out.println("Swims in water");
//     }
// }

class Pen {
    private String color;
    private int tip;

    //constructor
    Pen() {
        System.out.println("constructor is called ...");
    }

    //getters
    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    //setters
    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[] = new int[3];

    // Shallow Copy constructor
    // Student(Student copy) {
    //     this.name = copy.name;
    //     this.roll = copy.roll;
    //     this.marks = copy.marks;
    // }

    //Deep Copy constructor
    Student(Student copy) {
        this.name = copy.name;
        this.roll = copy.roll;
        for(int i=0; i<marks.length; i++) {
            this.marks[i] = copy.marks[i];
        }
    }

    Student() { // Non-parameterized constructor
        System.out.println("constructor is called ...");
    }

    Student(String name) { // parameterized constructor
        this.name = name;
    }

    Student(int roll) { // parameterized constructor
        this.roll = roll;
    }

    // void calcPercentage(int phy, int chem, int math) {
    //     percentage = (phy + chem + math) / 3;
    // }
}
