<template>
    <div>
        <div class = "product-item">
            <img :src="product.imageUrl">
            <div class = "info">
                <h3>{{product.name}}</h3>
                <p>Price ${{product.price}}</p>
            </div>
            <div class = "quantity">
                <h4> Quantity:{{quantity}}</h4>
                <h4 class = "total"> Item Total: $ {{productPrice}}</h4>
            </div>
            <div class = "controls">
                <button class="btn" @click="removeFromCart(product.productId, 0)">
                    <h3>Remove</h3>
                </button>
                <nuxt-link :to="'product/'+product.productId">View Item</nuxt-link>
            </div>
        </div>

        
    </div>
</template>

<script>

export default {
    data () {
        return {
            quantity: {
                type: Number
            },
            productPrice: {
                type: Number
            }
        }
    },
    props: ['product'],
    async fetch() {

        this.quantity = await this.$axios({
            method: 'get',
            url: `cart/quantity/${this.product.productId}`
        }).then((response) => {
            return response.data
        })

        this.productPrice = await this.$axios({
            method: 'get',
            url: `cart/checkout/${this.product.productId}`
        }).then((response) => {
            return response.data
        })
    },
    methods: {
        removeFromCart (productId, quant) {
            this.$axios({
            method: 'post',
            url: 'cart',
            data: {
                productId,
                quant
            }
        }).then((response) => {
            window.location.reload(true)
        })
        }
    }
}

</script>

<style lang = "scss">

.product-item {
    display: flex;
    float: left;
 flex-basis: 25%;
padding: 10px;
min-height: 200px;
margin: 5px auto;
box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
}

.product-item .info {
    float: left;
    padding-left: 25px;
    width: 550px;
    height: 100px;
    text-align: center;
    justify-content: center;
}

.product-item h3{
    min-width: 550px;
    float: left;
    margin-top: 5px;
    margin-bottom: 20px;
    text-align: left;
}

.product-item p{
    float: left;
    margin-top: 5px;
    margin-bottom: 20px;
}

.product-item img {
float: left;
height: auto;
width: 15%;
margin-bottom: 50px;
}

.product-item .controls a {
float: right;
max-width: 90px;
padding-left: 0;
margin-left: 20px;
text-align: center;
}

.product-item .controls .btn {
float: right;
max-width: 90px;
padding-left: 0;
margin-left: 20px;
text-align: center;
text-decoration: none;
color: #556;
background: none;
padding-right: 0;
margin-top: 0;
margin-bottom: 0;
}

.product-item .controls .btn h3 {
    display: flex;
    margin: auto;
    padding: 0;
    min-width: 90px;
    min-height: 50px;
    align-items: center;
    justify-content: center;
    text-align: center;
}

.product-item .quantity {
width: 300px;
float: right;
flex-wrap: wrap;
text-align: right;
}

.product-item .quantity input{
width: 100px;
display: inline-block;
}

.product-item .quantity h4{
width: 150px;
margin-top: 10px;
margin-bottom: 10px;
display: inline-block;
}

.product-item .quantity .total{
width: 220px;
margin-top: 10px;
margin-bottom: 10px;
display: inline-block;
}

</style>
