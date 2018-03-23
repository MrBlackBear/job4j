package ru.job4j.chess;

public class Board {
    Figure[] figures = new Figure[32];
    private int index = 0;

    Figure add(Figure figure) {
        this.figures[index++] = figure;
        return figure;
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        Figure ourFigure = null;
        Cell[] resArrayFigure = null;
        for (Figure figure : figures) {
            if (figure != null && figure.position.getX() == source.getX() && figure.position.getY() == source.getY()) {
                ourFigure = figure;
            }
        }
        if (ourFigure != null) {
            try {
                resArrayFigure = ourFigure.way(source, dest);
                for (Cell step : resArrayFigure) {
                    for (Figure figure : figures) {
                        if (figure != null && figure.position.getX() == step.getX() && figure.position.getY() == step.getY()) {
                            throw new OccupiedWayException("На пути стоит какая-то фигура");
                        }
                    }
                }
                ourFigure.copy(dest);
                result = true;
            } catch (ImpossibleMoveException ime) {
                throw new ImpossibleMoveException(ime.toString());
            }
        } else {
            throw new FigureNotFoundException("Нету фигуры на заданной точке");
        }
        return result;
    }
}
