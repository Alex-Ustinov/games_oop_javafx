package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
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
    public Cell[] way(Cell dest) throws ImpossibleMoveException {

        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException();
        }

        int deltaX = dest.getX() > position.getX() ? 1 : -1;
        int deltaY = dest.getY() > position.getY() ? 1 : -1;

        int size = Math.abs(dest.getX() - position.getX());

        int x = position.getX();
        int y = position.getY();

        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            x += deltaX;
            y += deltaY;
            System.out.println("X "+ x);
            System.out.println("Y "+ y);
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - position.getX()) == Math.abs(dest.getY() - position.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public static void main(String[] args) throws ImpossibleMoveException {
        Cell cell = Cell.findBy(1, 0);
        Cell desc = Cell.findBy(1, 5);
        BishopBlack bishopBlack = new BishopBlack(cell);

        Cell way1 = Cell.findBy(0, 2);
        Cell[] arrayCell = {cell};
        bishopBlack.way(desc);
    }

}
