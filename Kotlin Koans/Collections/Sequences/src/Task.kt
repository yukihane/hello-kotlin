// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.asSequence().filter(Order::isDelivered).flatMap(Order::products).maxByOrNull(Product::price)


// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    val products = customers.asSequence().flatMap(Customer::orders).flatMap(Order::products)
    return products.count { it == product }
}

fun Customer.getOrderedProducts(): Sequence<Product> =
        orders.asSequence().flatMap(Order::products)
