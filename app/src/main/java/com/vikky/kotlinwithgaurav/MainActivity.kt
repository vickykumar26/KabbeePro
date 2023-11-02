package com.vikky.kotlinwithgaurav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.vikky.kotlinwithgaurav.databinding.ActivityMainBinding
import com.vikky.kotlinwithgaurav.fragments.SignInFragment
import com.vikky.kotlinwithgaurav.fragments.SignUpFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Add tabs and their click listeners
        binding.tabLayout.addTab(
            binding.tabLayout.newTab().setText("Sign In")
        )
        binding.tabLayout.addTab(
            binding.tabLayout.newTab().setText("Sign Up")
        )

        binding.tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Replace the content fragment when a tab is selected
                when (tab?.position) {
                    0 -> replaceFragment(SignInFragment())
                    1 -> replaceFragment(SignUpFragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // Initially, replace the content with the first fragment
        replaceFragment(SignInFragment())

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.tabContentContainer, fragment)
        transaction.commit()
    }
}
