"use strict"

var registerApi = '//localhost:8080/api/register';
var customerApi = ({username}) =>
        `//localhost:8080/api/customers/${username}`;

const app = Vue.createApp({

    data() {
        return {// models (comma separated key/value pairs)
            customer: new Object(),
            signInMessage: "Please sign in to continue."
        };
    },

    mounted() { // semicolon separated statements

    },

    methods: {// comma separated function declarations
        registerCustomer() { // send POST request to service to create customer
            axios.post(registerApi, this.customer)
                    .then(() => {
                        window.location = 'signin.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        signIn() {
            axios.get(customerApi({'username': this.customer.username}))
                    .then(response => {
                        this.customer = response.data;
                        dataStore.commit("signIn", this.customer);
                        window.location = 'products.html';
                    })
                    .catch(error => {
                        this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                    });
        }
    }
});

// other component imports go here
// import data store
import { dataStore } from './data-store.js'
        app.use(dataStore);

// import navigation  menu component
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);

// mount the page - this needs to be the last line in the file
app.mount("#content");