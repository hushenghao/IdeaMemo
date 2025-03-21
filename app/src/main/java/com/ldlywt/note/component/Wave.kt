package com.ldlywt.note.component

import androidx.annotation.IntRange
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun FadingCircle(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    durationMillis: Int = 1200,
    color: Color = MaterialTheme.colorScheme.primary,
    circleSizeRatio: Float = 1.0f
) {
    val transition = rememberInfiniteTransition()

    val durationPerFraction = durationMillis / 2

    val circleAlpha1 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 1,
        easing = EaseInOut
    )
    val circleAlpha2 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 2,
        easing = EaseInOut
    )
    val circleAlpha3 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 3,
        easing = EaseInOut
    )
    val circleAlpha4 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 4,
        easing = EaseInOut
    )
    val circleAlpha5 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 5,
        easing = EaseInOut
    )
    val circleAlpha6 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 6,
        easing = EaseInOut
    )
    val circleAlpha7 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 7,
        easing = EaseInOut
    )
    val circleAlpha8 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 8,
        easing = EaseInOut
    )
    val circleAlpha9 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 9,
        easing = EaseInOut
    )
    val circleAlpha10 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 10,
        easing = EaseInOut
    )
    val circleAlpha11 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 11,
        easing = EaseInOut
    )
    val circleAlpha12 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 12,
        easing = EaseInOut
    )

    Canvas(modifier = modifier.size(size)) {
        val pathRadius = (this.size.height / 2)

        val radius = this.size.height / 12 * circleSizeRatio

        for(i in 0 until 12){
            val angle = i / 12.toDouble() * 360.0
            val offsetX = -(pathRadius * sin(Math.toRadians(angle))).toFloat() + pathRadius
            val offsetY = (pathRadius * cos(Math.toRadians(angle))).toFloat() + pathRadius

            drawCircle(
                color = color,
                radius = radius,
                center = Offset(offsetX,  offsetY),
                alpha = when(i){
                    0 -> circleAlpha1.value
                    1 -> circleAlpha2.value
                    2 -> circleAlpha3.value
                    3 -> circleAlpha4.value
                    4 -> circleAlpha5.value
                    5 -> circleAlpha6.value
                    6 -> circleAlpha7.value
                    7 -> circleAlpha8.value
                    8 -> circleAlpha9.value
                    9 -> circleAlpha10.value
                    10 -> circleAlpha11.value
                    11 -> circleAlpha12.value
                    else -> circleAlpha1.value
                }
            )
        }
    }
}
@Composable
internal fun InfiniteTransition.fractionTransition(
    initialValue: Float,
    targetValue: Float,
    @IntRange(from = 1, to = 4) fraction: Int = 1,
    durationMillis: Int,
    delayMillis: Int = 0,
    offsetMillis: Int = 0,
    repeatMode: RepeatMode = RepeatMode.Restart,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis
                this.delayMillis = delayMillis
                initialValue at 0 with easing
                when(fraction){
                    1 ->{
                        targetValue at durationMillis with easing
                    }
                    2 ->{
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue at durationMillis with easing
                    }
                    3 ->{
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue / fraction * 2 at durationMillis / fraction * 2 with easing
                        targetValue at durationMillis with easing
                    }
                    4 ->{
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue / fraction * 2 at durationMillis / fraction * 2 with easing
                        targetValue / fraction * 3 at durationMillis / fraction * 3 with easing
                        targetValue at durationMillis with easing
                    }
                }
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}

val EaseInOut = CubicBezierEasing(0.42f, 0f, 0.58f, 1f)