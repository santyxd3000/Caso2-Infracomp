package caso2;

import java.util.HashMap;

public class Falla extends Thread {

    private int fallas;
    private MemoriaReal memReal;
    private boolean activo = true;

    public void setActivo(){
        this.activo = false;
    }


    public Falla(MemoriaReal memReal) {
        this.memReal = memReal;
        this.fallas = 0;
    }

    public void LRU() {

        HashMap<Integer, Long> bytes = memReal.getBytesAsociados();
        for (int i = 0; i < bytes.size(); i++) {
            long valor = bytes.get(i);
            valor = valor/10;
            bytes.put(i, valor);

        }

    }

    public void resetLRU(int posicion){

        HashMap<Integer, Long> bytes = memReal.getBytesAsociados();
        long valori = bytes.get(posicion);
        long valorl = valori + 10000000000000L;
        bytes.put(posicion, valorl);
        fallas = fallas + 1;
        System.out.println("Fallas: " + fallas);


    }

    public int getFallas() {
        return fallas;
    }

    public void run() {

        while (activo) {

            try {
                LRU();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    
}
