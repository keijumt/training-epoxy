package keijumt.epoxy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyController
import kotlinx.android.synthetic.main.activity_epoxy_controller.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_epoxy_controller.setOnClickListener {
            startActivity(Intent(this, EpoxyControllerActivity::class.java))
        }
    }
}
