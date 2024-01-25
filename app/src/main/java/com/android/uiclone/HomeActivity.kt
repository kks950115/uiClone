package com.android.uiclone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.android.uiclone.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(),ChatDataListener, LocalDataListener {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
//    private val fragmentHome by lazy { HomeFragment()}
//    private val fragmentlocalLife by lazy { LocalLifeFragment()}
//    private val fragmentChat = ChatFragment()
//    private val fragmentMyinfo by lazy { MyinfoFragment()}

    //private val homeFragment by lazy { HomeFragment }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.vp2.apply {
            adapter = ViewPagerAdapter(this@HomeActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNaviViiew.selectedItemId = when (position) {
                        0 -> R.id.navi_home
                        1 -> R.id.navi_localLife
                        2 -> R.id.navi_myNear
                        3 -> R.id.navi_chat
                        4 -> R.id.navi_myInfo
                        else -> R.id.navi_home
                    }
                }
            } )
        }
        //binding.vp2.currentItem=3
        binding.bottomNaviViiew.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navi_localLife -> {
                    Log.d("jess", "1")
                    binding.vp2.currentItem = 1
                }
                R.id.navi_myNear -> {
                    Log.d("jess", "2")
                    binding.vp2.currentItem = 2
                }
                R.id.navi_chat -> {
                    Log.d("jess", "3")
                    binding.vp2.currentItem = 3
                }
                R.id.navi_myInfo -> {
                    Log.d("jess", "4")
                    binding.vp2.currentItem = 4
                }
                else -> {
                    Log.d("jess", "0")
                    binding.vp2.currentItem = 0
                }
            }
            true
        }




    }


    inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount() = 5

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> HomeFragment()
                1 -> LocalLifeFragment()
                2 -> MyNearFragment()
                3 -> ChatFragment()
                4 -> MyinfoFragment()
                else -> HomeFragment()
            }
        }
    }

    override fun onChatDataReceived (data: Bundle) {
        Log.d("test", "data = ${data}")
        val intent = Intent(this,ChatDetailActivity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
    }

    override fun onLocalDataReceived(data: Bundle) {
        Log.d("test", "data = ${data}")
        val intent = Intent(this,LocalDetailActivity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
    }
}


