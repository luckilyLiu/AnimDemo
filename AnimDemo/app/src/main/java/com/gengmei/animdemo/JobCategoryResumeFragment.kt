package com.gengmei.animdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gengmei.animdemo.databinding.FragmentJobCategoryResumeBinding

/**
 * 大类页 完善简历卡片的fragment
 */
class JobCategoryResumeFragment : Fragment() {
    private var mParam1: String? = null
    private var mParam2: String? = null


    private var _binding: FragmentJobCategoryResumeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentJobCategoryResumeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }

        binding.tvResumeTitle.text = "Hello World"
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment JobCategoryResumeFragment.
         */
        fun newInstance(param1: String?, param2: String?): JobCategoryResumeFragment {
            val fragment = JobCategoryResumeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }


}