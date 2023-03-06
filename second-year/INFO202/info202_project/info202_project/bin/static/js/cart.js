"use strict";
var salesApi = '//localhost:8080/api/sales';

class SaleItem {
    constructor(product, quantityPurchased) {
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.salePrice = product.listPrice;
    }
}

class Sale {
    constructor(customer, items) {
        this.customer = customer;
        this.items = items;
    }
}

const app = Vue.createApp({

    data() {
        return {
            quantity: 1,
            // models (comma separated key/value pairs)

        };
    },

    computed: Vuex.mapState({
        product: 'selectedProduct',
        items: 'items',
        customer: 'customer'
    }),

    mounted() {
        // semicolon separated statements


    },

    methods: {
        // comma separated function declarations
        addToCart() {
            dataStore.commit("addItem", new SaleItem(this.product, this.quantity));
            window.location = 'cart.html';
        },
        checkOut() {
            let sale = new Sale(this.customer, this.items);
            axios.post(salesApi, sale)
                    .then(() => {
                        window.location = 'confirm.html';
                        dataStore.commit("clearItems");
                    })
                    .catch(error => {
                        console.error(error);
                        alert("You cannot buy a higher number of items than we have in stock.");
                    });
        }, getItemTotal(item) {
            return item.salePrice * item.quantityPurchased;
        }, getCartTotal() {
            let total = 0;
            for (let item of this.items) {
                total += this.getItemTotal(item);
            }
            return total;
        }
    },
    mixins: [NumberFormatter]

});

/* other component imports go here */

// import data store
import { dataStore } from './data-store.js'
        app.use(dataStore);

// import navigation  menu component
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);

import { NumberFormatter } from './number-formatter.js';

// mount the page - this needs to be the last line in the file
app.mount("#content");