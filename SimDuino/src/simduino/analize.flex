import java_cup.runtime.*;

%%
/*declarations*/

%class Lexer
%line
%column
%cup
%{
private Symbol symbol(int type){
 return new Symbol(type,yyline,yycolumn);
}
private Symbol symbol(int type,Object value){
 return new Symbol(type,yyline,yycolumn,value);
}
%}

LineTerminator=\r|\n|\r\n
WhiteSpace={LineTerminator}|[\t\f]
num=0|[1-9][0-9]*
version={num}"."[0-9]*
encoding="UTF-8"|"UTF-16"


%%
/*rules*/
<YYINITIAL>
{
	{num} { System.out.println(yytext()+"f");return symbol(sym.NUM,new String(yytext()));}
	{version} { /*System.out.println(yytext());*/ return symbol(sym.VERSION,new String(yytext()));}
	{encoding} { System.out.println(yytext()); return symbol(sym.ENCODING,new String(yytext()));}
	{WhiteSpace} {}


	"?" {System.out.println("?"); return symbol(sym.QUESTION);}
	"=" {System.out.println("="); return symbol(sym.EQUAL);}
	"/" {System.out.println("/"); return symbol(sym.DIV);}
	"<" {System.out.println("<"); return symbol(sym.MIN);}
	">" {System.out.println(">"); return symbol(sym.MAX);}
	"xml" {System.out.println("xml"); return symbol(sym.XML);}
	"version" {System.out.println("version"); return symbol(sym.VERSION);}
	"encoding" {System.out.println("encoding"); return symbol(sym.ENCODING);}
	"program" {System.out.println("program"); return symbol(sym.PROGRAM);}
	"for" {System.out.println("for"); return symbol(sym.FOR);}
	"rung" {System.out.println("rung"); return symbol(sym.RUNG);}
	"section1" {System.out.println("section1"); return symbol(sym.SECTION1);}
	"section2" {System.out.println("section2"); return symbol(sym.SECTION2);}
	"contact" {System.out.println("contact"); return symbol(sym.CONTACT);}
	"from" {System.out.println("from"); return symbol(sym.FROM);}
	"to" {System.out.println("to"); return symbol(sym.TO);}
	"port" {System.out.println("port"); return symbol(sym.PORT);}
	"type" {System.out.println("type"); return symbol(sym.TYPE);}
	"coil" {System.out.println("coil"); return symbol(sym.COIL);}

}

[^] {throw new Error("Illegal character <"+yytext()+">");}

