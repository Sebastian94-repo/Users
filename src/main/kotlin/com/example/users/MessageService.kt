package com.example.users

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
@Repository

class MessageService (val db: MessageRepository) {

    fun findMessages(): List<Message> = db.findMessages()


    fun post(message: Message) {
        db.save(message)

    }
}

interface MessageRepository : CrudRepository <Message, String> {

    @Query("select * from messages")
    fun findMessages(): List<Message>

}

