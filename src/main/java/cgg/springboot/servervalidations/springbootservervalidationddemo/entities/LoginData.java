package cgg.springboot.servervalidations.springbootservervalidationddemo.entities;

import cgg.springboot.servervalidations.springbootservervalidationddemo.validations.ImageNameValidate;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData{
                         @NotBlank(message = "UserName cannot be empty!")
                         @Size(min=3,max = 12,message = "UserName must be 3 to 12 characters")
                        private String userName;
                         @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email!")
                         private String email;
                        @AssertTrue(message = "Must agree Terms&Conditions")
                        private boolean agreed;


                        // Custom Validator
                        @ImageNameValidate
                        private String imageName;

    public LoginData(){
        //default constructor
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginData(
            @NotBlank(message = "UserName cannot be empty!") @Size(min = 3, max = 12, message = "UserName must be 3 to 12 characters") String userName,
            @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email!") String email,
            @AssertTrue(message = "Must agree Terms&Conditions") boolean agreed) {
        this.userName = userName;
        this.email = email;
        this.agreed = agreed;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    @Override
    public String toString() {
        return "LoginData [userName=" + userName + ", email=" + email + ", agreed=" + agreed + "]";
    }
}
