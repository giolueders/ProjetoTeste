/// <reference types="cypress"/>

class cadastroDeFuncionarioPO{

    get abaPIM() {
        return cy.xpath('/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span');
    }

    get titlePIM() {
        return cy.xpath('//h6[@class="oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module"]');
    }

    get buttonAddEmployee() {
        return cy.xpath('//button[@class="oxd-button oxd-button--medium oxd-button--secondary"]');
    }

    get inputFirstNameEmployee() {
        return cy.xpath('//input[@name="firstName"]');
    }

    get inputMiddleNameEmployee() {
        return cy.xpath('//input[@name="middleName"]');
    }

    get inputLastNameEmployee() {
        return cy.xpath('//input[@name="lastName"]');
    }

    get inputEmployeeId(){
        return cy.xpath('//*[@id="app"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input');
    }

    get submitButton(){
        return cy.xpath('//button[@type="submit"]');
    }

    get titlePersonNewEmployee(){
        return cy.xpath('//h6[@class="oxd-text oxd-text--h6 --strong"]');
    }

    get nameRequired(){
        return cy.xpath('//*[@id="app"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/span');
    }

    get lastNameRequired(){
        return cy.xpath('//*[@id="app"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]')
    }

    typeEmployeeFirstName(firstName){
        this.inputFirstNameEmployee.type(firstName, {force:true});
    }

    typeEmployeeMiddleName(middleName){
        this.inputMiddleNameEmployee.type(middleName, {force:true});
    }

    typeEmployeeLastName(lastName){
        this.inputLastNameEmployee.type(lastName, {force:true});
    }

    typeEmployeeId(id){
        this.inputEmployeeId.type(id);
    }

    submit(){
        this.submitButton.click();
    }

    newEmployeeRegister(firstName, middleName, lastName){
        this.buttonAddEmployee.click();
        this.typeEmployeeFirstName(firstName);
        this.typeEmployeeMiddleName(middleName);
        this.typeEmployeeLastName(lastName);
    }

    employeeRegisterWithoutFirstName(middleName, lastName){
        this.buttonAddEmployee.click()
        this.typeEmployeeMiddleName(middleName)
        this.typeEmployeeLastName(lastName)
        this.submit()
    }

    employeeRegisterWithoutMiddleName(firstName, lastName){
        this.buttonAddEmployee.click()
        this.typeEmployeeFirstName(firstName)
        this.typeEmployeeLastName(lastName)
        this.submit()
    }

    employeeRegisterWithoutLastName(firstName, middleName){
        this.buttonAddEmployee.click()
        this.typeEmployeeFirstName(firstName)
        this.typeEmployeeMiddleName(middleName)
        this.submit()
    }

    switchToPIMTab(){
        this.abaPIM.click();
        this.titlePIM.should('have.text', 'PIM');
    }

    verifySuccessfullyRegister(){
        cy.wait(10000);
        this.titlePersonNewEmployee.should('exist');
    }

    verifyNameRequired(){
        cy.wait(1000);
        this.nameRequired.should('have.text', 'Required');
    }

    verifyLastNameRequired(){
        cy.wait(1000);
        this.lastNameRequired.should('have.text', 'Required');
    }

    clearEmployeeId(){
        this.inputEmployeeId.clear();
    }

}

export default new cadastroDeFuncionarioPO();