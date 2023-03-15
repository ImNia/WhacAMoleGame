package com.delirium.whacamole

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import io.realm.Realm

class MenuFragment : Fragment() {

    private val configDB: RealmConfiguration = RealmConfiguration()
    val realmDB: Realm = Realm.getInstance(configDB.getConfigDB())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val button = view.findViewById<Button>(R.id.play_button)
        val bestResultTextView = view.findViewById<TextView>(R.id.best_result_menu)

        val best = getBestResult()
        best?.let {
            bestResultTextView.text = it.toString()
        }

        button.setOnClickListener {
            findNavController().navigate(
                R.id.action_menuFragment_to_game
            )
        }
        return view
    }

    private fun getBestResult() : Int? {
        var bestResult: DataDB? = null
        realmDB.beginTransaction()
        bestResult = realmDB.where(DataDB::class.java).findFirst()
        realmDB.commitTransaction()

        return bestResult?.result
    }
}