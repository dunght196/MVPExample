package dunght.example.com.mvpexample

class SignInPresenterImpl : SignInPresenter {

    private lateinit var mView: SignInView

    fun setView(view: SignInView) {
        this.mView = view
    }

    override fun handleSignIn(username: String, password: String) {
        if (username.equals("mvpexample") && password.equals("1234")) {
            mView.signInSuccess();
            return;
        }

        mView.signInFailure("Username or Password not true!");
    }

}