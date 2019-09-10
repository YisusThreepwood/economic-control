package economic.control.balance

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BalanceInteractor @Inject
constructor(private val gateway: Contracts.BalanceGateway){
    fun getBalanceFromClub(clubId: String): BalanceEntity {
        return gateway.getBalanceFromClub(clubId)
    }
}