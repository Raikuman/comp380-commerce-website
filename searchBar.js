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

        const res = await fetch ('website url goes here!!!!!!!!!');
        let sharinganProducts = await res.json();
        displayProducts(sharinganProducts);
        console.log(sharinganProducts);
        }
    catch (err) {
        console.error(err);
    }
}

const displayProducts = (products) --> {
    const htmlString = products
        .map((products)) --> {
        return '
        <li class="product">
            <h2>${product.name}</h2>
            <p>Price: ${product.price}</p>
            <img src="${product.image}"></img>
        </li>
       ';
       })
       .join('');
    productList.innerHTML = htmlString;
};

loadProducts();
