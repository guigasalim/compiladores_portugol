public class CmdClose extends Command{
    private String idVar;
    public CmdClose(String idVar){
        this.idVar = idVar;
        
    
    }


    public String toJava(){
		return idVar;
	}



}
