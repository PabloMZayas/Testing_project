package com.example.logInRabbit.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.logInRabbit.domain.UserModelDomain

@Entity(tableName = "users")

data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "user_id")
    val id: String,

    @ColumnInfo (name = "user_name")
    val name: String,

    @ColumnInfo (name = "user_last_name")
    val lastName: String,

    @ColumnInfo (name = "user_birthday")
    val birthday: String,

    @ColumnInfo (name = "user_email")
    val email: String,

    @ColumnInfo (name = "user_password")
    val password: String,

    @ColumnInfo (name = "user_description")
    val description: String
)

fun UserEntity.toUserDomainModel(): UserModelDomain {
    return UserModelDomain(
        id = id,
        name = name,
        lastName = lastName,
        birthday = birthday,
        email = email,
        password = password,
        description = description
    )
}

fun UserModelDomain.toUserEntity(): UserEntity {
    return UserEntity(
        id = id,
        name = name,
        lastName = lastName,
        birthday = birthday,
        email = email,
        password = password,
        description = description
    )
}
