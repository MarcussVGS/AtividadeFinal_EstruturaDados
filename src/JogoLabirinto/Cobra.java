package JogoLabirinto;
//@author Marcus Machine
import java.util.Stack;


public class Cobra {
    private Stack<Coordenada> pilhaCaminho;
    
    public Cobra(){
        pilhaCaminho = new Stack<>();
    }
    
    public boolean Caminho(Coordenada coord){
        //teste adicionar coordenadas
        pilhaCaminho.push(coord);
        return true;
    }
    
    public Coordenada topo(){
        if (!pilhaCaminho.isEmpty() ){
            return pilhaCaminho.peek() ;
        } else {
            return null; }
    }
    
    public int tamanho(){
        return pilhaCaminho.size();
    }
    
    public String imprimirCaminho() {
        String dados = "Conteudo da Pilha: ";
        for (Coordenada c : pilhaCaminho) {
            dados += "\n" + c;
        }
        return dados;
    }
    
    
    
}
