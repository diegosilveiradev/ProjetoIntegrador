package br.bruno.projetointegrador.favorites.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import br.bruno.projetointegrador.R
import br.bruno.projetointegrador.favorites.data.FavMovie
import br.bruno.projetointegrador.favorites.viewModel.FavViewModels
import br.bruno.projetointegrador.utils.Success


class FavoritesFragment : Fragment(R.layout.favoritos_fragments) {

    private val viewModel: FavViewModels by viewModels()
    private val adapter: FavMovieAdapter by lazy {
        FavMovieAdapter(::onDeleteClicked)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchMovies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView(view)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.favMovie.observe(viewLifecycleOwner) {
            when (it) {
                is Success -> {
                    adapter.updateData(it.data)
                }
                else -> showError()
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
    }

    private fun setView(view: View) {
        view.findViewById<RecyclerView>(R.id.favoritos_Rv).adapter = adapter
    }

    private fun onDeleteClicked(favMovie: FavMovie) {
        viewModel.deleteMovie(favMovie)

    }
}