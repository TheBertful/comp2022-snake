import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.Random;
public class Food
{
    private String food = "images/fries.png";
    
    private int x;
    private int y;
    private int w;
    private int h;
    private Image image;
    public Food(){
        Random rand = new Random();
        this.w = 50;
        this.h = 50;
        this.x = rand.nextInt(14)*50 + w;
        this.y = rand.nextInt(10)*50 + h;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(food));
        image = ii.getImage();
    }
    
    public void setPosition(){
        Random rand = new Random();
        this.x = rand.nextInt(15)*50 + w;
        this.y = rand.nextInt(11)*50 + h;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getW(){
        return this.w;
    }
    
    public int getH(){
        return this.h;
    }
    
    public Image getImage(){
        return this.image;
    }   
}
