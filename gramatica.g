class MeuParser extends Parser;
{
 Expression expression;
   AbstractOperand num;
   BinaryOperand sumOrSubt;
   AbstractOperand parent;
   BinaryOperand multOrDiv;
   char op;
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
            |  cmdAttr  T_pontof
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

cmdEscreva  :  "escreva" T_ap (T_texto |
                                T_Id
                                    {
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
            
termBool    : fator opBool fator
            ;
opBool      :  (cmdLt|cmdGt|cmdNe|cmdGtig|cmdLtig|cmdEq)
            ;

cmdWhile    : "enquanto" T_ap termBool T_fp T_cha bloco  T_chf
	        ;
cmdFor      : "para" T_ap declara T_pontVirg T_Id
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


expr        : {expression = new Expression();} expr_c 
          {
            if (expression.getRoot() == null) expression.setRoot(num);
            expression.eval();
            System.out.println(expression);
            System.out.println(expression.getRoot().toXml());
          } ;
          
          
          
          
expr_c :          termo (cmdSoma 
                     { 
                     if(expression.getRoot() == null){
                        sumOrSubt.setRight(num);
                        expression.setRoot(sumOrSubt);
                        parent = sumOrSubt;
                     }
                     else{
                         sumOrSubt = new BinaryOperand(op);
                         sumOrSubt.setRight(num);
                         BinaryOperand pai = (BinaryOperand)parent;
                         sumOrSubt.setLeft(pai.getRight());
                         pai.setRight(sumOrSubt);
                     }
                  }
                   | cmdSubt
                    
                      { 
                     if(expression.getRoot() == null){
                        sumOrSubt.setRight(num);
                        expression.setRoot(sumOrSubt);
                        parent = sumOrSubt;
                     }
                     else{
                         sumOrSubt = new BinaryOperand(op);
                         sumOrSubt.setRight(num);
                         BinaryOperand pai = (BinaryOperand)parent;
                         sumOrSubt.setLeft(pai.getRight());
                         pai.setRight(sumOrSubt);
                     }
                  })* 
            ;            
termo       :  fator (cmdMult
                      { 
                     if(expression.getRoot() == null){
                        multOrDiv.setRight(num);
                        expression.setRoot(multOrDiv);
                        parent = multOrDiv;
                     }
                     else{
                         multOrDiv = new BinaryOperand(op);
                         multOrDiv.setRight(num);
                         BinaryOperand pai = (BinaryOperand)parent;
                         multOrDiv.setLeft(pai.getRight());
                         pai.setRight(multOrDiv);
                     }
                  }
                     
                    |cmdDivi
                     { 
                     if(expression.getRoot() == null){
                        multOrDiv.setRight(num);
                        expression.setRoot(multOrDiv);
                        parent = multOrDiv;
                     }
                     else{
                         multOrDiv = new BinaryOperand(op);
                         multOrDiv.setRight(num);
                         BinaryOperand pai = (BinaryOperand)parent;
                         multOrDiv.setLeft(pai.getRight());
                         pai.setRight(multOrDiv);
                     }
                  }
                    
                     )*
            ;

fator       :  T_Id
                {
                    if (mapVar.get(LT(0).getText()) == null){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                    }
                    }
                
                | T_num 
                { num = new UnaryOperand(Float.parseFloat(LT(0).getText()));
                }
                | T_ap expr {expression = new Expression();} 
                  T_fp
                  {
                    if (expression.getRoot() == null)   expression.setRoot(num);
                                                        expression.eval();
                                                        System.out.println(expression);
                                                        System.out.println(expression.getRoot().toXml());
          } 
            ;
            
cmdSoma :  "Mais"
                    {   op = '+';
                        sumOrSubt = new BinaryOperand(op);
                    sumOrSubt.setLeft(num);}
            
            termo
          
        ;
cmdSubt : "Menos"
            {
op='-';
            sumOrSubt = new BinaryOperand(op);
                                sumOrSubt.setLeft(num);} 
            termo
            
        ;
cmdMult : "MultiplicadoPor"{op='*';
            multOrDiv = new BinaryOperand(op);
                                multOrDiv.setLeft(num);} fator
        ;
cmdDivi : "DivididoPor"{op='/';
            multOrDiv = new BinaryOperand(op);
                                multOrDiv.setLeft(num);} fator
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
          
