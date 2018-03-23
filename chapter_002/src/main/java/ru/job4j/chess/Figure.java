package ru.job4j.chess;

public abstract class Figure {
    public Figure(Cell position){
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    final Cell position;

    abstract Figure copy(Cell dest);
}
