// ISSUE: KT-59426

// IGNORE_BACKEND: ANY
// IGNORE_IR_DESERIALIZATION_TEST: NATIVE
// REASON: red code (see corresponding diagnostic test)
// IGNORE_IR_DESERIALIZATION_TEST: JS_IR
// ^^^ Source code is not compiled in JS.

fun box(): String {
    build {
        setTypeVariable(DifferentType())
        consumeBuildeeReceiver()
    }
    return "OK"
}




class TargetType
class DifferentType

fun consumeTargetType(value: TargetType) {}

class Buildee<TV> {
    fun setTypeVariable(value: TV) { storage = value }
    fun getTypeVariable(): TV = storage
    private var storage: TV = TargetType() as TV
}

fun Buildee<TargetType>.consumeBuildeeReceiver() {
    consumeTargetType(getTypeVariable())
}

fun <PTV> build(instructions: Buildee<PTV>.() -> Unit): Buildee<PTV> {
    return Buildee<PTV>().apply(instructions)
}
