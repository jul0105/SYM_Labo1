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

private lateinit var email: EditText
private lateinit var password: EditText
private lateinit var validateButton: Button


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.main_email)
        password = findViewById(R.id.main_password)
        validateButton = findViewById(R.id.main_validate)

        validateButton.setOnClickListener {
            //on réinitialise les messages d'erreur
            email.error = null
            password.error = null

            //on récupère le contenu de deux champs dans des variables de type String
            val emailInput = email.text?.toString()
            val passwordInput = password.text?.toString()

            if (emailInput.isNullOrEmpty() or passwordInput.isNullOrEmpty()) {
                // on affiche un message d'erreur sur les champs qui n'ont pas été renseignés
                // la méthode getString permet de charger un String depuis les ressources de
                // l'application à partir de son id
                if (emailInput.isNullOrEmpty())
                    email.error = getString(R.string.main_mandatory_field)
                if (passwordInput.isNullOrEmpty())
                    password.error = getString(R.string.main_mandatory_field)
                // Pour les fonctions lambda, on doit préciser à quelle fonction l'appel à return
                // doit être appliqué
                return@setOnClickListener
            }

            // Check if email is valid
            if (!emailInput!!.contains("@")) {
                Toast.makeText(applicationContext, "Invalid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(applicationContext, "Successful registration", Toast.LENGTH_SHORT).show()
            /*val intent = Intent(this,MainActivity::class.java).apply {
                putExtra("email",emailInput)
                putExtra("password",passwordInput)
            }*/
            val returnIntent:Intent = Intent()
            returnIntent.putExtra("email",emailInput)
            returnIntent.putExtra("password",passwordInput)
            setResult(Activity.RESULT_OK)
            finish()
        }

    }
}