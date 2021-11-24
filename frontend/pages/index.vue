<template>
    <div>
        <!-------- header ------->
        <div class="header">
            <div class="navbar">
                <div class="logo">
                    <img src="https://cdn.glitch.me/f1fa65f4-5f0f-402a-9ff2-2a42121a91f3%2Fpngkey.com-sharingan-png-4377742.png?v=1636600383605" width="125px" />
                    <img src="https://cdn.glitch.me/f1fa65f4-5f0f-402a-9ff2-2a42121a91f3%2FRight%20eye.png?v=1636600408926" width="125px" />
                </div>
                <nav>
                    <ul id="MenuItems">
                        <nuxt-link :to="'/'">Home</nuxt-link>
                        <nuxt-link :to="'/product'">Products</nuxt-link>
                        <nuxt-link :to="'/about'">About</nuxt-link>
                        <nuxt-link :to="'/contacts'">Contacts</nuxt-link>
                        <nuxt-link :to="'/cart'">Cart</nuxt-link>
                    </ul>
                        <img src="https://cdn.glitch.me/f1fa65f4-5f0f-402a-9ff2-2a42121a91f3%2Fcart.png?v=1636603220903" width="30px" height="30px">
                        <img src="https://cdn.glitch.me/f1fa65f4-5f0f-402a-9ff2-2a42121a91f3%2Fmenu.png?v=1636872799914" class="menu-icon" onclick="menutoggle()">
                </nav>
            </div>
            <div class="image-txt-container">
                    <div class="text">
                    <h1>Any Technique is Worthless <br> Before My Eyes.</h1>
                    <p>Get your Sharingan clothing and accessories right here</p>
                </div>
                <div class="image">
                    <img src="https://cdn.glitch.me/f1fa65f4-5f0f-402a-9ff2-2a42121a91f3%2Fpngkey.com-itachi-png-8948327.png?v=1636596887705" height="300px" width="300px" padding="1" >
                </div>
            </div>
        </div>
        
        <!-------featured product-------->
        <div class="small-container">
            <h2 class="title">Featured Products</h2>
            <div class="row">
                <product-list-item :product = "product1" />
                <product-list-item :product = "product2" />
                <product-list-item :product = "product3" />
                <product-list-item :product = "product4" />
            </div>
        </div>

        <!-------- footer ------->
        <sharingan-footer/>
    </div>
</template>

<script>

export default {
    data () {
        return {
            product1: {
                type: Object
            },
            product2: {
                type: Object
            },
            product3: {
                type: Object
            },
            product4: {
                type: Object
            }
        }
    },
    async asyncData(ctx) {
        return {
            product1: await ctx.app.$services.product.findProduct(10),
            product2: await ctx.app.$services.product.findProduct(11),
            product3: await ctx.app.$services.product.findProduct(15),
            product4: await ctx.app.$services.product.findProduct(21)
        }
    }
}

</script>
