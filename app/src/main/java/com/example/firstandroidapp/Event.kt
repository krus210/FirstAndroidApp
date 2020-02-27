package com.example.firstandroidapp

class Event(
    textOfPost: String,
    dateOfPost: String,
    nameAuthor: String,
    photoAuthor: Int,
    sharesCount: Int = 0,
    commentsCount: Int = 0,
    likesCount: Int = 0,
    isLikedByUser: Boolean = false,
    isCommentedByUser: Boolean = false,
    isSharedByUser: Boolean = false,
    val address: String = "Moscow",
    val coordinates: Pair<String, String>
    ):
    Post(
    textOfPost,
    dateOfPost,
    nameAuthor,
    photoAuthor,
    sharesCount,
    commentsCount,
    likesCount,
    isLikedByUser,
    isCommentedByUser,
    isSharedByUser)