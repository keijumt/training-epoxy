package keijumt.epoxy

import android.content.Context
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController


class SimpleController(
    private val context: Context
) : EpoxyController() {

    private val headers = mutableListOf<String>()
    private val carousel1 = mutableListOf<String>()
    private val carousel2 = mutableListOf<String>()
    private var gridCount = 0

    override fun buildModels() {

        ItemHeaderBindingModel_()
            .title(headers[0])
            .spanSizeOverride { _, _, _ -> 2 }
            .id(modelCountBuiltSoFar)
            .addTo(this)

        CarouselModel_()
            .id("carousel1")
            .spanSizeOverride { _, _, _ -> 2 }
            .models(
                carousel1.map {
                    ItemCarousel1BindingModel_()
                        .title(it)
                        .id(modelCountBuiltSoFar)
                }
            )
            .addTo(this)

        ItemHeaderBindingModel_()
            .title(headers[1])
            .id(modelCountBuiltSoFar)
            .addTo(this)

        CarouselModel_()
            .id("carousel2")
            .spanSizeOverride { _, _, _ -> 2 }
            .models(
                carousel2.map {
                    ItemCarousel2BindingModel_()
                        .title(it)
                        .id(modelCountBuiltSoFar)
                }
            )
            .addTo(this)

        ItemHeaderBindingModel_()
            .spanSizeOverride { _, _, _ -> 2 }
            .title(headers[2])
            .id(modelCountBuiltSoFar)
            .addTo(this)

        repeat(gridCount) {
            ItemGridBindingModel_()
                .id(modelCountBuiltSoFar)
                .spanSizeOverride { _, _, _ -> 1 }
                .addTo(this)
        }
    }

    fun update(headers: List<String>, carousel1: List<String>, carousel2: List<String>, gridCount: Int) {
        this.headers.clear()
        this.headers.addAll(headers)

        this.carousel1.clear()
        this.carousel1.addAll(carousel1)

        this.carousel2.clear()
        this.carousel2.addAll(carousel2)

        this.gridCount = gridCount

        requestModelBuild()
    }
}

private fun convertDpToPx(dp: Float, context: Context): Float {
    val metrics = context.resources.displayMetrics
    return dp * metrics.density
}