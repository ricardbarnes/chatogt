package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.domain.valueobject.IdFaker
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateUserCommandHandlerTest {

    @Mock
    private lateinit var idGeneratorMock: IdGenerator

    @Mock
    private lateinit var eventBusMock: EventBus

    @InjectMocks
    private lateinit var sut: CreateUserCommandHandler

    @Test
    fun `It should create a user`() {
        // Given
        val command = CreateUserCommandMother.random()
        `when`(idGeneratorMock.next())
            .thenReturn(IdFaker.random())

        // When
        sut.handle(command)

        // Then
        verify(eventBusMock).publish(anyList())
    }

}