package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ch.heigvd.iict.sym.labo1.network.ImageDownloader

class content : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        // get the email value
        val email = intent.getStringExtra("email")

        // set it to the text view :))
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = email
        }
        // update the image view with the downloaded image
        val imageView = findViewById<ImageView>(R.id.avatarView).apply {
            ImageDownloader(this, "https://thispersondoesnotexist.com/image").show()
        }



    }
}