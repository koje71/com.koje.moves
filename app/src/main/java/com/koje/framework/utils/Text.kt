package com.koje.framework.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.xor

object Text {

    fun masc(data: ByteArray): ByteArray {
        val code = "mdu7chdnwl9adknaswnwdicyöwebvnmf".toByteArray()
        var codeIndex = 0
        val bytes = data
        var bytesIndex = 0

        while (bytesIndex < bytes.size) {
            bytes[bytesIndex] = bytes[bytesIndex] xor code[codeIndex]
            codeIndex++
            if (codeIndex == code.size) {
                codeIndex = 0
            }
            bytesIndex++
        }

        return bytes
    }


    fun getFormattedDuration(duration: Long): String {
        var seconds = duration / 1000
        seconds %= 3600

        val minutes = seconds / 60
        seconds %= 60

        return String.format("%02d:%02d", minutes, seconds)
    }

    fun getFormattedDurationWithHours(duration: Long): String {
        var seconds = duration / 1000
        val hours = seconds / 3600
        seconds %= 3600

        val minutes = seconds / 60
        seconds %= 60


        return (when (hours > 0) {
            true -> String.format("%02d:%02d:%02d", hours, minutes, seconds)
            else -> String.format("%02d:%02d", minutes, seconds)
        })
    }

    fun getHash(text: String): String {
        try {
            val digest = MessageDigest.getInstance("SHA-256")
            digest.reset()
            val result = digest.digest(text.toByteArray())
            return String.format("%0" + (result.size * 2) + "X", BigInteger(1, result))
        } catch (e1: NoSuchAlgorithmException) {
            return "error"
        }
    }


}