package com.example.attendancesystemandroid.utils

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, message: String): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }
    }
}
