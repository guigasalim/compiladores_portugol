// $ANTLR 2.7.6 (20190807): "gramatica.g" -> "MeuParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class MeuParser extends antlr.LLkParser       implements MeuParserTokenTypes
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

protected MeuParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected MeuParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenStream lexer) {
  this(lexer,1);
}

public MeuParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void prog() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			mapVarInt = new java.util.HashMap<String, String>();
			mapVarDouble = new java.util.HashMap<String, String>();
			mapVarString = new java.util.HashMap<String, String>();
			mapVarTipo = new java.util.HashMap<String, String>();
			
			match(LITERAL_programa);
			{
			int _cnt3=0;
			_loop3:
			do {
				if ((LA(1)==LITERAL_declare)) {
					declara();
				}
				else {
					if ( _cnt3>=1 ) { break _loop3; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt3++;
			} while (true);
			}
			bloco();
			match(LITERAL_fimprog);
			match(T_pontVirg);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void declara() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_declare);
			match(LITERAL_como);
			tipo();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void bloco() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt14=0;
			_loop14:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt14>=1 ) { break _loop14; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt14++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void tipo() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_String:
			{
				match(LITERAL_String);
				
				tipo = LT(0).getText(); 
				tipo = tipo.replace("\"","");
				
				
				match(T_Id);
				
				mapVarString.put(LT(0).getText(), LT(0).getText());
				mapVarTipo.put(LT(0).getText(), tipo    );
				
				
				
				{
				_loop7:
				do {
					if ((LA(1)==T_virg)) {
						match(T_virg);
						match(T_Id);
						
						mapVarString.put(LT(0).getText(), LT(0).getText());
						mapVarTipo.put(LT(0).getText(), tipo    );
						
						
					}
					else {
						break _loop7;
					}
					
				} while (true);
				}
				match(T_pontVirg);
				p.setVariaveisString(mapVarString.values());
				break;
			}
			case LITERAL_Inteiro:
			{
				match(LITERAL_Inteiro);
				
				
				tipo = LT(0).getText(); 
				tipo = tipo.replace("\"","");
				
				
				match(T_Id);
				
				mapVarInt.put(LT(0).getText(), LT(0).getText());
				mapVarTipo.put(LT(0).getText(), tipo    );
				
				
				
				{
				_loop9:
				do {
					if ((LA(1)==T_virg)) {
						match(T_virg);
						match(T_Id);
						
						mapVarInt.put(LT(0).getText(), LT(0).getText());
						mapVarTipo.put(LT(0).getText(), tipo    );
						
						
					}
					else {
						break _loop9;
					}
					
				} while (true);
				}
				match(T_pontVirg);
				p.setVariaveisInt(mapVarInt.values());
				break;
			}
			case LITERAL_Decimal:
			{
				match(LITERAL_Decimal);
				
				
				tipo = LT(0).getText(); 
				tipo = tipo.replace("\"","");
				
				
				
				match(T_Id);
				
				mapVarDouble.put(LT(0).getText(), LT(0).getText());
				mapVarTipo.put(LT(0).getText(), tipo    );
				
				
				{
				_loop11:
				do {
					if ((LA(1)==T_virg)) {
						match(T_virg);
						match(T_Id);
						
						mapVarDouble.put(LT(0).getText(), LT(0).getText());
						mapVarTipo.put(LT(0).getText(), tipo    );
						
						
					}
					else {
						break _loop11;
					}
					
				} while (true);
				}
				match(T_pontVirg);
				p.setVariaveisDouble(mapVarDouble.values());
				
						      
							  System.out.println("Variable list assembled...");
						
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void cmd() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_leia:
			{
				cmdLeia();
				match(T_pontVirg);
				break;
			}
			case LITERAL_escreva:
			{
				cmdEscreva();
				match(T_pontVirg);
				break;
			}
			case T_Id:
			{
				cmdAttr();
				match(T_pontVirg);
				break;
			}
			case LITERAL_se:
			{
				cmdIf();
				break;
			}
			case LITERAL_escolha:
			{
				cmdSwitch();
				break;
			}
			case LITERAL_enquanto:
			{
				cmdWhile();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdLeia() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_leia);
			match(T_ap);
			match(T_Id);
			System.out.println("Variavel "+ LT(0).getText() + " lida") ;
			if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
			throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
			
			
			}
			p.addCommand(new CmdLeitura(LT(0).getText()));
			
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void cmdEscreva() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_escreva);
			match(T_ap);
			{
			switch ( LA(1)) {
			case T_texto:
			{
				match(T_texto);
				break;
			}
			case T_Id:
			{
				match(T_Id);
				
				if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
				throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
				
				}
				
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			p.addCommand(new CmdEscrita(LT(0).getText()));
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void cmdAttr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_Id);
			
			if ((mapVarTipo.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
			throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
			
			}else {comparaTipo = mapVarTipo.get(LT(0).getText());
			idVar = LT(0).getText();
			
			}       
			
			match(LITERAL_recebe);
			conteudoAtr = "";
			{
			switch ( LA(1)) {
			case T_Id:
			case T_ap:
			case T_num:
			{
				expr();
				break;
			}
			case T_texto:
			{
				
				if(comparaTipo != "Inteiro"||comparaTipo != "Decimal"){
				throw new RuntimeException("ERRO ID " + LT(0).getText() + " declarado como "+ comparaTipo + " sendo uma String");
				
				}
				
				
				
				match(T_texto);
				
				if(comparaTipo != "String"){
				throw new RuntimeException("ERRO ID " + LT(0).getText() + " declarado como "+ comparaTipo + "não sendo uma String");
				
				}
				conteudoAtr = LT(0).getText();
				conteudoAtr = conteudoAtr.replace("\"","");
				
				
				
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			p.addCommand(new CmdAtribuir(idVar,conteudoAtr));
			conteudoAtr = "";
			idVar = "";
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void cmdIf() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_se);
			match(T_ap);
			termBool();
			match(T_fp);
			match(LITERAL_entao);
			match(T_cha);
			
			
			p.addCommand(new CmdSe(conteudoBool));
			conteudoBool = "";
			
			bloco();
			match(T_chf);
			
			
			p.addCommand(new CmdClose(LT(0).getText()));
			{
			switch ( LA(1)) {
			case LITERAL_senao:
			{
				cmdElse();
				break;
			}
			case LITERAL_fimprog:
			case T_Id:
			case LITERAL_leia:
			case LITERAL_escreva:
			case LITERAL_se:
			case T_chf:
			case LITERAL_enquanto:
			case LITERAL_escolha:
			case LITERAL_caso:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdSwitch() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_escolha);
			match(T_ap);
			match(T_Id);
			
			if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
			throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
			
			}
			
			idVar = LT(0).getText();
			
			match(T_fp);
			match(T_cha);
			p.addCommand(new CmdEscolha(idVar));
			idVar = "";
			{
			int _cnt31=0;
			_loop31:
			do {
				if ((LA(1)==LITERAL_caso)) {
					match(LITERAL_caso);
					{
					switch ( LA(1)) {
					case T_Id:
					{
						match(T_Id);
						
						if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
						throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
						
						}
						
						break;
					}
					case T_num:
					{
						match(T_num);
						break;
					}
					case T_texto:
					{
						match(T_texto);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					idVar = LT(0).getText();
					
					
					match(LITERAL_faca);
					
					p.addCommand(new CmdCaso(idVar));
					idVar = "";
					
					bloco();
					p.addCommand(new CmdFimCaso());
				}
				else {
					if ( _cnt31>=1 ) { break _loop31; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt31++;
			} while (true);
			}
			match(T_chf);
			
			p.addCommand(new CmdClose(LT(0).getText()));
			
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_enquanto);
			match(T_ap);
			termBool();
			match(T_fp);
			match(LITERAL_faca);
			
			
			p.addCommand(new CmdEnquanto(conteudoBool));
			conteudoBool = "";
			
			match(T_cha);
			bloco();
			match(T_chf);
			
			
			p.addCommand(new CmdClose(LT(0).getText()));
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			expression = new Expression();
			expr_c();
			
			if (expression.getRoot() == null) expression.setRoot(num);
			expression.eval();
			System.out.println(expression);
			System.out.println(expression.getRoot().toXml());
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
	}
	
	public final void termBool() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			conteudoBool = "";
			fator();
			
			conteudoBool = conteudoBool + LT(0).getText();
			
			
			
			opBool();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void cmdElse() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_senao);
			match(T_cha);
			
			
			p.addCommand(new CmdSenao());
			
			
			bloco();
			match(T_chf);
			
			
			p.addCommand(new CmdClose(LT(0).getText()));
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void fator() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				
				if ((mapVarInt.get(LT(0).getText()) == null)&&(mapVarDouble.get(LT(0).getText())==null)&&(mapVarInt.get(LT(0).getText()) == null)){
				throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
				
				}
				conteudoAtr = conteudoAtr + LT(0).getText();
				
				break;
			}
			case T_num:
			{
				match(T_num);
				num = new UnaryOperand(Float.parseFloat(LT(0).getText()));
				conteudoAtr = conteudoAtr + LT(0).getText();
				
				break;
			}
			case T_ap:
			{
				match(T_ap);
				conteudoAtr = conteudoAtr + LT(0).getText();
				expr();
				match(T_fp);
				conteudoAtr = conteudoAtr + LT(0).getText();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
	}
	
	public final void opBool() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_eMenorQue:
			{
				cmdLt();
				break;
			}
			case LITERAL_eMaiorQue:
			{
				cmdGt();
				break;
			}
			case LITERAL_eDiferenteDe:
			{
				cmdNe();
				break;
			}
			case LITERAL_eMaiorEIgualQue:
			{
				cmdGtig();
				break;
			}
			case LITERAL_eMenorEIgualQue:
			{
				cmdLtig();
				break;
			}
			case LITERAL_eIgualQue:
			{
				cmdEq();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void cmdLt() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMenorQue);
			fator();
			conteudoBool =conteudoBool+ "<"+ LT(0).getText();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void cmdGt() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMaiorQue);
			fator();
			conteudoBool =conteudoBool+ ">"+ LT(0).getText();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void cmdNe() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eDiferenteDe);
			fator();
			conteudoBool =conteudoBool+  "!="+ LT(0).getText();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void cmdGtig() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMaiorEIgualQue);
			fator();
			conteudoBool =conteudoBool+ ">="+ LT(0).getText();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void cmdLtig() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMenorEIgualQue);
			fator();
			conteudoBool =conteudoBool+ "<="+ LT(0).getText();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void cmdEq() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eIgualQue);
			fator();
			conteudoBool =conteudoBool+ "=="+ LT(0).getText();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void expr_c() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			termo();
			{
			_loop35:
			do {
				switch ( LA(1)) {
				case LITERAL_Mais:
				{
					cmdSoma();
					
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
					
					break;
				}
				case LITERAL_Menos:
				{
					cmdSubt();
					
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
					
					break;
				}
				default:
				{
					break _loop35;
				}
				}
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
	}
	
	public final void termo() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			fator();
			{
			_loop38:
			do {
				switch ( LA(1)) {
				case LITERAL_MultiplicadoPor:
				{
					cmdMult();
					
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
					
					break;
				}
				case LITERAL_DivididoPor:
				{
					cmdDivi();
					
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
					
					break;
				}
				default:
				{
					break _loop38;
				}
				}
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdSoma() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_Mais);
			op = '+';
			conteudoAtr = conteudoAtr + op;
			sumOrSubt = new BinaryOperand(op);
			sumOrSubt.setLeft(num);
			termo();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_10);
		}
	}
	
	public final void cmdSubt() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_Menos);
			
			op='-';
			conteudoAtr = conteudoAtr + op;
			sumOrSubt = new BinaryOperand(op);
			sumOrSubt.setLeft(num);
			termo();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_10);
		}
	}
	
	public final void cmdMult() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_MultiplicadoPor);
			
			op='*';
			conteudoAtr = conteudoAtr + op;
			multOrDiv = new BinaryOperand(op);
			multOrDiv.setLeft(num);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
	}
	
	public final void cmdDivi() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_DivididoPor);
			
			op='/';
			conteudoAtr = conteudoAtr + op;
			multOrDiv = new BinaryOperand(op);
			multOrDiv.setLeft(num);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
	}
	
	public final void cmdElev() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_ElevadoA);
			termo();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"programa\"",
		"\"fimprog\"",
		"T_pontVirg",
		"\"declare\"",
		"\"como\"",
		"\"String\"",
		"T_Id",
		"T_virg",
		"\"Inteiro\"",
		"\"Decimal\"",
		"\"leia\"",
		"T_ap",
		"T_fp",
		"\"escreva\"",
		"T_texto",
		"\"recebe\"",
		"\"se\"",
		"\"entao\"",
		"T_cha",
		"T_chf",
		"\"senao\"",
		"\"enquanto\"",
		"\"faca\"",
		"\"escolha\"",
		"\"caso\"",
		"T_num",
		"\"Mais\"",
		"\"Menos\"",
		"\"MultiplicadoPor\"",
		"\"DivididoPor\"",
		"\"ElevadoA\"",
		"\"eMenorQue\"",
		"\"eMaiorQue\"",
		"\"eMenorEIgualQue\"",
		"\"eMaiorEIgualQue\"",
		"\"eDiferenteDe\"",
		"\"eIgualQue\"",
		"T_pontof",
		"T_blank"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 168969344L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 168969216L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 276824096L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 445793312L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 64L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 65600L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 65536L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 2180769710146L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 3221291074L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 3221291072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 16106192962L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	
	}
