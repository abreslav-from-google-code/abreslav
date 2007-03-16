package ru.ifmo.rain.astrans.asttomodel.resolver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		EPackageResolverTest.class, 
		IterableClassQNTest.class,
		IterableQNTest.class, 
		MyEPackageTest.class,
		CreatedClassesTest.class,
		MappedClassesTest.class,
		CompositeClassifierNamespaceTest.class
})
public class AllTests {

}
