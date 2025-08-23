package cat.vonblum.chatogt.chat.producer.provider.fbi.messages

import cat.vonblum.chatogt.chat.messages.Message
import cat.vonblum.chatogt.chat.messages.ReportingMessages
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Primary
@Component
class FbiReportingMessages : ReportingMessages {

    override fun report(message: Message) {
        println("Message: $message reported to the FBI")
    }

}