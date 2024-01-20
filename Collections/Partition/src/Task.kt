// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
        customers.filter {
            val (have, haveNot) = it.orders.partition { it.isDelivered  }
            have.size < haveNot.size
        }.toSet()
