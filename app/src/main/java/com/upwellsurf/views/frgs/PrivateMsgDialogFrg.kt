package com.upwellsurf.views.frgs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.upwellsurf.adapters.ChatAdapter
import com.upwellsurf.databinding.FragmentPrivateMsgDialogFrgBinding
import com.upwellsurf.models.ChatMessages

class PrivateMsgDialogFrg : BottomSheetDialogFragment() {
    var listOfMessages = ArrayList<ChatMessages>()

    lateinit var mDataBinding: FragmentPrivateMsgDialogFrgBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mDataBinding =
            FragmentPrivateMsgDialogFrgBinding.inflate(inflater, container, false)

        mDataBinding.btSend.setOnClickListener {
            val msg = mDataBinding.etMessage.text.toString()
            if (msg.isNotEmpty()) {
                listOfMessages.add(ChatMessages(msg))
                mDataBinding.etMessage.text.clear()
                val adapter = ChatAdapter(listOfMessages)

                mDataBinding.recyChatList.layoutManager =
                    androidx.recyclerview.widget.LinearLayoutManager(context)
                mDataBinding.recyChatList.adapter = adapter
            } else {
                Snackbar.make(
                    this.mDataBinding.btSend,
                    "Please enter a message",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

        }
        return mDataBinding.root
    }

    override fun onStart() {
        super.onStart()
        dialog ?: return
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.setLayout(width, height)

    }
}