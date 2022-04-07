package com.digel.permissionbinarchap5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("ON ActivityCreated", "is Fragment ActivityCreated")
        Toast.makeText(context, "this Fragment ActivityCreated", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.i("ON START", "is Fragment Start")
        Toast.makeText(context, "this Fragment Start", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("ON RESUME", " is Fragment Resume")
        Toast.makeText(requireContext(), "this Fragment Resume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("ON PAUSE", " is Fragment Pause")
        Toast.makeText(context, "this Fragment Pause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("ON STOP", "is Fragment Stop")
        Toast.makeText(context, "this Fragment Stop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ON DESTROY", "is Fragment Destroy")
        Toast.makeText(context, "this Fragment Destroy", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("ON DESTROY View", "is Fragment Destroy View")
        Toast.makeText(context, "this Fragment Destroy View", Toast.LENGTH_SHORT).show()
    }

}