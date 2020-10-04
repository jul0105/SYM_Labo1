package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : Auth() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun validate(emailInput: String, passwordInput: String) {
        Toast.makeText(applicationContext, "Successful registration", Toast.LENGTH_SHORT).show()
        val returnIntent: Intent = Intent()
        returnIntent.putExtra("email", emailInput)
        returnIntent.putExtra("password", passwordInput)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    companion object {
        private const val TAG: String = "RegisterActivity"
        private const val LAYOUT = R.layout.activity_register
    }

    override fun getTag(): String {
        return TAG
    }

    override fun getLayout(): Int {
        return LAYOUT
    }
}