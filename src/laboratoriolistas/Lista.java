package laboratoriolistas;
/**
 *
 * @author Leonard Manrique
 */
public class Lista {
    private Nodo primero;
    private Nodo ultimo;
    public Lista(){
        this.primero = null;
        this.ultimo = null;
    }
    /**
     * Se anexa  un nodo al inicio de la lista
     * @param dato
     */
    public void anexarInicioLista(int dato){
        Nodo nuevo;
        nuevo = new Nodo(dato);
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            nuevo.setEnlace(primero);
            primero = nuevo;
        }
    }
    /**
     * Se anexa un nodo al final de la lista
     * @param dato
     */
    public void anexarFinalLista(int dato){
        Nodo nuevo;
        nuevo = new Nodo(dato);
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            ultimo.setEnlace(nuevo);
            ultimo = nuevo;
            ultimo.setEnlace(null);
        }
    }
    /**
     * Se evalua si la lista está vacía
     * @return true si es vacia o false
     */
    public boolean esVacia(){
        return(primero == null);
    }
    public boolean buscarNodo(int dato){
        boolean encontro = false;
        Nodo p = primero;
        while(p.getEnlace() != null && encontro == false){
            if(p.getDato() == dato){
                encontro = true;
            }
            p = p.getEnlace();
        }
        return encontro;
    }
    /**
     * metodo que borra un nodo al inicio de la lista
     * @return false o true dependiendo si borró o no el nodo
     */
    public boolean borrarNodoInicio(){
        if(esVacia()){
            return  false;
        }
        if(primero.getEnlace() == null){
            primero = null;
            ultimo = null;
            return false;
        }
        else{
            Nodo temp = primero;
            primero = primero.getEnlace();
            temp.setEnlace(null);
            return true;
        }
    }
    /**
     * Método que borra un nodo al final de la lista
     * @return false o true dependiendo si borro o el nodo o no
     */
    public boolean borrarNodoFinal(){
        if(esVacia()){
            return false;
        }
        if(primero.getEnlace() == null){
            primero = null;
            ultimo = null;
            return false;
        }
        else{
            Nodo temp = primero;
            Nodo aux = primero;
            while(temp.getEnlace() != null){
                aux = temp;
                temp = temp.getEnlace();
            }
            ultimo = aux;
            ultimo.setEnlace(null);
            return true;
        }
    }
    /**
     * Método que almacena en un String los nodos de la lista
     * a imprimir o el mensaje de lista vacia, si no hay nodos
     * @return string
     */
    public String imprimirLista(){
        Nodo aux = primero;
        String str = "";
        if(aux.getEnlace()!=null){ 
            
            while(aux.getEnlace()!=null){
		aux = aux.getEnlace();
                str = str + aux.getDato()+ "/t"; 
            }
        }else{
            str="Lista Vacía";
        }
        return str;
    }
}