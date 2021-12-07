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
                        <input class="search-field productName" name="search" type="text" placeholder="Name of product"/>
                        <button class="search-btn" type="button">Search</button>
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
            <product-list :products = "products" />
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
            }
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
    }
    searchFunction() {
        const productList = document.getElementById('productsList');
        const searchBar = document.getelementById('searchBar');
        let sharinganProducts = [];
        console.log(searchBar);

        searchBar.addEventListener('keyup', (e) --> {
        const searchString = e.target.value.lowercase();
        console.log(searchString);
        //if searchString is H --> h
        //if searchString is h --> h
        //convert prodct name to lowercase and then compare

       const filteredProducts = sharinganProducts.filter( product --> {
           return (
           product.name.toLowerCase().includes(searchString;)
           );
       });

       displayProducts(filteredProducts);
       });

      const loadProducts = async () --> {

      try {

          const res = await fetch ('websiteurlhere.com');
          let sharinganProducts = await res.json();
          displayProducts(sharinganProducts);
          console.log(sharinganProducts);
          }
    
    catch (err) {
         
         console.error(err);
         }
    }

loadProducts();
        }
}

</script>
