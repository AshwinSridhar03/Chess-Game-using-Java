import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class UserInterface extends JPanel implements MouseListener, MouseMotionListener {       //This class contains our GUI and everything the user needs to interface with the chess board
    static int tile = 58, X, Y, newX, newY;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);                        //need the paint component super class
        this.setBackground(Color.BLACK);                // sets the background to black. dont think its necessary because i made it non-resizable but jic
        this.addMouseListener(this);                //so user can use the mouse
        this.addMouseMotionListener(this);

        for ( int i  =0; i < 64; i += 2){
            setVisible(true);                                                               //makes visible
            setSize(900,900) ;                                                 // sets the size of the board
            g.setColor(new Color(45, 45, 45));                                            // sets the color for the lighter tiles ( a lightish green color)
            g.fillRect((i%8 + (i/8)%2)*tile, (i/8)*tile, tile, tile);                           //creates the light tiles (50% of the board)
            g.setColor(new Color(135, 135, 135));                                     //sets the color for the dark tiles ( reddish color)
            g.fillRect(((i+1)%8 - (i/8)%2)*tile, ((i+1)/8)*tile, tile, tile);                   //creates the dark tiles(other 50% of the board)
        }
        Image chessPieceArray = new ImageIcon("ChessPieces.jpg").getImage();    // Array of Chess icons from online
