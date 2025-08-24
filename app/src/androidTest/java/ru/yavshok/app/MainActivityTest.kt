package ru.yavshok.app.tests

import MainPage
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.yavshok.app.MainActivity

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun checkUsersValidEmail() {
        val mainPage = MainPage(composeTestRule)

        mainPage
            .waitForScreenVisible()

        mainPage
            .typeEmail("vea@gmail.com")

        mainPage
            .checkUser()

        mainPage
            .waitForUserIn()

        mainPage
            .checkResultIn()
    }

    @Test
    fun checkUsersInvalidEmail() {
        val mainPage = MainPage(composeTestRule)

        mainPage
            .waitForScreenVisible()

        mainPage
            .typeEmail("nonexistingemaildhdhdhdhdks@gmail.com")

        mainPage
            .checkUser()

        mainPage
            .waitForUserOut()

        mainPage
            .checkResultOut()
    }
}