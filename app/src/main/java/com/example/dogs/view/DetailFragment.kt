package com.example.dogs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

import com.example.dogs.R
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private var dogUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // This means we will only run this if arguments is not null
        // That is the way we retrieve the argument that was passed
        arguments?.let {
            dogUuid = DetailFragmentArgs.fromBundle(it).dogUuid
        //    textView2.text = dogUuid.toString()
        }
//        buttonList.setOnClickListener {
//            // define the action
//            val action : NavDirections = DetailFragmentDirections.actionListFragment()
//            Navigation.findNavController(it).navigate(action)
//        }

    }

}
