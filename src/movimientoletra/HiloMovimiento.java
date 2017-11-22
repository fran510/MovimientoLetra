/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimientoletra;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class HiloMovimiento implements Runnable{
    PanelLetra p;
    
    public HiloMovimiento(PanelLetra p){
        this.p=p;
    }
    
    @Override
    public void run() {
        while(!p.interrumpir){
            if(p.cont<p.getWidth()-25 &&p.avanzar==true){
                p.cont=p.cont+5;
                //if(p.cont==p.getWidth()-25)p.avanzar=false;
            }else{
                p.avanzar=false;
                p.cont=p.cont-5;
                if(p.cont==0)p.avanzar=true;
            }
            p.repaint();
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Thread.currentThread().interrupt();
    }
}
