
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
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
IntLiteral     = 0 | [1-9][0-9]*

%%

<YYINITIAL>
{
    "+"             { return symbol( PLUS ); }
    "/"             { return symbol( DIVIDE ); }    
    "*"             { return symbol( TIMES ); }
    "-"             { return symbol( MINUS ); }
    "%"             { return symbol( MOD ); }
    "("             { return symbol( LPAREN ); }
    ")"             { return symbol( RPAREN ); }
    ";"             { return symbol( SEMI ); }
    {IntLiteral}    { return symbol( NUMBER, new Integer( yytext() ) ); }
    {WhiteSpace}    { /* ignore */ }
}

/* error fallback */
.|\n                { throw new Error("Illegal character <"+ yytext()+">"); }




