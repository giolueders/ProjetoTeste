/// <reference types="cypress"/>

import cadastroDeFuncionarioPO from "../support/pageObjects/cadastroDeFuncionarioPO.cy"
import basePO from "../support/pageObjects/basePO.cy"


describe ('Cadastro de funcionários', () => {

    it('Cadastro de funcionário correto', () =>{
        basePO.visit()
        basePO.login('Admin', 'admin123')
        cadastroDeFuncionarioPO.switchToPIMTab()
        cadastroDeFuncionarioPO.newEmployeeRegister('Maria','Célia', 'da Silva','500')
        cadastroDeFuncionarioPO.submit()
        cadastroDeFuncionarioPO.verifySuccessfullyRegister()
    })

    it('Cadastro sem Primeiro Nome', () => {
        basePO.visit()
        basePO.login('Admin', 'admin123')
        cadastroDeFuncionarioPO.switchToPIMTab()
        cadastroDeFuncionarioPO.employeeRegisterWithoutFirstName('Vinicius', 'de Souza')
        cadastroDeFuncionarioPO.submit()
        cadastroDeFuncionarioPO.verifyNameRequired()

    })

    it.only('Cadastro sem Nome do Meio', () => {
        basePO.visit()
        basePO.login('Admin', 'admin123')
        cadastroDeFuncionarioPO.switchToPIMTab()
        cadastroDeFuncionarioPO.employeeRegisterWithoutMiddleName('Vinicius', 'de Souza')
        cadastroDeFuncionarioPO.submit()
        cy.wait(15000)
        cadastroDeFuncionarioPO.verifySuccessfullyRegister()

    })

    it('Cadastro sem Ultimo Nome', () => {
        basePO.visit()
        basePO.login('Admin', 'admin123')
        cadastroDeFuncionarioPO.switchToPIMTab()
        cadastroDeFuncionarioPO.employeeRegisterWithoutLastName('Vinicius', 'de Souza')
        cadastroDeFuncionarioPO.submit()
        cadastroDeFuncionarioPO.verifyLastNameRequired()

    })

    it('Cadastro sem informações de nome', () => {
        basePO.visit()
        basePO.login('Admin', 'admin123')
        cadastroDeFuncionarioPO.switchToPIMTab()
        cadastroDeFuncionarioPO.buttonAddEmployee.click()
        cadastroDeFuncionarioPO.submit()
        cadastroDeFuncionarioPO.verifyNameRequired()
        cadastroDeFuncionarioPO.verifyLastNameRequired()

    })

    it('Cadastro sem ID', () =>{
        basePO.visit()
        basePO.login('Admin', 'admin123')
        cadastroDeFuncionarioPO.switchToPIMTab()
        cadastroDeFuncionarioPO.newEmployeeRegister('João', 'da Silva', 'Sauro')
        cadastroDeFuncionarioPO.clearEmployeeId();
        cadastroDeFuncionarioPO.submit()
        cadastroDeFuncionarioPO.verifySuccessfullyRegister()

    })

})