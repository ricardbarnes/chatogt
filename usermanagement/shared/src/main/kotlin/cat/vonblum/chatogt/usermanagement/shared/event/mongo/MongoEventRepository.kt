package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import org.springframework.data.mongodb.repository.MongoRepository

interface MongoEventRepository : MongoRepository<MongoEvent, String>