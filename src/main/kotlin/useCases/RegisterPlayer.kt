package useCases

import DTOs.LoginData
import models.Player
import repositories.IPlayerRepository

class RegisterPlayer(val playerRepository: IPlayerRepository) {
    suspend fun execute(player: LoginData){

        if(player == null) {
            throw Exception("Not player info sent")
        }

        if(playerRepository.Get(player.id) != null) {
            throw Exception("Player already exists")
        }

        if(player.password.length <5){
            throw Exception("Password must have at least 5 characters")
        }

        playerRepository.Add(Player(player.id, player.password, 0))

    }
}