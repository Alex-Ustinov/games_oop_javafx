package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        if (free(steps)) {
            figures[index] = figures[index].copy(dest);
        } else {
            throw new OccupiedCellException();
        }
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (int i = 0; i < figures.length; i++) {
            for (int g = 0; g < steps.length; g++) {
                if(figures[i].position().getY() != steps[g].getY() && steps[g].getX() != figures[i].position().getX()) {
                    return true;
                } else {
                    throw new OccupiedCellException();
                }
            }
        }
        return false;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
