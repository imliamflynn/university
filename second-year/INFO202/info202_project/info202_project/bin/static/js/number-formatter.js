export const NumberFormatter = {
  methods: {
     formatCurrency(value) {
        return new Intl.NumberFormat('en-NZ',{style: "currency", currency: 'NZD'}).format(value);
     },
     formatNumber(value, decimalPlaces) {
        return value.toFixed(decimalPlaces);
     }
  }
};