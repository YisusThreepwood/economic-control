package economic.control.balance

import javax.inject.Singleton

@Singleton
class BalanceMapper: Contracts.BalanceMapper {
    companion object {
        const val CLUB_ID_INDEX = 0
        const val BALANCE_INDEX = 1
    }

    override fun toEntity(data: String): BalanceEntity {
        var tokens = data.split(',')
        return BalanceEntity(
                tokens[CLUB_ID_INDEX],
                tokens[BALANCE_INDEX].toDouble()
        )
    }
}