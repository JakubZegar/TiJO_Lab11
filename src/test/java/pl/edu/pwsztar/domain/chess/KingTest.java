package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class KingTest {

    private RulesOfGame king = new RulesOfGame.King();

    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            " 4,  4,  5,  5",
            " 4,  4,  5,  4",
            " 4,  4,  4,  5",
            " 4,  4,  3,  3",
            " 4,  4,  3,  4",
            " 4,  4,  4,  3",
            " 4,  4,  3,  5",
            " 4,  4,  5,  3",
    })
    void checkCorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 5, 6",
            "8, 8, 1, 1",
            "5, 6, 2, 5",
            "5, 1, 8, 1",
            "3, 8, 3, 8",

    })
    void checkIncorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}

