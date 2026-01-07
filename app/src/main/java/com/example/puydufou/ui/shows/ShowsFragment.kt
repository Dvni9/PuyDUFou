package com.example.puydufou.ui.shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.puydufou.data.database.AppDatabase
import com.example.puydufou.data.repository.ShowRepository
import com.example.puydufou.databinding.FragmentShowsBinding
import com.example.puydufou.ui.shows.adapter.ShowsAdapter
import kotlinx.coroutines.launch

class ShowsFragment : Fragment() {

    private var _binding: FragmentShowsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ShowsAdapter

    private val viewModel: ShowsViewModel by viewModels {
        ShowsViewModelFactory(
            ShowRepository(
                AppDatabase.getDatabase(requireContext()).showDao()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        initializeData()
    }

    private fun setupRecyclerView() {
        // PASA una lista vacía inicialmente
        adapter = ShowsAdapter(emptyList()) { show ->
            // Aquí iría la navegación al detalle
        }

        binding.showsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.showsRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.shows.observe(viewLifecycleOwner) { shows ->
            // Crea un NUEVO adapter con la lista de shows
            adapter = ShowsAdapter(shows) { show ->
                // Navegación al detalle
            }
            binding.showsRecyclerView.adapter = adapter
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun initializeData() {
        lifecycleScope.launch {
            viewModel.initializeData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}