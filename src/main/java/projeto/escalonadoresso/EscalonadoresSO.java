/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package projeto.escalonadoresso;
import java.util.LinkedList;
/**
 *
 * @author LucianoNeto
 */
public class EscalonadoresSO {

    public static void main(String[] args) throws InterruptedException {
        // Esse é o Arquivo principal onde vai ter as classes em funcionamento
        System.out.println("Uso de memoria inicial = "+MedirUsos.printMemoryUsage());
        
        Processo p1 = new Processo(1,6,1);
        Processo p2 = new Processo(2,3,4);
        Processo p3 = new Processo(3,6,6);
        Processo p4 = new Processo(4,4,3);
        Processo p5 = new Processo(5,2,2);
        Processo p6 = new Processo(6,2,9);
        Processo p7 = new Processo(7,2,12);
        Processo p8 = new Processo(8,2,4);
        Processo p9 = new Processo(9,2,6);
        Processo p10 = new Processo(10,2,8);
        Processo p11 = new Processo(11,3,1);
        Processo p12 = new Processo(12,5,2);
        Processo p13 = new Processo(13,2,5); 
        Processo p14 = new Processo(14,4,7); 
        Processo p15 = new Processo(15,5,5); 
        Processo p16 = new Processo(16,1,7); 
        Processo p17 = new Processo(17,6,4); 
        Processo p18 = new Processo(18,7,2); 
        Processo p19 = new Processo(19,3,2);
        Processo p20 = new Processo(20,6,4); 
        Processo p21 = new Processo(21,7,2); 
        Processo p22 = new Processo(22,3,2); 
        Processo p23 = new Processo(23,7,2);
        Processo p24 = new Processo(24,8,11);
        Processo p25 = new Processo(25,1,4);
        
        LinkedList<Processo> listinha = new LinkedList();
        
        listinha.add(p1);
        listinha.add(p3);
        listinha.add(p2);
        listinha.add(p4);
        listinha.add(p5);
        listinha.add(p6);
        listinha.add(p7);
        listinha.add(p8);
        listinha.add(p9);
        listinha.add(p10);
        listinha.add(p11);
        listinha.add(p12);
        listinha.add(p13);
        listinha.add(p14);
        listinha.add(p15);
        listinha.add(p16);
        listinha.add(p17);
        listinha.add(p18);
        listinha.add(p19);
        listinha.add(p20);
        listinha.add(p21);
        listinha.add(p22);
        listinha.add(p23);
        listinha.add(p24);
        listinha.add(p25);
        
        
        ShortJobFirst shortJF = new ShortJobFirst();
        //RoundRobin pipeRB = new RoundRobin();
        
        MedirUsos.printProcessorUsage();
        
        String usoMemoriaSJF = MedirUsos.printMemoryUsage();
        System.out.println("Uso de memoria antes do SJF = "+usoMemoriaSJF);
        
        shortJF.execute(listinha);
        //pipeRB.execute(listinha);
        
        String usoMemorialSJFFinal = MedirUsos.printMemoryUsage();
        System.out.println("\nUso de memoria depois do SJF= "+usoMemorialSJFFinal);
        
        MedirUsos.printProcessorUsage();
                
        //PriorityFirst escalonadorPF = new PriorityFirst();
        //escalonadorPF.execute(listinha);
        
        
        
    }
}
