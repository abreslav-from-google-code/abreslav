package ru.ifmo.rain.astrans.asttomodel.resolver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		EPackageResolverTest.class, 
		IterableClassQNTest.class,
		IterableQNTest.class, 
		MyEPackageTest.class 
})
public class AllTests {

}
