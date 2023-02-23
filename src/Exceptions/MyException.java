package Exceptions;

public class MyException extends Exception {
    private String exp_message;

    public MyException(String exp_message) {
        this.exp_message = exp_message;
    }

    public String getMessage(){
        return exp_message;
    }

}
