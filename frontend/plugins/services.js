import ProductService from '~/assets/service/ProductService'

export default (ctx, inject) => {
    const services = {
        product: new ProductService(ctx.$axios)
    }

    inject('services', services)
}