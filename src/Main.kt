import net.kanjitomo.KanjiTomo
import java.awt.MouseInfo
import java.io.File
import java.lang.Thread.sleep
import javax.imageio.ImageIO

fun main() {
    val tomo = KanjiTomo()
    tomo.loadData()
    val screenshot = Screenshot()
    val gui = GUI()

    while(true) {
        screenshot.capture()
        val image = ImageIO.read(File("screenshot.jpg"))
        tomo.setTargetImage(image)
        val point = MouseInfo.getPointerInfo().location
        val results = tomo.runOCR(point)
        if (results != null) {
//            println(results)
            gui.update(results)
        }

        sleep(1000)
    }
}