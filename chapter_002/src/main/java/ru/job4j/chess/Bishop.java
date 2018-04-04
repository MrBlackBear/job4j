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
        int compareX = Integer.compare(sourceX, destX);
        int compareY = Integer.compare(sourceY, destY);
        Cell[] result = new Cell[Math.abs(sourceX - destX)];
        diffCells(source, dest);
        outwardCells(source, dest);
        if (Math.abs(sourceX - destX) == Math.abs(sourceY - destY)) {
            if (compareX == 1 && compareY == -1) {
                for (int y = sourceY; y < destY; y++) {
                    result[position++] = new Cell(--sourceX, ++sourceY);
                }
            }
            if (compareX == -1 && compareY == -1) {
                for (int y = sourceY; y < destY; y++) {
                    result[position++] = new Cell(++sourceX, ++sourceY);
                }
            }
            if (compareX == -1 && compareY == 1) {
                for (int x = sourceX; x < destX; x++) {
                    result[position++] = new Cell(++sourceX, --sourceY);
                }
            }
            if (compareX == 1 && compareY == 1) {
                for (int x = sourceX; x > destX; x--) {
                    result[position++] = new Cell(--sourceX, --sourceY);
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
