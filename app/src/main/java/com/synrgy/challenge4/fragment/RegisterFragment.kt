package com.synrgy.challenge4.fragment

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.synrgy.challenge4.R
import com.synrgy.challenge4.fragment.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View?) {
        // Implement your click handling logic here
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        // Implement your focus change handling logic here
    }

    override fun onKey(view: View?, keyCode: Int, event: KeyEvent?): Boolean {
        // Implement your key handling logic here
        return false
    }
}
