package com.example.lab_3

object DataSource {
    const val NEW_USER_EXTRA = "newUser"
    private val users: ArrayList<User> = arrayListOf<User>(
        User("John", "Doe", "john.doe@email.com", "password123"),
        User("a", "g", "a", "123"),
        User("Jane", "Smith", "jane.smith@email.com", "password456"),
        User(null, "Johnson", "jjohnson@email.com", "password789"),
        User("Alice", "Williams", "awilliams@email.com", null),
        User("Bob", null, "bob@example.com", null),
        User(null, null, "no.name@email.com", "password123"),
        User("Mike", "Lee", "mlee@email.com", ""),
        User("", "", "emptyfields@email.com", ""),
        User("Sarah", "Jones", "sarahjones@email.com", ""),
        User("David", null, "david@email.com", "")
    )

    fun getUsers() : ArrayList<User>{
        return users
    }

    fun insertUser(user: User) {
        users.add(user)
    }

    fun getUserByName(email : String) : User?{
        return users.find { u->u.email.equals(email) }
    }

}