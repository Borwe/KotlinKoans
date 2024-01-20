fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for((i,p) in products.withIndex()){
                tr {
                    td(getCellColor(i,1)) {
                        text(p.description)
                    }
                    td(getCellColor(i,2)) {
                        text(p.price)
                    }
                    td(getCellColor(i,3)) {
                        text(p.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, column: Int) = if ((index + column) % 2 == 0) "#dce4ff" else "#eff2ff"
