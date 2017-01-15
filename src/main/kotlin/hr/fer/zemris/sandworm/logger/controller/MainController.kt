package hr.fer.zemris.sandworm.logger.controller

import hr.fer.zemris.sandworm.logger.model.Message
import hr.fer.zemris.sandworm.logger.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class MainController
@Autowired constructor(
        val messageRepository: MessageRepository
) {

    @PostMapping("/{taskId}")
    fun logMessage(
            @PathVariable taskId: String,
            @RequestParam tag: String,
            @RequestParam content: String,
            @RequestParam @DateTimeFormat(iso = DATE_TIME) timestamp: LocalDateTime
    ) = messageRepository.save(Message(
            null,
            taskId,
            tag,
            content,
            timestamp,
            LocalDateTime.now()
    ))

    @GetMapping("/{taskId}")
    fun getMessages(@PathVariable taskId: String) = messageRepository.findByTaskId(taskId)

    @GetMapping("/{taskId}/since/{since}")
    fun getMessagesSince(
            @PathVariable taskId: String,
            @PathVariable @DateTimeFormat(iso = DATE_TIME) since: LocalDateTime
    )
            = messageRepository.findByTaskIdAndTimestampGreaterThan(taskId, since)

}
