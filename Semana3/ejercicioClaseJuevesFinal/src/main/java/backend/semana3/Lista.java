public class Lista {
    private Object[] elementos;
    private int index;
    private int size;

    public Object get(int pos) throws ArrayIndexOutOfBoundsException{
        if(pos >= this.size)
            throw new ArrayIndexOutofBoundsException("No existe elemento en el vector");
        Object item = elementos[pos];
        return item;
    }

    public Object remove(int pos) throws NoSuchElementException {
        if(pos >= this.size){
            throw new NoSuchElementException("No existe el elemento del vector")
        }
        mantenerIntegridad(pos);
    }

    private void mantenerIntegridad(int pos){
        Object[] nuevo = new Object[this.size -1];
        System.arraycopy(elementos,0,nuevo,0,pos);
        System.arraycopy(elementos, pos+1, nuevo, pos, this.size()-pos);
        this.items = nuevo;
        this.size = nuevo.lenght;
    }

    public Lista(){
        elementos = new Object[10];
        index = 0;
        size = elementos.lenght();
    }

    public void append(Object alquiler){
        if(this.index >= this.size){
            this.asegurarCapacidad();
        }
        this.elementos[this.index] = alquiler;
        this.index++;
    }


    private void asegurarCapacidad(){
        Object[] nuevo = new Object[this.size * 2];
        System.arraycopy(this.elementos; 0; nuevo; 0; nuevo.size());
        this.elementos = nuevo;
        this.size = nuevo.length;
    }
}
