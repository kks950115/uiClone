package com.android.uiclone

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uiclone.databinding.FragmentChatBinding
import com.android.uiclone.databinding.FragmentLocalLifeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val LOCAL_LIFE_KEY = "local_life_key"
private const val COMUNITY_KEY = "comunity_key"

interface LocalDataListener {
    fun onLocalDataReceived(data: Bundle)
}

class LocalLifeFragment : Fragment(R.layout.fragment_local_life) {
    // TODO: Rename and change types of parameters
    private var localLifePostData : LocalLifePost? = null
    private var community : Community? = null
    private var _binding: FragmentLocalLifeBinding? =null
    private var listener: LocalDataListener? = null
    private  val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            localLifePostData = it.getParcelable(LOCAL_LIFE_KEY,LocalLifePost::class.java)
            community = it.getParcelable(COMUNITY_KEY,Community::class.java)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is LocalDataListener){
            listener = context
        }else{
            throw RuntimeException("$context must implement ChatDataListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocalLifeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val communityAdapter = CommunityAdapter(Data.communityData)
        binding.rvGroupList.adapter = communityAdapter
        binding.rvGroupList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val localLifePostAdapter = LocalLifePostAdapter(Data.localLifePostData)
        binding.rvLocalLifePostList.adapter = localLifePostAdapter
        binding.rvLocalLifePostList.layoutManager = LinearLayoutManager(context)

        localLifePostAdapter.itemClick = object : LocalLifePostAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val bundle = Bundle()
                val localDetail = Data.localLifePostData[position]
                val commentLog = Data.localDetailCommentData[position]
                bundle.putParcelable("localDetail",localDetail)
                bundle.putParcelableArrayList("ccommentLog",commentLog)
                bundle.putInt("itemIndex", position)
                listener?.onLocalDataReceived(bundle)
                Log.d("test","클릭됨")
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Binding 객체 해제
        _binding = null
        listener = null
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LocalLifeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocalLifeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}