/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projeto.escalonadoresso;
import java.util.LinkedList;
/**
 *
 * @author LucianoNeto
 */
public class ShortJobFirst {

    
    private long mediaEspera,mediaExecucao,esperaTotal,execucaoTotal;
    
    public void execute(LinkedList<Processo> processList) {
        
        
        System.out.println("--------Short Job First---------");
        
        ListaDeProcessos pipelineProcessos = new ListaDeProcessos(processList);
        pipelineProcessos.ordenarLista(1);
        //listinha.remove();
        for(Processo processo:processList){//Entra na Linked list e passa do primeiro ao último objeto
            processo.run();
            tempoEsperaTotal(processo);
            tempoExecucaoTotal(processo);
            
            System.out.println("\nid:"+processo.getId() + "\ntempo de execução: "+processo.getTempoExec()+" ms");
            
        }
        this.mediaEspera=(this.esperaTotal)/processList.size();
        this.mediaExecucao=(this.execucaoTotal)/processList.size();
        System.out.println("\nmedia de espera:"+this.getMediaEspera() + " s\ntempo medio de execução: "+this.getMediaExecucao()+" ms");
    }
    
    public void tempoEsperaTotal(Processo processo){
        this.esperaTotal = this.esperaTotal + processo.getTempo();
        
    }
    public void tempoExecucaoTotal(Processo processo){
        this.execucaoTotal = this.execucaoTotal + processo.getTempoExec();
    }
    
    
    
    
    public long getMediaEspera() {
        return mediaEspera;
    }

    public long getMediaExecucao() {
        return mediaExecucao;
    }

    public long getEsperaTotal() {
        return esperaTotal;
    }

    public long getExecucaoTotal() {
        return execucaoTotal;
    }
}
