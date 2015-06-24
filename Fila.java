
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
        Snake aux = inicio;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        Snake last = new Snake(aux);
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
