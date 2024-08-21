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
    private Processo processoAnterior=null;
    long esperaProcesso = 0;
    
    public void execute(LinkedList<Processo> processList) throws InterruptedException {
        
        
        System.out.println("-------- Round Robin ---------");
        System.out.println("\n-------- Tamanho da lista: "+processList.size()+" --------\n");
        ListaDeProcessos pipelineProcessos = new ListaDeProcessos(processList);
        pipelineProcessos.ordenarLista(2);
        
        
        long esperaProcesso = 0;
        
        int tamanhoDaLista=processList.size();
        
        for(Processo processo:processList){
            esperaProcesso = esperaProcesso+ processo.getTempo();
  
        }
        
        this.mediaEspera=esperaProcesso/processList.size();
        
        System.out.println("        |Média de espera: "+getMediaEspera()+"|\n");
        
        int i = 1;
        System.out.println("\n"+i+"º \"round\" ");
        /*
        
        WHILE TA MEI QUEBRADO, TEMPO DE EXEC AINDA ESTA ERRADO E OS i's rounds
        
        */
        
        
        while(!processList.isEmpty()){
            
            
            
            
            for(Processo processo:processList){//Entra na Linked list e passa do primeiro ao último objeto
                
                if( (this.processoAnterior != null) &&(this.processoAnterior.getTempo() ==0 )){
                        
                    processList.remove(this.processoAnterior);
                    
                }
                if(!processList.isEmpty()){
                    System.out.println(
                        "\n    |Processo anterior: "+this.processoAnterior+
                        "\n    |Tempo esperando até executar: "+getEsperaTotal()+
                        "\n    |Processo atual: "+processo.getId()
                        
                        );           
                
                
                
                
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

                    tempoEsperaTotal(processo);
                    tempoExecucaoTotal(processo);
                    System.out.println("tempo de execução: "+processo.getTempoExec()+" ms");
                }else{
                    System.out.println("Lista vazia");
                    break;
                }
                
                
                if(processList.size()>1){
                System.out.println("\n-------- Tamanho da lista: "+processList.size()+" --------");
                
                }

                
                }
                i++;
                System.out.println("\n"+i+"º \"round\" ");
                
            }
        
        
        this.mediaExecucao=(this.execucaoTotal)/tamanhoDaLista;
       
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
