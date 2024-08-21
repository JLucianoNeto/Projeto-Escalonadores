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
        
        for(Processo processo:processList){

            System.out.println("id: "+processo.getId());
            
            System.out.println("Tempo esperando até executar: "+getEsperaTotal());

            processo.run();
            
            
            System.out.println("Tempo de turn around: "+(processo.getTempoExec()+getEsperaTotal()  ));
            
            System.out.println("tempo de execução: "+processo.getTempoExec()+" ms\n");
            
            
            tempoExecucaoTotal(processo);
            tempoEsperaTotal(processo);
            
            
            this.processoAnterior = processo;
        }

        this.mediaEspera=(this.esperaTotal)/processList.size();
        this.mediaExecucao=(this.execucaoTotal)/processList.size();
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nmedia de espera:"+this.getMediaEspera() + " s\ntempo medio de execução: "+this.getMediaExecucao()+" ms");

    }
    
    public void tempoEsperaTotal(Processo processo){
        this.esperaTotal = this.esperaTotal + processo.getTempo()*1000; // vezes 1000 para estar em milisegundos
        
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
