package T2_1

import T2_1.FitxerImatge
import java.io.File

fun main(args: Array<String>) {
    val f = File("src/main/resources/Penyagolosa.bmp")

    val fitxer = FitxerImatge(f)

    fitxer.transformaNegatiu()
    fitxer.transformaObscur()
    fitxer.transformaBlancNegre()
    fitxer.aumentarIntensitat()

}