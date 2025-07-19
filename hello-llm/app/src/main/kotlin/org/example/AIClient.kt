package org.example

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse
import java.nio.charset.StandardCharsets

fun main() {
    // String endpoint = "https://api.openai.com/v1/chat/completions";
    val endpoint = "http://localhost:1234/v1/chat/completions"

    val jsonBody = """
            {
              "model": "qwen/qwen3-1.7b",
              "messages": [
                { "role": "system", "content": "/no_thin\nあなたはユーザーの役にたつアシスタントです。" },
                { "role": "user", "content": "日本の首都は？" }
              ],
              "temperature": 0.7
            }
        """.trimIndent()

    val request = HttpRequest.newBuilder()
        .uri(URI.create(endpoint))
        // .header("Authorization", "Bearer " + API_KEY) // OpenAIにアクセスする場合はAPI_KEYが必要
        .header("Content-Type", "application/json")
        .POST(BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
        .build()

    val client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    println("Response Body:\n${response.body()}")
}
