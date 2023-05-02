package kz.pavel.crm.util;

public class CustomerErrorResponse {
    private String message;

    public CustomerErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
