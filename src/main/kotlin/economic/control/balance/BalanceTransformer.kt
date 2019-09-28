package economic.control.balance

import javax.inject.Singleton
import javax.json.Json
import javax.json.JsonObject

@Singleton
class BalanceTransformer {
    fun transform(balance: BalanceEntity): JsonObject {
        return Json.createObjectBuilder()
            .add("club_id", balance.clubId)
            .add("allowed_amount", balance.balance)
            .build()
    }
}