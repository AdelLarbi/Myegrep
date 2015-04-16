
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
%}    	
	collElemSingle = "TODO1"
	collElemMulti = "TODO2"
	metaChar = "TODO3"
	className = "TODO4"
	ordChar = "TODO5"
    quotedChar = "\\^" | "\\." | "\\*" | "\\[" | "\\$"| "\\\\"            
    dupCount = "TODO6"                   
        
%%

<YYINITIAL>
{		
	{collElemSingle}  { return symbol( COLL_ELEM_SINGLE ); } 
	{collElemMulti}   { return symbol( COLL_ELEM_MULTI );  }
	{metaChar}        { return symbol( META_CHAR );        }
		
	"[="              { return symbol( Open_equal );       }
	"=]"              { return symbol( Equal_close );      } 
	"[."              { return symbol( Open_dot );         }
	".]"              { return symbol( Dot_close );        }
	"[:"              { return symbol( Open_colon );       }
	":]"              { return symbol( Colon_close );      }
	
	{className}       { return symbol( class_name );       }
	{ordChar}         { return symbol( ORD_CHAR );         }
	{quotedChar}      { return symbol( QUOTED_CHAR );      }
	{dupCount}        { return symbol( DUP_COUNT );        } 		 
	
    "["               { return symbol( OPEN_BRACKET );     }
    "]"               { return symbol( CLOSE_BRACKET );    }    
    "^"               { return symbol( CARET );            }
    "-"               { return symbol( MINUS );            }
    "|"               { return symbol( VERTICAL_BAR );     }
    "$"               { return symbol( DOLLAR ); }
    "("               { return symbol( OPEN_PARENTHESE );  }
    ")"               { return symbol( CLOSE_PARENTHESE ); }
    "."               { return symbol( DOT );              }
    "*"               { return symbol( ASTERISK );         }
    "+"               { return symbol( PLUS );             }
    "?"               { return symbol( QUESTION_MARK );    }
    "{"               { return symbol( OPEN_BRACE );       }
    "}"               { return symbol( CLOSE_BRACE );      }
    ","               { return symbol( COMMA );            }
}

/* error fallback */
.|\n                { throw new Error("Illegal character <"+ yytext()+">"); }
