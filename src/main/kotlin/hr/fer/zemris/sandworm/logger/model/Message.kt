package hr.fer.zemris.sandworm.logger.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Message(
        @Id
        @GeneratedValue
        var id: Long?,

        var taskId: String,
        var tag: String,
        var content: String,
        var timestamp: LocalDateTime,
        var receivedAt: LocalDateTime
) {
    constructor() : this(null, "", "", "", LocalDateTime.MIN, LocalDateTime.MIN)
}
