package com.example.puydufou.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.puydufou.data.database.AppDatabase
import com.example.puydufou.data.repository.ShowRepository
import com.example.puydufou.databinding.FragmentFavoritesBinding
import com.example.puydufou.ui.shows.adapter.ShowsAdapter

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ShowsAdapter

    private val viewModel: FavoritesViewModel by viewModels {
        FavoritesViewModelFactory(
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
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        // PASA una lista vacía inicialmente
        adapter = ShowsAdapter(emptyList()) { show ->
            // Navegar a detalle
        }

        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.favoritesRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.favorites.observe(viewLifecycleOwner) { favorites ->
            // Crea un NUEVO adapter con la lista de favoritos
            adapter = ShowsAdapter(favorites) { show ->
                // Navegar a detalle
            }
            binding.favoritesRecyclerView.adapter = adapter

            if (favorites.isEmpty()) {
                binding.emptyText.visibility = View.VISIBLE
                binding.favoritesRecyclerView.visibility = View.GONE
            } else {
                binding.emptyText.visibility = View.GONE
                binding.favoritesRecyclerView.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}