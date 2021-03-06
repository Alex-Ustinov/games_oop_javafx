package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        Cell cell = Cell.findBy(1, 5);
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertSame(bishopBlack.position(), cell);
    }

    @Test
    public void testCopy() {
        Cell cell = Cell.findBy(1, 5);
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertSame(bishopBlack.copy(cell).position(), cell);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWay() throws ImpossibleMoveException {
        Cell cell = Cell.findBy(1, 0);
        Cell desc = Cell.findBy(1, 5);
        BishopBlack bishopBlack = new BishopBlack(cell);
        Cell[] arrayCell = {cell};
        assertThat(bishopBlack.way(desc), is(arrayCell));
    }

}