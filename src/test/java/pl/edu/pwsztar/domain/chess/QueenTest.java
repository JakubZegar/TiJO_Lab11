package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class QueenTest {

    private RulesOfGame queen = new RulesOfGame.Queen();

    @Tag("Queen")
    @ParameterizedTest
    @CsvSource({
            " 4,  4,  7,  7",
            " 4,  4,  5,  4",
            " 1,  1,  8,  1",
            " 5,  5,  3,  7",
            " 7,  2,  1,  8",
            " 5,  5,  3,  3",
            " 5,  5,  5,  8",
    })
    void checkCorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 5, 6",
            "7, 3, 8, 1",
            "1, 5, 4, 8",
            "5, 7, 6, 2",
            "1,1,1,1",

    })
    void checkIncorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}

