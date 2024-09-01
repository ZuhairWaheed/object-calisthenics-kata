package exercise_5_one_dot_per_line.fakes

import org.apache.commons.lang3.BooleanUtils
import org.apache.commons.lang3.StringUtils
import java.util.*

class TokenDetailsDto (
    val token: String,
    val isValidated: Boolean,
    val userId: String ,
    val userName: String,
    val userChannel: String,
    val userScopes: List<String>
        ) {
    fun toHeaderMap(): Map<String, String> {
        val headers = HashMap<String, String>()
        headers.put("AUTHORIZATION", token)

        // If request was validated, add headers for extracted details from token as well
        if (isValidated) {
            headers.putAll(
                java.util.Map.of(
                    "IS_VALIDATED_ATTRIBUTE", BooleanUtils.toStringTrueFalse(true),
                    "USER_ID_ATTRIBUTE", userId,
                    "USER_NAME_ATTRIBUTE", userName,
                    "USER_CHANNEL_ATTRIBUTE", userChannel,
                    "USER_SCOPES_ATTRIBUTE", StringUtils.join(userScopes, ",")
                )
            )
        }
        return Collections.unmodifiableMap(headers)
    }
}