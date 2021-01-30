import net.kanjitomo.OCRResults
import java.awt.*
import javax.swing.*
import javax.swing.border.Border

class GUI() {

    private val frame : JFrame = JFrame("Furigana Screen Reader")

    private val kanjiPanel : KanjiPanel = KanjiPanel()
    private val descriptionPanel : DescriptionPanel = DescriptionPanel()

    init {
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Dimension(420, 310)
        frame.isAlwaysOnTop = true
        frame.layout = BorderLayout()

//        val image = ImageIcon("icon.png");
//        frame.iconImage = image.image

        frame.contentPane.background = Color.DARK_GRAY

        kanjiPanel.preferredSize = Dimension(300, 80)
        frame.add(kanjiPanel, BorderLayout.NORTH)

        descriptionPanel.preferredSize = Dimension(300, 200)
        frame.add(descriptionPanel, BorderLayout.SOUTH)

        frame.isVisible = true
    }

    fun update(results: OCRResults) {
        kanjiPanel.kanjiLabel.text = results.words?.get(0)?.kanji ?: ""
        kanjiPanel.kanaLabel.text = results.words?.get(0)?.kana ?: ""
        descriptionPanel.textArea.text = results.words?.get(0)?.description ?: ""
    }
}

class KanjiPanel : JPanel() {
    val kanjiLabel : JLabel = JLabel()
    val kanaLabel : JLabel = JLabel()

    init {
        layout = BorderLayout()

        kanjiLabel.foreground = Color.BLACK
        kanjiLabel.font = Font("msgothic.ttc", Font.PLAIN, 42)
        kanjiLabel.horizontalAlignment = JLabel.CENTER
        add(kanjiLabel, BorderLayout.SOUTH)

        kanaLabel.foreground = Color.BLACK
        kanaLabel.font = Font("msgothic.ttc", Font.PLAIN, 24)
        kanaLabel.horizontalAlignment = JLabel.CENTER
        add(kanaLabel, BorderLayout.NORTH)
    }
}

class DescriptionPanel : JPanel() {
    val textArea : JTextArea = JTextArea()

    init {
        textArea.foreground = Color.BLACK
        textArea.font = Font("msgothic.ttc", Font.PLAIN, 16)
        textArea.lineWrap = true
        textArea.wrapStyleWord = true
        textArea.isEditable = false

        val scrollPane = JScrollPane(textArea)
        scrollPane.preferredSize = Dimension(400, 200)
        scrollPane.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED

        add(scrollPane)
    }
}