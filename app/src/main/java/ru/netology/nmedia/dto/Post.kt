package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean = true,
    val likes: Int = 5,
    val shares: Int = 999999,
)

