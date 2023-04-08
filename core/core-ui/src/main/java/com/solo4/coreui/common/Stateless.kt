package com.solo4.coreui.common

sealed class Stateless {
    object Loading : Stateless()
    data class Error(val cause: Throwable) : Stateless()
    object Success : Stateless()
}
