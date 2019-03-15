package generadorhtml;
import java.io.File;
/*
  @author Dinora
 */
public class GeneradorHTML {
    
    public static void main(String[] args) {       
        //PARSER
        String path = "src/analyzers/Lexer.jflex";
        generarLexico(path); 
        
        //SCANNER
        String opciones[] = new String[7];
        //Seleccionamos la opción de dirección de destino
        opciones[0] = "-destdir";
        //Le damos la dirección, carpeta donde se va a generar el analizador sintáctico y simbolos
        opciones[1] = "src/analyzers";
        //Seleccionamos la opción de nombre de archivo simbolos
        opciones[2] = "-symbols";
        //Le damos el nombre que queremos que tenga la clase simbolos
        opciones[3] = "sym";
        //Seleccionarmos la opción de clase parser
        opciones[4] = "-parser";
        //Le damos nombre a esa clase del paso anterior
        opciones[5] = "Scanner";
        //Le decimos en dónde se encuentra el archivo .cup
        opciones[6] = "src/analyzers/Syntactic.cup";
        
        try{
            java_cup.Main.main(opciones);
        }catch(Exception ex){
            System.out.println(ex);
        }
        
//        CrearHTML pt = new CrearHTML();
//        pt.setVisible(true);
        
        boolean a = true != false;
                
    }
    
    public static void generarLexico(String path){
        File file = new File(path);
        jflex.Main.generate(file);
    } 
}
