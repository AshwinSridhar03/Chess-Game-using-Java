
public static String possBlackPawn(int i) {         // checks all of the possible moves for black pawns.
    String out = " ", previous;
    int row = i / 8, col = i % 8;
    try {                                                                             //CAPTURE --possible capture moves for a pawn (2 diagonals in direction of movement)
        for (int j = -1; j <= 1; j += 2) {                                                // j  = -1 and 1
            if (Character.isUpperCase(board[row + 1][col - j].charAt(0)) && i <= 47) {            //if diagonal spot for capture is occupied by a white piece (upper case letter) which can be captured then it executes
                previous = board[row + 1][col - j];                                           // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                          // makes current loc an empty string
                board[row + 1][col - j] = "p";                                                     // inflates new loc with pawn
                if (noBlackKingThreat() == true) {
                    out = out + row + col + (row + 1) + (col - j) + previous;
                }
                board[row][col] = "p";                                                        // resets the board with new piece location  (if the king is under threat)
                board[row + 1][col - j] = previous;                                         //resets spot to the previous (if the king is under threat)
            }
        }
    } catch (Exception e) { }

    try {                                                                                 // MOVE UP 1 --sees if possible to move up 1, only will do so if space in front of it is empty
        if (" ".equals(board[row + 1][col]) && i <= 47) {                                       //if forwards spot is occupied by an empty string " "  then it executes
            previous = board[row + 1][col];                                                   // sets temporary variable  to be  whatever is the spot going to
            board[row][col] = " ";                                                              // makes current loc an empty string
            board[row + 1][col] = "p";                                                                 // inflates new loc with pawn
            if (noBlackKingThreat() == true) {
                out = out + row + col + (row + 1) + col + previous;             // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
            }
            board[row][col] = "p";                                                          // resets the board with new piece location  (if the king is under threat)
            board[row + 1][col] = previous;                                                 //resets spot to the previous (if the king is under threat)
        }
    } catch (Exception e) { }

    try {                                                                                //MOVE UP 2 --sees if possible for pawn to move up 2 ****only allowed on first move and if two squares in front are both empty
        if (" ".equals(board[row + 1][col]) && " ".equals(board[row + 2][col]) && i <= 15) {        //if forwards 2 spots are occupied by an empty string " "  then it executes
            previous = board[row + 2][col];                                                   // sets temporary variable  to be  whatever is the spot going to
            board[row][col] = " ";                                                              // makes current loc an empty string
            board[row + 2][col] = "p";                                                                      // inflates new loc with pawn
            if (noBlackKingThreat() == true) {
                out = out + row + col + (row + 2) + col + previous;           // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
            }
            board[row][col] = "p";                                                            // resets the board with new piece location  (if the king is under threat)
            board[row + 2][col] = previous;                                                 //resets spot to the previous (if the king is under threat)
        }
    } catch (Exception e) { }
    try {                                                                               //PROMOTE NO CAP --case for a pawn promotion walking directly onto final rank with no capture
        if (" ".equals(board[7][col]) && i >= 47) {                                   //if forwards spot on final rank is occupied by an empty string " "  then it promotes
            previous = board[7][col];                                               // sets temporary variable  to be  whatever is the spot going to
            board[row][col] = " ";                                                          // makes current loc an empty string
            board[7][col] = "q";                                                         // inflates new loc with pawn
            if (noBlackKingThreat() == true) {
                out = out + col + col + previous + "q" + "p";         // if legal: col from (0),col to (1), capped piece (2), queen "q" (3), "p" (4)
            }
            board[row][col] = "p";                                                  // resets the board with new piece location  (if the king is under threat)
            board[7][col] = previous;                                         //resets end spot to the previous (if the king is under threat)
        }
    } catch (Exception e) { }

    try {                                                                 //PROMOTE AND CAPTURE --case for a pawn promotion where it captures a piece on the final rank
        for (int j = -1; j <= 1; j += 2) {                                    // j  = -1 and 1
            if (Character.isUpperCase(board[7][col + j].charAt(0)) && i >= 47) {      //if 2 diagonals spots are occupied by white player pieces (upper case) it executes
                previous = board[7][col + j];                                   // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                   // makes current loc an empty string
                board[row + 1][col + j] = "q";                                                 // inflates new loc with pawn
                if (noBlackKingThreat() == true) {
                    out = out + col + (col + j) + previous + "q" + "p";        // if legal move outputs this string "out" to the makeMove function  in format: col from (0),col to (1), capped piece (2), queen "q" (3), "p" (4)
                }
                board[row][col] = "p";                                              // resets the board with new piece location  (if the king is under threat)
                board[row + 1][col + j] = previous;                             //resets spot to the previous (if the king is under threat)
            }
        }
    } catch (Exception e) { }
    try {                                                                                //PROMOTE AND CAPTURE on the first file ... this should be included in the above promote and cap logic but for some reason this specific move was unable to execute on the first file, I could not figure out the error so this is my fix
        int j = 1;                                        // j  =  -1  used to check columns to left and right of the pawn
        if (Character.isUpperCase(board[row+1][col + j].charAt(0)) && i == 48) {       //if diagonal spot for capture is occupied by a black piece (lower case letter) which can be captured then it executes
            previous = board[row + 1][1];                                           // sets temporary variable  to be  whatever is the spot going to
            board[row][col] = " ";                                                             // makes current loc an empty string
            board[row + 1][col + j] = "p";                                                         // inflates new loc with pawn
            if (noBlackKingThreat() == true) {
                out = out + "0" + "1" + previous + "q" + "p";                  // if it is a legal move  outputs this string "out" to the makeMove function  in format: col from (0),col to (1), capped piece (2), queen "q" (3), "p" (4)
            }
            board[row][col] = "p";                                                  // resets the board with new piece location  (if the king is under threat)
            board[row + 1][col + j] = previous;                                     //resets spot to the previous (if the king is under threat)
        }
    } catch (Exception e) {}
    return out;
}


public static String possWhiteKnight(int i) {                    // checks all of the possible moves for white knights.
    String out = " ", previous;
    int row = i/8, col = i%8;
    for (int j = -1; j <= 1; j += 2) {                                                       // j is -1 or 1
        for (int k = -1; k <= 1; k += 2) {                                                        // k is -1 or 1
            try {
                if (Character.isLowerCase(board[row + j][col + k*2].charAt(0)) || " ".equals(board[row + j][col + k*2])) {   //if row increse/decrease by 1 and col increase/decrease by 2 and spot goes to is black (lowercase) or empty " " it executes
                    previous = board[row + j][col + k*2];                                         // sets temporary variable  to be  whatever is the spot going to
                    board[row][col] = " ";                                                          // makes current loc an empty string
                    board[row + j][col + k*2] = "N";                                                   // inflates new loc with knight
                    if (noWhiteKingThreat() == true) {
                        out = out + row + col + (row + j) + (col + k*2) + previous;           // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                    }
                    board[row][col] = "N";                                              // resets the board with new piece location  (if the king is under threat)
                    board[row + j][col + k*2] = previous;                           //resets spot to the previous (if the king is under threat)
                }
            } catch (Exception e) { }
            try {
                if (Character.isLowerCase(board[row + j*2][col + k].charAt(0)) || " ".equals(board[row + j*2][col + k])) {           //if row increse/decrease by 2 and col increase/decrease by 1 and spot goes to is black (lowercase) or empty " " it executes
                    previous = board[row + j*2][col + k];                                     // sets temporary variable  to be  whatever is the spot going to
                    board[row][col] = " ";                                                      // makes current loc an empty string
                    board[row + j*2][col + k] = "N";                                             // inflates new loc with knight
                    if (noWhiteKingThreat() == true) {
                        out = out + row + col + (row + j*2) + (col + k) + previous;               // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                    }
                    board[row][col] = "N";                                                                  // resets the board with new piece location  (if the king is under threat)
                    board[row + j*2][col + k] = previous;                                                   //resets spot to the previous (if the king is under threat)
                }
            } catch (Exception e) { }

        }
    }
    return out;
}




public static String possBlackKnight(int i) {                              //Checks all possible moves for the black knight
    String out = " ", previous;
    int row = i / 8, col = i % 8;
    for (int j = -1; j <= 1; j += 2) {                                                          // j is -1 or 1
        for (int k = -1; k <= 1; k += 2) {                                                       // K is -1 or 1
            try {
                if (Character.isUpperCase(board[row + j][col + k*2].charAt(0)) || " ".equals(board[row + j][col + k*2])) {           //if row increse/decrease by 1 and col increase/decrease by 2 and spot goes to is white (uppercase) or empty " " it executes
                    previous = board[row + j][col + k*2];                                                             // sets temporary variable  to be  whatever is the spot going to
                    board[row][col] = " ";                                                                              // makes current loc an empty string
                    board[row + j][col + k*2] = "n";                                                                 // inflates new loc with knight
                    if (noBlackKingThreat() == true) {
                        out = out + row + col + (row + j) + (col + k*2) + previous;           // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                    }
                    board[row][col] = "n";                                                          // resets the board with new piece location  (if the king is under threat)
                    board[row + j][col + k*2] = previous;                                       //resets spot to the previous (if the king is under threat)
                }
            } catch (Exception e) {}
            try {
                if (Character.isUpperCase(board[row + j*2][col + k].charAt(0)) || " ".equals(board[row + j*2][col + k])) {                //if row increse/decrease by 2 and col increase/decrease by 1 and spot goes to is white (uppercase) or empty " " it executes
                    previous = board[row + j*2][col + k];                                                     // sets temporary variable  to be  whatever is the spot going to
                    board[row][col] = " ";                                                                      // makes current loc an empty string
                    board[row + j*2][col + k] = "n";                                                             // inflates new loc with knight
                    if (noBlackKingThreat() == true) {
                        out = out + row + col + (row + j*2) + (col + k) + previous;           // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                    }
                    board[row][col] = "n";                                                          // resets the board with new piece location  (if the king is under threat)
                    board[row + j*2][col + k] = previous;                                           //resets spot to the previous (if the king is under threat)
                }
            } catch (Exception e) {}
        }
    }
    return out;
}


public static String possWhiteRook(int i) {                   // checks all of the possible moves for white rooks.
    String out = " ", previous;
    int row = i / 8, col = i % 8, foo = 1;
    for (int j = -1; j <= 1; j += 2) {                                              //j is = -1 or 1
        try {
            while (" ".equals(board[row][col + foo*j])) {                                                   // if vertical spot is empty it executes
                previous = board[row][col + foo*j];                                                        // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                                          // makes current loc an empty string
                board[row][col + foo*j] = "R";                                                                   // inflates new loc with Rook
                if (noWhiteKingThreat() == true) {
                    out = out + row + col + row + (col + foo*j) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "R";                                                                  // resets the board with new piece location  (if the king is under threat)
                board[row][col + foo*j] = previous;                                                         //resets spot to the previous (if the king is under threat)
                foo++;                                                                                      //keeps increasing spot until it hits a piece or reaches end of board
            }
            if (Character.isLowerCase(board[row][col + foo*j].charAt(0))) {                                         // if vertical spot is black it executes
                previous = board[row][col + foo*j];                                                              // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                                              // makes current loc an empty string
                board[row][col + foo*j] = "R";                                                                      // inflates new loc with Rook
                if (noWhiteKingThreat() == true) {
                    out = out + row + col + row + (col + foo*j) + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "R";                                                                      // resets the board with new piece location  (if the king is under threat)
                board[row][col + foo*j] = previous;                                                         //resets spot to the previous (if the king is under threat)
            }
        } catch (Exception e) {}
        foo = 1;                                                                                        ///resets our temporary variable that counts spots
        try {
            while (" ".equals(board[row + foo*j][col])) {                                               // if horizontal spot is empty it executes
                previous = board[row + foo*j][col];                                                           // sets temporary variable  to be  whatever is the spot going to
                board[row][col] = " ";                                                                                  // makes current loc an empty string
                board[row + foo*j][col] = "R";                                                                          // inflates new loc with Rook
                if (noWhiteKingThreat() == true) {
                    out = out + row + col + (row + foo*j) + col + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "R";                                                                       // resets the board with new piece location  (if the king is under threat)
                board[row + foo*j][col] = previous;                                                         //resets spot to the previous (if the king is under threat)
                foo++;                                                                                        //keeps increasing spot until it hits a piece or reaches end of board
            }
            if (Character.isLowerCase(board[row + foo*j][col].charAt(0))) {                                          // if horizontal spot is black piece  it executes
                previous = board[row + foo*j][col];                                                          // sets the temporary variable  to be the spot going to
                board[row][col] = " ";                                                                          // makes current loc an empty string
                board[row + foo*j][col] = "R";                                                                  // inflates new loc with Rook
                if (noWhiteKingThreat() == true) {
                    out = out + row + col + (row + foo*j) + col + previous;                                          // if legal: row from (0), col from (1) , row to (2) , col to (3) , captured piece or empty string(4)
                }
                board[row][col] = "R";                                                                          // resets the board with new piece location  (if the king is under threat)
                board[row + foo*j][col] = previous;                                                         //resets spot to the previous (if the king is under threat)
            }
        } catch (Exception e) { }
        foo = 1;
    }
    return out;
}
