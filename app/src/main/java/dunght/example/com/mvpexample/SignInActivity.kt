package dunght.example.com.mvpexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), SignInView {

    private lateinit var mSignInPresenterImpl: SignInPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun registerListener() {
        button_sign_in.setOnClickListener {
            login()
        }

        button_sign_up.setOnClickListener {

        }
    }

    fun initPresenter() {
        mSignInPresenterImpl.setView(this)
    }

    fun login() {
        val username = text_username.text.toString()
        val password = text_password.text.toString()
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username or Password is Empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        mSignInPresenterImpl.handleSignIn(username, password)
    }

    override fun signInSuccess() {
        Toast.makeText(this, "Sign In Success!", Toast.LENGTH_SHORT).show();
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun signInFailure(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
