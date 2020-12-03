package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        int size = 0;
        int deltaX = 0;
        int deltaY = 0;

        if (dest.getX() > position.getX()) {
            size = dest.getX() - position.getX();
        } else {
            size = position.getX() - dest.getX();
        }
        System.out.println("size = " + size);
        if(!isDiagonal(position, dest, size)) {
            throw new IllegalStateException(String.format("Could not move by diagonal from %s to %s", position, dest));
        }

        Cell[] steps = new Cell[size];
        for(int i = 0; i < size; i++) {
            if (dest.getX() > position.getX() && dest.getY() > position.getY()) {
                deltaX = dest.getX() - i - 1;
                deltaY = dest.getY() - i - 1;
            } else if (dest.getX() < position.getX() && dest.getY() > position.getY()) {
                deltaX = dest.getX() + i + 1;
                deltaY = dest.getY() - i - 1;
            } else if (dest.getX() < position.getX() && dest.getY() < position.getY()) {
                deltaX = dest.getX() + i + 1;
                deltaY = dest.getY() + i + 1;
            } else if (dest.getX() > position.getX() && dest.getY() < position.getY()) {
                deltaX = dest.getX() - i - 1;
                deltaY = dest.getY() + i + 1;
            }
            steps[i] = Cell.findBy(deltaX, deltaY);
        }
        if (steps.length > 0) {
            return steps;
        }
        throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
        );
    }

    public boolean isDiagonal(Cell source, Cell dest, int size) {
        boolean diagonalX = false;
        boolean diagonalY = false;

        if (dest.getX() > source.getX()) {
           if (dest.getX() == (source.getX() + size)) {
               diagonalX = true;
           }
        } else {
            if (source.getX() == (dest.getX() + size)) {
                diagonalX = true;
            }
        }

        if (dest.getY() > source.getY()) {
            if (dest.getY() == (source.getY() + size)) {
                diagonalY = true;
            }
        } else {
            if (source.getY() == (dest.getY() + size)) {
                diagonalY = true;
            }
        }

        if (diagonalX && diagonalY) return true;
            return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
