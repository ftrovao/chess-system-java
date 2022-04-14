package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {


    private static final long serialVersionUId = 1l;
    public ChessException(String msg){
        super(msg);
    }
}
