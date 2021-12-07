<template>
    <div class="searchHolder">
        <div class="searchHolder_Banner">
            <div class="headerContainer">
                <h1 class="header">
                    Enter Product Name:
                </h1>
                <div class="searchBar">
                    <div class="searchForm">
                       <div class="search">
                       <input
                       @change = "handleChange"
                       v-model="searchText"
                       class="formControl"
                       type="text"
                       />
                    </div>
                    <img class="icon" src="" width="" height=""/>
                </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    computed: {
    },
    data() {
        return {
            searchText: ''
       };
    },
    methods: {
        handleChange(){
            this.$emit("search", this.searchText);
    }
    }
}:
</script>

<style>
.searchHolder {
    margin-top: 60px;

    banner {
        margin: 0 auto;
        width: 80px;
        padding: 15px;
        text-align: center;
    }
    fullbanner {
        margin: 0 auto;
        width: 80px;
        padding: 15px;
        text-align: center;
    }
    .header {
        margin: 0 0 2px;
    }
    .searchBar {
        .search {
            .formControl {
                display: block;
                width: 100%;
                padding: 1px 12px;
            }
        }
    }
}
</style>
