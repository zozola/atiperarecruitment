package pl.ozagrabska.atiperarecruitment;

public class AtiperaError {
    private int status;
    private String message;

    public AtiperaError() {
	this.status = 400;
	this.message = "";
    }
    
    public AtiperaError(int status, String message) {
        this.status = status;
        this.message = message;
    }
 
    public int getStatus() {
       return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
       this.message = message;
    }
}
