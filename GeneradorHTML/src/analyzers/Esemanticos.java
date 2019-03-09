package analyzers;

/*
  @author Dinora
 */
public class Esemanticos {
    public String id;
    public String tipo;
    public int fila;
    public int columna;
    public String descripcion;
    
    public Esemanticos(String id, String tipo, int fila, int columna, String descripcion){
        this.id = id;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
    }
}