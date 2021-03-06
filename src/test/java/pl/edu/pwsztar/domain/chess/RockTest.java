package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RockTest {

        private RulesOfGame rock = new RulesOfGame.Rock();

        @Tag("Rook")
        @ParameterizedTest
        @CsvSource({
                " 1,  1,  8,  1",
                " 7,  2,  2,  2",
                " 4,  2,  4,  8 ",
                " 1,  3,  1,  0 "
        })
        void checkCorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
            assertTrue(rock.isCorrectMove(xStart, yStart, xStop, yStop));
        }

        @ParameterizedTest
        @CsvSource({
                "1,  1,  6,   3",
                "2, 2, 3, 3",
                "8, 5, 6, 3",
                "5, 7, 6, 2"
        })
        void checkIncorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
            assertFalse(rock.isCorrectMove(xStart, yStart, xStop, yStop));
        }
}

