package com.example.firstandroidapp

import android.content.Intent
import android.net.Uri
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

        val post = Event(
            getString(R.string.post_text),
            getString(R.string.post_date),
            getString(R.string.name_author),
            R.drawable.photo_author,
            commentsCount = 5,
            likesCount = 0,
            coordinates = Pair("55.760108", "37.648603")
        )
        textViewPost.text = post.textOfPost
        textViewDate.text = post.dateOfPost
        textViewAuthor.text = post.nameAuthor
        imageViewAvatar.setImageResource(post.photoAuthor)

        fillCount(textViewShareCount, post.sharesCount)
        fillCount(textViewCommentCount, post.commentsCount)
        fillCount(textViewLikeCount, post.likesCount)

        isCheckedByUser(imageButtonShare, textViewShareCount,
            post.isSharedByUser, R.drawable.ic_share_red)
        isCheckedByUser(imageButtonComment, textViewCommentCount,
            post.isCommentedByUser, R.drawable.ic_comment_red)
        isCheckedByUser(imageButtonLike, textViewLikeCount,
            post.isLikedByUser, R.drawable.ic_like_red)



        imageButtonLike.setOnClickListener {
            it as ImageButton
            post.isLikedByUser = !post.isLikedByUser
            isCheckedByUser(it, textViewLikeCount,
                post.isLikedByUser, R.drawable.ic_like_red, R.drawable.ic_like_gray)

            if (post.isLikedByUser) {
                post.likesCount++
            } else {
                post.likesCount--
            }
            fillCount(textViewLikeCount, post.likesCount)
        }

        imageButtonLocation.setOnClickListener {
            val lat = post.coordinates.first
            val lng = post.coordinates.second
            val dataOfCoordinates = Uri.parse("geo:$lat,$lng")
            showMap(dataOfCoordinates)
        }


    }

    private fun fillCount(view: TextView, count: Int) {
        if (count == 0) {
            view.visibility = View.INVISIBLE
        } else {
            view.visibility = View.VISIBLE
            view.text = count.toString()
        }
    }

    private fun isCheckedByUser(
        imageView: ImageButton,
        textView: TextView,
        isChecked: Boolean,
        imageRed: Int) {
        if (isChecked) {
            imageView.setImageResource(imageRed)
            textView.setTextColor(resources.getColor(R.color.colorRed))
        }
    }

    private fun isCheckedByUser(
        imageView: ImageButton,
        textView: TextView,
        isChecked: Boolean,
        imageRed: Int,
        imageGray: Int) {
        if (isChecked) {
            imageView.setImageResource(imageRed)
            textView.setTextColor(resources.getColor(R.color.colorRed))
        } else {
            imageView.setImageResource(imageGray)
            textView.setTextColor(resources.getColor(android.R.color.tab_indicator_text))
        }
    }

    fun showMap(geoLocation: Uri) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocation
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}
