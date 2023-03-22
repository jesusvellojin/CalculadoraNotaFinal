package com.jesumoreno.notafinal.ui.signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.jesumoreno.notafinal.R
import com.jesumoreno.notafinal.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private  lateinit var signUpBinding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)

            fun View.hidekeyboard(){
                val inm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inm.hideSoftInputFromWindow(windowToken,0)
            }


            signUpBinding.registerButton.setOnClickListener {
            val nota1 = signUpBinding.editNota60.text.toString()
            val nota2 = signUpBinding.editNota7.text.toString()
            val nota3 = signUpBinding.editNota8.text.toString()
            val nota4 = signUpBinding.editNota25.text.toString()

            signUpBinding.nota60Layout.error=null
            signUpBinding.nota7Layout.error=null
            signUpBinding.nota8Layout.error=null
            signUpBinding.nota25Layout.error=null
            signUpBinding.resultadoTextView.setText(null)


            if (nota1.isEmpty())
                signUpBinding.nota60Layout.error="La casilla esta vacia"

            else if (nota2.isEmpty())
                signUpBinding.nota7Layout.error="La casilla esta vacia"

            else if (nota3.isEmpty())
                signUpBinding.nota8Layout.error="La casilla esta vacia"

            else if (nota4.isEmpty())
                signUpBinding.nota25Layout.error="La casilla esta vacia"

            else{
                if ((nota1.toFloat()>5) or  (nota1.toFloat()<0))
                   signUpBinding.nota60Layout.error="La nota tiene que estar en el rango de 0 y 5"

                else if((nota2.toFloat()>5) or  (nota2.toFloat()<0))
                    signUpBinding.nota7Layout.error="La nota tiene que estar en el rango de 0 y 5"

                else if ((nota3.toFloat()>5) or  (nota3.toFloat()<0))
                    signUpBinding.nota8Layout.error="La nota tiene que estar en el rango de 0 y 5"

               else if ((nota4.toFloat()>5) or  (nota4.toFloat()<0))
                    signUpBinding.nota25Layout.error="La nota tiene que estar en el rango de 0 y 5"

               else {
                   val notaFinal =
                       ((nota1.toFloat() * 0.6) + (nota2.toFloat() * 0.07) + (nota3.toFloat() * 0.08) + (nota4.toFloat() * 0.25))
                   signUpBinding.resultadoTextView.setText("NOTA FINAL: $notaFinal")

                   it.hidekeyboard()
               }
            }

        }
    }
}