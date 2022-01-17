package com.example.demo

sealed interface Response{
    data class Response1(val name: String): Response
}
