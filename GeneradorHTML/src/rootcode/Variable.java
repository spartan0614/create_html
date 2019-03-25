package rootcode;

/*
  @author Dinora
 */
public class Variable {
    public String tipo;
    public String nombre;
    public String valor;
    public String linea;
    public String columna;
     
    public Variable(String tipo, String nombre, String valor, String linea, String columna){
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
}
