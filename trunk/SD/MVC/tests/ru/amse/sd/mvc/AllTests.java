package ru.amse.sd.mvc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.amse.sd.mvc.onetomany.NotifyingDataArrayTest;
import ru.amse.sd.mvc.onetoone.DataArrayTest;
import ru.amse.sd.mvc.onetoone.view.TreeVertexTest;

@RunWith(Suite.class)
@SuiteClasses({NotifyingDataArrayTest.class, TreeVertexTest.class, DataArrayTest.class})
public class AllTests {
}
