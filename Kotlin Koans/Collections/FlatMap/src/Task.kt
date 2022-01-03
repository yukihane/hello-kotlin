// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
    orders.map(Order::products).flatten()

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
    customers.asSequence().map(Customer::orders).flatten().distinct().map(Order::products).flatten().toSet()
