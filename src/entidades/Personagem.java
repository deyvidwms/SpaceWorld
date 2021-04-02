
package entidades;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class Personagem extends JLabel{

    private int x = 330, y = 480;
    private int dx = 330, dy = 480;
    private int largura = 29, altura = 37;
    private boolean visivel = true;
    private ImageIcon personagem;
    private int contTiros = 0;
    
    public ArrayList<Tiro> tiros = new ArrayList();

    //private Tiro tiro;
    
    
    public Personagem() {
        editarComponentes();
    }

    private void editarComponentes(){
        personagem = new ImageIcon(getClass().getResource("/Imagens/Nave.png"));
        setIcon(personagem);
        setBounds(x, y, getLargura(), getAltura());
        setVisible(visivel);
        //setBorder(new BevelBorder(1));
    }
    
    public void addMovimento(){
        this.x = dx;
        this.y = dy;
    }
    
    public void atirar(){
        if(tiros.size()<3){
            Tiro ti = new Tiro(x, y, largura, altura);
            tiros.add(ti);
        }
  
    }
    //Tecla pressionada
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            dx -= 10;
            if(dx < 0){
               dx = 0;
            }
        }
       /* if(ke.getKeyCode() == KeyEvent.VK_UP){
            dy -= 10;
            if(dy < -10){
                dy = -10;
            }
        }*/
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            dx += 10;
            if(dx > 683){
                dx = 683;
            }
        }
       /* if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            dy += 10;
            if(dy > 480){
                dy = 480;
            }
        }*/
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            atirar();
        }
        //System.out.println("X - "+x+" Y - "+y);
        setBounds(x, y, getLargura(), getAltura());

    }            

    //Solta tecla
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            dx -= 0;
        }
        if(ke.getKeyCode() == KeyEvent.VK_UP){
            dy -= 0;
        }
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            dx += 0;
        }
        if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            dy += 0;
        }
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the dx
     */
    public int getDx() {
        return dx;
    }

    /**
     * @param dx the dx to set
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * @return the dy
     */
    public int getDy() {
        return dy;
    }

    /**
     * @param dy the dy to set
     */
    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * @return the visivel
     */
    public boolean isVisivel() {
        return visivel;
    }

    /**
     * @param visivel the visivel to set
     */
    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    /**
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the tiros
     */
    public ArrayList<Tiro> getTiros() {
        return tiros;
    }

    /**
     * @param tiros the tiros to set
     */
    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }
    
    
}
