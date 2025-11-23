package cl.duoc.cuidapet.service1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.cuidapet.model.User;
import cl.duoc.cuidapet.repository.UserRepository;
import cl.duoc.cuidapet.service.UserService;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUser() {
        // Arrange
        User user = new User();
        user.setName("Maria");
        user.setEmail("maria@example.com");
        user.setPassword("secure123");

        when(userRepository.save(user)).thenReturn(user);

        // Act
        User savedUser = userService.create(user);

        // Assert
        assertNotNull(savedUser);
        assertEquals("Maria", savedUser.getName());
        assertEquals("maria@example.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(user);
    }
}


