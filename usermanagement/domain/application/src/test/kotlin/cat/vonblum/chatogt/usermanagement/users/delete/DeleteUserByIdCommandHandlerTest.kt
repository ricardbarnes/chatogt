package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.FindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class DeleteUserByIdCommandHandlerTest {

    @Mock
    private lateinit var finding: FindingUsers

    @Mock
    private lateinit var eventBus: EventBus

    @InjectMocks
    private lateinit var sut: DeleteUserByIdCommandHandler

    @Test
    fun `It should delete a user`() {
        // TODO
    }

}