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
        Cell[] result = new Cell[Math.abs(sourceX - destX)];
        if ((sourceX + sourceY + destY + destX) % 2 != 0) {
            throw new ImpossibleMoveException("Стоят на разных цветовых полях");
        }
        if (sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7 || destX < 0 || destX > 7 || destY < 0 || destY > 7) {
            throw new ImpossibleMoveException("Координаты выходят за пределы поля");
        }
        if (Math.abs(sourceX - destX) == Math.abs(sourceY - destY)) {
            if (sourceX > destX && sourceY < destY) {
                for (int y = sourceY; y < destY; y++) {
                    result[position++] = new Cell(--sourceX, ++sourceY);
                }
            }
            if (sourceX < destX && sourceY < destY) {
                for (int y = sourceY; y < destY; y++) {
                    result[position++] = new Cell(++sourceX, ++sourceY);
                }
            }
            if (sourceX < destX && sourceY > destY) {
                for (int x = sourceX; x < destX; x++) {
                    result[position++] = new Cell(++sourceX, --sourceY);
                }
            }
            if (sourceX > destX && sourceY > destY) {
                for (int x = sourceX; x > destX; x--) {
                    result[position++] = new Cell(--sourceX, --sourceY);
                }
            }
        } else {
            throw new ImpossibleMoveException("Не удалось");
        }
        return result;
    }

    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
