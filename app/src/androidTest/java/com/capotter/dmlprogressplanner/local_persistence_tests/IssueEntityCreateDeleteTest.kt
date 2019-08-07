package com.capotter.dmlprogressplanner.local_persistence_tests

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.capotter.dmlprogressplanner.data.model.Issue
import com.capotter.dmlprogressplanner.data.persistence.Issue.IssueDao
import com.capotter.dmlprogressplanner.data.persistence.Issue.IssueDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
class IssueEntityCreateDeleteTest {
    private lateinit var issueDao: IssueDao
    private lateinit var db: IssueDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(
            context, IssueDatabase::class.java).build()
        issueDao = db.issueDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun createIssueAndDeleteIssue() = runBlocking {
        val issue: Issue =
            Issue(1,
                1,
                "TestIssue",
                "This is a test issue",
                "open",
                "2011-04-22T13:33:48Z",
                "2011-04-22T13:33:48Z")
        issueDao.insertIssue(issue)
        val issueItem = issueDao.getIssueByTitle(issue.title)
        assertThat(issueItem.title, equalTo(issue.title))
        assertThat(issueItem.body, equalTo(issue.body))
        assertThat(issueItem.state, equalTo(issue.state))
        assertThat(issueItem.created_at, equalTo(issue.created_at))
        issueDao.deleteIssue(issue)
        val removedIssueItem = issueDao.getIssueByTitle(issue.title)
        assert(removedIssueItem == null)

    }
}