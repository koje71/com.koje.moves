package com.koje.moves.core

import android.media.AudioAttributes
import android.media.SoundPool
import com.koje.framework.App
import com.koje.framework.utils.BooleanPreference
import com.koje.moves.R


object Sound {

    class Player(id: Int, val trackVolume: Float) {
        val content = soundPool.load(App.context, id, 1)

        fun play() {
            if (enabled.get()) {
                val volume = systemVolume * trackVolume
                soundPool.play(content, volume, volume, 1, 0, 1f)
            }
        }

    }

    var soundAttributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_GAME)
        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        .build()

    val soundPool = SoundPool
        .Builder()
        .setMaxStreams(4)
        .setAudioAttributes(soundAttributes)
        .build()


    // stone_mechanisem_loop_01.wav by Claire.H -- https://freesound.org/s/182345/ -- License: Attribution 3.0
    val cat = Player(R.raw.cat, 0.9f)
//
//    // Can rolling rug by CheChoDj -- https://freesound.org/s/609463/ -- License: Attribution 4.0
//    val rolling02 = Player(R.raw.rolling02, 0.9f)
//
//    // Collect 2 by JustInvoke -- https://freesound.org/s/446134/ -- License: Attribution 4.0
//    val collect = Player(R.raw.collect, 0.9f)
//
//    // Ktoilet seat lift knock slight echo.flac by kyles -- https://freesound.org/s/454231/ -- License: Creative Commons 0
//    val knock = Player(R.raw.knock, 0.5f)
//
//    // Switch.wav by RutgerMuller -- https://freesound.org/s/51166/ -- License: Creative Commons 0
//    val switch = Player(R.raw.switcher, 0.9f)
//
//    // Move.mp3 by AbdrTar -- https://freesound.org/s/558117/ -- License: Creative Commons 0
//    val switch2 = Player(R.raw.switch2, 0.9f)
//
//    // Forcefully knocking over chess piece, with roll FINAL.wav by mht23SD -- https://freesound.org/s/707342/ -- License: Creative Commons 0
//    val knock2 = Player(R.raw.knock2, 0.9f)
//
//    //Success Fanfare Trumpets.mp3 by FunWithSound -- https://freesound.org/s/456966/ -- License: Creative Commons 0
//    val success = Player(R.raw.success, 0.9f)
//
//    // Retro, Coin 02.wav by MATRIXXX_ -- https://freesound.org/s/402288/ -- License: Creative Commons 0
//    val collect04 = Player(R.raw.collect04, 0.2f)
//
//    // Marble Drop by gamer500 -- https://freesound.org/s/682661/ -- License: Creative Commons 0
//    val drop02 = Player(R.raw.drop02, 0.4f)
//
//    // SFX_SIMPLESNAPS_singles_02.wav by MrFossy -- https://freesound.org/s/589134/ -- License: Creative Commons 0
//    val snap02 = Player(R.raw.snap02, 0.5f)
//
//    // Explosion_Debris_Short_Stereo.wav by Nox_Sound -- https://freesound.org/s/560510/ -- License: Creative Commons 0
//    val explode = Player(R.raw.explode, 0.7f)
//
//    // ui sound 1.wav by nezuai -- https://freesound.org/s/577020/ -- License: Attribution 4.0
//    val select = Player(R.raw.select, 0.7f)
//
//    // 5 Knock -101.m4a by WakaProduction2018 -- https://freesound.org/s/437588/ -- License: Creative Commons 0
//    // val start = Player(R.raw.start02, 0.4f)
//
//    // Plastic_Bottle_Air_Press.wav by tokeno -- https://freesound.org/s/565155/ -- License: Attribution 4.0
//    val falling = Player(R.raw.falling, 0.7f)
//
//    //Fanfare 3 - Rpg by colorsCrimsonTears -- https://freesound.org/s/607407/ -- License: Creative Commons 0
//    val fanfare = Player(R.raw.fanfare, 0.5f)
//
//    //Devastating Laser Blasts by SamsterBirdies -- https://freesound.org/s/731984/ -- License: Creative Commons 0
//    val transport = Player(R.raw.transport, 0.2f)
//
//    val silent = Player(R.raw.silent, 0.9f)

    var systemVolume = 1f

    val enabled = BooleanPreference("sound", true)
}