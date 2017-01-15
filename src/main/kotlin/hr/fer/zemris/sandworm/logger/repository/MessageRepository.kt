package hr.fer.zemris.sandworm.logger.repository

import hr.fer.zemris.sandworm.logger.model.Message
import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime

interface MessageRepository : CrudRepository<Message, Long> {

    fun findByTaskId(taskId: String): List<Message>

    fun findByTaskIdAndTimestampGreaterThan(taskId: String, timestamp: LocalDateTime): List<Message>

}
