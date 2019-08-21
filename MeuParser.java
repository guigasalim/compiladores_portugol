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
java.util.HashMap<String, String> mapVar;

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
			mapVar = new java.util.HashMap<String, String>();
			match(LITERAL_programa);
			declara();
			bloco();
			match(LITERAL_fimprog);
			match(T_pontof);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void declara() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_declare);
			match(T_Id);
			
			mapVar.put(LT(0).getText(), LT(0).getText());
			System.out.println("Variavel " + LT(0).getText() + " salva!");
			
			{
			_loop4:
			do {
				if ((LA(1)==T_virg)) {
					match(T_virg);
					match(T_Id);
					
					mapVar.put(LT(0).getText(), LT(0).getText());
					System.out.println("Variavel " + LT(0).getText() + " salva!");
					
				}
				else {
					break _loop4;
				}
				
			} while (true);
			}
			match(T_pontof);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void bloco() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt7=0;
			_loop7:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt7>=1 ) { break _loop7; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt7++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmd() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_leia:
			{
				cmdLeia();
				match(T_pontof);
				break;
			}
			case LITERAL_escreva:
			{
				cmdEscreva();
				match(T_pontof);
				break;
			}
			case T_Id:
			{
				cmdAttr();
				match(T_pontof);
				break;
			}
			case LITERAL_se:
			{
				cmdIf();
				break;
			}
			case LITERAL_para:
			{
				cmdFor();
				break;
			}
			case LITERAL_escolha:
			{
				cmdSwitch();
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
			if (mapVar.get(LT(0).getText()) == null){
			throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
			
			}
			
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
				
				if (mapVar.get(LT(0).getText()) == null){
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
			
			if (mapVar.get(LT(0).getText()) == null){
			throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
			
			}
			
			match(LITERAL_recebe);
			expr();
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
			bloco();
			match(T_chf);
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
			case LITERAL_para:
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
	
	public final void cmdFor() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_para);
			match(T_ap);
			declara();
			match(T_pontVirg);
			match(T_Id);
			
			if (mapVar.get(LT(0).getText()) == null){
			throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
			
			}
			
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
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			fator();
			match(T_pontVirg);
			expr();
			match(T_fp);
			match(T_cha);
			bloco();
			match(T_chf);
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
			
			if (mapVar.get(LT(0).getText()) == null){
			throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
			
			}
			
			match(T_fp);
			match(T_cha);
			{
			int _cnt25=0;
			_loop25:
			do {
				if ((LA(1)==LITERAL_caso)) {
					match(LITERAL_caso);
					{
					switch ( LA(1)) {
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
					match(LITERAL_faca);
					bloco();
				}
				else {
					if ( _cnt25>=1 ) { break _loop25; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt25++;
			} while (true);
			}
			match(T_chf);
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
			fator();
			opBool();
			fator();
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
			bloco();
			match(T_chf);
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
				
				if (mapVar.get(LT(0).getText()) == null){
				throw new RuntimeException("ERRO ID " + LT(0).getText() + " não declarado");
				
				}
				
				break;
			}
			case T_num:
			{
				match(T_num);
				num = new UnaryOperand(Float.parseFloat(LT(0).getText()));
				
				break;
			}
			case T_ap:
			{
				match(T_ap);
				expr();
				expression = new Expression();
				match(T_fp);
				
				if (expression.getRoot() == null)   expression.setRoot(num);
				expression.eval();
				System.out.println(expression);
				System.out.println(expression.getRoot().toXml());
				
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
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdLt() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMenorQue);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdGt() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMaiorQue);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdNe() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eDiferenteDe);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdGtig() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMaiorEIgualQue);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdLtig() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eMenorEIgualQue);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdEq() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eIgualQue);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
	}
	
	public final void cmdWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_enquanto);
			match(T_ap);
			termBool();
			match(T_fp);
			match(T_cha);
			bloco();
			match(T_chf);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void expr_c() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			termo();
			{
			_loop29:
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
					break _loop29;
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
			_loop32:
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
					break _loop32;
				}
				}
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_10);
		}
	}
	
	public final void cmdSoma() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_Mais);
			op = '+';
			sumOrSubt = new BinaryOperand(op);
			sumOrSubt.setLeft(num);
			termo();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
	}
	
	public final void cmdSubt() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_Menos);
			
			op='-';
			sumOrSubt = new BinaryOperand(op);
			sumOrSubt.setLeft(num);
			termo();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
	}
	
	public final void cmdMult() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_MultiplicadoPor);
			op='*';
			multOrDiv = new BinaryOperand(op);
			multOrDiv.setLeft(num);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
	}
	
	public final void cmdDivi() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_DivididoPor);
			op='/';
			multOrDiv = new BinaryOperand(op);
			multOrDiv.setLeft(num);
			fator();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
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
		"T_pontof",
		"\"declare\"",
		"T_Id",
		"T_virg",
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
		"\"para\"",
		"T_pontVirg",
		"\"escolha\"",
		"\"caso\"",
		"T_num",
		"\"faca\"",
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
		"T_blank"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 29435136L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 21046528L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 34078752L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 55125280L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 64L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 4160L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 4096L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 545267915074L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 67111168L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 805310530L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 805310528L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 4026536002L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	
	}
