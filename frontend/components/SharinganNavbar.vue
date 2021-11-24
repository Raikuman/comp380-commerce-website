<!--Created by Lloyd Aclan
    Date: 11-15-2021
    Discription: Displays the Navigation headder on top for each page of the app
-->
<template>
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
        </div>
</template>
