package com.example.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogs.model.DogBreed

class ListViewModel: ViewModel() {

    // This will contain the livedata we retrieve from our source
    val dogs = MutableLiveData<List<DogBreed>>()
    // This will notify that there is an error with the retrieval of the data
    // Here we had a Boolean that mean true means error and false means not
    val dogsLoadError = MutableLiveData<Boolean>()
    // This will be that the system is loading and we have no error
    val loading = MutableLiveData<Boolean>()

    // That is the only mehtod that is accessable from outside
    fun refresh() {
        // We will create some random mocked data locally for now
        val dog1 = DogBreed("1", "Ronaldo", "15 years", "breadGroup", "bredFor", "temperament", "")
        val dog2 = DogBreed("2", "Messi", "20 years", "breadGroup", "bredFor", "temperament", "")
        val dog3 = DogBreed("3", "Cristiano", "25 years", "breadGroup", "bredFor", "temperament", "")
        // add data to list
        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)
        // pass the information to mutablelivedata
        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false
        // Then go to the place you want to show that
    }
}