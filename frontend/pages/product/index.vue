<template>
    <div>
        <!-------- header ------->
        <sharingan-navbar/>

        <!-------Products------->
        <div class="small-container">
      
            <!-----Search Bar ------>
            <div class="head">
                <form>
                    <div class="form-box">
                        <h4>Search</h4>
                        <input class="search-field productName" name="search" type="text" id="searchBar" v-model="searchTerm" placeholder="Name of product"/>
                    </div>
                </form>
            </div>
            <div class="row row-2">
                <h2>All Products</h2>
                <select>
                    <option>Default sorting</option>
                    <option>Sort by price</option>
                    <option>Sort by popularity</option>
                    <option>Sort by rating</option>
                    <option>Sort by sale</option>
                </select>
            </div>
            <product-list :products = "searchedProducts" />
        </div>
        
        <!-------- footer ------->
        <sharingan-footer/>
    </div>
</template>

<script>

import ProductList from '~/components/ProductList.vue'

export default {
    components: {
        ProductList
    },
    data () {
        return {
            products: {
                type: Array
            },
            searchTerm: ""
        }
    },
    head() {
        return {
            title: "Sharingan - Products"
        }
    },
    async asyncData (ctx) {
        return {
            products: await ctx.app.$services.product.findAll()
        }
    },
    computed: {
        searchedProducts: function () {
            return this.products.filter(product => {
                return product.name.toLowerCase().includes(this.searchTerm.toLowerCase())
            })
        }
    }
}

</script>
