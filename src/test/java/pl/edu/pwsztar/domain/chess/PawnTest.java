package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PawnTest {

    private RulesOfGame pawn = new RulesOfGame.Pawn();

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            " 2,  2,  2,  4",
            " 2,  3,  2,  4",
            " 5,  6,  5,  7",
            " 3,  4,  3,  5",
            " 1,  1,  1,  2",
            " 5,  5,  5,  6",
            " 8,  2,  8,  4",
            "2,2,2,3",
    })
    void checkCorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 4, 5, 6",
            "2, 2, 3, 3",
            "7, 5, 7, 4",
            "7, 8, 5, 2",
            "1, 3, 2, 3",
            "2,2,2,2",
    })
    void checkIncorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}

