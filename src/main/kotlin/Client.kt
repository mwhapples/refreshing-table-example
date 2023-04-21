import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.*
import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlin.random.Random

fun main() {
    window.onload = {
        document.body?.sayHello()
        window.setInterval({ document.body?.showRefreshing() }, 5000)
    }
}

fun Node.sayHello() {
    append {
        div {
            +"Hello from JS"
        }
    }
}

val r = Random(currentTimeMillis())
fun Node.showRefreshing() {
    document.getElementById("client-table")?.let { it.parentElement?.removeChild(it) }
    append {
        table {
            id = "client-table"
            thead {
                tr {
                    th { +"Client" }
                    th { +"Speed" }
                }
            }
            tbody {
                for (x in 0..10) {
                    tr {
                        td { +"Client $x" }
                        td { +"${r.nextInt(2000)}mbps" }
                    }
                }
            }
        }
    }
}