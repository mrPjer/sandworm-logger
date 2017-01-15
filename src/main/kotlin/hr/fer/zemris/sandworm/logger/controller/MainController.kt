package hr.fer.zemris.sandworm.logger.controller

import hr.fer.zemris.sandworm.logger.model.Message
import hr.fer.zemris.sandworm.logger.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime

@Controller
class MainController
@Autowired constructor(
        val messageRepository: MessageRepository
) {

    @PostMapping("/{taskId}")
    fun logMessage(
            @PathVariable taskId: String,
            @RequestParam tag: String,
            @RequestParam content: String,
            @RequestParam timestamp: LocalDateTime
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
    fun getMessagesSince(@PathVariable taskId: String, @PathVariable since: LocalDateTime)
            = messageRepository.findByTaskIdAndTimestampGreaterThan(taskId, since)

}
