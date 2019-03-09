package analyzers;
import java_cup.runtime.*;
import java.io.Reader;
import java.util.ArrayList;

%%

/*  -----------------------  DIRECTIVAS  --------------------  */
%class Parser           //Nombre de la clase que genera
%cup                    //Indica que trabajará junto con cup.
%public                 //Clase pública.
%unicode
%line                   //Se debe tomar en cuenta la linea de las palabras.
%column                 //Se debe tomar en cuenta la columna de las palabras
%char
%full
%ignorecase             //Ignorar mayúsculas y minúsculas.

%{
    public ArrayList<Esemanticos> ErroresLexicos = new ArrayList<Esemanticos> ();
    
    //Generar un java_cup.symbol para guardar el tipo de token encontrado
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    
    //Generar un symbol para el tipo de token encontrado junto con su valor
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

/*  -----------------   ExPRESIONES REGULARES  ---------------  */


identificador   = [a-zA-Z][a-zA-Z0-9_]*
cadena          = [\"]([^\"\n]|(\\\"))*[\"] 
//decimal         = [0-9]+ ('.' [0-9]+)
//entero          = [0-9]+
numero          = [0-9]+(\.[0-9]+)?
hex             = [a-fA-F0-9]
rgb             = "#"({hex}){6}
paragraph       = ([:jletterdigit:]|["."(),;:!¡\?¿])+

CommentTAG      = "<!" [^*] ~"!>" | "<!" "!"+ ">"
CommentHSC           = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

LineTerminator = \r|\n|\r\n  
InputCharacter = [^\r\n"'"]*
DobleInputChar = [^\r\n\"]*
WhiteSpace     = {LineTerminator} | [ \t\f]

%state      HSC
%state      TAG

%%

<YYINITIAL>{
    "<?hs"              { yybegin(HSC); return symbol(sym.beginHS, yytext()); }
    "<"                 { yybegin(TAG); return symbol(sym.open, yytext());}

    {paragraph}         { return symbol(sym.paragraph, yytext()); }
    {CommentTAG}        { /* Ignore */ }
    {WhiteSpace}        { /* Ignore */ }
}

<TAG>{
    "compi"             { return symbol(sym.compi, yytext()); }
    "cabecera"          { return symbol(sym.cabecera, yytext()); }
    "titulo"            { return symbol(sym.titulo, yytext()); }
    "cuerpo"            { return symbol(sym.cuerpo, yytext()); }
    "parrafo"           { return symbol(sym.parrafo, yytext()); }
    "salto"             { return symbol(sym.salto, yytext()); }
    "tabla"             { return symbol(sym.tabla, yytext()); }
    "fila"              { return symbol(sym.fila, yytext()); }
    "columnaC"          { return symbol(sym.columnac, yytext()); }
    "columna"           { return symbol(sym.columna, yytext()); }
    "imagen"            { return symbol(sym.imagen, yytext()); }
    "textoA"            { return symbol(sym.textoa, yytext()); }
    "textoB"            { return symbol(sym.textob, yytext()); }
    "boton"             { return symbol(sym.boton, yytext()); }
    "espacio"           { return symbol(sym.espacio, yytext()); }
    "fondo"             { return symbol(sym.fondo, yytext()); }
    "alineacion"        { return symbol(sym.alineacion, yytext()); }
    "path"              { return symbol(sym.path, yytext()); }
    "alto"              { return symbol(sym.alto, yytext()); }
    "ancho"             { return symbol(sym.ancho, yytext()); }
    "id"                { return symbol(sym.id, yytext()); }
    "texto"             { return symbol(sym.texto, yytext()); }
    "borde"             { return symbol(sym.borde, yytext()); }
    "true"              { return symbol(sym.true_, yytext()); }
    "false"             { return symbol(sym.false_, yytext()); }

    ">"                 { yybegin(YYINITIAL); return symbol(sym.close, yytext()); }
    "/"                 { return symbol(sym.div, yytext()); }
    "="                 { return symbol(sym.equal, yytext()); }
    \"                  { return symbol(sym.ddq, yytext()); }

    {rgb}               { return symbol(sym.rgb, yytext()); }
    //{entero}            { return symbol(sym.entero, yytext()); }
    {numero}            { return symbol(sym.numero, yytext()); }
    {cadena}            { return symbol(sym.cadena, yytext()); }
    {WhiteSpace}        { /* Ignore */ }
}

<HSC>{
    "true"              { return symbol(sym.true_, yytext()); }
    "false"             { return symbol(sym.false_, yytext()); }
    "echo"              { return symbol(sym.echo, yytext()); }
    "if"                { return symbol(sym.if_, yytext()); }
    "else"              { return symbol(sym.else_, yytext()); }
    "repetir"           { return symbol(sym.repetir, yytext()); }
    "crearparrafo"      { return symbol(sym.crearparrafo, yytext()); }
    "alineacion"        { return symbol(sym.alineacion, yytext()); }
    "setcontenido"      { return symbol(sym.setcontenido, yytext()); }
    "setalineacion"     { return symbol(sym.setalineacion, yytext()); }
    "getcontenido"      { return symbol(sym.getcontenido, yytext()); }
    "getalineacion"     { return symbol(sym.getalineacion, yytext()); }
    "creartextoa"       { return symbol(sym.creartextoa, yytext()); }
    "creartextob"       { return symbol(sym.creartextob, yytext()); }
    "crearimagen"       { return symbol(sym.crearimagen, yytext()); }
    "insertar"          { return symbol(sym.insertar, yytext()); }
    "getpath"           { return symbol(sym.getpath, yytext()); }
    "getancho"          { return symbol(sym.getancho, yytext()); }
    "getalto"           { return symbol(sym.getalto, yytext()); }
    "setpath"           { return symbol(sym.setpath, yytext()); }
    "setancho"          { return symbol(sym.setancho, yytext()); }
    "setalto"           { return symbol(sym.setalto, yytext()); }
    "creartabla"        { return symbol(sym.creartabla, yytext()); }
    "setborde"          { return symbol(sym.setborde, yytext()); }
    "crearboton"        { return symbol(sym.crearboton, yytext()); }
    "settexto"          { return symbol(sym.settexto, yytext()); }
    "gettexto"          { return symbol(sym.gettexto, yytext()); }
    "clickboton"        { return symbol(sym.clickboton, yytext()); }

    "?>"                { yybegin(YYINITIAL); return symbol(sym.endHS, yytext()); }
    ";"                 { return symbol(sym.semicolon, yytext()); }
    "$"                 { return symbol(sym.dolar, yytext()); }
    "+"                 { return symbol(sym.plus, yytext()); }
    "-"                 { return symbol(sym.hypen, yytext()); }
    "*"                 { return symbol(sym.asterisk, yytext()); }
    "/"                 { return symbol(sym.div, yytext()); }   
    "<="                { return symbol(sym.menorque, yytext()); }
    ">="                { return symbol(sym.mayorque, yytext()); }
    "<"                 { return symbol(sym.menor, yytext()); }
    ">"                 { return symbol(sym.mayor, yytext()); }
    "!="                { return symbol(sym.diferente, yytext()); }
    "=="                { return symbol(sym.igualque, yytext()); }
    "="                 { return symbol(sym.equal, yytext()); }
    "&&"                { return symbol(sym.and, yytext()); }
    "||"                { return symbol(sym.or, yytext()); }
    "!"                 { return symbol(sym.not, yytext()); }
    "{"                 { return symbol(sym.ollv, yytext()); }
    "}"                 { return symbol(sym.cllv, yytext()); }
    "("                 { return symbol(sym.opar, yytext()); }
    ")"                 { return symbol(sym.cpar, yytext()); }
    "#"                 { return symbol(sym.hashtag, yytext()); }
    "["                 { return symbol(sym.ocorch, yytext()); }
    "]"                 { return symbol(sym.ccorch, yytext()); }
    ","                 { return symbol(sym.comma, yytext()); }
    \"                  { return symbol(sym.ddq, yytext()); }

    {cadena}            { return symbol(sym.cadena, yytext()); }
    //{entero}            { return symbol(sym.entero, yytext()); }
    //{decimal}           { return symbol(sym.decimal, yytext()); }
    {numero}            { return symbol(sym.numero, yytext()); }
    {identificador}     { return symbol(sym.identificador, yytext()); }
    "."                 { return symbol(sym.dot, yytext()); }
    {CommentHSC}        { /* Ignore */ }
    {WhiteSpace}        { /* Ignore */ } 
}

/* error fallback */
    [^]     { 
                System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
                Esemanticos e = new Esemanticos(String.valueOf(yytext()),"Lexico",(int)yyline+1,(int)yychar, "Caracter Invalido");
                ErroresLexicos.add(e);
            }