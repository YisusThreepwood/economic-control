package economic.control.balance

interface Contracts {
    interface BalanceGateway {
        fun getBalanceFromClub(clubId: String): BalanceEntity
    }

    interface BalanceMapper {
        fun toEntity(data: String): BalanceEntity
    }
}