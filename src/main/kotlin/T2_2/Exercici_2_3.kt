package exercicis

import javax.swing.*
import java.awt.*
import java.io.File

class Exercici_2_3 : JFrame() {
    val area = JTextArea()
    val scrollPane = JScrollPane(area)

    val menu_p = JMenuBar()

    val menu_arxiu = JMenu("Arxiu")
    val menu_ajuda = JMenu("Ajuda")

    val obrir = JMenuItem("Obrir")
    val guardar = JMenuItem("Guardar")
    val guardarCom = JMenuItem("Guardar com ...")
    val eixir = JMenuItem("Eixir")

    val quantA = JMenuItem("Quant a Editor")

    val fCh = JFileChooser()

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        setLayout(BorderLayout())
        setTitle("Editor de text més avançat")
        add(scrollPane)
        area.setEditable(true)

        setSize(750, 400)
        setJMenuBar(menu_p)

        menu_p.add(menu_arxiu)
        menu_p.add(menu_ajuda)

        menu_arxiu.add(obrir)
        menu_arxiu.add(guardar)
        menu_arxiu.add(guardarCom)
        menu_arxiu.add(JSeparator())
        menu_arxiu.add(eixir)

        menu_ajuda.add(quantA);

        obrir.addActionListener { obrir() }

        guardar.addActionListener { guardar() }

        guardarCom.addActionListener { guardarCom() }

        eixir.addActionListener { eixir() }

        quantA.addActionListener { quantA() }
    }

    fun obrir() {
        val r = fCh.showOpenDialog(this)
        val f: File
        if (r == JFileChooser.APPROVE_OPTION) {
            println("Fitxer seleccionat: " + fCh.getSelectedFile().getName())
            f = fCh.selectedFile
            area.text = f.readText()
        } else
            println("No s'ha seleccionat res")
    }

    fun guardar() {
        if (fCh.selectedFile == null) {
            val r = fCh.showSaveDialog(this)
            if (r == JFileChooser.APPROVE_OPTION) {
                fCh.selectedFile.writeText(area.text)
            } else
                println("S'ha cancelat l'accio")
        } else fCh.selectedFile.writeText(area.text)
    }

    fun guardarCom() {
        if (fCh.selectedFile != null)
            JOptionPane.showMessageDialog(this, "Cambia el nombre del fichero o se reescribira")
        val r = fCh.showSaveDialog(this)
        if (r == JFileChooser.APPROVE_OPTION) {
            fCh.selectedFile.writeText(area.text)
        } else
            println("S'ha cancelat l'accio")
    }

    fun eixir() {
        System.exit(0)
    }

    fun quantA() {
        JOptionPane.showMessageDialog(this, "No hi ha ajuda, espavila")
    }
}


fun main(args: Array<String>) {
    EventQueue.invokeLater({ Exercici_2_3().isVisible = true })
}