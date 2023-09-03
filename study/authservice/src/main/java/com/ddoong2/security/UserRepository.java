package com.ddoong2.security;

/**
 * UserRepository
 *
 * Created by kdj on 2018. 8. 6.
 */
interface UserRepository {
    User findById(String id);
}
