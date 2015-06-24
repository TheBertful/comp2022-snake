import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Score score;
    
    private boolean isPlaying = true;
    private Food food = new Food();
    
    private Fila fila = new Fila();
    private String direcao = "parado";
    private boolean gameOver = false;
    private boolean esperarMover;

    private Font font;
       
    public Board() {

        addKeyListener(new TAdapter());
        
        setFocusable(true);        
        setDoubleBuffered(true);
        setBackground(Color.WHITE);

        score = new Score();
        add(score);
        
        Snake snake = fila.getHead();
        while(snake.getProximo() != null){
            add(snake);
            snake = snake.getProximo();        
        }
        
        timer = new Timer(5, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        
        score.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        
        
        if(isPlaying){
            Snake cabeca = fila.getHead();
            if(cabeca.getProximo() == null){
                g2d.drawImage(cabeca.getImage(), cabeca.getX(), cabeca.getY(), this);
                g2d.drawImage(food.getImage(), food.getX(), food.getY(), this);
            }
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }


    public void paintIntro(Graphics g) {
        if(isPlaying){
            isPlaying = false;
            Graphics2D g2d = (Graphics2D) g;
            try{
                File file = new File("fonts/VT323-Regular.ttf");
                font = Font.createFont(Font.TRUETYPE_FONT, file);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
                font = font.deriveFont(Font.PLAIN,40);
                g2d.setFont(font);
            }catch (Exception e){
                System.out.println(e.toString());
            }   
            g2d.drawString("S N A K E: " + this.score, 300, 300);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            Thread.sleep(75);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        repaint();
        if(!gameOver){
            mover();
        } else {
            JOptionPane.showMessageDialog (null, "Game over!\n Your score was: " + score.getScore());
            System.exit(0);
        }
    }
    
    public void mover() {
        switch (direcao) {
            case "esquerda":
                fila.getHead().setX(-25);
                fila.getHead().setY(0);                
                if(comeu()) score.addScore(10);
                if (fila.getHead().getX() < 0) gameOver = true;
                esperarMover = false;
                break;
                
            case "direita":
                fila.getHead().setX(25);
                fila.getHead().setY(0);
                if(comeu()) score.addScore(10);
                if (fila.getHead().getX() > (800 - fila.getHead().getW())) gameOver = true;
                esperarMover = false;
                break;
                
            case "cima":
                fila.getHead().setX(0);
                fila.getHead().setY(-25);
                if(comeu()) score.addScore(10);
                if (fila.getHead().getY() < 0) gameOver = true;
                esperarMover = false;
                break;
                
            case "baixo":
                fila.getHead().setX(0);
                fila.getHead().setY(25);
                if(comeu()) score.addScore(10);
                if (fila.getHead().getY() > (600 - fila.getHead().getH())) gameOver = true;
                esperarMover = false;
                break;
                
            case "parado":
                fila.getHead().setX(0);
                fila.getHead().setY(0);
                break;
        }
    }
    
    public boolean comeu(){
        if((fila.getHead().getY() + fila.getHead().getH()/2 <= food.getY() + food.getH()/2 && fila.getHead().getY() - fila.getHead().getH()/2 >= food.getY() - food.getH()/2) &&
            fila.getHead().getX() + fila.getHead().getW()/2 <= food.getX() + food.getW()/2 && fila.getHead().getX() - fila.getHead().getW()/2 >= food.getX() - food.getW()/2){
            food.setPosition();
            return true;
        }else{
            return false;
        }
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            
            // Obtém o código da tecla
            int key =  e.getKeyCode();

            switch (key){
                case KeyEvent.VK_ENTER:
                    break;
                    
                case KeyEvent.VK_LEFT:
                    if(!(direcao.equals("direita")) && !esperarMover){
                        direcao = "esquerda";
                        esperarMover=true;
                    }                    
                    break;
                    
                case KeyEvent.VK_RIGHT:
                    if(!(direcao.equals("esquerda")) && !esperarMover){
                        direcao = "direita";
                        esperarMover=true;
                    }
                    break;
                    
                case KeyEvent.VK_UP:
                    if(!(direcao.equals("baixo")) && !esperarMover){
                        direcao = "cima";
                        esperarMover=true;
                    }
                    break;
                    
                case KeyEvent.VK_DOWN:
                    if(!(direcao.equals("cima")) && !esperarMover){
                        direcao = "baixo";
                        esperarMover=true;
                    }
                    break;
            }
            
        }
    }
    
}