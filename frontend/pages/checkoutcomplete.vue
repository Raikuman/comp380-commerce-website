<template>
    <div>
        <!-------- header ------->
        <sharingan-navbar/>

        <div class="textform">
            <h1>Thank you for shopping at Sharingan!</h1>
            <h2>A confirmation email has been sent to you!</h2>

            <button class="btn" @click="checkoutFunc()">
                <h3>Go to Homepage</h3>
            </button>
        </div>

        <!-------- footer ------->
        <sharingan-footer/>
    </div>
</template>

<script>

export default {
    head() {
        return {
            title: "Sharingan - Complete"
        }
    },
    methods: {
        checkoutFunc() {
            window.location.href = "/"
        }
    }
}

</script>

<style lang = "scss">

.textform {
    text-align: center;
}

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
