package com.jesumoreno.notafinal.ui.signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jesumoreno.notafinal.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpBinding: ActivitySignUpBinding
    private lateinit var calcularViewModel: CalcularViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        calcularViewModel = ViewModelProvider(this)[CalcularViewModel::class.java]

        val view = signUpBinding.root
        setContentView(view)

        val erroBasio1Observer = Observer<String?> { erroBasio1 ->
            signUpBinding.nota60Layout.error = erroBasio1

        }
        val erroBasio2Observer = Observer<String?> { erroBasio2 ->
            signUpBinding.nota7Layout.error = erroBasio2

        }
        val erroBasio3Observer = Observer<String?> { erroBasio3 ->
            signUpBinding.nota8Layout.error = erroBasio3

        }
        val erroBasio4Observer = Observer<String?> { erroBasio4 ->
            signUpBinding.nota25Layout.error = erroBasio4

        }
        val rango1Observer = Observer<String?> { rango ->
            signUpBinding.nota60Layout.error = rango

        }
        val rango2Observer = Observer<String?> { rango ->
            signUpBinding.nota7Layout.error = rango

        }
        val rango3Observer = Observer<String?> { rango ->
            signUpBinding.nota8Layout.error = rango

        }
        val rango4Observer = Observer<String?> { rango ->
            signUpBinding.nota25Layout.error = rango

        }
        val resultadoObserver = Observer<String?> { resultado ->
            signUpBinding.resultadoTextView.setText("NOTA FINAL: $resultado")

        }
        val delErrorObserver = Observer<String?> { resultado ->
            signUpBinding.nota60Layout.error = resultado
            signUpBinding.nota7Layout.error = resultado
            signUpBinding.nota8Layout.error = resultado
            signUpBinding.nota25Layout.error = resultado
            signUpBinding.resultadoTextView.setText(resultado)
        }

        calcularViewModel.errorBasio1.observe(this, erroBasio1Observer)
        calcularViewModel.errorBasio2.observe(this, erroBasio2Observer)
        calcularViewModel.errorBasio3.observe(this, erroBasio3Observer)
        calcularViewModel.errorBasio4.observe(this, erroBasio4Observer)
        calcularViewModel.rango1.observe(this, rango1Observer)
        calcularViewModel.rango2.observe(this, rango2Observer)
        calcularViewModel.rango3.observe(this, rango3Observer)
        calcularViewModel.rango4.observe(this, rango4Observer)
        calcularViewModel.resultado.observe(this, resultadoObserver)
        calcularViewModel.delError.observe(this, delErrorObserver)




        signUpBinding.registerButton.setOnClickListener {
            signUpBinding.editNota25.clearFocus()
            val nota1 = signUpBinding.editNota60.text.toString()
            val nota2 = signUpBinding.editNota7.text.toString()
            val nota3 = signUpBinding.editNota8.text.toString()
            val nota4 = signUpBinding.editNota25.text.toString()
            calcularViewModel.caluclarNota(nota1, nota2, nota3, nota4)
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(signUpBinding.nota25Layout.windowToken, 0)


        }
    }
}
//fianl