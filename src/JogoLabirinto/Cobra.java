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
    public boolean incurso (int linha, int coluna, int[][]matrix){
        if ( (passoFrenteTeste(linha, coluna, matrix, this)) == true ){
            incurso(linha, coluna+1, matrix);
        }
        return true;
    }
    
    // aqui usamos um metodo que carrega 3 informaç?e: a linha, a coluna e a matrix
// a ser verificada
    public boolean verificarValor (int linha, int coluna, int[][]matrix){
        int valor = matrix[linha][coluna];
        switch  (valor){
            case 0: System.out.println("Rua");
            case 1: System.out.println("Parede");
            case 2: System.out.println("Entrada");
            case 3: System.out.println("Saida");
            default: System.out.println("Fora do laberinto");
        }
        return true;
    }
    
//    passo de verificaç?o a coluna da direita
    public boolean passoFrente (int linha, int coluna, int[][]matrix){
        if ( matrix.length > linha || matrix[linha].length > coluna){ 
            return false; }
        if ( matrix[linha][coluna+1] == 1){ return false; }
        if ( matrix[linha][coluna+1] == 0){ return true; }
        if ( matrix[linha][coluna+1] == 2){ return true; }
        if ( matrix[linha][coluna+1] == 3){ return true; }       
        return true;
    }
    
//    falta os metodos Esquerda, Acima e Abaixo
    
    
    
    public boolean passoFrenteTeste (int linha, int coluna, int[][]matrix, Cobra cb){
         if ( coluna > 4){
             throw new IndexOutOfBoundsException("Posiçao Inavalida no labirinto");
         }
        if ( matrix[linha][coluna+1] == 1){ 
            System.out.println("Parede"); 
            return false;
        } else if ( matrix[linha][coluna+1] == 0){
            System.out.println("Rua"); 
            cb.Passo(new Coordenada (linha, coluna+1));            
            Coordenada coord = cb.Topo();
            System.out.println(coord);            
        } else if ( matrix[linha][coluna+1] == 2){
            System.out.println("INICIO"); 
            cb.Passo(new Coordenada (linha, coluna+1));
            Coordenada coord = cb.Topo();
            System.out.println(coord);
        }else if ( matrix[linha][coluna+1] == 3){
            System.out.println("FIM"); 
            cb.Passo(new Coordenada (linha, coluna+1));
            Coordenada coord = cb.Topo();
            System.out.println(coord);
        } 
        return true;
    }
    

    
    
    
}
