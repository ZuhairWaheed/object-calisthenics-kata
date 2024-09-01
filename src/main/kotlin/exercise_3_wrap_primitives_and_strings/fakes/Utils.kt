package exercise_3_wrap_primitives_and_strings.fakes

import org.apache.commons.lang3.RandomStringUtils

object Utils {

    fun randomNumbers(length: Int): String {
        return RandomStringUtils.random(
            length,
            0,
            0,
            false,
            true,
            null as CharArray?,
            getPseudoRandomGenerator()
        )
    }

    private fun getPseudoRandomGenerator(): java.security.SecureRandom {
        return java.security.SecureRandom(System.nanoTime().toString().toByteArray())
    }
}