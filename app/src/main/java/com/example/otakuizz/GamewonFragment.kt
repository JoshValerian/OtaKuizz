package com.example.otakuizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.otakuizz.databinding.FragmentGameOverBinding
import com.example.otakuizz.databinding.FragmentGamewonBinding

class GamewonFragment : Fragment() {

    private val args : GamewonFragmentArgs by navArgs()

    private var _binding: FragmentGamewonBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGamewonBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        binding.tvRatingWon.setText(getString(R.string.rating,args.numRight,args.numQuest))

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_gamewonFragment_to_gameFragment)
        }

        return binding.root
    }

}