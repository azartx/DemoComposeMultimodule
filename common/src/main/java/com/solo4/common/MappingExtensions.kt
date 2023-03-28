package com.solo4.common

inline fun <IN, reified OUT> IN.transform(block: (IN) -> OUT): OUT {
    return block.invoke(this)
}
