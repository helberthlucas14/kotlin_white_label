package com.example.kotlin_white_label.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_white_label.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductsViewModel by viewModels()

    private val productsAdapter = ProductsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        observeVMEvents()

        viewModel.getProducts()
    }


    private fun observeVMEvents() {
        viewModel.productsData.observe(viewLifecycleOwner) { products ->
            productsAdapter.submitList(products)
        }
    }


    private fun setRecyclerView() {
        binding.recyclerProducts.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(
                this@ProductsFragment.requireContext(),
                2
            )
            adapter = productsAdapter
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}