package useCases

import models.Player
import repositories.IPlayerRepository

class LoginPlayer(val playerRepository: IPlayerRepository) {
    suspend fun execute(id:String?,password:String?): Player {
        if(id==null) throw NullPointerException("id sin valor")
        if(password==null) throw NullPointerException("password sin valor")

        val player = playerRepository.Get(id)
        if(player==null) throw NullPointerException("jugador con id: $id no encontrado")
        if(player.password!=password) throw NullPointerException("password incorrecta")
        return player
    }
}