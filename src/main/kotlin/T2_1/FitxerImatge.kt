package T2_1

import java.io.*


class FitxerImatge(fEnt: File) {
    var f: File = File("")

    init {
        if (fEnt.exists()) {
            if (fEnt.extension == "bmp") {
                f = fEnt
            } else println("El fixer no es bmp")
        } else println("El fixero no existe")

    }

    fun sacarNombreArxivo(): String {
        val nomobre = f.name.split(".")
        return nomobre[0]
    }

    fun transformaNegatiu() {
        val bin = FileInputStream(f)
        val bout = FileOutputStream("src/main/resources/" + sacarNombreArxivo() + "_n.bmp")
        val info = bin.readNBytes(54)
        bout.write(info)
        var bite = bin.read()
        while (bite != -1) {
            bout.write(255 - bite)
            bite = bin.read()
        }
        bin.close()
        bout.close()
    }

    fun transformaObscur() {
        val bin = FileInputStream(f)
        val bout = FileOutputStream("src/main/resources/" + sacarNombreArxivo() + "_o.bmp")
        val info = bin.readNBytes(54)
        bout.write(info)
        var bite = bin.read()
        while (bite != -1) {
            bout.write(bite / 2)
            bite = bin.read()
        }
        bin.close()
        bout.close()
    }

    fun transformaBlancNegre() {

        val bin = FileInputStream(f)
        val bout = FileOutputStream("src/main/resources/" + sacarNombreArxivo() + "_bn.bmp")
        val info = bin.readNBytes(54)
        bout.write(info)

        var bit1 = bin.read()
        var bit2 = bin.read()
        var bit3 = bin.read()

        while (bit1 != -1) {
            var pixel = (bit1 + bit2 + bit3) / 3
            bout.write(pixel)
            bout.write(pixel)
            bout.write(pixel)
            bit1 = bin.read()
            bit2 = bin.read()
            bit3 = bin.read()
        }
        bin.close()
        bout.close()
    }
    fun aumentarIntensitat(){
        val bin = FileInputStream(f)
        val bout = FileOutputStream("src/main/resources/" + sacarNombreArxivo() + "_in.bmp")
        val info = bin.readNBytes(54)
        bout.write(info)
        var bite = bin.read()
        while (bite != -1) {
            bout.write(bite + (255-bite)/2)
            bite = bin.read()
        }
        bin.close()
        bout.close()
    }

}


