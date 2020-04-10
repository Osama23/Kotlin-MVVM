package com.example.dogs.view

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.dogs.R
import com.example.dogs.model.DogBreed
import com.example.dogs.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    // here we pass empty arraylist to the adopter
    private var dogsListAdapter = DogsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // instiniate the viewmode
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        // instiniate our list
        // dogsList is the id of Recyclerview in our layout
        dogsList.apply {
            // we can use GridLayoutManager
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }
        // This will use the variables we created in the viewmodel to update the layout
        observeViewModel()
    }

    fun observeViewModel(){
        // this will give us a list of dogs
        viewModel.dogs.observe(this, Observer { dogs :List<DogBreed> ->
            dogs?.let {
                // dogsList is the id of recyclerview in layout
                dogsList.visibility = View.VISIBLE
                dogsListAdapter.updateDogList(dogs)
            }
        })

        viewModel.dogsLoadError.observe(this, Observer { isError :Boolean ->
            isError?.let {
                listError.visibility = if(it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(this, Observer { isLoading :Boolean ->
            isLoading?.let {
                loadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it){
                    listError.visibility = View.GONE
                    dogsList.visibility = View.GONE
                }
            }
        })
    }

//    // This method is called once the view has been created and we have our elements avialable
//    // Since we want to attach some actions to the elements, we want to make sure that the elements have been created
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        buttonDetail.setOnClickListener {
////            // define the action
////            val action : ListFragmentDirections.ActionDetailFragment = ListFragmentDirections.actionDetailFragment()
////            // To use your args
////            action.dogUuid = 5
////            Navigation.findNavController(it).navigate(action)
////        }
//
//    }

}
