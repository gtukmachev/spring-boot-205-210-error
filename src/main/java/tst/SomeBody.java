package tst;

import java.beans.ConstructorProperties;

public class SomeBody {

    private String login;

    @ConstructorProperties({"login", "password"})
    public SomeBody(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
