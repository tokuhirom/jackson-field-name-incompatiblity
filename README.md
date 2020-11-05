# jackson-module-kotlin's incompatibility between 2.10.0 to 2.10.1

In Jackson 2.11.x+, there's jackson-module-kotlin's serialization result is incomptible.

Reproducing method:

 - Kotlin data class contains the field named `/is.*/`

## Building project

    ./gradlew :jackson210:run :jackson211:run

## Result

### Jackson version: 2.10.0

	{"usingBar":true}

### Jackson version: 2.10.1

	{"isUsingBar":true}

## See also

https://github.com/FasterXML/jackson-module-kotlin/issues/80
