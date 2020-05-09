package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.chess.RulesOfGame;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.domain.enums.FigureType;
import pl.edu.pwsztar.service.ChessService;

@Service
public class ChessServiceImpl implements ChessService {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame rock;
    private RulesOfGame queen;
    private RulesOfGame king;
    private RulesOfGame pawn;

    @Autowired
    public ChessServiceImpl(@Qualifier("Bishop") RulesOfGame bishop,
                            @Qualifier("Knight") RulesOfGame knight,
                            @Qualifier("Rock") RulesOfGame rock,
                            @Qualifier("Queen") RulesOfGame queen,
                            @Qualifier("King") RulesOfGame king,
                            @Qualifier("Pawn") RulesOfGame pawn ){
        this.bishop = bishop;
        this.knight = knight;
        this.rock = rock;
        this.queen = queen;
        this.king = king;
        this.pawn = pawn;
    }

    @Override
    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        FigureType figureType = figureMoveDto.getType();
        char startX = figureMoveDto.getStart().charAt(0);
        char startY = figureMoveDto.getStart().charAt(2);
        char endX = figureMoveDto.getDestination().charAt(0);
        char endY = figureMoveDto.getDestination().charAt(2);

        switch (figureType){
            case KING:
                return this.king.isCorrectMove(startX,startY,endX,endY);
            case PAWN:
                return this.pawn.isCorrectMove(startX,startY,endX,endY);
            case ROCK:
                return this.rock.isCorrectMove(startX,startY,endX,endY);
            case QUEEN:
                return this.queen.isCorrectMove(startX,startY,endX,endY);
            case BISHOP:
                return this.bishop.isCorrectMove(startX,startY,endX,endY);
            case KNIGHT:
                return this.knight.isCorrectMove(startX,startY,endX,endY);
            default:
                return false;
        }
    }
}
