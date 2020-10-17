package com.youtube.example.exampleviewmodel.models

data class User(val id: String, val name: String, var age: Int)
private val user = User("3ad50gfbcdbu","Larry", 99)
class UsersRepository() {
    fun fetchUserFromBackend(id: String): User {
        return user
    }
    fun happyBirthday(): User {
        user.age = user.age + 1
        return user
    }
}