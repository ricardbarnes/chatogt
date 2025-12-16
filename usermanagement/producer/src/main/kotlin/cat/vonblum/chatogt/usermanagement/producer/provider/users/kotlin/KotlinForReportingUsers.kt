package cat.vonblum.chatogt.usermanagement.producer.provider.users.kotlin

import cat.vonblum.chatogt.usermanagement.users.ForReportingUsers
import cat.vonblum.chatogt.usermanagement.users.User

class KotlinForReportingUsers : ForReportingUsers {

    override fun report(user: User) {
        println("User ${user.email.value} has been created")
    }

}