
package regExp;

import java_cup.runtime.*;
import static regExp.ParserSym.*;

%%
%public
%class Lexer
%cupsym regExp.ParserSym
%cup
%line
%column 
%eofval{ 
    return symbol( EOF ); 
%eofval}

%{	  	
  	private Symbol symbol(int type, Object value) {
	    return new Symbol(type, yyline, yycolumn, value);
  	}
%}    					
	ORD_CHAR    = [a-zA-Z0-9_=]
    QUOTED_CHAR = "\\^" | "\\." | "\\[" | "\\$" | "\\(" | "\\)" | "\\|" | "\\*" | "\\+" | "\\?" | "\\{" | "\\\\"            
    CHARS       = "|" | "^" | "$" | "(" | ")" | "[" | "]" | "." | "*" | "+" | "?" | "{" | "}" | "-" | ","
    WHITE_SPACE = [\n\r\t]               
        
%%

<YYINITIAL>
{			
	{ORD_CHAR}     { return symbol( ORD_CHAR,    new String( yytext() )); }
	{QUOTED_CHAR}  { return symbol( QUOTED_CHAR, new String( yytext() )); }
	{CHARS}        { return symbol( QUOTED_CHAR, new String( yytext() )); }		
	{WHITE_SPACE}  { /* ignore */ }
}

/* erreur */
   .|\n            { throw new Error("Caractère illégal <"+ yytext()+">"); }