package economic.control.balance

import io.micronaut.context.annotation.Value
import java.io.BufferedReader
import java.io.FileReader
import java.nio.file.Paths
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BalanceCsvGateway @Inject
constructor(private val balanceMapper: BalanceMapper): Contracts.BalanceGateway
{
    @Value("\${data.relative-path}")
    private lateinit var dataPath: String;

    override fun getBalanceFromClub(clubId: String): BalanceEntity {
        val reader = BufferedReader(FileReader(
                Paths.get("").toAbsolutePath().toString() + '/' + this.dataPath + "/clubs_balance.csv"
        ))
        val line = findLineByClubId(reader.lines().toArray(), clubId)

        return balanceMapper.toEntity(line)
    }

    private fun findLineByClubId(lines: Array<Any>, clubId: String): String {
        var lineIndex: Int? = null

        for (i in 0 until lines.size) {
            var data = lines[i].toString().split(',')
            if (data[BalanceMapper.CLUB_ID_INDEX] == clubId) {
                lineIndex = i
            }
        }

        if (lineIndex === null) {
            throw Exception("Balance not found for club $clubId")
        }

        return lines[lineIndex].toString()
    }
}