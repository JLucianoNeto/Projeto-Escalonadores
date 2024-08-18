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
public class RoundRobin {
    private long mediaEspera,mediaExecucao,esperaTotal,execucaoTotal;
    private Processo processoAnterior;
    
    
    public void execute(LinkedList<Processo> processList) throws InterruptedException {
        
        
        System.out.println("-------- Round Robin ---------");
        System.out.println("\n-------- Tamanho da lista: "+processList.size()+" --------\n");
        ListaDeProcessos pipelineProcessos = new ListaDeProcessos(processList);
        pipelineProcessos.ordenarLista(2);
        
        
        
        for(Processo processo:processList){
            this.esperaTotal = this.esperaTotal+ processo.getTempo();
            this.execucaoTotal = this.execucaoTotal+ processo.getTempo();
            
        }
        
        this.mediaEspera=(this.esperaTotal)/processList.size();
        this.mediaExecucao=(this.execucaoTotal)/processList.size();
        
         
        while(!processList.isEmpty()){
            
            for(Processo processo:processList){//Entra na Linked list e passa do primeiro ao último objeto
                
                
                System.out.println("Processo anterior:"+this.processoAnterior);
                
                if( (this.processoAnterior != null) &&(this.processoAnterior.getTempo() ==0 )){
                        
                    processList.remove(this.processoAnterior);
                    
                }
                System.out.println("\nLista: "+processList);
                
                long tempoAuxiliar = processo.getTempo()-this.mediaEspera; 
                
                
                
                if(tempoAuxiliar >=0 ){
                    processo.setTempo((int)this.mediaEspera);
                    System.out.println("Rodando : "+processo.toString());
                
                    processo.run();
                    processo.setTempo((int)tempoAuxiliar);
                    this.processoAnterior=processo;
                    
                }else if(((int)tempoAuxiliar <0)&&(processo.getTempo()>0)){
                    System.out.println("Rodando : "+processo.toString());
                
                    processo.run();
                    //processList.remove();
                    
                    //processo.setTempo((int)tempoAuxiliar);
                    this.processoAnterior=processo;
                    this.processoAnterior.setTempo(0);
                    
                    
                }
                
            }
            if(processList.size()>1){
            System.out.println("\n-------- Tamanho da lista: "+processList.size()+" --------");
            }
           }
        
        
       
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
