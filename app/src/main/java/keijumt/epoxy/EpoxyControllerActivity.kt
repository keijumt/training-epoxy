package keijumt.epoxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.Carousel
import kotlinx.android.synthetic.main.activity_epoxy_controller.*

class EpoxyControllerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy_controller)

        val controller = SimpleController(this)
        recycler_simple.let { recyclerView ->
            recyclerView.adapter = controller.adapter
            recyclerView.layoutManager = GridLayoutManager(this, 2).also {
                it.spanSizeLookup = controller.spanSizeLookup
                it.recycleChildrenOnDetach = true
            }
            recyclerView.setItemSpacingDp(8)
        }

        Carousel.setDefaultGlobalSnapHelperFactory(null)

        controller.update(
            listOf("Header1", "Header1", "Header3"),
            listOf(
                "carousel1",
                "carousel2",
                "carousel3",
                "carousel4",
                "carousel5",
                "carousel7",
                "carousel8"
            ),
            listOf(
                "CAROUSEL1",
                "CAROUSEL2",
                "CAROUSEL3",
                "CAROUSEL4",
                "CAROUSEL5",
                "CAROUSEL7",
                "CAROUSEL8"
            ),
            10
        )
    }
}