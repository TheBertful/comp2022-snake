
public class Fila
{
    private Snake inicio;
    
    public Fila() {
        this.inicio = new Snake();
    }
    
    public Snake getHead() {
        Snake head = inicio;
        return head;
    }
    
    public void inserir() {
        Snake novo = new Snake();
        Snake aux = inicio;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }        
        aux.setProximo(novo);        
        novo.setAnterior(aux);
    }
    
    public Snake getSnake(int position) {
        if(position < 0 || position > getSize()){
            return null;
        }
        
        Snake aux = inicio;
        for(int i = 1; i < position; i++) {
            aux = aux.getProximo();
        }
        return aux;
    }
    
    private int getSize(){
        int tamanho = 1;
        Snake aux = inicio;
        if (aux == null) {
            return 0;
        } else {
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
                tamanho++;
            }
        }
        return tamanho;
    }
}
