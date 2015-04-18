
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
	private Symbol symbol(int type) {
    	return new Symbol(type, yyline, yycolumn);
  	}
  	
  	private Symbol symbol(int type, Object value) {
	    return new Symbol(type, yyline, yycolumn, value);
  	}
%}    					
	WHITE_SPACE = [\n\r\t]         
	ORD_CHAR    = [a-zA-Z0-9_=]
    QUOTED_CHAR = "\\^" | "\\." | "\\[" | "\\$" | "\\(" | "\\)" | "\\|" | "\\*" | "\\+" | "\\?" | "\\{" | "\\\\"             
        
%%

<YYINITIAL>
{			
	{WHITE_SPACE}  { /* ignore */ }
	{ORD_CHAR}     { return symbol( ORD_CHAR,    new String( yytext() )); }
	{QUOTED_CHAR}  { return symbol( QUOTED_CHAR, new String( yytext() )); }
	"["            { return symbol( OPEN_BRACKET     );}
    "]"            { return symbol( CLOSE_BRACKET    );}    
    "^"            { return symbol( CARET            );}
    "-"            { return symbol( MINUS            );}
    "|"            { return symbol( VERTICAL_BAR     );}
    "$"            { return symbol( DOLLAR           );}
    "("            { return symbol( OPEN_PARENTHESE  );}
    ")"            { return symbol( CLOSE_PARENTHESE );}
    "."            { return symbol( DOT              );}
    "*"            { return symbol( ASTERISK         );}
    "+"            { return symbol( PLUS             );}
    "?"            { return symbol( QUESTION_MARK    );}
    "{"            { return symbol( OPEN_BRACE       );}
    "}"            { return symbol( CLOSE_BRACE      );}
    ","            { return symbol( COMMA            );}			
}

/* erreur */
   .|\n            { System.err.println("Caractère illégal <"+ yytext()+">"); }