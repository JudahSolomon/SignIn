package com.anushka.navdemo5


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.register.R
import com.example.register.databinding.FragmentNameBinding
import com.google.android.material.snackbar.Snackbar




/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        binding.nextButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.nameEditText.text.toString())) {
                // using bundle to get the name entered and pass it to the next fragment
                val nameText = bundleOf("user_Name" to binding.nameEditText.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, nameText)

            }
            else{
                val snackBar = Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "please enter Name", Snackbar.LENGTH_LONG
                )
                snackBar.show()
            }
        }





        return binding.root
    }
}
