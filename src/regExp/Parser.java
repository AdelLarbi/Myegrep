
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat Apr 18 23:16:11 CEST 2015
//----------------------------------------------------

package regExp;


/** CUP v0.11a beta 20060608 generated parser.
  * @version Sat Apr 18 23:16:11 CEST 2015
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\042\000\002\002\004\000\002\014\003\000\002\014" +
    "\005\000\002\015\003\000\002\015\004\000\002\016\003" +
    "\000\002\016\003\000\002\016\003\000\002\016\005\000" +
    "\002\016\004\000\002\017\003\000\002\017\003\000\002" +
    "\017\003\000\002\017\003\000\002\020\003\000\002\020" +
    "\003\000\002\020\003\000\002\020\005\000\002\020\006" +
    "\000\002\020\007\000\002\002\005\000\002\002\005\000" +
    "\002\003\003\000\002\004\004\000\002\005\003\000\002" +
    "\006\003\000\002\006\004\000\002\007\003\000\002\007" +
    "\003\000\002\010\003\000\002\011\004\000\002\011\004" +
    "\000\002\012\004\000\002\013\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\060\000\020\004\014\005\015\006\012\010\006\013" +
    "\005\014\004\016\013\001\002\000\020\004\014\005\015" +
    "\006\012\010\006\013\005\014\004\016\013\001\002\000" +
    "\036\002\ufffa\004\ufffa\005\ufffa\006\ufffa\010\ufffa\012\ufffa" +
    "\013\ufffa\014\ufffa\015\ufffa\016\ufffa\017\ufffa\020\ufffa\021" +
    "\ufffa\022\ufffa\001\002\000\036\002\ufffb\004\ufffb\005\ufffb" +
    "\006\ufffb\010\ufffb\012\ufffb\013\ufffb\014\ufffb\015\ufffb\016" +
    "\ufffb\017\ufffb\020\ufffb\021\ufffb\022\ufffb\001\002\000\036" +
    "\002\ufff4\004\ufff4\005\ufff4\006\ufff4\010\ufff4\012\ufff4\013" +
    "\ufff4\014\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4\021\ufff4" +
    "\022\ufff4\001\002\000\036\002\ufffc\004\ufffc\005\ufffc\006" +
    "\ufffc\010\ufffc\012\ufffc\013\ufffc\014\ufffc\015\ufffc\016\ufffc" +
    "\017\ufffc\020\ufffc\021\ufffc\022\ufffc\001\002\000\006\002" +
    "\057\012\056\001\002\000\006\004\045\010\037\001\002" +
    "\000\036\002\ufff5\004\ufff5\005\ufff5\006\ufff5\010\ufff5\012" +
    "\ufff5\013\ufff5\014\ufff5\015\ufff5\016\ufff5\017\ufff5\020\ufff5" +
    "\021\ufff5\022\ufff5\001\002\000\036\002\ufff7\004\ufff7\005" +
    "\ufff7\006\ufff7\010\ufff7\012\ufff7\013\ufff7\014\ufff7\015\ufff7" +
    "\016\ufff7\017\ufff7\020\ufff7\021\ufff7\022\ufff7\001\002\000" +
    "\036\002\ufff6\004\ufff6\005\ufff6\006\ufff6\010\ufff6\012\ufff6" +
    "\013\ufff6\014\ufff6\015\ufff6\016\ufff6\017\ufff6\020\ufff6\021" +
    "\ufff6\022\ufff6\001\002\000\026\002\000\004\014\005\015" +
    "\006\012\010\006\012\000\013\005\014\004\015\000\016" +
    "\013\001\002\000\036\002\ufffe\004\ufffe\005\ufffe\006\ufffe" +
    "\010\ufffe\012\ufffe\013\ufffe\014\ufffe\015\ufffe\016\ufffe\017" +
    "\023\020\022\021\021\022\024\001\002\000\036\002\ufff8" +
    "\004\ufff8\005\ufff8\006\ufff8\010\ufff8\012\ufff8\013\ufff8\014" +
    "\ufff8\015\ufff8\016\ufff8\017\ufff8\020\ufff8\021\ufff8\022\ufff8" +
    "\001\002\000\036\002\ufff1\004\ufff1\005\ufff1\006\ufff1\010" +
    "\ufff1\012\ufff1\013\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1" +
    "\020\ufff1\021\ufff1\022\ufff1\001\002\000\036\002\ufff2\004" +
    "\ufff2\005\ufff2\006\ufff2\010\ufff2\012\ufff2\013\ufff2\014\ufff2" +
    "\015\ufff2\016\ufff2\017\ufff2\020\ufff2\021\ufff2\022\ufff2\001" +
    "\002\000\036\002\ufff3\004\ufff3\005\ufff3\006\ufff3\010\ufff3" +
    "\012\ufff3\013\ufff3\014\ufff3\015\ufff3\016\ufff3\017\ufff3\020" +
    "\ufff3\021\ufff3\022\ufff3\001\002\000\004\004\025\001\002" +
    "\000\006\023\027\024\026\001\002\000\006\004\031\023" +
    "\030\001\002\000\036\002\ufff0\004\ufff0\005\ufff0\006\ufff0" +
    "\010\ufff0\012\ufff0\013\ufff0\014\ufff0\015\ufff0\016\ufff0\017" +
    "\ufff0\020\ufff0\021\ufff0\022\ufff0\001\002\000\036\002\uffef" +
    "\004\uffef\005\uffef\006\uffef\010\uffef\012\uffef\013\uffef\014" +
    "\uffef\015\uffef\016\uffef\017\uffef\020\uffef\021\uffef\022\uffef" +
    "\001\002\000\004\023\032\001\002\000\036\002\uffee\004" +
    "\uffee\005\uffee\006\uffee\010\uffee\012\uffee\013\uffee\014\uffee" +
    "\015\uffee\016\uffee\017\uffee\020\uffee\021\uffee\022\uffee\001" +
    "\002\000\036\002\ufffd\004\ufffd\005\ufffd\006\ufffd\010\ufffd" +
    "\012\ufffd\013\ufffd\014\ufffd\015\ufffd\016\ufffd\017\023\020" +
    "\022\021\021\022\024\001\002\000\004\007\uffeb\001\002" +
    "\000\004\007\055\001\002\000\006\004\045\007\uffe9\001" +
    "\002\000\004\004\045\001\002\000\006\004\uffe5\007\uffe5" +
    "\001\002\000\006\004\uffe6\007\uffe6\001\002\000\006\004" +
    "\045\011\052\001\002\000\010\004\uffe4\007\uffe4\011\050" +
    "\001\002\000\006\004\uffe8\007\uffe8\001\002\000\010\004" +
    "\uffe0\007\uffe0\011\uffe0\001\002\000\004\007\047\001\002" +
    "\000\036\002\uffec\004\uffec\005\uffec\006\uffec\010\uffec\012" +
    "\uffec\013\uffec\014\uffec\015\uffec\016\uffec\017\uffec\020\uffec" +
    "\021\uffec\022\uffec\001\002\000\006\004\uffe1\011\uffe1\001" +
    "\002\000\006\004\uffe3\007\uffe3\001\002\000\006\004\uffe2" +
    "\007\uffe2\001\002\000\004\007\uffea\001\002\000\006\004" +
    "\uffe7\007\uffe7\001\002\000\036\002\uffed\004\uffed\005\uffed" +
    "\006\uffed\010\uffed\012\uffed\013\uffed\014\uffed\015\uffed\016" +
    "\uffed\017\uffed\020\uffed\021\uffed\022\uffed\001\002\000\020" +
    "\004\014\005\015\006\012\010\006\013\005\014\004\016" +
    "\013\001\002\000\004\002\001\001\002\000\026\002\uffff" +
    "\004\014\005\015\006\012\010\006\012\uffff\013\005\014" +
    "\004\015\uffff\016\013\001\002\000\006\012\056\015\062" +
    "\001\002\000\036\002\ufff9\004\ufff9\005\ufff9\006\ufff9\010" +
    "\ufff9\012\ufff9\013\ufff9\014\ufff9\015\ufff9\016\ufff9\017\ufff9" +
    "\020\ufff9\021\ufff9\022\ufff9\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\060\000\014\002\006\014\010\015\015\016\016\017" +
    "\007\001\001\000\014\002\006\014\060\015\015\016\016" +
    "\017\007\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\024" +
    "\003\034\004\045\005\033\006\035\007\043\010\040\011" +
    "\037\012\041\013\042\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\010\002\006\016\032\017" +
    "\007\001\001\000\004\020\017\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\020\017\001\001\000\002\001\001\000\002" +
    "\001\001\000\014\007\053\010\040\011\037\012\041\013" +
    "\042\001\001\000\020\005\052\006\035\007\043\010\040" +
    "\011\037\012\041\013\042\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\013\050\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\012\002\006\015\057\016\016\017\007\001\001" +
    "\000\002\001\001\000\010\002\006\016\032\017\007\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // end_range ::= ORD_CHAR 
            {
              Object RESULT =null;
		int ocleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int ocright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object oc = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 System.out.println( oc ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("end_range",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // start_range ::= end_range MINUS 
            {
              Object RESULT =null;
		 System.out.println( "end_range-" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("start_range",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // range_expression ::= start_range MINUS 
            {
              Object RESULT =null;
		 System.out.println( "start_range-" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("range_expression",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // range_expression ::= start_range end_range 
            {
              Object RESULT =null;
		 System.out.println( "start_range end_range" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("range_expression",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // single_expression ::= end_range 
            {
              Object RESULT =null;
		 System.out.println( "end_range" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("single_expression",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // expression_term ::= range_expression 
            {
              Object RESULT =null;
		 System.out.println( "range_expression" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expression_term",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // expression_term ::= single_expression 
            {
              Object RESULT =null;
		 System.out.println( "single_expression" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expression_term",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // follow_list ::= follow_list expression_term 
            {
              Object RESULT =null;
		 System.out.println( "follow_list expression_term" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("follow_list",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // follow_list ::= expression_term 
            {
              Object RESULT =null;
		 System.out.println( "expression_term" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("follow_list",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // bracket_list ::= follow_list 
            {
              Object RESULT =null;
		 System.out.println( "follow_list" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("bracket_list",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // nonmatching_list ::= CARET bracket_list 
            {
              Object RESULT =null;
		 System.out.println( "^bracket_list" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("nonmatching_list",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // matching_list ::= bracket_list 
            {
              Object RESULT =null;
		 System.out.println( "bracket_list" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("matching_list",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // bracket_expression ::= OPEN_BRACKET nonmatching_list CLOSE_BRACKET 
            {
              Object RESULT =null;
		 System.out.println( "[nonmatching_list]" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("bracket_expression",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // bracket_expression ::= OPEN_BRACKET matching_list CLOSE_BRACKET 
            {
              Object RESULT =null;
		 System.out.println( "[matching_list]" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("bracket_expression",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // ERE_dupl_symbol ::= OPEN_BRACE ORD_CHAR COMMA ORD_CHAR CLOSE_BRACE 
            {
              Object RESULT =null;
		int oc1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int oc1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		Object oc1 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int oc2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int oc2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object oc2 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 System.out.println( "{" + oc1 + "," + oc2 + "}" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_dupl_symbol",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // ERE_dupl_symbol ::= OPEN_BRACE ORD_CHAR COMMA CLOSE_BRACE 
            {
              Object RESULT =null;
		int ocleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int ocright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object oc = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		 System.out.println( "{" + oc + ",}" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_dupl_symbol",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // ERE_dupl_symbol ::= OPEN_BRACE ORD_CHAR CLOSE_BRACE 
            {
              Object RESULT =null;
		int ocleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int ocright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object oc = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 System.out.println( "{" + oc + "}" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_dupl_symbol",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // ERE_dupl_symbol ::= QUESTION_MARK 
            {
              Object RESULT =null;
		 System.out.println( "?" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_dupl_symbol",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ERE_dupl_symbol ::= PLUS 
            {
              Object RESULT =null;
		 System.out.println( "+" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_dupl_symbol",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // ERE_dupl_symbol ::= ASTERISK 
            {
              Object RESULT =null;
		 System.out.println( "*" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_dupl_symbol",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // one_char_or_coll_elem_ERE ::= bracket_expression 
            {
              Object RESULT =null;
		 System.out.println( "bracket_expression" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("one_char_or_coll_elem_ERE",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // one_char_or_coll_elem_ERE ::= DOT 
            {
              Object RESULT =null;
		 System.out.println( "." ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("one_char_or_coll_elem_ERE",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // one_char_or_coll_elem_ERE ::= QUOTED_CHAR 
            {
              Object RESULT =null;
		int ocleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int ocright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object oc = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 System.out.println( oc ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("one_char_or_coll_elem_ERE",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // one_char_or_coll_elem_ERE ::= ORD_CHAR 
            {
              Object RESULT =null;
		int ocleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int ocright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object oc = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 System.out.println( oc ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("one_char_or_coll_elem_ERE",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // ERE_expression ::= ERE_expression ERE_dupl_symbol 
            {
              Object RESULT =null;
		 System.out.println( "ERE_expression ERE_dupl_symbol" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_expression",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // ERE_expression ::= OPEN_PARENTHESE extended_reg_exp CLOSE_PARENTHESE 
            {
              Object RESULT =null;
		 System.out.println( "(extended_reg_exp)" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_expression",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ERE_expression ::= DOLLAR 
            {
              Object RESULT =null;
		 System.out.println( "$" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_expression",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ERE_expression ::= CARET 
            {
              Object RESULT =null;
		 System.out.println( "^" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_expression",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ERE_expression ::= one_char_or_coll_elem_ERE 
            {
              Object RESULT =null;
		 System.out.println( "one_char_or_coll_elem_ERE" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_expression",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ERE_branch ::= ERE_branch ERE_expression 
            {
              Object RESULT =null;
		 System.out.println( "ERE_branch ERE_expression" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_branch",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // ERE_branch ::= ERE_expression 
            {
              Object RESULT =null;
		 System.out.println( "ERE_expression" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ERE_branch",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // extended_reg_exp ::= extended_reg_exp VERTICAL_BAR ERE_branch 
            {
              Object RESULT =null;
		 System.out.println( "extended_reg_exp|ERE_branch" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("extended_reg_exp",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // extended_reg_exp ::= ERE_branch 
            {
              Object RESULT =null;
		 System.out.println( "ERE_branch" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("extended_reg_exp",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= extended_reg_exp EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

