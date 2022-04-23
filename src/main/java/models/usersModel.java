package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author mohware
 */
public class usersModel {

    @Expose
    @SerializedName("success")
    private Boolean success;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("u_name")
    private String u_name;

    @Expose
    @SerializedName("f_name")
    private String f_name;

    @Expose
    @SerializedName("l_name")
    private String l_name;

    @Expose
    @SerializedName("pass")
    private String pass;

    @Expose
    @SerializedName("pin")
    private String pin;

    @Expose
    @SerializedName("designation")
    private String designation;

    @Expose
    @SerializedName("duty")
    private String duty;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("security")
    private String security;

    @Expose
    @SerializedName("securityPIN")
    private String securityPIN;

    @Expose
    @SerializedName("present")
    private String present;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getSecurityPIN() {
        return securityPIN;
    }

    public void setSecurityPIN(String securityPIN) {
        this.securityPIN = securityPIN;
    }

}
