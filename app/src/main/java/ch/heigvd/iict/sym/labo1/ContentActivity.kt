package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.sym.labo1.network.ImageDownloader
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content2)

        val email = intent.getStringExtra("email")
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = email
        }

        ImageDownloader(findViewById<ImageView>(R.id.avatarView), "https://thispersondoesnotexist.com/image").show()

    }
}