public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //all cords exist
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (line != toLine && column != toColumn && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine]
                    [toColumn].color.equals(this.color)) && chessBoard.board[line][column] != null) {
                if (!chessBoard.board[line][column].equals(this)) {
                    return false;
                }

                int[][] position = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}
                };
                for (int[] ints : position) {
                    if (ints[0] == toLine && ints[1] == toColumn) {
                        return true;
                    }
                }
            }
        }else return false;
        return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
