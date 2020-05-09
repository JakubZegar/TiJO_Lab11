package pl.edu.pwsztar.domain.chess;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public interface RulesOfGame {

    boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd);

    @Component
    @Qualifier("Bishop")
    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if(xStart == xEnd && yStart == yEnd) {
                return false;
            }

            return Math.abs(xEnd - xStart) == Math.abs(yEnd - yStart);
        }
    }

    @Component
    @Qualifier("Rock")
    class Rock implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            return xStart == xEnd || yStart == yEnd;
        }
    }

    @Component
    @Qualifier("Knight")
    class Knight implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            return (Math.abs(xStart - xEnd) == 2 && Math.abs(yStart - yEnd) == 1) ||
                    (Math.abs(yStart - yEnd) == 2 && Math.abs(xStart - xEnd) == 1);
        }
    }

    @Component
    @Qualifier("King")
    class King implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            return (Math.abs(xStart - xEnd) == 0 && (Math.abs(yStart - yEnd) == 1)) ||
                    (Math.abs(xStart - xEnd) == 1 && (Math.abs(yStart - yEnd) == 1)) ||
                    (Math.abs(xStart - xEnd) == 1 && (Math.abs(yStart - yEnd) == 0));
        }
    }

    @Component
    @Qualifier("Queen")
    class Queen implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            return (Math.abs(xEnd - xStart) == Math.abs(yEnd - yStart)) || (xStart == xEnd || yStart == yEnd);
        }
    }

    @Component
    @Qualifier("Pawn")
    class Pawn implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            System.out.println(yStart);
            if( yStart == 2 && xStart == xEnd &&  (Math.abs(yEnd - yStart)) != 0  ){
                return true;
            } else return yStart != 2 && (xStart == xEnd && yEnd - yStart == 1);
        }
    }
}
