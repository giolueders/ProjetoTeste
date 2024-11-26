/// <reference types="cypress"/>

import loginPO from "../support/pageObjects/loginPO.cy"
import basePO from "../support/pageObjects/basePO.cy"

describe('login', () => {

    it('Login com sucesso', () => {
        basePO.login('Admin', 'admin123')
        loginPO.verifyCorrectLogin()
    })

    it('Login com usuário incorreto', () => {
        basePO.login('Administrador', 'admin123')
        loginPO.verifyInvalidCredentials()
    })

    it('Login com senha incorreta', () => {
        basePO.login('Admin', 'admin12345')
        loginPO.verifyInvalidCredentials()
    })

    it('Login com usuário e senha incorretos', () => {
        basePO.login('Administrador', 'admin12345')
        loginPO.verifyInvalidCredentials()
    })

    it('Login com usuário e senha em branco', () => {
        basePO.visit()
        basePO.submit()
        loginPO.verifyInvalidUserandPassword()
    })
})
