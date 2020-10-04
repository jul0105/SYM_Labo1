package ch.heigvd.iict.sym.labo1

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : Auth() {

    // on définit une liste de couples e-mail / mot de passe
    // ceci est fait juste pour simplifier ce premier laboratoire,
    // mais il est évident que de hardcoder ceux-ci est une pratique à éviter à tout prix...
    private var credentials = listOf(
                                Pair("user1@heig-vd.ch","1234"),
                                Pair("user2@heig-vd.ch","abcd")
                            )

    // le modifieur lateinit permet de définir des variables avec un type non-null
    // sans pour autant les initialiser immédiatement
    private lateinit var cancelButton: Button
    private lateinit var newAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // on va maintenant lier le code avec les éléments graphiques (champs texts, boutons, etc.)
        // présents dans le layout (nous allons utiliser l'id défini dans le layout, le cast est
        // réalisé automatiquement)
        cancelButton = findViewById(R.id.main_cancel)
        newAccount = findViewById(R.id.main_new_account)

        // Kotlin, au travers des Android Kotlin Extensions permet d'automatiser encore plus cette
        // étape en créant automatiquement les variables pour tous les éléments graphiques présents
        // dans le layout et disposant d'un id
        // cf. https://medium.com/@temidjoy/findviewbyid-vs-android-kotlin-extensions-7db3c6cc1d0a

        //mise en place des événements
        cancelButton.setOnClickListener {
            //on va vider les champs de la page de login lors du clique sur le bouton Cancel
            email.text?.clear()
            password.text?.clear()
            // on annule les éventuels messages d'erreur présents sur les champs de saisie
            email.error = null
            password.error = null
        }

        newAccount.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivityForResult(intent,REGISTER_ACTIVITY)
        }
    }

    // Validation du login
    override fun validate(emailInput: String, passwordInput: String) {
        // Vérifie si la pair e-mail/mot de passe est valide
        if (!credentials.contains(Pair(emailInput, passwordInput))) {
            AlertDialog.Builder(this).setMessage(getString(R.string.pass_wrong)).create().show()
            return
        } else {
            // Bascule vers l'activité "Content"
            Toast.makeText(applicationContext, getString(R.string.login_sucess), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ContentActivity::class.java).apply {
                putExtra("email", emailInput)
            }
            startActivity(intent)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent? ) {
        super.onActivityResult(requestCode, resultCode, data)

        // Création d'un nouveau utilisateur depuis l'activité "Register"
        if(requestCode == REGISTER_ACTIVITY) {
            if (resultCode == RESULT_OK && data != null) {

                val email: String = data.getStringExtra("email").toString()
                val password: String = data.getStringExtra("password").toString()

                credentials = credentials + Pair(email, password)
            }
        }
    }


    // En Kotlin, les variables static ne sont pas tout à fait comme en Java
    // pour des raison de lisibilité du code, les variables et méthodes static
    // d'une classe doivent être regroupées dans un bloc à part: le companion object
    // cela permet d'avoir un aperçu plus rapide de tous les éléments static d'une classe
    // sans devoir trouver le modifieur dans la définition de ceux-ci, qui peuvent être mélangé
    // avec les autres éléments non-static de la classe
    companion object {
        private const val TAG: String = "MainActivity"
        private const val REGISTER_ACTIVITY = 1
        private const val LAYOUT = R.layout.activity_main
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
