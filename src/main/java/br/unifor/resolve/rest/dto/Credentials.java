package br.unifor.resolve.rest.dto;

import br.unifor.resolve.rest.util.MD5Encrypter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Credentials {

    private String email, password;

    public Credentials() {
    }

    public Credentials(String email, String password) {
        this.email = email;
        this.password = MD5Encrypter.encrypt(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = MD5Encrypter.encrypt(password);
    }
}
