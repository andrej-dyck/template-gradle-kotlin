package ad.template.gradle.domain

import org.assertj.core.api.Assertions.*

class CustomAssert<T> internal constructor(val actual: T)

val <T> T.must get() = CustomAssert(this)

inline fun <T> CustomAssert<T>.custom(assert: (T) -> Unit): CustomAssert<T> {
    assert(actual)
    return this
}

fun <T> CustomAssert<T>.beEqualTo(expectedValue: T) = custom {
    assertThat(it).isEqualTo(expectedValue)
}