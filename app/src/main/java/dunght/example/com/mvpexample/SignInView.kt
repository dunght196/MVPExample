package dunght.example.com.mvpexample

interface SignInView {

    fun signInSuccess()

    fun signInFailure(error: String)
}