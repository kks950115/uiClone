package com.android.uiclone

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uiclone.databinding.FragmentChatBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val CHAT_KEY = "chat_key"

interface ChatDataListener {
    fun onChatDataReceived(data: Bundle)
}
class ChatFragment : Fragment(R.layout.fragment_chat) {

    private var chatyResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }
    private var chat :Chat? = null
    private var _binding:FragmentChatBinding? =null
    private val binding get() = _binding!!
    private var listener: ChatDataListener? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            chat = it.getParcelable(CHAT_KEY,Chat::class.java)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is ChatDataListener){
            listener = context
        }else{
            throw RuntimeException("$context must implement ChatDataListener")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentChatBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivQrcode.setOnClickListener {
            startQrcodeScan()
        }

        val adapter = ChatAdapter(Data.chatData)
        binding.rvChatList.adapter = adapter
        binding.rvChatList.layoutManager = LinearLayoutManager(context)

        adapter.itemClick = object : ChatAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val bundle = Bundle()
                val chatDetail = Data.chatDetail[position]
                val chatLog = Data.chatLogs[position]
                bundle.putParcelable("chatDetail",chatDetail)
                bundle.putParcelableArrayList("chatLog",chatLog)
                bundle.putInt("itemIndex", position)
                listener?.onChatDataReceived(bundle)
                //Log.d("test","클릭 확인 ,${position}, ${chatDetail} ,${chatLog}")
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
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun startQrcodeScan(){
//        val integrator = IntentIntegrator(this)
//        with(integrator) {
//            setBeepEnabled(false)
//            initiateScan()

    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (resultCode == Activity.RESULT_OK) {
//            val scanRes = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//            val content = scanRes.contents
//
//            Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(context,"QR코드 인식에 실패했습니다.", Toast.LENGTH_SHORT).show()
//        }
//    }
}