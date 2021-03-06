package com.letterboxd.authentication

import io.archano.playground.common.api.RequestDecorator
import okhttp3.Request

internal class SignatureHeaderRequestDecorator (private val signer: RequestSigner) : RequestDecorator {

    override fun decorate(request: Request): Request {
        val signature = signer.sign(request)
        return request.newBuilder()
                .addHeader("Authorization", "Signature $signature")
                .build()

    }
}
