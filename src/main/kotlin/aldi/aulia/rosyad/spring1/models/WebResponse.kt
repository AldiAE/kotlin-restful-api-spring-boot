package aldi.aulia.rosyad.spring1.models

data class WebResponse<T>(

    val code: Int,

    val status: String,

    val data: T
)