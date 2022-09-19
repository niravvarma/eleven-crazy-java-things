package com.github.hannotify.elevencrazyjavathings.number2;

import java.time.LocalTime;

public class Number2FunctionalInterfaces {

}

//@FunctionalInterface -- only interface class with abstract method can be FunctionalInterface
abstract class Venue {
    public abstract void open();
}

@FunctionalInterface
interface Speaker {
    void speak();
}

/**
 * default methods are not considered for functional interface
 */
@FunctionalInterface
interface Badge {
    void print();
    default void flip() {
        System.out.println("Badge has flipped... again!");
    }
}

//@FunctionalInterface -- not a functional interface because it will add another abstract method by extend keyword
interface IgniteSpeaker extends Speaker {
    void stressOutOverTimeLimit(int timeLimit);
}

/**
 * Is a functional interface because speak() method is overridden and set to default
 * There is only 1 abstract method stressOutOverTimeLimit(), thus, valid functional interface
 */
@FunctionalInterface
interface ByteSizeSpeaker extends Speaker {
    default void speak() {
        System.out.println("Speaking on a great subject in a Byte Size format");
    }
    void stressOutOverTimeLimit(int timeLimit);
}

/**
 * as equals and toString are overridden from Object class, thus, they are NOT considered as abstract method
 * hence, this is also a functional interface
 */
@FunctionalInterface
interface Room {
    void book(LocalTime timeslot);
    boolean equals(Object otherRoom);
    String toString();
}