<template>
    <div class = "product-list-container">
        <product-list-item v-for = "product in products" :key = "product.id" :product = "product" />
    </div>
</template>

<script>

import ProductListItem from '~/components/ProductListItem.vue'

export default {
    components: {
        ProductListItem
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

.product-list-container{
    min-width: 1080px;
    margin: auto;
    padding-left: 25px;
    padding-right: 25px;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    justify-content: space-around;
}

.product-list-container .productlink{
    display: inline-flex;
    flex-basis: 25%;
    padding: 10px;
    min-width: 200px;
    margin-bottom: 50px;
    transition: transform 0.5s;
}

</style>