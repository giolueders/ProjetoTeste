const cypress = require("cypress");
const { defineConfig } = require("cypress");

module.exports = defineConfig({
  projectId: '1412jy',
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
      pageLoadTimeout:120000
    },
  },
});
