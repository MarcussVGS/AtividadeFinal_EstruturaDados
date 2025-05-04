package JogoLabirinto;
//@author Marcus Machine
import java.util.Stack;


public class Cobra {
    private Stack<Coordenada> pilhaCaminho;
    
    public Cobra(){
        pilhaCaminho = new Stack<>();
    }
    
    public boolean dentroLabirinto (int linha, int coluna, int[][]matrix){
        if ( (0 > linha) || (matrix.length < linha) ){ return false;}
        if ( (0 > coluna) || (matrix[linha].length < coluna) ){ return false;}
        return true;
    }
    
    public boolean salvarPasso(Coordenada coord){
        //teste adicionar coordenadas
        pilhaCaminho.push(coord);
        return true;
    }
    
    public Coordenada exibirTopo(){
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
    
    // aqui usamos um metodo que carrega 3 informaç?e: a linha, a coluna e a matrix
// a ser verificada
    public int verificarValor (int linha, int coluna, int[][]matrix){
        int valor = matrix[linha][coluna];
        System.out.println(valor);
        switch  (valor){
            case 0: System.out.println("Rua");     break;
            case 1: System.out.println("Parede");  break;
            case 2: System.out.println("Entrada"); break;
            case 3: System.out.println("Saida");   break;
            default: System.out.println("Fora do labirinto"); break;
        }
        return valor;
    }
    
//Atributos,Coordenadas qual linha, qual coluna, qual matrix
    public void incurso (int linha, int coluna, int[][]matrix){
        if (passoDireita(linha, coluna, matrix) == true){
            incurso(linha, coluna+1, matrix);
        } else if (passoDireita(linha, coluna, matrix) == true){
            incurso(linha, coluna+1, matrix);
        }
    }
    
//    passo de verificaç?o a coluna da direita
    public boolean passoDireita (int linha, int coluna, int[][]matrix){
        int valorDireita = matrix[linha][coluna+1];
        if ( valorDireita > 3){  return false; }
        if ( valorDireita == 1){ return false; }
        if ( valorDireita >= 0){ return true; }     
        return true;
    }
    
//    passo de verificaç?o a coluna da direita
    public boolean passoCima (int linha, int coluna, int[][]matrix){
        if (linha == 1){ return false;}
        int valorDireita = matrix[linha-1][coluna];
        if ( valorDireita > 3){  return false; }
        if ( valorDireita == 1){ return false; }
        if ( valorDireita >= 0){ return true; }     
        return true;
    }
 
    
//    falta os metodos Esquerda, Acima e Abaixo
    
    
    
    public boolean passoDireitaTeste (int linha, int coluna, int[][]matrix, Cobra cb){
         if ( coluna > 4){
            return false;
         }
        if ( matrix[linha][coluna+1] == 1){ 
            System.out.println("Parede"); 
            return false;
        } else if ( matrix[linha][coluna+1] == 0){
            System.out.println("Rua"); 
            cb.salvarPasso(new Coordenada (linha, coluna+1));            
            Coordenada coord = cb.exibirTopo();
            System.out.println(coord);            
        } else if ( matrix[linha][coluna+1] == 2){
            System.out.println("INICIO"); 
            cb.salvarPasso(new Coordenada (linha, coluna+1));
            Coordenada coord = cb.exibirTopo();
            System.out.println(coord);
        }else if ( matrix[linha][coluna+1] == 3){
            System.out.println("FIM"); 
            cb.salvarPasso(new Coordenada (linha, coluna+1));
            Coordenada coord = cb.exibirTopo();
            System.out.println(coord);
        } 
        return true;
    }
    

    
    
    
}
