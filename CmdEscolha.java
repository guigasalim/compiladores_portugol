public class CmdEscolha extends Command{
    private String idVar;
    public CmdEscolha(String idVar){
        
        this.idVar = idVar;
    
    }


    public String toJava(){
		return "switch ("+ idVar +") {";
	}



}
