package ru.annin.penzgtulesson02;

import com.sun.istack.internal.NotNull;

public final class Car implements Comparable<Car>{

    private final int id;
    private final String name;

    public Car(int id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{ Id = " + id + ", Name = " + name + " }";
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(id, car.getId());
    }
}