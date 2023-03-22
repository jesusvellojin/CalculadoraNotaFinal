package com.jesumoreno.notafinal.ui.signup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcularViewModel:ViewModel() {

    val errorBasio1: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val errorBasio2: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val errorBasio3: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val errorBasio4: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val rango1: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val rango2: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val rango3: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val rango4: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val resultado: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val delError: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }


    fun caluclarNota(nota1: String, nota2: String, nota3: String, nota4: String) {

        delError.value = null
        if (nota1.isEmpty()) {
            errorBasio1.value = "La casilla esta vacia"
        } else if (nota2.isEmpty()) {
            errorBasio2.value = "La casilla esta vacia"
        } else if (nota3.isEmpty()) {
            errorBasio3.value = "La casilla esta vacia"
        } else if (nota4.isEmpty()) {
            errorBasio4.value = "La casilla esta vacia"
        } else {
            if ((nota1.toFloat() > 5) or (nota1.toFloat() < 0)) {
                rango1.value = "La nota tiene que estar en el rango de 0 y 5"
            } else if ((nota2.toFloat() > 5) or (nota2.toFloat() < 0)) {
                rango2.value = "La nota tiene que estar en el rango de 0 y 5"
            } else if ((nota3.toFloat() > 5) or (nota3.toFloat() < 0)) {
                rango3.value = "La nota tiene que estar en el rango de 0 y 5"
            } else if ((nota4.toFloat() > 5) or (nota4.toFloat() < 0)) {
                rango4.value = "La nota tiene que estar en el rango de 0 y 5"
            } else {
                resultado.value =
                    ((nota1.toFloat() * 0.6) + (nota2.toFloat() * 0.07) + (nota3.toFloat() * 0.08) + (nota4.toFloat() * 0.25)).toString()

            }


        }

    }

}