package exercise_6_dont_abbreviate

import exercise_6_dont_abbreviate.fakes.CoordinateDto
import java.lang.Math.floor

/*
Identify and eliminate abbreviations.
 */

object PolylineUtil {

    fun encodePolyline(poly: List<CoordinateDto>): String {
        return encodePolyline(poly, 1e5)
    }

    private fun encodePolyline(poly: List<CoordinateDto>, precision: Double): String {
        val sb = StringBuilder()
        val size: Int = poly.size
        var prevLat = 0
        var prevLon = 0
        for (i in 0 .. size) {
            var num = floor(poly[i].latitude * precision).toInt()
            encodeNumber(sb, num - prevLat)
            prevLat = num
            num = floor(poly[i].longitude * precision).toInt()
            encodeNumber(sb, num - prevLon)
            prevLon = num
        }
        return sb.toString()
    }

    private fun encodeNumber(sb: StringBuilder, num: Int) {
        var num = num
        num = num shl 1
        if (num < 0) {
            num = num.inv()
        }
        while (num >= 0x20) {
            val nextValue = (0x20 or (num and 0x1f)) + 63
            sb.append(nextValue.toChar())
            num = num shr 5
        }
        num += 63
        sb.append(num.toChar())
    }
}