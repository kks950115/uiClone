package com.android.uiclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uiclone.databinding.ActivityLocallifeBinding

class LocalLifeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLocallifeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val communityData = mutableListOf<Community>(
            Community("모임이름1",R.drawable.psa),
            Community("모임이름2",R.drawable.psa),
            Community("모임이름3",R.drawable.psa),
            Community("모임이름4",R.drawable.psa),
            Community("모임이름5",R.drawable.psa),
            Community("모임이름6",R.drawable.psa),
            Community("모임이름7",R.drawable.psa),
            Community("모임이름8",R.drawable.psa),
            Community("모임이름9",R.drawable.psa),
            Community("모임이름10",R.drawable.psa),
            Community("모임이름11",R.drawable.psa),
            Community("모임이름12",R.drawable.psa),
            Community("모임이름13",R.drawable.psa)
        )
        val localLifePostData = mutableListOf<LocalLifePost>(
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp,listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
            LocalLifePost("2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35)
        )
        binding.bottomNaviViiew.run{
            setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.navi_home -> {
                        val intent = Intent(applicationContext,HomeActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.navi_localLife -> {
                        val intent = Intent(applicationContext,LocalLifeActivity::class.java)
                        startActivity(intent)
                        //setFragment(fragmentlocalLife)
                    }
                    R.id.navi_myInfo -> {
                        val intent = Intent(applicationContext,MyinfoActivity::class.java)
                        startActivity(intent)
                        //setFragment(fragmentMyinfo)
                    }
                    R.id.navi_chat -> {
                        val intent = Intent(applicationContext,ChatActivity::class.java)
                        startActivity(intent)
                        //Log.d("test","이거 작동하고있냐?")
                        //setFragment(fragmentChat)
                    }
                }
                true
            }
        }
        binding.tvLocalarea.text = intent?.getStringExtra("localarea")
        Toast.makeText(
            this,
            "안녕하세요 ${intent?.getStringExtra("username")}님!!!!!",
            Toast.LENGTH_SHORT
        ).show()

        val communityAdapter = CommunityAdapter(communityData)
        binding.rvGroupList.adapter = communityAdapter
        binding.rvGroupList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val localLifePostAdapter = LocalLifePostAdapter(localLifePostData)
        binding.rvLocalLifePostList.adapter = localLifePostAdapter
        binding.rvLocalLifePostList.layoutManager = LinearLayoutManager(this)


    }
}