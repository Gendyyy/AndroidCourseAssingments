package com.example.lab_3


data class User(val firstName: String? = null, val lastName: String? = null
                , val email: String? = null, val password: String? = null)
    : java.io.Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (email?.lowercase() != other.email?.lowercase()) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = email.hashCode()
        result = 31 * result + (password?.hashCode() ?: 0)
        return result
    }
}
