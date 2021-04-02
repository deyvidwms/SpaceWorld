package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class Tiro {
    private int x,y;
    private int altura = 10,largura = 11;
    private int dy;
    private boolean visivel;
    private ImageIcon iconTiro;
    public JLabel j =  new JLabel();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
    
    public Tiro(int x, int y, int largura, int altura){
        iconTiro = new ImageIcon(getClass().getResource("/Imagens/tiro.png"));
        j.setIcon(iconTiro);
        this.x = x+(largura/2)-5;
        this.y = y;
        this.dy = 0;
        this.visivel = true;
        this.j.setBounds(this.x, this.y, this.largura, this.altura);
        //j.setBorder(new BevelBorder(1));
    }
    
    
}

