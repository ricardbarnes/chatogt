package cat.vonblum.chatogt.chat.producer.provider.messages.cia

import cat.vonblum.chatogt.chat.messages.Message
import cat.vonblum.chatogt.chat.messages.ReportingMessages
import org.springframework.stereotype.Component

@Component
class CiaReportingMessages : ReportingMessages {

    override fun report(message: Message) {
        println("Reported message: $message to the CIA")
    }

}