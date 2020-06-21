package com.fau.labandroidfragsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnFragmentActionsListener, SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_sensor1.setOnClickListener {loadFragment(FirstsensorFragment())}
        btn_sensor2.setOnClickListener {loadFragment(SecondsensorFragment())}
        btn_sensor3.setOnClickListener {loadFragment(ThirdsensorFragment())}
        btn_sensor4.setOnClickListener {loadFragment(ForthsensorFragment())}
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    override fun onClickFragmentButton(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}

    override fun onSensorChanged(event: SensorEvent?) {
        Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show()
        for (i in 0..2) {
            Toast.makeText(this, i, Toast.LENGTH_SHORT).show()
            if (event != null) {
                myLog("Orientación " + i + ": " + event.values.get(i))
            }
        }
    }

    private fun myLog(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

}