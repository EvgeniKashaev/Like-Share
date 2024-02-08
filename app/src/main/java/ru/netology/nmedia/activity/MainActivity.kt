package ru.netology.nmedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import ru.netology.nmedia.R
import ru.netology.nmedia.repository.UIFormatter
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content

                shareCount.text = UIFormatter.format(post.shares)

                likeCount.text = UIFormatter.format(post.likes)

                root.setOnClickListener {
                    Log.d("stuff", "stuff")
                }

                avatar.setOnClickListener {
                    Log.d("stuff", "avatar")
                }

                share.setOnClickListener {
                    shareCount.text = UIFormatter.format(viewModel.share())
                }
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                like.setOnClickListener {
                    likeCount.text = UIFormatter.format(viewModel.like())
                }
            }
        }
    }
}

