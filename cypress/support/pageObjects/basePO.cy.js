/// <reference types="cypress"/>

class basePO{

    get userNameInput() {
        return cy.xpath('//input[@name="username"]');
    }

    get userPasswordInput() {
        return cy.xpath('//input[@name="password"]');
    }

    get loginButton() {
        return cy.xpath('//button[@type="submit"]');
    }

    visit() {
        cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index'); // URL ou caminho da página de login
    }

    typeUserName(username) {
        this.userNameInput.type(username);
    }

    typeUserPassword(password){
        this.userPasswordInput.type(password);
    }

    submit(){
        this.loginButton.click();
    }

    
    login(username, password) {
        this.visit();
        this.typeUserName(username);
        this.typeUserPassword(password);
        this.submit();

    }

    
}
export default new basePO();
