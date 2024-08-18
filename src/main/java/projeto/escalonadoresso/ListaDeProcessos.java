/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.escalonadoresso;
import java.util.Collections;
import java.util.LinkedList;
/**
 *
 * @author LucianoNeto
 */
public class ListaDeProcessos{
    private LinkedList<Processo> lista;
    private boolean isSorted;
    
    public ListaDeProcessos(LinkedList<Processo> lista){
        this.lista = lista;
        this.isSorted = false;
    }
    
    public void ordenarLista(int chave){
        if(this.isSorted == false){
            trocarChaveOrdem(chave);
        }
        Collections.sort(this.lista);   
        this.isSorted = true;
    }
    public void trocarChaveOrdem(int chave){
      for(Processo processo:this.lista){//Entra na Linked list e passa do primeiro ao último objeto
        processo.setChaveOrdenacao(chave);
      }
    }
    
    public void inserirProcesso(Processo processo){
        this.isSorted = false;
        this.lista.add(processo);
    }

    
}
