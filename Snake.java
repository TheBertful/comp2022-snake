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
    private String head = "images/headL.png";
    
    private String corpo = "images/body.png";
    private Snake proximo;
    private Snake anterior;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int w;
    private int h;
    private Image image;
    private String direcao = "parado";
    
    public Snake() {        
        ImageIcon ii;
        switch(direcao){
            case "direita":
                head = "images/headD.png";
                break;
            case "esquerda":
                head = "images/headL.png";
                break;
            case "cima":
                head = "images/headU.png";
                break;
            case "baixo":
                head = "images/headD.png";
                break;
            default:
                head = "images/headL.png";
                break;
        }
        ii= new ImageIcon(this.getClass().getResource(head));
        image = ii.getImage();
        x = 700;
        y = 500;
        w = 50;
        h = 50;
    }
    
    public Snake(Snake s){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(corpo));
        image = ii.getImage();
        x = s.getX() + 40;
        y = s.getY() + 40;
        w = 40;
        h = 40;
        s.setProximo(this);
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
    
    public void setImage(){
        ImageIcon ii;
        switch(direcao){
            case "direita":
                head = "images/headD.png";
                break;
            case "esquerda":
                head = "images/headL.png";
                break;
            case "cima":
                head = "images/headU.png";
                break;
            case "baixo":
                head = "images/headD.png";
                break;
            default:
                head = "images/headL.png";
                break;
        }
        ii= new ImageIcon(this.getClass().getResource(head));        
        image = ii.getImage();
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
    
    public int getW(){
        return this.w;
    }
    
    public int getH(){
        return this.h;
    }
    
    public void setAnterior(Snake anterior){
        this.anterior = anterior;
    }
    
    public Snake getAnterior(){
        return this.anterior;
    }

}
