package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.domain.query.Query

data class FindUserByEmailQuery(val email: String) : Query