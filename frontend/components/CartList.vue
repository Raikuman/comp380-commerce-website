<template>
    <div class = "product-container">
        <div class = "product-list-container">
            <cart-list-item v-for = "product in products" :key = "product.id" :product = "product"/>
        </div>
    </div>
</template>

<script>

import CartListItem from '~/components/CartListItem.vue'

export default {
    components: {
        CartListItem
    },
    props: {
        products: {
            type: Array,
            default () {
                return []
            }
        }
    }
}

</script>

<style lang = "scss">

.product-container {
    width: 70%;
    margin: auto;
    margin-top: 50px;
    display: block;
}

.product-list-container {
    width: 400px;
    margin: auto;
    margin-top: 50px;
    display: block;
    box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
}

</style>