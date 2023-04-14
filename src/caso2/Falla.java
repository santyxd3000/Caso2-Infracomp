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

        HashMap<Integer, Integer> bytes = memReal.getBytesAsociados();
        for (int i = 0; i < bytes.size(); i++) {
            int valor = bytes.get(i);
            valor = valor/10;
            bytes.put(i, valor);

        }

    }

    public void resetLRU(int posicion){

        HashMap<Integer, Integer> bytes = memReal.getBytesAsociados();
        int valori = bytes.get(posicion);
        valori = valori + 10000000;
        bytes.put(posicion, valori);
        fallas = fallas + 1;
        System.out.println("Fallas: " + fallas);


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
