package rsq.rsqtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsqtestApplication

fun main(args: Array<String>) {
    runApplication<RsqtestApplication>(*args)
}
