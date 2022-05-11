public class NodoAVL {
    Integer valor;
    NodoAVL izq = null;
    NodoAVL der = null;
    NodoAVL padre = null;
    Integer pasos = 0;

    public NodoAVL(){
        izq=der=null;
    }
    public NodoAVL(int data){
        this(data,null,null);
    }
    public NodoAVL(int data, NodoAVL lt, NodoAVL rt){
        valor=data;
        izq = lt;
        der = rt;
    }
    
    public void setIzq(NodoAVL izq) {
        this.izq = izq;
    }
    
    public void setDer(NodoAVL der) {
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

    public void setPadre(NodoAVL padre) {
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
