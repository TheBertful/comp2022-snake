import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends JPanel
{
    private String snake = "images/head.png";
    
    private Snake proximo;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int w;
    private int h;
    private Image image;
    private int index;
    private String direcao = "parado";
    
    public Snake() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(snake));
        image = ii.getImage();
        x = 40;
        y = 60;
    }
    
    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public Snake getProximo(){
        return this.proximo;
    }
    
    public void setProximo(Snake proximo){
        this.proximo = proximo;
    }
    
    public void setX(int x) {
        this.x += x;
    }
    
    public void setY(int y) {
        this.y += y;
    }    
    
    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

}
