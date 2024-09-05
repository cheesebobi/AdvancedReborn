import java.io.File

val INPUT_PATH = "input.java"
val OUTPUT_PATH = "output.java"

fun main() {
    val input = File(INPUT_PATH)
    val output = File(OUTPUT_PATH)

    if (!input.exists()) {
        println("not found")
        return
    }

    var contents = input.readText()

    var initContents = ""
    val instanceGeneratorList = mutableListOf<String>()
    val varNameList = mutableListOf<String>()

    val pattern = Regex("public static Block ([A-Z0-9_]+) = (.*);")
    val initPattern = Regex("public static void init\\(\\) \\{([\\s\\S]*?)\\}")

    pattern.findAll(contents).forEach {
        val (varName, instanceGenerator) = it.destructured
        varNameList.add(varName)
        instanceGeneratorList.add(instanceGenerator)

        initContents += "        $varName = registry.registerBlock(INSTANCE.compatId(\"$varName\"), () -> $instanceGenerator);\n"
    }

    contents = contents.replace(pattern) {
        val (varName, instanceGenerator) = it.destructured
        "public static RegistryResult<Block> $varName;"
    }
    contents = initPattern.replace(contents) {
        "public static void init() {\n$initContents\n    }"
    }

    if (!output.exists()) output.createNewFile()

    output.writeText(contents)
}

main()