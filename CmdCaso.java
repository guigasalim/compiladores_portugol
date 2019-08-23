public class CmdCaso extends Command{
    private String idVar;
    public CmdCaso(String idVar){
        
        this.idVar = idVar;
    
    }


    public String toJava(){
		return "case "+ idVar +" :";
	}



}
