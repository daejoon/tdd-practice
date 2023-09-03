package com.ddoong2.security;

/**
 * AuthService
 *
 * Created by kdj on 2018. 8. 6.
 */
class AuthService {
    private UserRepository userRepository;

    public Authentication authenticate(String id, String password) {
        assertIdAndPw(id, password);
        User user = findUserOrThrownEx(id);
        thrownExIfPasswordIsWrong(password, user);
        return createAuthentication(user);
    }

    private void assertIdAndPw(String id, String password) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private User findUserOrThrownEx(String id) {
        User user = findUserById(id);
        if (user == null) {
            throw new NonExistingUserException();
        }
        return user;
    }

    private void thrownExIfPasswordIsWrong(String password, User user) {
        if (!user.matchPassword(password)) {
            throw new WrongPasswordException();
        }
    }

    private Authentication createAuthentication(User user) {
        return new Authentication(user.getId());
    }

    private User findUserById(String id) {
        return userRepository.findById(id);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
