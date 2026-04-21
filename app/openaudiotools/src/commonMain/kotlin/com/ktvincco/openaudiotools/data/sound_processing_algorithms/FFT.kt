package com.ktvincco.openaudiotools.data.sound_processing_algorithms

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.floor
import kotlin.math.log2
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Optimized Iterative Fast Fourier Transform implementation.
 * Replaces the recursive version to avoid deep stacks and excessive object allocation.
 */

fun fastFourierTransform(input: FloatArray): List<Float> {
    if (input.isEmpty()) return listOf(0f)
    if (input.size == 1) return listOf(input[0])

    val n = input.size
    // Find nearest power of 2
    val p = floor(log2(n.toFloat())).toInt()
    val m = 1 shl p
    
    // Use arrays for real and imaginary parts to avoid Complex object overhead
    val real = DoubleArray(m)
    val imag = DoubleArray(m)
    
    // Bit-reversal permutation
    for (i in 0 until m) {
        val j = reverseBits(i, p)
        real[j] = input[i].toDouble()
        imag[j] = 0.0
    }
    
    // Cooley-Tukey iterative FFT
    var size = 2
    while (size <= m) {
        val halfSize = size / 2
        val angleStep = -2.0 * PI / size
        for (i in 0 until m step size) {
            for (j in 0 until halfSize) {
                val angle = j * angleStep
                val wReal = cos(angle)
                val wImag = sin(angle)
                
                val tr = real[i + j + halfSize] * wReal - imag[i + j + halfSize] * wImag
                val ti = real[i + j + halfSize] * wImag + imag[i + j + halfSize] * wReal
                
                real[i + j + halfSize] = real[i + j] - tr
                imag[i + j + halfSize] = imag[i + j] - ti
                real[i + j] += tr
                imag[i + j] += ti
            }
        }
        size *= 2
    }
    
    // Normalize and take positive frequencies
    val scaleFactor = 2.0 / m
    val result = FloatArray(m / 2)
    for (i in 0 until m / 2) {
        result[i] = (scaleFactor * sqrt(real[i] * real[i] + imag[i] * imag[i])).toFloat()
    }
    
    return result.toList()
}

private fun reverseBits(i: Int, p: Int): Int {
    var index = i
    var res = 0
    for (j in 0 until p) {
        res = (res shl 1) or (index and 1)
        index = index shr 1
    }
    return res
}
