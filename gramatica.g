class MeuParser extends Parser;
{

java.util.HashMap<String, String> mapVar;
}


prog        : {mapVar = new java.util.HashMap<String, String>();} "programa" declara bloco "fimprog" T_pontof
            ;
    
declara     :  "declare" T_Id { 
                                mapVar.put(LT(0).getText(), LT(0).getText());
                                System.out.println("Variavel " + LT(0).getText() + " salva!");
                                }
                        (T_virg T_Id{
                                        mapVar.put(LT(0).getText(), LT(0).getText());
                                        System.out.println("Variavel " + LT(0).getText() + " salva!");
                                    })* T_pontof
            ;
    
bloco       :  (cmd)+
            ;
    
cmd         :  cmdLeia T_pontof
            |  cmdEscreva T_pontof
            |  cmdAttr T_pontof
	        |  cmdIf 
            |  cmdFor 
            |  cmdSwitch 
            ;
    
cmdLeia     :  "leia" T_ap 
                        T_Id{System.out.println("Variavel "+ LT(0).getText() + " lida") ;
                                if (mapVar.get(LT(0).getText()) == null){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                    }
                                }
                        T_fp
            ;

cmdEscreva  :  "escreva" T_ap (T_texto{System.out.println("oiiiiiii2");} |
                                T_Id
                                    {System.out.println("oiiiiiii");
                                        if (mapVar.get(LT(0).getText()) == null){
                                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                        }
                                    }
                                ) T_fp
            ;

cmdAttr     :  T_Id
                   {
                        if (mapVar.get(LT(0).getText()) == null){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                    }
                                } 
                "recebe" expr
            ;

cmdIf       : "se" T_ap termBool T_fp "entao" T_cha bloco  T_chf (cmdElse)?
            ;

cmdElse     : "senao" T_cha bloco  T_chf
            ;
            
termBool    : fator opBool
            ;
opBool      :  (cmdLt|cmdGt|cmdNe|cmdGtig|cmdLtig|cmdEq)
            ;

cmdWhile    : "enquanto" T_ap termBool T_fp T_cha bloco  T_chf
	        ;
cmdFor      : "para" T_ap cmdAttr T_pontVirg T_Id
                                                {
                                                    if (mapVar.get(LT(0).getText()) == null){
                                                            throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                                                                            }
                                                }
                                                (cmdLt|cmdGt|cmdNe|cmdGtig|cmdLtig) fator T_pontVirg expr T_fp T_cha bloco  T_chf
	        ;
	        
cmdSwitch   : "escolha" T_ap T_Id 
                                
                                {
                                    if (mapVar.get(LT(0).getText()) == null){
                                    throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                    }
                                }
                                
                                T_fp T_cha ("caso" (T_num|T_texto) "faca" bloco )+ T_chf
	        ;
expr        :  termo (cmdSoma | cmdSubt)*  
            ;

termo       :  fator (cmdMult|cmdDivi)*
            ;

fator       :  T_Id
                {
                    if (mapVar.get(LT(0).getText()) == null){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                    }
                    }
                
                | T_num | T_ap expr T_fp
            ;
            
cmdSoma : "Mais" termo
        ;
cmdSubt : "Menos" termo
        ;
cmdMult : "MultiplicaPor" fator
        ;
cmdDivi : "DividePor" fator
        ;
cmdElev : "ElevadoA" termo
        ;

cmdLt	    : "eMenorQue" fator
	        ;

cmdGt	    : "eMaiorQue" fator
	        ;

cmdLtig      : "eMenorEIgualQue" fator
            ;
            
cmdGtig      : "eMaiorEIgualQue" fator
            ;	        
	        
cmdNe	    : "eDiferenteDe" fator
	        ;  
	        
cmdEq        : "eIgualQue" fator
            ;
class MeuLexer extends Lexer;

options{
    caseSensitive = true;
    k=7;
    
}


T_Id        : ('a'..'z'| 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')* 
            ;
  
T_virg      : ','
            ;
 
T_pontof    : '.'
            ;
T_pontVirg    : ';'
            ;            

T_ap        : '('
            ;
    
T_fp        : ')'
            ;
    

    
    

T_cha	    : '{'
	        ;

T_chf	    : '}'
	        ;

T_num       : ('0'..'9')+
            ;
    

          
T_texto     : "'" ('a'..'z' | '0'..'9' | ' ' | 'A'..'Z')+ "'"
            ;
          
T_blank     : (" " | "\n"{newline();} | "\r" | "\t") {_ttype=Token.SKIP;}
            ;
          
