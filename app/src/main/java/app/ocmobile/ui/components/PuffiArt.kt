package app.ocmobile.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.core.graphics.PathParser

/** Puffi's 48 × 36 pixel base. Face and accessories remain independent. */
internal object PuffiArt {
    private const val BODY = "M27,0H33V1H36V3H38V5H39V9H38V12H40V14H42V17H45V19H47V21H48V26H47V29H44V31H40V33H34V34H30V36H23V35H20V34H18V35H12V34H9V32H5V30H2V28H0V22H1V20H3V18H5V16H8V12H10V10H13V8H19V7H22V4H24V2H27Z"
    private const val SHADOW = "M0,25H2V27H5V28H8V27H10V29H13V30H17V29H19V31H23V32H28V31H30V29H33V28H35V29H39V28H42V27H45V25H48V26H47V29H44V31H40V33H34V34H30V36H23V35H20V34H18V35H12V34H9V32H5V30H2V28H0Z"
    private const val CURL = "M22,8H23V10H25V11H27V9H28V8H32V9H34V11H35V14H34V16H32V17H29V16H28V15H31V14H32V12H31V11H29V12H28V13H24V12H22Z"
    private const val CHEEKS = "M12,23H13V26H12ZM15,23H16V26H15ZM33,23H34V26H33ZM36,23H37V26H36Z"
    private val layers = listOf(
        BODY to Color(0xFFEDE6FF), SHADOW to Color(0xFFD5C3FF),
        CURL to Color(0xFFB98DFF), CHEEKS to Color(0xFFFF8FD6),
    ).map { (data, color) -> PathParser.createPathFromPathData(data)!!.asComposePath() to color }

    fun draw(scope: DrawScope, x: Float, y: Float, width: Float) = with(scope) {
        withTransform({ translate(x, y); scale(width / 48f, width / 48f, androidx.compose.ui.geometry.Offset.Zero) }) {
            layers.forEach { (path, color) -> drawPath(path, color) }
        }
    }
}
