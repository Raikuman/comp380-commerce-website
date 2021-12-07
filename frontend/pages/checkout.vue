<template>
    <div>
        <!-------- header ------->
        <sharingan-navbar/>

        <div class="form">
            <h1 class="heading">Checkout</h1>
            <h2 class="text">Shipping Address</h2>

            <div class="two-input-container">
                <input type="text" id="firstName" placeholder="First Name">
                <input type="text" id="lastName" placeholder="Last Name">
            </div>

            <input type="text" id="address" placeholder="Address">

            <div class="three-input-container">
                <input type="text" id="city" placeholder="City">
                <input type="text" id="state" placeholder="State">
                <input type="text" id="areacode" placeholder="Area code">
            </div>

            <input type="text" id="email" placeholder="Email Address">
        </div>

        <div class="bottomform">
            <div class="form1">
                <h4 class="text">Payment</h4>

                <input type="text" id="cardowner" placeholder="Card Owner Name">
                <input type="text" id="cardnumber" placeholder="Card Number">

                <div class="three-input-container1">
                    <div class="carddate">
                        <input type="text" id="cardmonth" placeholder="Exp. MM">
                        <input type="text" id="cardyear" placeholder="Exp. YY">
                    </div>
                    <input type="text" id="cardcvv" placeholder="CVV">
                </div>
            </div>

            <div class="form2">
                <h4 class="text">Shipping Method</h4>
                <div class=radioform>
                    <div class="shipmethod">
                        <input type="radio" name="chooseone" value="0.00" v-model="shipping"><label>Free Shipping (+$0)</label>
                    </div>

                    <div class="shipmethod">
                        <input type="radio" name="chooseone" value="4.99" v-model="shipping"><label>1-3 Day Shipping (+$4.99)</label>
                    </div>

                    <div class="shipmethod">
                        <input type="radio" name="chooseone" value="9.99" v-model="shipping"><label>Next-Day Shipping (+$9.99)</label>
                    </div>
                </div>
            </div>
        </div>

        <div class="form1">
            <h2 class="text">Total</h2>

            <div class="pricing">
                <div class="pricingitem">
                    <h4>Item(s) Subtotal:</h4>
                    <p>${{subtotal}}</p>
                </div>
                <div class="pricingitem">
                    <h4>Shipping & Handling:</h4>
                    <p>${{shipping}}</p>
                </div>
                <div class="pricingitem">
                    <h4>Tax:</h4>
                    <p>${{tax}}</p>
                </div>
                <p>-------------------------------------</p>
                <div class="pricingitem">
                    <h4>Total:</h4>
                    <p>${{total}}</p>
                </div>
            </div>
            <button class="Place-order-btn" @click="checkoutFunc(total)">Place Order</button>
        </div>

        <!-------- footer ------->
        <sharingan-footer/>
    </div>
</template>

<script>

export default {
    data () {
        return {
            subtotal: 0,
            shipping: 0,
            tax: 0,
            total: 0.00
        }
    },
    head() {
        return {
            title: "Sharingan - Checkout"
        }
    },
    async asyncData(ctx) {
        return {
            subtotal: await ctx.app.$services.product.getSubtotal(),
            tax: await ctx.app.$services.product.calculateTax()
        }
    },
    watch: {
        shipping: function() {
            this.total = parseFloat(this.subtotal) + parseFloat(this.shipping) + parseFloat(this.tax)
        }
    },
    methods: {
        checkoutFunc(total) {
            var email = document.getElementById("email").value

            console.log(email)

            this.$axios({
                method: 'post',
                url: 'cart/checkout/complete',
                data: {
                    email,
                    total
                }
            }).then((response) => {
                window.location.href = "/checkoutcomplete"
            }) 
        }
    }
}

</script>

<style lang = "scss">

.form{
  width: 100%;
  padding: 20px 5vw;
}

.form1{
  width: 30%;
  padding: 20px 5vw;
}

.form2{
  width: 70%;
  padding: 20px 5vw;
}

.bottomform{
    display: flex;
}

.heading{
  font-size: 500;
  font-size: 30px;
  margin-bottom: 20px;
}
.form input, .form1 input{
  background: #f5f5f5 !important;
  width: 100% !important;
  padding: 10px;
  margin: 1px;
  border-radius: 5px;
  border: none;
}

.radioform .shipmethod{
    display: block;
    margin-bottom: 10px;
}

.three-input-container, .two-input-container, .three-input-container1{
  display: flex;
  justify-content: space-between;
}
.three-input-containter input{
  margin: 10px !important;
}
.Place-order-btn{
  display: block;
  border: none;
  outline: none;
  cursor: pointer;
  height: 40px;
  border-radius: 5px;
  background: #383838;
  color: #fff;
  line-height: 40px;
  text-transform: capitalize;
  text-decoration: none;
  margin: 10px 0;
  width: 100%;
}

.carddate{
display: flex;
margin-right: 30px;
}

.pricing .pricingitem {
    display: flex;
}

.pricing .pricingitem p {
    height: 24px;
    margin: auto;
    margin-right: 40px;
}

</style>
