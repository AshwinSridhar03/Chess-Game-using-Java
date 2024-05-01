for (int i = 0; i < 64; i ++){                        // This switch searches through Image Array of Chess Pieces downloaded from Wikipedia and returns coordinates of piece
    int j = -1, k = -1;
    switch (ChessGame.board[i / 8][i % 8]) {
        case "K":                           //White king piece image
            j = 0;
            k = 0;
            break;
        case "k":                            //Black king piece image
            j = 0;
            k = 1;
            break;
        case "Q":                            //White Queen piece image
            j = 1;
            k = 0;
            break;
        case "q":                           //Black queen piece image
            j = 1;
            k = 1;
            break;
        case "R":                            //White Rook piece image
            j = 2;
            k = 0;
            break;
        case "r":                               //Black rook piece image
            j = 2;
            k = 1;
            break;
        case "B":                                //White Bishop piece image
            j = 3;
            k = 0;
            break;
        case "b":                               //Black bishop piece image
            j = 3;
            k = 1;
            break;
        case "N":                                //White Knight piece image   **note: use N not K
            j = 4;
            k = 0;
            break;
        case "n":                                   //Black Knight piece image
            j = 4;
            k = 1;
            break;
        case "P":                                    //White pawn piece image
            j = 5;
            k = 0;
            break;
        case "p":                                   ////Black pawn piece image
            j = 5;
            k = 1;
            break;
    }
    if (j!= -1 && k!= -1){
        g.drawImage(chessPieceArray, (i%8)*tile, (i/8)*tile, (i%8 + 1)*tile,(i/8 + 1)*tile,j*64, k*64,(j+1)*64,(k+1)*64,this) ;    // draws the specific piece that is called upon from the array
    }

}

}
