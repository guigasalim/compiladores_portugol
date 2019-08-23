public class CmdEnquanto extends Command{
    private String conteudoBool;
    public CmdEnquanto(String conteudoBool){
        
        this.conteudoBool = conteudoBool;
    
    }


    public String toJava(){
		return "while ("+ conteudoBool +") {";
	}



}
