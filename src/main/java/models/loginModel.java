package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author mohware
 */
public class loginModel {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("success")
    private Boolean success;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("pass")
    private String pass;
    @Expose
    @SerializedName("designation")
    private String designation;
    @Expose
    @SerializedName("counter")
    private String counter;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

}
