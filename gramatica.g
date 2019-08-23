class MeuParser extends Parser;
{
 Expression expression;
   AbstractOperand num;
   BinaryOperand sumOrSubt;
   AbstractOperand parent;
   BinaryOperand multOrDiv;
   char op;
    int confirmaInt;
    double confirmaDouble;
    String tipo;
    String comparaTipo;
    String conteudoAtr;
    String idVar;
    String conteudoBool;
   Programa p;

    public void setPrograma(String name){
      p = new Programa(name);
    }
  
    public Programa getPrograma(){
       return p;
    }
java.util.HashMap<String, String> mapVarInt;
java.util.HashMap<String, String> mapVarDouble;
java.util.HashMap<String, String> mapVarString;
java.util.HashMap<String, String> mapVarTipo;
}


prog        : {mapVarInt = new java.util.HashMap<String, String>();
                mapVarDouble = new java.util.HashMap<String, String>();
                mapVarString = new java.util.HashMap<String, String>();
                mapVarTipo = new java.util.HashMap<String, String>();
                } "programa" (declara)+ bloco "fimprog" T_pontVirg
            ;
    
declara     :  "declare" "como" tipo 
            ;

tipo	:

            "String" 
                    {
                    tipo = LT(0).getText(); 
                   tipo = tipo.replace("\"","");
                    
                    }  
            T_Id    
                    { 
                        mapVarString.put(LT(0).getText(), LT(0).getText());
                        mapVarTipo.put(LT(0).getText(), tipo    );
                        System.out.println("Variavel "+LT(0).getText()+" encontrada do tipo "+tipo);
                        System.out.println("Variavel " + LT(0).getText() + " salva!");
                                
                    }
            (T_virg T_Id
                {
                        mapVarString.put(LT(0).getText(), LT(0).getText());
                        mapVarTipo.put(LT(0).getText(), tipo    );
                        System.out.println("Variavel "+LT(0).getText()+" encontrada do tipo "+tipo);
                       System.out.println("Variavel " + LT(0).getText() + " salva!");
                }
            )* T_pontVirg
                {p.setVariaveisString(mapVarString.values());}
            |"Inteiro"
                
                {
                    
                    tipo = LT(0).getText(); 
                    tipo = tipo.replace("\"","");
                    
                    }
                
            T_Id 
            {
                    mapVarInt.put(LT(0).getText(), LT(0).getText());
                     mapVarTipo.put(LT(0).getText(), tipo    );
                        System.out.println("Variavel "+LT(0).getText()+" encontrada do tipo "+tipo);
                    System.out.println("Variavel " + LT(0).getText() + " salva!");
                    
                  }
            (T_virg T_Id
                {
                 mapVarInt.put(LT(0).getText(), LT(0).getText());
                 mapVarTipo.put(LT(0).getText(), tipo    );
                        System.out.println("Variavel "+LT(0).getText()+" encontrada do tipo "+tipo);
                System.out.println("Variavel " + LT(0).getText() + " salva!");
                }
            )* T_pontVirg
                {p.setVariaveisInt(mapVarInt.values());}
            |"Decimal"
                {
                
                    tipo = LT(0).getText(); 
                   tipo = tipo.replace("\"","");
                    
                    
                }
            T_Id 
                { 
                 mapVarDouble.put(LT(0).getText(), LT(0).getText());
                  mapVarTipo.put(LT(0).getText(), tipo    );
                        System.out.println("Variavel "+LT(0).getText()+" encontrada do tipo "+tipo);
                 System.out.println("Variavel " + LT(0).getText() + " salva!");
                }
            (T_virg T_Id
                {
                  mapVarDouble.put(LT(0).getText(), LT(0).getText());
                   mapVarTipo.put(LT(0).getText(), tipo    );
                        System.out.println("Variavel "+LT(0).getText()+" encontrada do tipo "+tipo);
                  System.out.println("Variavel " + LT(0).getText() + " salva!");
                                    }
            )* T_pontVirg{p.setVariaveisDouble(mapVarDouble.values());}  

	 {
		      
			  System.out.println("Variable list assembled...");
		   }
	
	;


bloco       :  (cmd)+
            ;
    
cmd         :  cmdLeia T_pontVirg
            |  cmdEscreva T_pontVirg
            |  cmdAttr  T_pontVirg
	        |  cmdIf 
            |  cmdFor 
            |  cmdSwitch 
            |  cmdWhile
            ;
    
cmdLeia     :  "leia" T_ap 
                        T_Id{System.out.println("Variavel "+ LT(0).getText() + " lida") ;
                                if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                
                                    
                                    }
                                p.addCommand(new CmdLeitura(LT(0).getText()));
                                }
                        T_fp  
            ;

cmdEscreva  :  "escreva" T_ap (T_texto |
                                T_Id
                                    {
                                        if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
                                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                        }
                                    }
                                )  { p.addCommand(new CmdEscrita(LT(0).getText())); } T_fp
            ;

cmdAttr     :  T_Id
                   {
                        if ((mapVarTipo.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                    }else {comparaTipo = mapVarTipo.get(LT(0).getText());
                                            idVar = LT(0).getText();
                                        
                                     }       
                                } 
                "recebe" 
                    {conteudoAtr = "";}
                (expr|
                                {
                                if(comparaTipo != "Inteiro"||comparaTipo != "Decimal"){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " declarado como "+ comparaTipo + " sendo uma String");
                                
                                }
                                
                                
                                }
                
                                T_texto
                                
                                {
                                if(comparaTipo != "String"){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " declarado como "+ comparaTipo + "não sendo uma String");
                                                         
                                }
                                conteudoAtr = LT(0).getText();
                                conteudoAtr = conteudoAtr.replace("\"","");
       
                                
                                }
                                
                                
                                ){  p.addCommand(new CmdAtribuir(idVar,conteudoAtr));
                                    conteudoAtr = "";
                                    idVar = "";
                                }
            ;

cmdIf       : "se" T_ap termBool T_fp "entao" T_cha{
                                                    
                                                    p.addCommand(new CmdSe(conteudoBool));
                                                    conteudoBool = "";
                                                    } 
                bloco  T_chf{
                            
                            p.addCommand(new CmdClose(LT(0).getText()));} (cmdElse)?
            ;

cmdElse     : "senao" T_cha 
                      {
                                                    
                    p.addCommand(new CmdSenao());
                   
                    } 
                    
                    bloco  T_chf{
                            
                            p.addCommand(new CmdClose(LT(0).getText()));}
            ;
            
            
termBool    : {conteudoBool = "";}fator {
                    conteudoBool = conteudoBool + LT(0).getText();
                    System.out.println("O token anterior é: "+LT(0).getText());
                    
                    } opBool 
            ;
opBool      :  (cmdLt|cmdGt|cmdNe|cmdGtig|cmdLtig|cmdEq)
            ;

cmdWhile    : "enquanto" T_ap termBool T_fp "faca"
                           {
                                                    
                    p.addCommand(new CmdEnquanto(conteudoBool));
                    conteudoBool = "";
                    } 
                        T_cha bloco  T_chf {
                            
                            p.addCommand(new CmdClose(LT(0).getText()));}
	        ;
cmdFor      : "para" T_ap declara T_pontVirg T_Id
                                                {
                                                    if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
                                                            throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                                                                            }
                                                }
                                                (cmdLt|cmdGt|cmdNe|cmdGtig|cmdLtig) fator T_pontVirg expr T_fp T_cha bloco  T_chf
	        ;
	        
cmdSwitch   : "escolha" T_ap T_Id 
                                
                                {
                                    if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
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
          
          
          
          
expr_c :           termo (cmdSoma 
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
termo       :    fator (cmdMult
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
                    if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
                                throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
                                    
                                    }
                    }
                
                | T_num 
                { num = new UnaryOperand(Float.parseFloat(LT(0).getText()));
                        conteudoAtr = conteudoAtr + LT(0).getText();
                }
                | T_ap{conteudoAtr = conteudoAtr + LT(0).getText();} expr  
                  T_fp{conteudoAtr = conteudoAtr + LT(0).getText();}
                  				 
            ;
            
cmdSoma :  "Mais" 
                    {   op = '+';
                    conteudoAtr = conteudoAtr + op;
                        sumOrSubt = new BinaryOperand(op);
                    sumOrSubt.setLeft(num);}
            
            termo
          
        ;
cmdSubt : "Menos"
            {
            op='-';
            conteudoAtr = conteudoAtr + op;
            sumOrSubt = new BinaryOperand(op);
                                sumOrSubt.setLeft(num);} 
            termo
            
        ;
cmdMult : "MultiplicadoPor"{
            op='*';
            conteudoAtr = conteudoAtr + op;
            multOrDiv = new BinaryOperand(op);
                                multOrDiv.setLeft(num);} fator
        ;
cmdDivi : "DivididoPor"{
            op='/';
            conteudoAtr = conteudoAtr + op;
            multOrDiv = new BinaryOperand(op);
                                multOrDiv.setLeft(num);} fator
        ;
cmdElev : "ElevadoA" termo
        ;

cmdLt	    : "eMenorQue" fator   {conteudoBool =conteudoBool+ "<"+ LT(0).getText();}
	        ;

cmdGt	    : "eMaiorQue" fator   {conteudoBool =conteudoBool+ ">"+ LT(0).getText();}
	        ;

cmdLtig      : "eMenorEIgualQue" fator {conteudoBool =conteudoBool+ "<="+ LT(0).getText();}
            ;
            
cmdGtig      : "eMaiorEIgualQue" fator {conteudoBool =conteudoBool+ ">="+ LT(0).getText();}
            ;	        
	        
cmdNe	    : "eDiferenteDe" fator {conteudoBool =conteudoBool+  "!="+ LT(0).getText();}
	        ;  
	        
cmdEq        : "eIgualQue" fator {conteudoBool =conteudoBool+ "=="+ LT(0).getText();}
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

T_num       : ('0'..'9')+(T_pontof ('0'..'9')+)?
            ;
    

          
T_texto  : '"' ( 'a'..'z' | '0'..'9' | ' ' | 'A'..'Z' )+ '"'
            ;
          
T_blank     : (" " | "\n"{newline();} | "\r" | "\t") {_ttype=Token.SKIP;}
            ;
          
