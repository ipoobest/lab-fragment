package com.hoikhong.fragmentlab

import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.hoikhong.fragmentlab.fragment.MainFragment
import com.hoikhong.fragmentlab.fragment.SecondFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
//        actionBar!!.title = "Fragment"


        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                    .add(R.id.content_container, MainFragment.newInstance(5), "MainFragment")
                    .commit()
        val fragment = SecondFragment.newInstance()
        supportFragmentManager.beginTransaction()
                .add(R.id.content_container, SecondFragment.newInstance(), "SecondFragment")
                .detach(fragment)
                .commit()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        var inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.setting -> {


                supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.from_right, R.anim.to_left
                                , R.anim.from_left, R.anim.to_right)
                        .replace(R.id.content_container, SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit()




                Toast.makeText(this@MainActivity, "setting", Toast.LENGTH_SHORT).show()
            }
            R.id.action_first_tab -> {
                val mainFragment = supportFragmentManager.findFragmentByTag("MainFragment") as MainFragment
                val secondFragment = supportFragmentManager.findFragmentByTag("SecondFragment") as SecondFragment

                supportFragmentManager.beginTransaction()
                        .attach(mainFragment)
                        .detach(secondFragment)
                        .commit()
                return true

            }
            R.id.action_second_tab -> {
                val mainFragment = supportFragmentManager.findFragmentByTag("MainFragment") as MainFragment
                val secondFragment = supportFragmentManager.findFragmentByTag("SecondFragment") as SecondFragment

                supportFragmentManager.beginTransaction()
                        .attach(secondFragment)
                        .detach(mainFragment)
                        .commit()
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }

    // Run after onCreate
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val mainFragment: MainFragment = supportFragmentManager.findFragmentByTag("MainFragment") as MainFragment
            mainFragment.setHelloText("Hi main fragment")
        }
    }
}

