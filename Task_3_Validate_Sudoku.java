package Ready;

// Task 3. Validate Sudoku with size `NxN`
import static Ready.Board.bigSquare;
import static Ready.Board.emptyCell;

final class Board {
    static final int emptyCell = 0;
    static final int bigSquare = 9;
    static final int smallSquare = 3;

    private final int[][] board;

    Board(int[][] init) {
        board = init;
    }

    int[] getRow(int row) {
        return board[row];
    }

    int[] getColumn(int col) {
        final int[] columnView = new int[bigSquare];
        for(int a = 0; a < bigSquare; a++) {
            columnView[a] = board[a][col];
        }
        return columnView;
    }

    int[] getSmallSquareSize(int row, int col) {
        final int[] smallView = new int[bigSquare];
        final int rowBase = row - (row % smallSquare);
        final int colBase = col - (col % smallSquare);
        int counter = 0;
        for (int r = rowBase; r < smallSquare + rowBase; r++) {
            for (int c = colBase ; c < smallSquare + colBase; c++) {
                smallView[counter++] = board[r][c];
            }
        }
        return smallView;
    }

    int getCell(int row, int col) {
        return board[row][col];
    }

    void setCell(int row, int col, int val) {
        board[row][col] = val;
    }
}

class Solver {

    private final Board board;

    Solver(int[][] input) {
        this.board = new Board(input);
    }

    boolean solve() {
        return solve(0,0);
    }

    private boolean solve(int row, int col) {
        if (row == bigSquare) {
            row = 0;
            if (++col == bigSquare) {
                return true;
            }
        }
        if (board.getCell(row, col) != emptyCell) {
            return solve(row+1,col);
        }

        for(int val = 1; val <= bigSquare; val++) {
            if (isMoveOK(row, col, val)) {
                board.setCell(row, col, val);
                if (solve(row+1, col)) {
                    return true;
                }
            }
        }
        board.setCell(row, col, emptyCell);
        return false;
    }

    private boolean isMoveOK(int row, int col, int val) {
        return ! (  arrayContains(board.getRow(row), val)
                || arrayContains(board.getColumn(col), val)
                || arrayContains(board.getSmallSquareSize(row, col), val));
    }

    private boolean arrayContains(int[] array, int val) {
        for (int arrayVal : array) {
            if (arrayVal == val) {
                return true;
            }
        }
        return false;
    }
}

