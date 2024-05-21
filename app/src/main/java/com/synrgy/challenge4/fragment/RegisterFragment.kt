package com.synrgy.challenge4.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.synrgy.challenge4.R
import com.synrgy.challenge4.database.AppDatabase
import com.synrgy.challenge4.database.UserDao
import com.synrgy.challenge4.repository.UserRepository
import com.synrgy.challenge4.viewmodel.AuthViewModel
import com.synrgy.challenge4.viewmodel.AuthViewModelFactory
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        // Initialize database and repository
        val database = AppDatabase.getInstance(requireContext())
        val userDao = database.userDao()
        val userRepository = UserRepository(userDao)
        val factory = AuthViewModelFactory(userRepository)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        view.findViewById<Button>(R.id.btn_register).setOnClickListener {
            val email = view.findViewById<EditText>(R.id.et_email).text.toString()
            val username = view.findViewById<EditText>(R.id.et_name).text.toString()
            val password = view.findViewById<EditText>(R.id.et_password).text.toString()

            if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                try {
                    viewModel.register(email, username, password)
                    findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "Registration failed. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }
}
