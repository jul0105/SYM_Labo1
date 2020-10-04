package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.content.Intent
import android.widget.Toast

class RegisterActivity : Auth() {

    // Validation du l'inscription
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

    // Récupère le tag companion
    override fun getTag(): String {
        return TAG
    }

    // Récupère le layout du companion
    override fun getLayout(): Int {
        return LAYOUT
    }
}