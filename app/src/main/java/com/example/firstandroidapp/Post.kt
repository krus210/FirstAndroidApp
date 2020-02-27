package com.example.firstandroidapp

open class Post(
    var textOfPost: String,
    var dateOfPost: String,
    val nameAuthor: String,
    val photoAuthor: Int,
    var sharesCount: Int = 0,
    var commentsCount: Int = 0,
    var likesCount: Int = 0,
    var isLikedByUser: Boolean = false,
    var isCommentedByUser: Boolean = false,
    var isSharedByUser: Boolean = false)
