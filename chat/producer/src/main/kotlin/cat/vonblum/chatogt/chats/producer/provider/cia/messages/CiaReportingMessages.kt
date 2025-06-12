package cat.vonblum.chatogt.chats.producer.provider.cia.messages

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.ReportingMessages
import org.springframework.stereotype.Component

@Component
class CiaReportingMessages : ReportingMessages {

    override fun report(message: Message) {
        println("Reported message: $message to the CIA")
    }

}