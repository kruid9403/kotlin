@file:kotlin.Suppress("DEPRECATION_ERROR")

import kotlin.native.internal.ExportedBridge
import kotlinx.cinterop.*
import kotlinx.cinterop.internal.convertBlockPtrToKotlinFunction

@ExportedBridge("b_bridge")
public fun b_bridge(): UShort {
    val _result = b()
    return _result
}

@ExportedBridge("c_bridge")
public fun c_bridge(): UInt {
    val _result = c()
    return _result
}

@ExportedBridge("d_bridge")
public fun d_bridge(): ULong {
    val _result = d()
    return _result
}

@ExportedBridge("e_bridge")
public fun e_bridge(): UByte {
    val _result = e()
    return _result
}