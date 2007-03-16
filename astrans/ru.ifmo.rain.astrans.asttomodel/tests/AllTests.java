

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.ifmo.rain.astrans.asttomodel.resolver.CreatedClassesTest;
import ru.ifmo.rain.astrans.asttomodel.resolver.EPackageResolverTest;
import ru.ifmo.rain.astrans.asttomodel.resolver.IterableClassQNTest;
import ru.ifmo.rain.astrans.asttomodel.resolver.IterableQNTest;
import ru.ifmo.rain.astrans.asttomodel.resolver.MappedClassesTest;
import ru.ifmo.rain.astrans.asttomodel.resolver.MyEPackageTest;
import utils.ORTest;

@RunWith(Suite.class)
@SuiteClasses({
		EPackageResolverTest.class, 
		IterableClassQNTest.class,
		IterableQNTest.class, 
		MyEPackageTest.class,
		CreatedClassesTest.class,
		MappedClassesTest.class,
		ORTest.class,
})
public class AllTests {

}
