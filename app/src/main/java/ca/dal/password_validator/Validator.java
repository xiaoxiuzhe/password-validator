package ca.dal.password_validator;

public class Validator {
    private boolean valid;
    private String password;

    public boolean validate(String password){
        valid = true;
        this.password = password;
        //password must have at least 8 characters
        if (password.length() < 8){
            valid = false;
        }
        //password must no be "password"  (case insensitive)
        if (password.toLowerCase().equals("password")){
            valid = false;
        }
        //password must have a uppercase character
        if (password.equals(password.toLowerCase())){
            valid = false;
        }
        //password must have a lowercase character
        if (password.equals(password.toUpperCase())){
            valid = false;
        }
        //at least one digit is required
        if (!password.matches(".*\\d+.*")){
            valid = false;
        }
        //at least one special character is required
        if (password.matches("[a-zA-Z0-9 ]*")){
            valid = false;
        }
        return valid;
    }
}
