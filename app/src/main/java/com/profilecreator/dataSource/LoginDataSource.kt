package com.profilecreator.dataSource

import com.profilecreator.model.User
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<User> {

        try {
            // TODO: handle loggedInUser authentication
            val user = User(username, password)

            return Result.Success(user)

        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

