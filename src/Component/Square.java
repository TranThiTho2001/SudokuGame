
package Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Square extends javax.swing.JButton{
    private int x; 
    private int y;
    
    public Square(){
        x = 0; 
        y = 0;
    }
    public Square(int ToaDoX, int ToaDoY){
        x = ToaDoX;
        y = ToaDoY;
        setPreferredSize(new Dimension(65, 65));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 28));
        setOpaque(true);
        setForeground(Color.black);
    }
    
    // Tra ve toa do diem x
    public int getCoordinateX(){
        return x;
    }
    
    //TRa ve toa do diem Y
    public int getCoordinateY(){
        return y;
    }
    
    //Dien so cho o vuong
    public void setnumber(String text){
        setText(text);
    }

}
