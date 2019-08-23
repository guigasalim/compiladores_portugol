// $ANTLR 2.7.6 (20190807): "gramatica.g" -> "MeuLexer.java"$

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class MeuLexer extends antlr.CharScanner implements MeuParserTokenTypes, TokenStream
 {
public MeuLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public MeuLexer(Reader in) {
	this(new CharBuffer(in));
}
public MeuLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public MeuLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("Inteiro", this), new Integer(12));
	literals.put(new ANTLRHashString("programa", this), new Integer(4));
	literals.put(new ANTLRHashString("senao", this), new Integer(24));
	literals.put(new ANTLRHashString("ElevadoA", this), new Integer(35));
	literals.put(new ANTLRHashString("eIgualQue", this), new Integer(41));
	literals.put(new ANTLRHashString("Mais", this), new Integer(31));
	literals.put(new ANTLRHashString("leia", this), new Integer(14));
	literals.put(new ANTLRHashString("eMenorQue", this), new Integer(36));
	literals.put(new ANTLRHashString("DivididoPor", this), new Integer(34));
	literals.put(new ANTLRHashString("fimprog", this), new Integer(5));
	literals.put(new ANTLRHashString("Decimal", this), new Integer(13));
	literals.put(new ANTLRHashString("se", this), new Integer(20));
	literals.put(new ANTLRHashString("caso", this), new Integer(29));
	literals.put(new ANTLRHashString("escreva", this), new Integer(17));
	literals.put(new ANTLRHashString("declare", this), new Integer(7));
	literals.put(new ANTLRHashString("para", this), new Integer(27));
	literals.put(new ANTLRHashString("eMaiorEIgualQue", this), new Integer(39));
	literals.put(new ANTLRHashString("Menos", this), new Integer(32));
	literals.put(new ANTLRHashString("escolha", this), new Integer(28));
	literals.put(new ANTLRHashString("MultiplicadoPor", this), new Integer(33));
	literals.put(new ANTLRHashString("eDiferenteDe", this), new Integer(40));
	literals.put(new ANTLRHashString("recebe", this), new Integer(19));
	literals.put(new ANTLRHashString("como", this), new Integer(8));
	literals.put(new ANTLRHashString("entao", this), new Integer(21));
	literals.put(new ANTLRHashString("String", this), new Integer(9));
	literals.put(new ANTLRHashString("faca", this), new Integer(26));
	literals.put(new ANTLRHashString("eMaiorQue", this), new Integer(37));
	literals.put(new ANTLRHashString("enquanto", this), new Integer(25));
	literals.put(new ANTLRHashString("eMenorEIgualQue", this), new Integer(38));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':  case 'a':  case 'b':
				case 'c':  case 'd':  case 'e':  case 'f':
				case 'g':  case 'h':  case 'i':  case 'j':
				case 'k':  case 'l':  case 'm':  case 'n':
				case 'o':  case 'p':  case 'q':  case 'r':
				case 's':  case 't':  case 'u':  case 'v':
				case 'w':  case 'x':  case 'y':  case 'z':
				{
					mT_Id(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mT_virg(true);
					theRetToken=_returnToken;
					break;
				}
				case '.':
				{
					mT_pontof(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mT_pontVirg(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mT_ap(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mT_fp(true);
					theRetToken=_returnToken;
					break;
				}
				case '{':
				{
					mT_cha(true);
					theRetToken=_returnToken;
					break;
				}
				case '}':
				{
					mT_chf(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mT_num(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mT_texto(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mT_blank(true);
					theRetToken=_returnToken;
					break;
				}
				default:
				{
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mT_Id(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_Id;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop56:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			default:
			{
				break _loop56;
			}
			}
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_virg(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_virg;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_pontof(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_pontof;
		int _saveIndex;
		
		match('.');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_pontVirg(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_pontVirg;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_ap(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_ap;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_fp(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_fp;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_cha(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_cha;
		int _saveIndex;
		
		match('{');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_chf(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_chf;
		int _saveIndex;
		
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_num(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_num;
		int _saveIndex;
		
		{
		int _cnt66=0;
		_loop66:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt66>=1 ) { break _loop66; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt66++;
		} while (true);
		}
		{
		if ((LA(1)=='.')) {
			mT_pontof(false);
			{
			int _cnt69=0;
			_loop69:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0','9');
				}
				else {
					if ( _cnt69>=1 ) { break _loop69; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt69++;
			} while (true);
			}
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_texto(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_texto;
		int _saveIndex;
		
		match('"');
		{
		int _cnt72=0;
		_loop72:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case ' ':
			{
				match(' ');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			default:
			{
				if ( _cnt72>=1 ) { break _loop72; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt72++;
		} while (true);
		}
		match('"');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mT_blank(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = T_blank;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(" ");
			break;
		}
		case '\n':
		{
			match("\n");
			newline();
			break;
		}
		case '\r':
		{
			match("\r");
			break;
		}
		case '\t':
		{
			match("\t");
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		_ttype=Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	
	}
