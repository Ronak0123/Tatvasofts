package com.ronak.gopani.view.ui.homeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ronak.gopani.PrcticalApp
import com.ronak.gopani.databinding.FragmentListBinding
import com.ronak.gopani.view.adapter.RListAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.longToast

class RListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentListBinding
    private lateinit var adapter: RListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@RListFragment).get(RListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

        viewDataBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = RListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            repo_list_rv.adapter = adapter
        }
    }
}
