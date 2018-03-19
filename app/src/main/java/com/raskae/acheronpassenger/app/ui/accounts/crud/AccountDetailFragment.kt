package com.raskae.acheronpassenger.app.ui.accounts.crud

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raskae.acheronpassenger.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountDetailFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_detail, container, false)
    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }


}
