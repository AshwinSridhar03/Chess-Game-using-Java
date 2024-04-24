
public static String possBlackKing(int i) {                                                   // checks all of the possible moves for black king
    String out = " ", previous;
    int row = i / 8, col = i % 8;
    for (int j = 0; j < 9; j++) {               // checks the 9 squares that surround and include the king
        if (j != 4) {                               // excludes the tile the king is standing on
            try {
                if (Character.isUpperCase(board[row - 1 + j / 3][col - 1 + j % 3].charAt(0)) || " ".equals(board[row - 1 + j / 3][col - 1 + j % 3])) {         // if space around king is black or empty it executes
                    previous = board[row - 1 + j / 3][col - 1 + j % 3];                                       // sets temporary variable  to be  whatever is the spot going to
                    board[row][col] = " ";                                                                      // makes current loc an empty string
                    board[row - 1 + j / 3][col - 1 + j % 3] = "k";                                              // inflates new loc with King
                    int kingFoo = blackKing;                                                                //pulls the location of the black king
                    blackKing = i + (j / 3) * 8 + j % 3 - 9;                                                          //determines the poss king moves
                    if (noBlackKingThreat() == true) {
                        out = out + row + col + (row - 1 + j / 3) + (col - 1 + j % 3) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                    }
                    board[row][col] = "k";                                                                      // resets the board with new piece location  (if the king is under threat)
                    board[row - 1 + j / 3][col - 1 + j % 3] = previous;                                         //resets spot to the previous (if the king is under threat)
                    blackKing = kingFoo;                                                       // resets our temp variable
                }

            } catch (Exception e) { }
        }

    }
    return out;
}

public static boolean noWhiteKingThreat() {

    int foo = 1;               // checks diagonals from king position for threat from BISHOP OR QUEEN
    for (int i = -1; i <= 1; i += 2) {                                                // i  = -1 and 1
        for (int j = -1; j <= 1; j += 2) {                                            // j  = -1 and 1
            try {
                while (" ".equals(board[whiteKing / 8 + foo*i][whiteKing % 8 + foo*j])) {
                    foo++;                                                                //keeps increasing spot until it finds a piece or reaches end of board
                }
                if ("b".equals(board[whiteKing / 8 + foo*i][whiteKing % 8 + foo*j]) || "q".equals(board[whiteKing/8 + foo*i][whiteKing%8 + foo*j])) {    // if a black bishop or a queen is found on diagonal king is in check
                    return false;
                }
            } catch (Exception e) { }
            foo = 1;                                                                    //resets our temporary variable that counts spots
        }
    }

    for (int i = -1; i <= 1; i += 2) {            // checks horiz/vert from king position for threat from ROOK OR QUEEN
        try {
            while (" ".equals(board[whiteKing / 8][whiteKing%8 + foo*i])) {
                foo++;                                                                                     //keeps increasing spot until it finds a piece or reaches end of board
            }
            if ("r".equals(board[whiteKing/8][whiteKing%8 + foo*i]) || "q".equals(board[whiteKing/8][whiteKing%8 + foo*i])) {
                return false;
            }
        } catch (Exception e) {}
        foo = 1;                                                                                //resets our temporary variable that counts spots
        try {
            while (" ".equals(board[whiteKing/8 + foo*i][whiteKing%8])) {
                foo++;                                                                                                     //keeps increasing spot until it finds a piece or reaches end of board
            }
            if ("r".equals(board[whiteKing/8 + foo*i][whiteKing%8]) || "q".equals(board[whiteKing/8 + foo*i][whiteKing%8])) {
                return false;
            }
        } catch (Exception e) {}
        foo = 1;                                                                               //resets our temporary variable that counts spots
    }

    //checks if king is threatened by opponents knight
    for (int i = -1; i <= 1; i += 2) {                                                    // i  = -1 and 1
        for (int j = -1; j <= 1; j += 2) {                                            // j  = -1 and 1
            try {
                if ("n".equals(board[whiteKing/8 + i][whiteKing%8 + j*2])) {            // if a black knight is found in a threatening position kings in check (first four knight cases row move 1 col move 2)
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ("n".equals(board[whiteKing/8 + i*2][whiteKing%8 + j])) {                   // if a black knight is found in a threatening position kings in check (second four cases row move 2 col move 1)
                    return false;
                }
            } catch (Exception e) {}
        }
    }
    //checks if pawns threaten king
    if (whiteKing >= 16) {
        try {
            if ("p".equals(board[whiteKing/8 - 1][whiteKing%8 - 1])) {                      //checks for a black pawn on its left diagonal
                return false;
            }
        } catch (Exception e) { }
        try {
            if ("p".equals(board[whiteKing/8 - 1][whiteKing%8 + 1])) {                       //checks for a black pawn on its right diagonal
                return false;
            }
        } catch (Exception e) {}
    }
    //checks if the opponents king is poss threat
    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            if (i != 0 || j != 0) {                                           //for loop sorts through every space around the king except where the king actually is
                try {
                    if ("k".equals(board[whiteKing/8 + i][whiteKing%8 + j])) {                          //won't let other king get close
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
    }
    return true;
}


public static boolean noBlackKingThreat() {
    //checks threats in diagonal directions (BISHOP/QUEEN )
    int foo = 1;
    for (int i = -1; i <= 1; i += 2) {                                                        // i  = -1 and 1
        for (int j = -1; j <= 1; j += 2) {                                                        // j  = -1 and 1
            try {
                while (" ".equals(board[blackKing/8 + foo*i][blackKing%8 + foo*j])) {
                    foo++;                                                                                     //keeps increasing spot until it finds a piece or reaches end of board
                }
                if ("B".equals(board[blackKing/8 + foo*i][blackKing%8 + foo*j]) || "Q".equals(board[blackKing/8 + foo*i][blackKing%8 + foo*j])) {               //if a white bishop or a queen is found on diagonal king is in check
                    return false;
                }
            } catch (Exception e) {}
            foo = 1;                                                                    //resets our temporary variable that counts spots
        }
    }
    //checks threats in horizontal/vertical directions (ROOK / QUEEN)
    for (int i = -1; i <= 1; i += 2) {
        try {
            while (" ".equals(board[blackKing/8][blackKing%8 + foo*i])) {
                foo++;                                                                     //keeps increasing spot until it finds a piece or reaches end of board
            }
            if ("R".equals(board[blackKing/8][blackKing%8 + foo*i])
                    || "Q".equals(board[blackKing/8][blackKing%8 + foo*i])) {                       //if a white rook or a queen is found on diagonal king is in check
                return false;
            }
        } catch (Exception e) {}
        foo = 1;                                                                    //resets our temporary variable that counts spots
        try {
            while (" ".equals(board[blackKing/8 + foo*i][blackKing%8])) {
                foo++;                                                                                         //keeps increasing spot until it finds a piece or reaches end of board
            }
            if ("R".equals(board[blackKing/8 + foo*i][blackKing%8]) || "Q".equals(board[blackKing/8 + foo*i][blackKing%8])) {
                return false;
            }
        } catch (Exception e) {}
        foo = 1;                                                                        //resets our temporary variable that counts spots
    }

    //checks if king threatened by KNIGHT
    for (int i = -1; i <= 1; i += 2) {                                    // i  = -1 and 1
        for (int j = -1; j <= 1; j += 2) {                                    // j  = -1 and 1
            try {
                if ("N".equals(board[blackKing/8 + i][blackKing%8 + j*2])) {      //if knight on row +- 1 , col +-2  , kings in check
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ("N".equals(board[blackKing/8 + i*2][blackKing%8 + j])) {                  //if knight on row +- 2 , col +-1  , kings in check
                    return false;
                }
            } catch (Exception e) { }
        }
    }
    //checks if PAWNS threaten king
    if (blackKing < 48) {
        try {
            if ("P".equals(board[blackKing/8 + 1][blackKing%8 + 1])) {                  // king left up diag for a white pawn, if so in check
                return false;
            }
        } catch (Exception e) {
        }
        try {
            if ("P".equals(board[blackKing/8 + 1][blackKing%8 - 1])) {                           // king right up diag for a white pawn, if so in check
                return false;
            }
        } catch (Exception e) {}
    }
    //checks if the opponents king is poss threat
    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            if (i != 0 || j != 0) {                                                                                  //for loop sorts through every space around the king except where the king actually is
                try {
                    if ("K".equals(board[blackKing/8 + i][blackKing%8 + j])) {                                       //won't let other king get close
                        return false;
                    }
                } catch (Exception e) { }
            }
        }
    }
    return true;
}
}