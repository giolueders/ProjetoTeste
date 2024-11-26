/// <reference types="cypress" />

class baseTeste {

    login(username, password) {
        this.visit();
        this.typeUserName(username);
        this.typeUserPassword(password);
        this.submit();

    }
}

export default baseTeste;