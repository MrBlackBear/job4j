package ru.job4j.chess;

public class Bishop extends Figure {
    public Bishop(Cell dest) {
        super(dest);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int sourceX = source.getX();
        int sourceY = source.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        int position = 0;
        int x = Integer.compare(sourceX, destX);
        int y = Integer.compare(sourceY, destY);
        int size = Math.abs(destX - sourceX);
        int vertical = y;
        int horizontal = x;
        Cell[] result = new Cell[Math.abs(sourceX - destX)];
        diffCells(source, dest);
        outwardCells(source, dest);
        if (Math.abs(sourceX - destX) == Math.abs(sourceY - destY)) {
            for (int i = 0; i < size; i++) {
                if (x == 1 && y == -1) {
                    result[position++] = new Cell(sourceX - horizontal, sourceY - vertical);
                    horizontal++;
                    vertical--;
                    continue;
                }
                if (x == -1 && y == -1) {
                    result[position++] = new Cell(sourceX - horizontal, sourceY - vertical);
                    horizontal--;
                    vertical--;
                    continue;
                }
                if (x == -1 && y == 1) {
                    result[position++] = new Cell(sourceX - horizontal, sourceY - vertical);
                    horizontal--;
                    vertical++;
                    continue;
                }
                if (x == 1 && y == 1) {
                    result[position++] = new Cell(sourceX - horizontal, sourceY - vertical);
                    horizontal++;
                    vertical++;
                    continue;
                }
            }
        } else {
            throw new ImpossibleMoveException("Не удалось");
        }
        return result;
    }

    private boolean diffCells(Cell source, Cell dest) {
        if ((source.getX() + source.getY() + dest.getY() + dest.getX()) % 2 != 0) {
            throw new ImpossibleMoveException("Не находятся на клетках одинакового цвета");
        }
        return true;
    }

    private boolean outwardCells(Cell source, Cell dest) {
        if (source.getX() < 0 || source.getX() > 7 || source.getY() < 0 || source.getY() > 7 || dest.getX() < 0 || dest.getX() > 7 || dest.getY() < 0 || dest.getY() > 7) {
            throw new ImpossibleMoveException("Координаты выходят за пределы поля");
        }
        return true;
    }

    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
