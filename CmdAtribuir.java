public class CmdAtribuir extends Command{
    private String idVar;
    private String conteudoAtr;
    public CmdAtribuir(String idVar,String conteudoAtr){
        this.idVar = idVar;
        this.conteudoAtr = conteudoAtr;
    
    }


    public String toJava(){
		return idVar + "="+ conteudoAtr +";";
	}



}
