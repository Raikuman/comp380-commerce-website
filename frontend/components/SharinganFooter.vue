<!--Created by Lloyd Aclan
    Date: 11-15-2021
    Discription: Displays the footer of the app and is styled by css at the bottom of the code

<template>
    <div>
        <!----------- Footer------------>
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="footer-col-1">
                        <h3>Download Our App</h3>
                        <p>Download App for Android and ios mobile phone</p>
                        <div class="app-logo">
                            <img src="https://cdn.glitch.me/f1fa65f4-5f0f-402a-9ff2-2a42121a91f3%2Fplay-store.png?v=1636872490615">
                            <img src="https://cdn.glitch.me/f1fa65f4-5f0f-402a-9ff2-2a42121a91f3%2Fapp-store.png?v=1636872504417">
                        </div>
                    </div>
                    <div class="footer-col-2">
                        <h3>Links</h3>
                        <ul>
                            <li>Contact Us</li>
                            <li>Blog Post</li>
                            <li>Return Policy</li>
                        </ul>
                    </div>
                    <div class="footer-col-3">
                        <h3>Follow us</h3>
                        <ul>
                            <li>Facebook</li>
                            <li>Twitter</li>
                            <li>Instagram</li>
                            <li>Youtube</li>
                        </ul>
                    </div>
                </div>
                <hr>
                <p class="copyright">Copyright 2021 - Team Sharingan</p>
            </div>
        </div> 
    </div>
</template>

<style lang = "scss">

/*------footer------*/
.footer{
  background: #000;
  color: #8a8a8a;
  font-size: 14px;
  padding: 20px 0 20px;
}

.footer .container{
  margin-left: auto;
  margin-right: auto;
}

.footer .row {
    justify-content: center;
    text-align: center;
}

.footer ul {
    padding: 0;
}

.footer p{
  color: #8a8a8a;
}
.footer h3{
  color: #fff;
  margin-bottom: 20px;
}
.footer-col-1, .footer-col-2, .footer-col-3{
  min-width: 250px;
  margin-bottom: 20px;
}
.footer-col-1{
  flex-basis: 30%;
}
.footer-col-2, .footer-col-3{
  flex-basis: 12%;
  text-align: center;
}
ul{
  list-style-type: none;
}
.app-logo{
  margin-top: 20px;
}
.app-logo img{
  width: 140px;
}
.footer hr{
  border: none;
  background: #b5b5b5;
  height: 1px;
  margin: 20px 0;
}
.copyright{
  text-align: center;
}
.menu-icon{
  width: 28px;
  margin-left: 20px;
  display: none;
}

</style>
