package com.example.logInRabbit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.logInRabbit.databinding.FragmentApiBinding
import com.example.logInRabbit.jsons.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFragment : Fragment(){

    private var _binding: FragmentApiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogIn.setOnClickListener { getRetrofit() }
    }

    private fun getRetrofit() : List<UsersItem> {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(UsersApi::class.java)

        val retrofitData = retrofitBuilder.getUsers()
        var myResponse = mutableListOf<UsersItem>()
        retrofitData.enqueue(object : Callback<List<UsersItem>?> {
            override fun onResponse(
                call: Call<List<UsersItem>?>,
                response: Response<List<UsersItem>?>
            ) {
                myResponse = response.body() as MutableList<UsersItem>
                logIn(myResponse)
            }

            override fun onFailure(call: Call<List<UsersItem>?>, t: Throwable) {
                Toast.makeText(requireContext(), "connection could not be established", Toast.LENGTH_SHORT).show()
            }
        })
        return myResponse
    }

    private fun logIn(myResponse: List<UsersItem>) {
        val user = binding.userName.text.toString()
        val password = binding.userPassword.text.toString()

        var aux = 0
        for(i in myResponse.indices){
            if (user == myResponse[i].id.toString() && password == myResponse[i].username){
                aux = 1
                Toast.makeText(requireContext(), "logged", Toast.LENGTH_SHORT).show()
                val myUser = myResponse[i]
                val bundle = Bundle()
                bundle.putParcelable("user", myUser)
                findNavController().navigate(R.id.action_snakeMainFragment_to_loggedFragmentFragment, bundle)
            }
        }
        if(aux == 0){
            Toast.makeText(requireContext(), "wrong password", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
