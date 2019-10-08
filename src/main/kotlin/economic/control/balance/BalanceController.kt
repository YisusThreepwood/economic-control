package economic.control.balance

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/balance")
class BalanceController @Inject
constructor(private val balanceInteractor: BalanceInteractor, private val balanceTransformer: BalanceTransformer){

    @Get("/{clubId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun show(clubId: String): HttpResponse<Any?> {
        return  HttpResponse.ok(
                balanceTransformer.transform(balanceInteractor.getBalanceFromClub(clubId)).toString()
        )
    }
}