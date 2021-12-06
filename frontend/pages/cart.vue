<template>
    <div>
        <!-------- header ------->
        <sharingan-navbar/>

        <!--cart items details--->
        <div class = "small-container">
            <h1 class = "title">
                My Cart
            </h1>
        </div>
        
        <cart-list :products = "products" />

        <div class="subtotal-container">
            <h2>Total: ${{subtotal}}</h2>
            <button class="btn" @click="checkoutFunc()">
                <h3>Checkout</h3>
            </button>
        </div>

        <!-------- footer ------->
        <sharingan-footer/>
    </div>
</template>

<script>

import CartList from '~/components/CartList.vue'

export default {
    components: {
        CartList
    },
    data () {
        return {
            products: {
                type: Array
            },
            subtotal: {
                Type: Number
            }
        }
    },
    head() {
        return {
            title: "Sharingan - Shopping Cart"
        }
    },
    async asyncData (ctx) {
        return {
            products: await ctx.app.$services.product.findAllCart(),
            subtotal: await ctx.app.$services.product.getSubtotal()
        }
    },
    methods: {
        checkoutFunc() {
            window.location.href = "/checkout"
        }
    }
}

</script>

<style lang = "scss">

.subtotal-container {
    width: 70%;
    max-width: 1080px;
    margin: auto;
    margin-top: 50px;
    margin-bottom: 50px;
    padding-left: 25px;
    padding-right: 25px;
    display: flex;
    justify-content: right;
    box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
}

.subtotal-container h4 {
    margin-right: 10px;
    display: flex;
}

.subtotal-container .btn {
    margin: 10px;
    display: flex;
    border: none;
    font-family: 'Mochiy Pop P One', sans-serif;
}

</style>