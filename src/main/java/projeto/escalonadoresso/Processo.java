/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.escalonadoresso;

/**
 *
 * @author LucianoNeto
 */
public class Processo implements Comparable<Processo> {

    private int id, tempo, prioridade;
    private long tempoExec;

    int chaveOrdenacao; //Por padrão = 0 ordenar por id; 1 equivale a ordenar por tempo

    /*
    
    
    A chave de ordenação
    Serve para tipos de processos com semelhança
    sobre a ordenação da lista para uma tarefa
    
    por exemplo: preencher com 0 os processo de uma lista K
    significa dizer que a lista K será ordenada com base no id. E 
    portanto 1 ou outro valor assume que a lista K será ordenada
    pela variável tempo
    
    
     */
    public Processo(int id, int tempo, int prioridade) {
        this.id = id;
        this.tempo = tempo;
        this.prioridade = prioridade;
        this.tempoExec = 0;
        this.chaveOrdenacao = 0;
    }

    public void run() {

        long start = System.currentTimeMillis();
        try {
            Thread.sleep(this.tempo * 1000); // equivale ao valor de tempo em segundos 
        } catch (InterruptedException e) {
        }
        this.tempoExec = this.tempoExec + (System.currentTimeMillis() - start);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public long getTempoExec() {
        return tempoExec;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setChaveOrdenacao(int chaveOrdenacao) {
        this.chaveOrdenacao = chaveOrdenacao;
    }

    @Override
    public String toString() {
        return "Processo{" + "id=" + id + ", tempo=" + tempo + ", prioridade=" + prioridade + '}';
    }

    @Override
    public int compareTo(Processo o) {
        switch (this.chaveOrdenacao) {
            case 0:
                return Integer.compare(this.id, o.getId());//Comparando pelo tempo de execução para ordenação posterior
            case 1:
                return Integer.compare(this.tempo, o.getTempo());//Comparando pelo tempo de execução por padrão por hora
            case 2:
                return Integer.compare(this.prioridade, o.getPrioridade());//Comparando pela prioridade
            default:
                return Integer.compare(this.id, o.getId());//Comparando pelo id para ordenação posterior por padrão por hora
        }
        
        
        }
}
