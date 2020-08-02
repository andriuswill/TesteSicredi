package com.andriuswill.testesicredi.domain.usecases

interface RequestExceptionUseCase {
    fun treatException(exception: Exception): String
}