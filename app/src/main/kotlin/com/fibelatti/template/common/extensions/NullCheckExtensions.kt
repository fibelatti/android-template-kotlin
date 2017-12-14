package com.fibelatti.template.common.extensions

inline fun <T, R> T?.ifNotNullThisElseThat(ifNotNull: (T) -> R, ifNull: () -> R) {
    if (this != null) ifNotNull(this) else ifNull()
}

inline fun <T, R> withItIfNotNull(receiver: T?, block: T.() -> R) {
    receiver?.block()
}
