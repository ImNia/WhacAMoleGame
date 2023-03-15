package com.delirium.whacamole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView

class Game : AppCompatActivity() {
    var score = 0
    lateinit var firstHole: ImageView
    lateinit var secondHole: ImageView
    lateinit var thirdHole: ImageView
    lateinit var fourthHole: ImageView
    lateinit var fifthHole: ImageView
    lateinit var sixthHole: ImageView
    lateinit var seventhHole: ImageView
    lateinit var eighthHole: ImageView
    lateinit var ninthHole: ImageView
    lateinit var countView: TextView
    lateinit var timerView: TextView

    private val listMole = mutableListOf<Mole>()
    private val queue = mutableListOf<Pair<Long, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        firstHole = findViewById(R.id.first)
        secondHole = findViewById(R.id.second)
        thirdHole = findViewById(R.id.third)
        fourthHole = findViewById(R.id.fourth)
        fifthHole = findViewById(R.id.fifth)
        sixthHole = findViewById(R.id.sixth)
        seventhHole = findViewById(R.id.seventh)
        eighthHole = findViewById(R.id.eighth)
        ninthHole = findViewById(R.id.ninth)
        countView = findViewById(R.id.score)
        timerView = findViewById(R.id.timer)

        initMoles()
        firstHole.setOnClickListener {
            if (listMole[0].isVisible) {
                score++
                listMole[0].isVisible = !listMole[0].isVisible
                drawMoles()
            }
        }
        secondHole.setOnClickListener {
            if (listMole[1].isVisible) {
                score++
                listMole[1].isVisible = !listMole[1].isVisible
                drawMoles()
            }
        }
        thirdHole.setOnClickListener {
            if (listMole[2].isVisible) {
                score++
                listMole[2].isVisible = !listMole[2].isVisible
                drawMoles()
            }
        }
        fourthHole.setOnClickListener {
            if (listMole[3].isVisible) {
                score++
                listMole[3].isVisible = !listMole[3].isVisible
                drawMoles()
            }
        }
        fifthHole.setOnClickListener {
            if (listMole[4].isVisible) {
                score++
                listMole[4].isVisible = !listMole[4].isVisible
                drawMoles()
            }
        }
        sixthHole.setOnClickListener {
            if (listMole[5].isVisible) {
                score++
                listMole[5].isVisible = !listMole[5].isVisible
                drawMoles()
            }
        }
        seventhHole.setOnClickListener {
            if (listMole[6].isVisible) {
                score++
                listMole[6].isVisible = false
                drawMoles()
            }
        }
        eighthHole.setOnClickListener {
            if (listMole[7].isVisible){
                score++
                listMole[7].isVisible = false
                drawMoles()
            }
        }
        ninthHole.setOnClickListener {
            if (listMole[8].isVisible){
                score++
                listMole[8].isVisible = false
                drawMoles()
            }
        }

        object : CountDownTimer(30000, 1000) {
            override fun onFinish() {
                finish()
            }

            override fun onTick(p0: Long) {
                val curTime = (p0 / 1000).toInt()
                timerView.text = curTime.toString()
                if (queue.isNotEmpty()) {
                    if (queue.first().first - p0 > 500) {
                        listMole[queue.first().second].isVisible = false
                        drawMoles()
                        queue.removeFirst()
                    }
                }

                val rand = (1..9).random()
                if ((0..10).random() % 2 == 0) {
                    if (!listMole[rand - 1].isVisible) {
                        listMole[rand - 1].isVisible = true
                        drawMoles()
                        queue.add(Pair(p0, rand - 1))
                    }
                }
            }
        }.start()
    }

    private fun drawMoles() {
        for (item in listMole) {
            if (item.isVisible) {
                getViewHole(item.index).setImageDrawable(getDrawable(R.drawable.mole))
            } else {
                getViewHole(item.index).setImageDrawable(getDrawable(R.drawable.hole))
            }
        }
        countView.text = score.toString()
    }

    private fun getViewHole(index: Int) : ImageView {
        return when (index) {
            1 -> {
                firstHole
            }
            2 -> {
                secondHole
            }
            3 -> {
                thirdHole
            }
            4 -> {
                fourthHole
            }
            5 -> {
                fifthHole
            }
            6 -> {
                sixthHole
            }
            7 -> {
                seventhHole
            }
            8 -> {
                eighthHole
            }
            9 -> {
                ninthHole
            }
            else -> {
                throw java.lang.IllegalArgumentException()
            }
        }
    }


    private fun initMoles() {
        for (index in 1..COUNT_MOLE) {
            listMole.add(Mole(index, false))
        }
    }

    companion object {
        const val COUNT_MOLE = 9
    }
}