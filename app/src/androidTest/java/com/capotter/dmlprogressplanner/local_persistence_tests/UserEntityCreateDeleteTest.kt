package com.capotter.dmlprogressplanner.local_persistence_tests

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.User.UserDao
import com.capotter.dmlprogressplanner.data.persistence.User.UserDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
class UserEntityCreateDeleteTest {

    private lateinit var userDao: UserDao
    private lateinit var db: UserDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(
            context, UserDatabase::class.java).build()
        userDao = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun createUserAndDeleteUser() = runBlocking {
        val user: User = User(
            1,
            1,
            "TestUser",
            "testUrl.jpg",
            "Tom Sawyer",
            1,
            0,
            12,
            1,
            "2011-04-22T13:33:48Z"
        )
        userDao.insertUser(user)
        val userItem = userDao.getUserByName(user.name)
        MatcherAssert.assertThat(userItem.login, CoreMatchers.equalTo(user.login))
        MatcherAssert.assertThat(userItem.avatar_url, CoreMatchers.equalTo(user.avatar_url))
        MatcherAssert.assertThat(userItem.name, CoreMatchers.equalTo(user.name))
        MatcherAssert.assertThat(userItem.created_at, CoreMatchers.equalTo(user.created_at))
        userDao.deleteUser(user)
        val removedUserItem = userDao.getUserByName(user.name)
        assert(removedUserItem == null)
    }
}