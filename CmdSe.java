public class CmdSe extends Command{
    private String conteudoBool;
    public CmdSe(String conteudoBool){
        
        this.conteudoBool = conteudoBool;
    
    }


    public String toJava(){
		return "if ("+ conteudoBool +") {";
	}



}
