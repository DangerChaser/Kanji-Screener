import net.kanjitomo.OCRResults
import java.awt.*
import javax.swing.*
import javax.swing.border.Border

class View() {

    private val frame : JFrame = JFrame("Kanji Screener")

    val kanjiPanel : KanjiPanel = KanjiPanel()
    val descriptionPanel : DescriptionPanel = DescriptionPanel()

    init {
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Dimension(420, 310)
        frame.isResizable = false
        frame.isAlwaysOnTop = true
        frame.iconImage = ImageIcon("icon.png").image
        frame.layout = BorderLayout()

        frame.contentPane.background = Color.DARK_GRAY

        kanjiPanel.preferredSize = Dimension(300, 100)
        descriptionPanel.preferredSize = Dimension(300, 180)

        frame.add(kanjiPanel, BorderLayout.PAGE_START)
        frame.add(descriptionPanel, BorderLayout.CENTER)

        frame.isVisible = true
    }
}

class KanjiPanel : JPanel() {
    private val kanjiLabel : JLabel = JLabel()
    private val kanaLabel : JLabel = JLabel()

    init {
        layout = GridLayout(2, 1)

        kanjiLabel.foreground = Color.BLACK
        kanjiLabel.font = Font("msgothic.ttc", Font.PLAIN, 42)
        kanjiLabel.horizontalAlignment = JLabel.CENTER
        add(kanjiLabel)

        kanaLabel.foreground = Color.BLACK
        kanaLabel.font = Font("msgothic.ttc", Font.PLAIN, 24)
        kanaLabel.horizontalAlignment = JLabel.CENTER
        add(kanaLabel)
    }

    fun setText(kanji : String, kana : String) {
        kanjiLabel.text = kanji
        kanaLabel.text = kana
    }
}

class DescriptionPanel : JPanel() {
    private val textArea : JTextArea = JTextArea()

    init {
        textArea.foreground = Color.BLACK
        textArea.font = Font("msgothic.ttc", Font.PLAIN, 16)
        textArea.lineWrap = true
        textArea.wrapStyleWord = true
        textArea.isEditable = false

        val scrollPane = JScrollPane(textArea)
        scrollPane.preferredSize = Dimension(400, 164)
        scrollPane.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED

        add(scrollPane)
    }

    fun setText(text : String) {
        textArea.text = text
    }
}