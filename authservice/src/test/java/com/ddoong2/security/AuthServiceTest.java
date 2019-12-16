package com.ddoong2.security;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

/**
 * AuthServiceTest
 *
 * Created by kdj on 2018. 8. 6.
 */
public class AuthServiceTest {

    private static final String USER_PASSWORD = "userPassword";
    private static final String NO_USER_ID = "noUserId";
    private static final String USER_ID = "userId";
    private static final String WRONG_PASSWORD = "wrongPassword";
    private AuthService authService;
    private UserRepository mockUserRepository;

    @Before
    public void setUp() throws Exception {
        mockUserRepository = mock(UserRepository.class);
        authService = new AuthService();
        authService.setUserRepository(mockUserRepository);
    }

    @Test
    public void givenInvalidId_throwIllegalArgEx() {
        assertIllegalArgExThrown(null, USER_PASSWORD);
        assertIllegalArgExThrown("", USER_PASSWORD);
        assertIllegalArgExThrown(USER_ID, null);
        assertIllegalArgExThrown(USER_ID, "");
    }

    @Test
    public void whenUserFoundButWrongPasswordEx() {
        givenUserExists(USER_ID, USER_PASSWORD);
        assertExceptionThrown(USER_ID, WRONG_PASSWORD, WrongPasswordException.class);
        verifyUserFound(USER_ID);
    }

    private void verifyUserFound(String id) {
        then(mockUserRepository).should().findById(id);
    }

    private void givenUserExists(String id, String password) {
        given(mockUserRepository.findById(id)).willReturn(new User(id, password));
    }

    @Test
    public void whenUserNotFound_thrownNonExistingUserEx() {
        assertExceptionThrown(NO_USER_ID, USER_PASSWORD, NonExistingUserException.class);
        for (int i = 0; i < 100; i++) {
            assertExceptionThrown(NO_USER_ID + i, USER_PASSWORD, NonExistingUserException.class);
        }
    }

    private void assertExceptionThrown(String noUserId, String userPassword, Class<? extends Exception> type) {
        Exception thrownEx = null;
        try {
            authService.authenticate(noUserId, userPassword);
        } catch (Exception e) {
            thrownEx = e;
        }
        assertThat(thrownEx, instanceOf(type));
    }

    private void assertIllegalArgExThrown(String id, String password) {
        assertExceptionThrown(id, password, IllegalArgumentException.class);
    }


    @Test
    public void whenUserFoundAndRightPw_returnAuth() {
        givenUserExists(USER_ID, USER_PASSWORD);
        Authentication auth = authService.authenticate(USER_ID, USER_PASSWORD);
        assertThat(auth.getId(), equalTo(USER_ID));
    }

}
