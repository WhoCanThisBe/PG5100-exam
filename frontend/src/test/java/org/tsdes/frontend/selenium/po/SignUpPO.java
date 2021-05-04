package org.tsdes.frontend.selenium.po;


import org.tsdes.frontend.selenium.PageObject;

/**
 * Primarily adapted from https://github.com/arcuri82/testing_security_development_enterprise_systems/
 */
public class SignUpPO extends LayoutPO{

    public SignUpPO(PageObject other) {
        super(other);
    }

    @Override
    public boolean isOnPage() {
        return getDriver().getTitle().contains("Sign Up");
    }

    public IndexPO createUser(
            String username,
            String password,
            String name,
            String surname,
            String email){

        setText("username", username);
        setText("password", password);
        setText("name",name);
        setText("surname",surname);
        setText("email",email);
        clickAndWait("submit");

        IndexPO po = new IndexPO(this);
        if(po.isOnPage()){
            return po;
        }

        return null;
    }
}
