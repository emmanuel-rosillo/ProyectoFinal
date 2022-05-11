
package proyecto2;

//import java.util.Arrays;
/**
 *
 * @author 3ns3r
 */
public class IngresarDatos {
    String[] strOperadoresSeparados;
    String[] strNumerosSeparados;
    public void creandoArrays(String expresion){
        String separador = "";
        
        //Aquí sacamos los números de la expresion
        strNumerosSeparados = expresion.split("\\+|\\*|\\-|\\/");
        
        //Aquí se imprime el arreglo para comprobar que se guardaron los números
        //System.out.println("String original: "+expresion);
        //System.out.println("String separado (números): ");
        //System.out.println(Arrays.toString(strNumerosSeparados));
        
        //Aqui sacamos el separador personalizado para los operadores
        separador = separadorDeOperadores(strNumerosSeparados, separador);
        //System.out.println("El separador después del método "+separador);
        String[] strOperadores = expresion.split(separador);
        
        //Aqui eliminamos el valor o valores basura del array de los operadores
        strOperadoresSeparados = eliminandoBasura(strOperadores);
        
        //Aquí se imprime el arreglo para comprobar que se guardaron los operadores
        //System.out.println("String separado (operadores): ");
        //System.out.println(Arrays.toString(strOperadoresSeparados));
    }
    
    public void crearArbol(){
        int index = (strOperadoresSeparados.length)/2;
        //Aqui transformamos y guardamos los operadores y los numeros en la lista de nodos
        ArbolBin arbol = new ArbolBin(strOperadoresSeparados[index]);
        arbol.nodosDeOperadores(index, 0, strOperadoresSeparados, 0);
        arbol.nodosDeNumeros(strNumerosSeparados);
        
        //Acá se construye el árbol
        arbol.contruyendoArbol();
        
        System.out.println("\n\nBFS de su árbol queda así:");
        arbol.breadthFrist();
    } 
    
    public String separadorDeOperadores(String[] numeros, String separador){
        //String separadorModificado="";
        for(int i=0; i<numeros.length; i++){
            if(i==numeros.length-1)
                separador = separador+numeros[i];
            else
                separador = separador+numeros[i]+"|";
        }
        //System.out.println("El separador en el método "+separador);
        return separador;
    }
    
    public String[] eliminandoBasura(String[] operadores){
        String[] strSinNulos = new String[operadores.length-1];
        for(int i=0; i<operadores.length; i++){
            if(i>0)
                strSinNulos[i-1] = operadores[i];
        }
        //System.out.println("El nuevo Array en el método: "+Arrays.toString(strSinNulos));
        return strSinNulos;
    }
}