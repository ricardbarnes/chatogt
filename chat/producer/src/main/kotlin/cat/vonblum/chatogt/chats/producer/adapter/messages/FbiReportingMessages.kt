package cat.vonblum.chatogt.chats.producer.adapter.messages

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.ReportingMessages
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Primary
@Component
class FbiReportingMessages : ReportingMessages {

    override fun report(message: Message) {
        println("Message: $message reported to the FBI")
    }

}