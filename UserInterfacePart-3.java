
@Override
public void mousePressed(MouseEvent e) {
    if(e.getX() < 8*tile && e.getY() < 8*tile){                             // gets the X and Y coordinates of where you click
        //if inside the board
        X = e.getX();
        Y = e.getY();
        repaint();                                                  //repaints the board
    }
}

@Override
public void mouseReleased(MouseEvent e) {                       // You drag your piece to a tile and drop it on.  When your mouse releases this happens
    if(e.getX() < 8*tile && e.getY() < 8*tile){             //only allows if your mouse is within the frame of the board
        newX = e.getX();
        newY = e.getY();
        String dragpiece ;
        if(e.getButton() == MouseEvent.BUTTON1){                  //when the left mouse button is clicked down
            if(newY/tile == 0 && Y/tile == 1 && "P".equals(ChessGame.board[Y/tile][X/tile])) {                           // Case for white pawn promotion -> changes to a queen  (going from rank 1 to 0)
                dragpiece = "" + X/tile + newX/tile + ChessGame.board[newY/tile][newX/tile] +"Q" +"P";
            }
            else if(newY/tile == 7 && Y/tile == 6 && "p".equals(ChessGame.board[Y/tile][X/tile])) {                      //case for black pawn promotion  ( going from rank 6 to 7)
                dragpiece = "" + X/tile + newX/tile + ChessGame.board[newY/tile][newX/tile] +"q" +"p";
            }
            else{
                dragpiece = "" + Y/tile + X/tile + newY/tile + newX/tile + ChessGame.board[newY/tile][newX/tile];               // case for all other moves
            }

            if(ChessGame.possMoves().replaceAll(dragpiece," ").length() < ChessGame.possMoves().length()){
                ChessGame.movePiece(dragpiece);
            }

        }
        repaint();                                                      // repaints the board
    }
}



//even though we don't use these methods we still need them to avoid an error
@Override
public void mouseEntered(MouseEvent e) { }

@Override
public void mouseExited(MouseEvent e) { }

@Override
public void mouseDragged(MouseEvent e) { }

@Override
public void mouseMoved(MouseEvent e) { }

@Override
public void mouseClicked(MouseEvent e) { }
}