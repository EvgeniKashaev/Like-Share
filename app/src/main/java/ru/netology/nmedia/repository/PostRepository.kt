package ru.netology.nmedia.repository

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

interface PostRepository {
    fun get(): MutableLiveData<Post>
    fun like(): Int
    fun share(): Int

}