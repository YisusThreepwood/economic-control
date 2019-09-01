package economic.control

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("economic.control")
                .mainClass(Application.javaClass)
                .start()
    }
}