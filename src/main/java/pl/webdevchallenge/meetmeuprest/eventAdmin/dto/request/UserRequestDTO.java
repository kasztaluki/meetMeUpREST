package pl.webdevchallenge.meetmeuprest.eventAdmin.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDTO {

    @NotNull
    @Size(min=1, max = 120)
    private String mail;

    @NotNull
    @Size(min = 1, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @Size(min = 6, max = 20)
    private String profileNick;

    private String password;

    private String newPassword;

    private String repeatedPassword;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String mail, String firstName, String lastName, String profileNick, String newPassword, String repeatedPassword) {
        super();
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileNick = profileNick;
        this.newPassword = newPassword;
        this.repeatedPassword = repeatedPassword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileNick() {
        return profileNick;
    }

    public void setProfileNick(String profileNick) {
        this.profileNick = profileNick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public boolean isPasswordChangeDetected() {
        return this.newPassword != null;
    }
}
