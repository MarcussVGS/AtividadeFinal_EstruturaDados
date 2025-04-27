package JogoLabirinto;
//@author Marcus Machine
import java.util.Stack;


public class Cobra {
    Stack<Coordenada> pilhaCaminho = new Stack<>();
    
    public Cobra(){
    }
    
    public boolean Caminho (int linha, int coluna){
        //teste adicionar coordenadas
        pilhaCaminho.push(new Coordenada(linha, coluna) );
        return true;
    }
    
    public boolean printCaminho (){
        while (!pilhaCaminho.empty() ){
            System.out.println("Caminho:"); 
            System.out.println("\n" + pilhaCaminho.get(0) );
        }
        return true;
    }
    
}
