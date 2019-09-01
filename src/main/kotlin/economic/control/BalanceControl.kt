package economic.control

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/balance")
class BalanceControl {
    @Get("/{club}")
    @Produces(MediaType.TEXT_PLAIN)
    fun show(club: String): String {
        return "You are requesting for the $club balance"
    }
}