package models

import kotlinx.serialization.Serializable

@Serializable
class Player(val ID: String, var password:String, var victoryPoints: Int) {

    fun addVictoryPoints(points: Int){
        victoryPoints += points
    }

    fun hasThisPassword(password: String):Boolean{
        return this.password == password
    }
}


/*FROM gradle:4.5-jdk8-alpine as builder
USER root
WORKDIR /builder
ADD . /app
COPY . /app
FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/server.jar .
CMD ["java", "-jar", "server.jar"]*/