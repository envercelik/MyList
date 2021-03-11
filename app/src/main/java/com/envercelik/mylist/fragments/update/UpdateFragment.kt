package com.envercelik.mylist.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.envercelik.mylist.R
import com.envercelik.mylist.model.User
import com.envercelik.mylist.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var layoutUpdate: View
    private lateinit var mUserViewModel : UserViewModel





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layoutUpdate =  inflater.inflate(R.layout.fragment_update, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        layoutUpdate.edit_text_update_first_name.setText(args.currentUser.firstName)
        layoutUpdate.edit_text_update_last_name.setText(args.currentUser.lastName)
        layoutUpdate.edit_text_update_age.setText(args.currentUser.age.toString())

        layoutUpdate.button_update.setOnClickListener {
            updateUser()
        }


        return layoutUpdate
    }

    private fun updateUser() {
        val firstName = layoutUpdate.edit_text_update_first_name.text.toString()
        val lastName = layoutUpdate.edit_text_update_last_name.text.toString()
        val age = layoutUpdate.edit_text_update_age.text

        if (inputValidation(firstName,lastName,age)) {
            //create updated user object
            val updatedUser = User(args.currentUser.uid,firstName,lastName,age.toString().toInt())
            //update current user
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(),"Updated successfully",Toast.LENGTH_LONG).show()
            //navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
        }


    }


    private fun inputValidation(firstName:String, lastName:String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}