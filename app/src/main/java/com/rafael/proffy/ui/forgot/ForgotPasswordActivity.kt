package com.rafael.proffy.ui.forgot

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.rafael.proffy.R
import com.rafael.proffy.databinding.ActivityForgotPasswordBinding
import com.rafael.proffy.ui.finallyComponent.FinallyActivity

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurando ViewBinding (seguindo o padrão das outras Activities do projeto)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Botão de voltar na seta superior
        binding.ivBack.setOnClickListener {
            finish()
        }

        // Validação reativa enquanto o usuário digita
        binding.etEmail.addTextChangedListener { text ->
            validateEmail(text.toString())
        }

        // Clique no botão de envio
        binding.btnSubmit.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            if (isEmailValid(email)) {
                // Navega para a tela de conclusão existente (FinallyActivity)
                val intent = Intent(this, FinallyActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validateEmail(email: String) {
        if (email.isEmpty()) {
            binding.tilEmail.error = null
            setButtonState(isValid = false)
            return
        }

        if (!isEmailValid(email)) {
            binding.tilEmail.error = getString(R.string.error_invalid_email)
            setButtonState(isValid = false)
        } else {
            binding.tilEmail.error = null
            setButtonState(isValid = true)
        }
    }

    private fun setButtonState(isValid: Boolean) {
        if (isValid) {
            // Estado Válido exigido: Botão verde e habilitado com o texto "Enviar"
            binding.btnSubmit.isEnabled = true
            binding.btnSubmit.text = getString(R.string.btn_state_valid)
            binding.btnSubmit.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.holo_green_dark) // Ou cor primária verde do projeto se houver
        } else {
            // Estado Inicial exigido: Botão cinza e desabilitado com o texto "Entrar"
            binding.btnSubmit.isEnabled = false
            binding.btnSubmit.text = getString(R.string.btn_state_initial)
            binding.btnSubmit.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
        }
    }
}

