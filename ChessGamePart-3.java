
public static String possBlackRook(int i) {                                              // checks all of the possible moves for black rooks.
    String out = " ", previous;
    int row = i / 8, col = i % 8, foo = 1;
    for (int j = -1; j <= 1; j += 2) {                                                       // j is -1 or 1
        try {
            while (" ".equals(board[row][col + foo*j])) {                                                    // if vert spot is empty it executes
                previous = board[row][col + foo*j];                                                       // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                                  // makes current loc an empty string
                board[row][col + foo*j] = "r";                                                          // inflates new loc with Rook
                if (noBlackKingThreat() == true) {
                    out = out + row + col + row + (col + foo*j) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "r";                                                                  // resets the board with new piece location  (if the king is under threat)
                board[row][col + foo*j] = previous;                                                     //resets spot to the previous (if the king is under threat)
                foo++;                                                                                        //keeps increasing spot until it hits a piece or reaches end of board
            }
            if (Character.isUpperCase(board[row][col + foo*j].charAt(0))) {                                  // if vert spot is white it executes
                previous = board[row][col + foo*j];                                               // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                                  // makes current loc an empty string
                board[row][col + foo*j] = "r";                                                                  // inflates new loc with Rook
                if (noBlackKingThreat() == true) {
                    out = out + row + col + row + (col + foo*j) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "r";                                                      // resets the board with new piece location  (if the king is under threat)
                board[row][col + foo*j] = previous;                                          //resets spot to the previous (if the king is under threat)
            }
        } catch (Exception e) {}
        foo = 1;                                                                            //resets our temporary variable that counts spots
        try {
            while (" ".equals(board[row + foo*j][col])) {                                        // if horizontal spot is empty it executes
                previous = board[row + foo*j][col];                                               // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                              // makes current loc an empty string
                board[row + foo*j][col] = "r";                                                      // inflates new loc with Rook
                if (noBlackKingThreat() == true) {
                    out = out + row + col + (row + foo*j) + col + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "r";                                                                  // resets the board with new piece location  (if the king is under threat)
                board[row + foo*j][col] = previous;                                                     //resets spot to the previous (if the king is under threat)
                foo++;                                                                                    //keeps increasing spot until it hits a piece or reaches end of board
            }
            if (Character.isUpperCase(board[row + foo*j][col].charAt(0))) {                                 // if horizontal spot is white it executes
                previous = board[row + foo*j][col];                                                       // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                                      // makes current loc an empty string
                board[row + foo*j][col] = "r";                                                                      // inflates new loc with Rook
                if (noBlackKingThreat() == true) {
                    out = out + row + col + (row + foo*j) + col + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "r";                                                                  // resets the board with new piece location  (if the king is under threat)
                board[row + foo*j][col] = previous;                                                     //resets spot to the previous (if the king is under threat)
            }
        } catch (Exception e) { }
    }
    return out;
}

public static String possWhiteBishop(int i) {                                                    // checks all of the possible moves for white bishops.
    String out = " ", previous;
    int row = i / 8, col = i % 8, foo = 1;
    for (int j = -1; j <= 1; j += 2) {                                                      //j = -1 or 1
        for (int k = -1; k <= 1; k += 2) {                                                      //k is = -1 or 1
            if (j != 0 && k != 0) {                                                             //ensures move is a bishop move.. not entirely necessary
                try {
                    while (" ".equals(board[row + foo*j][col + foo*k])) {                               //if diagonal location increase/decrease is empty it executes
                        previous = board[row + foo*j][col + foo*k];                                   // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                          // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "B";                                          // inflates new loc with Bishop
                        if (noWhiteKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "B";                                                          // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                                     //resets spot to the previous (if the king is under threat)
                        foo++;                                                                                    //keeps increasing spot until it hits a piece or reaches end of board
                    }
                    if (Character.isLowerCase(board[row + foo*j][col + foo*k].charAt(0))) {                    //if diagonal location increase/decrease is black it executes
                        previous = board[row + foo*j][col + foo*k];                                       // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                              // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "B";                                                  // inflates new loc with Bishop
                        if (noWhiteKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "B";                                                           // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                                      //resets spot to the previous (if the king is under threat)
                    }
                } catch (Exception e) {     }
                foo = 1;                                                                    //resets our temporary variable that counts spots
            }
        }
    }
    return out;
}

public static String possBlackBishop(int i) {                                        // checks all of the possible moves for black bishops
    String out = " ", previous;
    int row = i / 8, col = i % 8, foo = 1;
    for (int j = -1; j <= 1; j += 2) {                                           //j = -1 or 1
        for (int k = -1; k <= 1; k += 2) {                                       //k = -1 or 1
            if (j != 0 && k != 0) {
                try {
                    while (" ".equals(board[row + foo*j][col + foo*k])) {                       //if diagonal location increase/decrease is empty it executes
                        previous = board[row + foo*j][col + foo*k];                                  // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                  // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "b";                                      // inflates new loc with Bishop
                        if (noBlackKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "b";                                              // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                         //resets spot to the previous (if the king is under threat)
                        foo++;                                                                    //keeps increasing spot until it hits a piece or reaches end of board
                    }
                    if (Character.isUpperCase(board[row + foo*j][col + foo*k].charAt(0))) {                //if diagonal location increase/decrease is white it executes
                        previous = board[row + foo*j][col + foo*k];                                   // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                          // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "b";                                              // inflates new loc with Bishop
                        if (noBlackKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "b";                                                  // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                             //resets spot to the previous (if the king is under threat)
                    }
                } catch (Exception e) { }
                foo = 1;                                                        //resets our temporary variable that counts spots
            }
        }
    }
    return out;
}


public static String possWhiteQueen(int i) {                                          // checks all of the possible moves for white queen
    String out = " ", previous;
    int row = i / 8, col = i % 8, foo = 1;
    for (int j = -1; j <= 1; j++) {                                                     // j = -1
        for (int k = -1; k <= 1; k++) {                                                   // k= -1
            if (j != 0 || k != 0) {                                                         // if one of these is zero queen move
                try {
                    while (" ".equals(board[row + foo*j][col + foo*k])) {                                   //if empty tile in any direction it executes
                        previous = board[row + foo*j][col + foo*k];                                       // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                             // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "Q";                                          // inflates new loc with Queen
                        if (noWhiteKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;    // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "Q";                                                          // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                                     //resets spot to the previous (if the king is under threat)
                        foo++;                                                                                    //keeps increasing spot until it hits a piece or reaches end of board
                    }
                    if (Character.isLowerCase(board[row + foo*j][col + foo*k].charAt(0))) {              //if black piece  in any direction it executes
                        previous = board[row + foo*j][col + foo*k];                                   // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                          // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "Q";                                          // inflates new loc with Queen
                        if (noWhiteKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;       // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "Q";                                                  // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                             //resets spot to the previous (if the king is under threat)
                    }
                } catch (Exception e) { }
                foo = 1;                                                            //resets our temporary variable that counts spots
            }
        }
    }
    return out;
}

public static String possBlackQueen(int i) {                              // checks all of the possible moves for black queen
    String out = " ", previous;
    int row = i / 8, col = i % 8, foo = 1;
    for (int j = -1; j <= 1; j++) {                         //j is -1 or 1
        for (int k = -1; k <= 1; k++) {                      // k is -1 or 1
            if (j != 0 || k != 0) {                             //queen move ensured
                try {
                    while (" ".equals(board[row + foo*j][col + foo*k])) {                                //if empty string in any direction it executes
                        previous = board[row + foo*j][col + foo*k];                                   // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                          // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "q";                                              // inflates new loc with Queen
                        if (noBlackKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "q";                                                          // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                                     //resets spot to the previous (if the king is under threat)
                        foo++;                                                                            //keeps increasing spot until it hits a piece or reaches end of board
                    }
                    if (Character.isUpperCase(board[row + foo*j][col + foo*k].charAt(0))) {                  //if white piece in any direction it executes
                        previous = board[row + foo*j][col + foo*k];                                       // sets temporary variable  to be  whatever is the spot going to
                        board[row][col] = " ";                                                              // makes current loc an empty string
                        board[row + foo*j][col + foo*k] = "q";                                              // inflates new loc with Queen
                        if (noBlackKingThreat() == true) {
                            out = out + row + col + (row + foo*j) + (col + foo*k) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                        }
                        board[row][col] = "q";                                                          // resets the board with new piece location  (if the king is under threat)
                        board[row + foo*j][col + foo*k] = previous;                                     //resets spot to the previous (if the king is under threat)
                    }
                } catch (Exception e) { }
                foo = 1;                                                                        //resets our temporary variable that counts spots
            }
        }
    }
    return out;
}


public static String possWhiteKing(int i) {                                       // checks all of the possible moves for white king
    String out = " ", previous;
    int row = i / 8, col = i % 8;
    for (int j = 0; j < 9; j++) {                                       // checks the 9 squares that surround and include the king
        if (j != 4) {                                       // excludes the tile the king is standing on
            try {
                if (Character.isLowerCase(board[row - 1 + j / 3][col - 1 + j % 3].charAt(0)) || " ".equals(board[row - 1 + j / 3][col - 1 + j % 3])) {      // if space around king is back or empty it executes
                    previous = board[row - 1 + j / 3][col - 1 + j % 3];                                       // sets temporary variable  to be  whatever is the spot going to
                    board[row][col] = " ";                                                                          // makes current loc an empty string
                    board[row - 1 + j / 3][col - 1 + j % 3] = "K";                                                  // inflates new loc with King
                    int kingFoo = whiteKing;                                                                    //pulls the loc of the white king
                    whiteKing = i + (j / 3) * 8 + j % 3 - 9;                                                    //determines the poss king moves
                    if (noWhiteKingThreat() == true) {
                        out = out + row + col + (row - 1 + j / 3) + (col - 1 + j % 3) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                    }
                    board[row][col] = "K";                                                                  // resets the board with new piece location  (if the king is under threat)
                    board[row - 1 + j / 3][col - 1 + j % 3] = previous;                                     //resets spot to the previous (if the king is under threat)
                    whiteKing = kingFoo;                                                               //resets our temp variable
                }

            } catch (Exception e) {  }
        }

    }
    return out;
}
