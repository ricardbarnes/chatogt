package cat.vonblum.chatogt.chats.producer.adapter.messages

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.ReportingMessages
import cat.vonblum.chatogt.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class CiaReportingMessages : ReportingMessages {

    override fun report(message: Message) {
        println("Reported message: $message to the CIA")
    }

}