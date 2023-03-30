package com.solo4.common

import com.solo4.common.model.ExampleModel1
import com.solo4.common.model.ExampleModel2
import org.junit.Test

import org.junit.Assert.*

class MappingExtensionsTest {
    @Test
    fun transformationTest() {
        val exampleData1 = ExampleModel1("", 0, 0.0)
        assert(
            exampleData1.transform {
                    ExampleModel2(it.field3, it.field1, it.field2, "Any")
            } is ExampleModel2
        )
    }
}