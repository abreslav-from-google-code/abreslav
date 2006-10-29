package ru.amse.abreslav.graphs.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	TestListGraph.class,
	TestMatrixGraph.class
})
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for ru.amse.abreslav.graphs.model");
		//$JUnit-BEGIN$
		suite.addTest(new JUnit4TestAdapter(TestListGraph.class));
		suite.addTest(new JUnit4TestAdapter(TestMatrixGraph.class));
		//$JUnit-END$
		return suite;
	}

}
