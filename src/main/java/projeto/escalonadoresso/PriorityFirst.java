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
public class PriorityFirst {

    
    private long mediaEspera,mediaExecucao,esperaTotal,execucaoTotal;
    private Processo processoAnterior = null;

    public void execute(LinkedList<Processo> processList) {
        
        
        System.out.println("-------- Priority First ---------");
        
        ListaDeProcessos pipelineProcessos = new ListaDeProcessos(processList);
        pipelineProcessos.ordenarLista(2);
        //listinha.remove();
        for(Processo processo:processList){//Entra na Linked list e passa do primeiro ao último objeto

            System.out.println("id: "+processo.getId());
            
            if(this.processoAnterior != null){
                System.out.println("Tempo esperando para executar: "+getEsperaTotal());
                 
            }
            
            processo.run();
            tempoEsperaTotal(processo);
            tempoExecucaoTotal(processo);
            
            System.out.println("tempo de execução: "+processo.getTempoExec()+" ms");
            this.processoAnterior = processo;
        }

        this.mediaEspera=(this.esperaTotal)/processList.size();
        this.mediaExecucao=(this.execucaoTotal)/processList.size();
        
        System.out.println("------------------------------------------------------------------------");
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
