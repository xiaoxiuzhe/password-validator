package ca.dal.password_validator;

public class Validator {
    private boolean valid;
    private String password;
    private String message;

    public Validator(){
        valid = true;
        message = "";
    }

    public boolean validate(String password){
        this.password = password;
        //password must have at least 8 characters
        if (password.length() < 8){
            valid = false;
            message = message.concat("\nMust have at least 8 characters");
        }
        //password must no be "password"  (case insensitive)
        if (password.toLowerCase().equals("password")){
            valid = false;
            message = message.concat("\nMust no be \"password\"  (case insensitive)");
        }
        //password must have a uppercase character
        if (password.equals(password.toLowerCase())){
            valid = false;
            message = message.concat("\nMust have at least one uppercase character");
        }
        //password must have a lowercase character
        if (password.equals(password.toUpperCase())){
            valid = false;
            message = message.concat("\nMust have at least one lowercase character");
        }
        //at least one digit is required
        if (!password.matches(".*\\d+.*")){
            valid = false;
            message = message.concat("\nMust have at least one digit");
        }
        //at least one special character is required
        if (password.matches("[a-zA-Z0-9 ]*")){
            valid = false;
            message = message.concat("\nMust have at least one special character");
        }
        return valid;
    }

    public String printMessage(){
        return message;
    }
}
