package com.delirium.whacamole

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ResultFragment : Fragment() {
    lateinit var resultText: TextView
    lateinit var bestResultText: TextView
    lateinit var replayButton: Button
    lateinit var menuButton: Button

    var scoreUser: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        resultText = view.findViewById(R.id.result)
        bestResultText = view.findViewById(R.id.best_result)
        replayButton = view.findViewById(R.id.replay_button)
        menuButton = view.findViewById(R.id.menu_button)

        scoreUser = arguments?.getInt("resultScore")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resultText.text = scoreUser.toString()

        replayButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_resultFragment_to_game
            )
        }

        menuButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_resultFragment_to_menuFragment
            )
        }
    }
}