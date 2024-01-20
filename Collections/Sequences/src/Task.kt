// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders.asSequence().filter { it.isDelivered }.flatMap { it.products }
            .reduce { exp, curr -> if(exp.price>curr.price) exp else curr  }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.asSequence().flatMap { it.getOrderedProducts() }.count { it.name == product.name }
}

fun Customer.getOrderedProducts(): Sequence<Product> =
        orders.asSequence().flatMap { it.products }
