package com.chrisfajardo.fixjob.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chrisfajardo.fixjob.data.repo.PaintRepo
import com.chrisfajardo.fixjobjob.ui.users.UserPaintScreenActivity

class PaintScreenViewModel:ViewModel() {


    private val repo = PaintRepo()
    fun fetchUserData():LiveData<MutableList<UserPaintScreenActivity>>{
        val  mutableData = MutableLiveData<MutableList<UserPaintScreenActivity>>()
        repo.getUserData(name).observeForever { userList->
            mutableData.value= userList
        }
        return mutableData


    }

    companion object{

        var name= ""

        fun addName(nameInfo:String){

            this.name= nameInfo


        }
    }
}