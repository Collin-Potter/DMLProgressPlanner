package com.capotter.dmlprogressplanner.local_persistence_tests

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.capotter.dmlprogressplanner.data.model.Milestone
import com.capotter.dmlprogressplanner.data.persistence.Milestone.MilestoneDao
import com.capotter.dmlprogressplanner.data.persistence.Milestone.MilestoneDatabase
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
class MilestoneEntityCreateDeleteTest {

    private lateinit var milestoneDao: MilestoneDao
    private lateinit var db: MilestoneDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(
            context, MilestoneDatabase::class.java).build()
        milestoneDao = db.milestoneDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun createMilestoneAndDeleteMilestone() {
        val milestone: Milestone = Milestone(
            1,
            1,
            "TestMilestone",
            "This is a test milestone",
            1,
            1,
            "2011-04-22T13:33:48Z",
            "2011-04-22T13:33:48Z",
            "2011-04-22T13:33:48Z",
            "2011-04-22T13:33:48Z"
        )
        milestoneDao.insertMilestone(milestone)
        val milestoneItem = milestoneDao.getMilestoneByTitle(milestone.title)
        MatcherAssert.assertThat(milestoneItem.title, CoreMatchers.equalTo(milestone.title))
        MatcherAssert.assertThat(milestoneItem.description, CoreMatchers.equalTo(milestone.description))
        MatcherAssert.assertThat(milestoneItem.open_issues, CoreMatchers.equalTo(milestone.open_issues))
        MatcherAssert.assertThat(milestoneItem.closed_issues, CoreMatchers.equalTo(milestone.closed_issues))
        MatcherAssert.assertThat(milestoneItem.created_at, CoreMatchers.equalTo(milestone.created_at))
        MatcherAssert.assertThat(milestoneItem.due_on, CoreMatchers.equalTo(milestone.due_on))
        milestoneDao.deleteMilestone(milestone)
        val removedMilestoneItem = milestoneDao.getMilestoneByTitle(milestone.title)
        assert(removedMilestoneItem == null)
    }
}