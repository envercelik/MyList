package com.envercelik.mylist.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.envercelik.mylist.R
import com.envercelik.mylist.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)


        //recycler view
        val adapter = ListAdapter()
        val recyclerView = view.recycler_view_user
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //view model
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.getAllUser.observe(viewLifecycleOwner, Observer {user ->
            adapter.setData(user)
        })



        view.fab_add_user.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }


        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.delete_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete) {
            deleteAllUser()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun deleteAllUser() {
        val builder = AlertDialog.Builder(requireContext())

        builder.setPositiveButton("yes") {_,_ ->
            mUserViewModel.deleteAllUser()
            Toast.makeText(requireContext(),"All user successfully removed",
                Toast.LENGTH_LONG).show()
        }

        builder.setNegativeButton("no") {_,_ ->}

        builder.setTitle("Delete All user ?")
        builder.setMessage("Are you sure you want to delete all user")
        builder.create().show()

    }





}