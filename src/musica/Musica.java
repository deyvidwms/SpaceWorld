
package musica;

import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Musica extends Thread{

    private Player play;
    private boolean pl;

    /**
     * @return the play
     */
    public Player getPlay() {
        return play;
    }

    /**
     * @param play the play to set
     */
    public void setPlay(Player play) {
        this.play = play;
    }

    /**
     * @return the pl
     */
    public boolean isPl() {
        return pl;
    }

    /**
     * @param pl the pl to set
     */
    public void setPl(boolean pl) {
        this.pl = pl;
    }
    
    @Override
    public void run() {
        try {
            while(true){
                InputStream input = this.getClass().getResourceAsStream("/soundtrack/silverland.mp3");
                play = new Player(input);
                play.play();
            }
        } catch (JavaLayerException ex) {
            System.out.println(ex);//Logger.getLogger(telaOpcao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
