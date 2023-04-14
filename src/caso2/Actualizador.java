package caso2;

import java.util.Collection;
import java.util.HashMap;

public class Actualizador extends Thread{

    private MemoriaReal memReal;
    private TablaPagina tablaPagina;
    private Falla falla;
    private MemoriaVirtual memVirtual;
    private Integer poner = -1;
    private int borra;
    private boolean activo = true;
    private int menor = 1;

    public void setActivo(){
        this.activo = false;
    }


    public Actualizador(MemoriaReal memReal, TablaPagina tablaPagina, Falla falla, MemoriaVirtual memVirtual) {
        this.memReal = memReal;
        this.tablaPagina = tablaPagina;
        this.falla = falla;
        this.memVirtual = memVirtual;

    }
    

    public int getBorrar(MemoriaReal memReal){
        HashMap<Integer, Integer> bytes = memReal.getBytesAsociados();
        //System.out.println(bytes + "bytes");
        Collection<Integer> valores = bytes.values();
        int pos=0;
        int i = 0;
        for (Integer valor : valores) {
            if (i == 0){
                menor = valor;
            }
            if (valor < menor) {
                //System.out.println(110);
                menor = valor;
                pos = i;
            }
            i++;
        }
        System.out.println(pos);
        return pos;
    }

    public void setPoner(Integer pag){
        this.poner = pag;
    }



    public void run() {

        
            while (activo){
                
                if (poner != -1) {

                    borra = getBorrar(memReal); //obtiene pos a borrar

                    int quitar = memReal.getRam().get(borra); //obtiene pagina a borrar
                    memReal.getRam().put(borra, poner); //actualiza ram
                    //System.out.println(memReal.getRam() + "rma");

                    tablaPagina.actualizarTabla(poner, borra); //actualiza tabla de paginas
                    tablaPagina.actualizarTabla(quitar, null); //actualiza tabla de paginas
                    falla.resetLRU(borra); //resetea LRU
                    poner = -1; //resetea poner
                    
                }

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        
    }
    
}
