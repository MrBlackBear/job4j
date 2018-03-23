package ru.job4j.chess;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void whenHasNoProblemThenGoThere() {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(2, 2));
        board.add(bishop);
        Cell sourceBishop = new Cell(2, 2);
        Cell destBishop = new Cell(5, 5);
        boolean result = board.move(sourceBishop, destBishop);
        assertTrue(result);
    }

    @Test
    public void whenHasNoProblemThenNewDestFiveFive() {
        Bishop bishop = new Bishop(new Cell(2, 2));
        Cell sourceBishop = new Cell(2, 2);
        Cell destBishop = new Cell(5, 5);
        Cell[] res = bishop.way(sourceBishop, destBishop);
        boolean result = res[res.length - 1].equals(new Cell(5, 5));
        assertTrue(result);
    }

    @Test
    public void whenHasNoProblemThenNewDestZeroZero() {
        Bishop bishop = new Bishop(new Cell(2, 2));
        Cell sourceBishop = new Cell(2, 2);
        Cell destBishop = new Cell(0, 0);
        Cell[] res = bishop.way(sourceBishop, destBishop);
        boolean result = res[res.length - 1].equals(new Cell(0, 0));
        assertTrue(result);
    }

    @Test
    public void whenHasNoProblemThenNewDestZeroFour() {
        Bishop bishop = new Bishop(new Cell(2, 2));
        Cell sourceBishop = new Cell(2, 2);
        Cell destBishop = new Cell(0, 4);
        Cell[] res = bishop.way(sourceBishop, destBishop);
        boolean result = res[res.length - 1].equals(new Cell(0, 4));
        assertTrue(result);
    }

    @Test
    public void whenHasNoProblemThenNewDestFourZero() {
        Bishop bishop = new Bishop(new Cell(2, 2));
        Cell sourceBishop = new Cell(2, 2);
        Cell destBishop = new Cell(4, 0);
        Cell[] res = bishop.way(sourceBishop, destBishop);
        boolean result = res[res.length - 1].equals(new Cell(4, 0));
        assertTrue(result);
    }
}
