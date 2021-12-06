<template>
    <div>
        <!-------- header ------->
        <sharingan-navbar/>

        <!-------Single product detail -------->
        <div class="small-container single-product">
            <div class="row">
                <div class="col-2">
                    <img :src="product.imageUrl" width="100%">
                </div>
                <div class="col-2">
                    <p>Products / {{ product.name }}</p>
                    <h1>{{ product.name }}</h1>
                    <h4>${{ product.price }}</h4>
                    <input type="number" value="1" id = "quantity" name = "quantity">
                    <button class="btn" @click="addToCart(product.productId)">
                        <h3>Add to Cart</h3>
                    </button>
                </div>
            </div>
        </div>

        <!-------- footer ------->
        <sharingan-footer/>
    </div>
</template>

<script>
export default {
    head() {
        return {
            title: "Sharingan - Product"
        }
    },
    async asyncData({ params, $axios }) {
        return await $axios({
            method: 'get',
            url: `product/${params.product}`
        }).then((response) => {
            const product = response.data
            return { product }
        })
    },
    validate ({ params }) {
      return /^\d+$/.test(params.product)
    },
    methods: {
        addToCart (productId) {
            var quantity = document.getElementsByName("quantity")[0].value

            this.$axios({
                method: 'post',
                url: 'product',
                data: {
                    productId,
                    quantity
                }
            }).then((response) => {
                window.location.href = "/cart"
            }) 
        }
    }
}

</script>

<style lang = "scss">

.btn{
    display: inline-block;
    background: #ff523b;
    color: #fff;
    padding: 8px 30px;
    margin: 30px 0;
    border-radius: 30px;
    border: none;
    padding: 0px 30px;
    margin: 30px 0;
    cursor: pointer;
}

.btn h3 {
    text-decoration: none;
    font-family: 'Mochiy Pop P One', sans-serif;
    line-height: 1.5;
    padding: 0px 15px;
}

</style>
