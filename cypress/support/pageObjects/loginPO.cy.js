/// <reference types="cypress"/>


class loginPO{

    get loginConfirmation(){
        return cy.xpath('//h6[@class="oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module"]').should('have.text', 'Dashboard')
    }

    get invalidCredentialsMessage() {
        return cy.xpath('//p[@class="oxd-text oxd-text--p oxd-alert-content-text"]').should('have.text', 'Invalid credentials');
    }

    get invalidUserAndPasswordMessage() {
        return cy.xpath('/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span').should('have.text', 'Required')
    }


    verifyCorrectLogin(){
        this.loginConfirmation.should('have.text', 'Dashboard')
    }

    verifyInvalidCredentials(){
        this.invalidCredentialsMessage.should('have.text', 'Invalid credentials')
    }

    verifyInvalidUserandPassword(){
        this.invalidUserAndPasswordMessage.should('have.text', 'Required')
    }

}

export default new loginPO();