package boardgame;

public class Board {

    private int rows;
    private int columns;
    //matriz de peças que se chama "pieces"
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows <1 || columns < 1){
            throw new BoardException("error creating board: theres must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        //crio manualmente a matriz de peças (pieces)
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    //retorna a peça na linha e coluna indicada.
    public Piece piece (int row, int column){
        if (!positionExists(row, column)){
            throw new BoardException(("Position not on the board"));
        }
        return pieces[row][column];
    }

    //retorna a peça na Position indicada.
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException(("Position not on the board"));
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece((position))){
            throw new BoardException("Theres is already a piece on positio" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //remove Piece
    public Piece removePiece(Position position) {
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        if(piece(position) == null){
            return null;
        }
        //this the piece to be taken out of the board.
        //aux points to the variable I want to declare null
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()]=null;
        return aux;
    }


    private boolean positionExists(int row, int column){
        return row >=0 && row < rows && column >=0 && column < columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException(("Position not on the board"));
        }
        return piece(position) != null;
    }
}
