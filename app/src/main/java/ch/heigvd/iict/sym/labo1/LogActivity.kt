package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class LogActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(getTag(), "CREATE")
    }

    override fun onStart() {
        super.onStart()
        Log.v(getTag(), "START")
    }

    override fun onResume() {
        super.onResume()
        Log.v(getTag(), "RESUME")
    }

    override fun onPause() {
        super.onPause()
        Log.v(getTag(), "PAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.v(getTag(), "STOP")
    }

    abstract fun getTag(): String
}