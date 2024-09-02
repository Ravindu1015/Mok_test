import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepositary userRepositary;
    private UserService userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        userService= new UserService(userRepositary);
    }

    @Test
    public void testGetUserName(){
        user user =new user(1,"john doe");
        when(userRepositary.findUserById(1)).thenReturn(user);

        String userName= userService.getUserName(1);

        assertEquals("john doe",userName);
    }

    @Test
    public void testGetUserName_UserNotFound(){
        when(userRepositary.findUserById(1)).thenReturn(null);

        String userName=userService.getUserName(1);

        assertEquals("unknown user",userName);

    }
}
