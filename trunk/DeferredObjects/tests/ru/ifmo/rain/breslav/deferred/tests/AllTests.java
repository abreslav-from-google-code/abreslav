package ru.ifmo.rain.breslav.deferred.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestDObject.class,
	TestDComposite.class,
	TestDArray.class
})
public class AllTests {

}
