package ru.yavshok.app.tests

import EditProfilePage
import LoginPage
import MainPage
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.yavshok.app.MainActivity

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    val mainCheck = MainPage(composeTestRule)
    val loginNow = LoginPage(composeTestRule)
    val profileMe = EditProfilePage(composeTestRule)

    private fun openLoginScreen() {
        mainCheck
            .waitForScreenVisible()

        mainCheck
            .clickLogin()

        loginNow
            .checkScreenVisible()
    }

    @Test
    fun successfulLogin(){
        openLoginScreen()

        loginNow
            .typeEmailAndPass("vea@gmail.com", "123456")

        loginNow
            .clickLogin()

        profileMe
            .checkProfileVisible()
    }

    @Test
    fun withInvalidData(){
        openLoginScreen()

        loginNow
            .typeEmailAndPass("somewrongemail@gmail.com", "jsdhjksdfhj")

        loginNow
            .clickLogin()

        loginNow
            .waitForErrorMessage()
    }

    @Test
    fun missingEmail(){
        openLoginScreen()

        loginNow
            .typeEmailAndPass("", "dsfkjlskdfjlk")

        loginNow
            .clickLogin()

        loginNow
            .waitForErrorMessage()
    }

    @Test
    fun missingPass(){
        openLoginScreen()

        loginNow
            .typeEmailAndPass("lskdfjksdjfl@gmail.com", "")

        loginNow
            .clickLogin()

        loginNow
            .waitForErrorMessage()
    }
}