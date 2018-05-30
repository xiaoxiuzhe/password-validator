package ca.dal.password_validator;

public class Validator {
    private boolean valid;
    private String password;

    public boolean validate(String password){
        valid = true;
        this.password = password;
        if (password.length() < 8){
            valid = false;
        }
        if (password.toLowerCase().equals("password")){
            valid = false;
        }
        return valid;
    }
}
