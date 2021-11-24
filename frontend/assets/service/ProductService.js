import Product from '~/assets/data/Product.class'

export default class ProductApi {
    constructor ($axios) {
        this.axios = $axios
    }

    // This method 
    findAll () {
        return this.axios({
            method: 'get',
            url: 'product'
        }).then((response) => {
            const products = []
            response.data.forEach((product) => {
                products.push(new Product(product.productId, product.name, product.price, product.imageUrl))
            })
            return products
        })
    }

    findProduct(productId) {
        return this.axios({
            method: 'get',
            url: `product/${productId}`
        }).then((response) => {
            const res = response.data
            const productObj = new Product(res.productId, res.name, res.price, res.imageUrl)
            return productObj
        })
    }

    findAllCart () {
        return this.axios({
            method: 'get',
            url: 'cart'
        }).then((response) => {
            const products = []
            response.data.forEach((product) => {
                products.push(new Product(product.productId, product.name, product.price, product.imageUrl))
            })
            return products
        })
    }

    addToCart (productId, quantity) {
        return this.axios({
            method: 'post',
            url: 'product',
            data: {
                productId,
                quantity
            }
        })
    }

    getSubtotal () {
        return this.axios({
            method: 'get',
            url: 'cart/checkout/total'
        }).then((response) => {
            return response.data
        })
    }
}