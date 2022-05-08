public class Nodo {
    Integer valor;
    Nodo izq = null;
    Nodo der = null;
    Nodo padre = null;
    Integer pasos = 0;

    public Nodo(){
        izq=der=null;
    }
    public Nodo(int data){
        this(data,null,null);
    }
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    }
    
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }

    public void setNull(){
        this.izq = null;
        this.der = null;
    }
    public void setNullIzq(){
        this.izq = null;
    }
    public void setNullDer(){
        this.der = null;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    public void setOne(){
        this.pasos = 1;
    }
    public void setTwo(){
        this.pasos = 2;
    }
    public void setThree(){
        this.pasos = 3;
    }
    public void incrementstep(){
        pasos++;
    }

    public void setPasos(Integer pasos) {
        this.pasos = pasos;
    }
}
