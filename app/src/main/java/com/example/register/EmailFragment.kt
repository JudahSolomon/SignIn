package com.anushka.navdemo5


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.register.R
import com.example.register.databinding.FragmentEmailBinding
import com.google.android.material.snackbar.Snackbar



class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        // getting the name data of the NameFragment here in the name variable
            val name = arguments?.getString("user_Name")

            binding.submitButton.setOnClickListener {
                if (!TextUtils.isEmpty(binding.emailEditText.text.toString())) {

        // saving both the Name and Email data into a different bundle then pass them into the .navigate()
                    val bundle= bundleOf(
                        "user_Email" to binding.emailEditText.text.toString(),
                        "user_Name" to name)
                    it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment,bundle)
                }
                else{
                    val snackBar = Snackbar.make(
                        requireActivity().findViewById(android.R.id.content),
                        "please enter Email", Snackbar.LENGTH_LONG
                    )
                    snackBar.show()
                }

            }












        return binding.root
    }
}
