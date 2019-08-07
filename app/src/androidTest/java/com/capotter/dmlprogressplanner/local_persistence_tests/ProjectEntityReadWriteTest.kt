package com.capotter.dmlprogressplanner.local_persistence_tests

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.capotter.dmlprogressplanner.data.model.Project
import com.capotter.dmlprogressplanner.data.persistence.Project.ProjectDao
import com.capotter.dmlprogressplanner.data.persistence.Project.ProjectDatabase
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
class ProjectEntityReadWriteTest {

    private lateinit var projectDao: ProjectDao
    private lateinit var db: ProjectDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(
            context, ProjectDatabase::class.java).build()
        projectDao = db.projectDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeProjectAndReadProject() = runBlocking {
        val project: Project = Project(
            1,
            1,
            "TestProject",
            "This is a test project",
            "open",
            "2011-04-22T13:33:48Z",
            "2011-04-22T13:33:48Z"
        )
        projectDao.insertProject(project)
        val projectItem = projectDao.getProjectByName(project.name)
        MatcherAssert.assertThat(projectItem.name, CoreMatchers.equalTo(project.name))
        MatcherAssert.assertThat(projectItem.body, CoreMatchers.equalTo(project.body))
        MatcherAssert.assertThat(projectItem.state, CoreMatchers.equalTo(project.state))
        MatcherAssert.assertThat(projectItem.updated_at, CoreMatchers.equalTo(project.updated_at))
        MatcherAssert.assertThat(projectItem.created_at, CoreMatchers.equalTo(project.created_at))
    }
}