import net.kanjitomo.KanjiTomo
import java.awt.MouseInfo
import java.io.File
import java.lang.Thread.sleep
import javax.imageio.ImageIO

fun main() {
    val tomo = KanjiTomo()
    tomo.loadData()
    val screenshot = Screenshot()
    val view = View()

    while(true) {
        screenshot.capture()
        val image = ImageIO.read(File("screenshot.jpg"))
        tomo.setTargetImage(image)
        val point = MouseInfo.getPointerInfo().location
        val results = tomo.runOCR(point)
        if (results != null && results.words.size > 0) {
            val word = results.words.get(0)
            view.kanjiPanel.setText(word.kanji, word.kana)
            view.descriptionPanel.setText(word.description)
        }

        sleep(500)
    }
}