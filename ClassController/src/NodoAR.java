

public class NodoAR {
    String valor;
    NodoAR izq = null;
    NodoAR der = null;
    
    public NodoAR(){
        izq=der=null;
    }
    public NodoAR(String data){
        this(data,null,null);
    }
    public NodoAR(String data, NodoAR lt, NodoAR rt){
        valor=data;
        izq = lt;
        der = rt;
    }   
    
    public void setIzq(NodoAR izq) {
        this.izq = izq;
    }
    
    public void setDer(NodoAR der) {
        this.der = der;
    }
}
