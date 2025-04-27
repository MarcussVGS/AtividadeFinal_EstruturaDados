package JogoLabirinto;
//@author Marcus Machine
import java.util.Stack;


public class Cobra {
    private Stack<Coordenada> pilhaCaminho;
    
    public Cobra(){
        pilhaCaminho = new Stack<>();
    }
    
    public boolean Passo(Coordenada coord){
        //teste adicionar coordenadas
        pilhaCaminho.push(coord);
        return true;
    }
    
    public Coordenada Topo(){
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
    
//Atributos,Coordenadas qual linha, qual coluna, qual matrix
    public boolean incurso (Coordenada aux, int linha, int coluna, int[][]matrix){
        if ( (aux.passoFrenteTeste(linha, coluna, matrix, this)) == true ){
            incurso(aux, linha, coluna+1, matrix);
        }
        return true;
    }
    

    
    
    
}
