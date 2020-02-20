package com.example.firstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(
            "Hi there!",
            "19 february 2020",
            commentsCount = 5,
            likesCount = 73,
            isLikedByUser = true
        )
        textViewPost.text = post.textOfPost
        textViewDate.text = post.dateOfPost

        fillCount(textViewShareCount, post.sharesCount)
        fillCount(textViewCommentCount, post.commentsCount)
        fillCount(textViewLikeCount, post.likesCount)

        isCheckedByUser(imageButtonShare, textViewShareCount,
            post.isSharedByUser, R.drawable.ic_share_red)
        isCheckedByUser(imageButtonComment, textViewCommentCount,
            post.isCommentedByUser, R.drawable.ic_comment_red)
        isCheckedByUser(imageButtonLike, textViewLikeCount,
            post.isLikedByUser, R.drawable.ic_like_red)
    }

    private fun fillCount(view: TextView, count: Int) {
        if (count == 0) {
            view.visibility = View.GONE
        } else {
            view.text = count.toString()
        }
    }

    private fun isCheckedByUser(
        imageView: ImageButton,
        textView: TextView,
        isChecked: Boolean,
        image: Int) {
        if (isChecked) {
            imageView.setImageResource(image)
            textView.setTextColor(resources.getColor(R.color.colorRed))
        }
    }

}
