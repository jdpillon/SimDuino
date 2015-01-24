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
WhiteSpace={LineTerminator}|[ \t\f]
num=0|[1-9][0-9]*
version={num}"."[0-9]*
encoding="UTF-8"|"UTF-16"


%%
/*rules*/
<YYINITIAL>
{
	{num} {return symbol(sym.NUM,new Integer(yytext()));}
	{version} {return symbol(sym.VERSION,new String(yytext()));}
	{encoding} {return symbol(sym.ENCODING,new String(yytext()));}
	{WhiteSpace} {}


	"?" {return symbol(sym.QUESTION);}
	"=" {return symbol(sym.EQUAL);}
	"/" {return symbol(sym.DIV);}
	"<" {return symbol(sym.MIN);}
	">" {return symbol(sym.MAX);}
	"xml" {return symbol(sym.XML);}
	"version" {return symbol(sym.VERSION);}
	"encoding" {return symbol(sym.ENCODING);}
	"program" {return symbol(sym.PROGRAM);}
	"for" {return symbol(sym.FOR);}
	"rung" {return symbol(sym.RUNG);}
	"section1" {return symbol(sym.SECTION1);}
	"section2" {return symbol(sym.SECTION2);}
	"contact" {return symbol(sym.CONTACT);}
	"from" {return symbol(sym.FROM);}
	"to" {return symbol(sym.TO);}
	"port" {return symbol(sym.PORT);}
	"type" {return symbol(sym.TYPE);}
	"coil" {return symbol(sym.COIL);}

}

[^] {throw new Error("Illegal character <"+yytext()+">");}

