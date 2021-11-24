<template>
    <nuxt-link class="productlink" :to="'product/'+product.productId">
        <div class="col-4">
            <img :src="product.imageUrl">
            <h4>{{product.name}}</h4>
            <div class="rating"> </div>
            <p>${{product.price}}</p>
        </div>
    </nuxt-link>
</template>

<script>

export default {
    props: {
        product: {
            type: Object,
            default () {
                return{}
            }
        }
    }
}

</script>

<style lang = "scss">

.product-item {
    width: 100%;
    display: block;
    height: 100px;
}
.controls a {
    height: 50px;
    padding-left: 20px;
    line-height: 50px;
    width: 300px;
    display: inline-block;
}

</style>
