package com.github.yukihane.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk

class MyControllerKtTest : FunSpec() {

    @MockK
    private lateinit var service: MyService

    @MockK
    private lateinit var outputMapper: MyParamMapper

    @InjectMockKs
    private lateinit var sut: MyController

    data class Param(val input: MyParamDTO, val expected: MyParamDTO)

    private val params = listOf(
        Param(
            MyParamDTO("alice", 16),
            MyParamDTO("alice", 17)
        ),
        Param(
            MyParamDTO("bob", 32),
            MyParamDTO("bob", 33)
        )
    )

    init {

        beforeTest {
            MockKAnnotations.init(this)
        }

        context("normal") {
            withData<Param>(nameFn = { "${it.input.name} ${it.input.age}" }, params) { param ->
                val service: MyService = MyServiceImpl()
                val controller = MyController(service, MyParamMapper.INSTANCE)
                val res = controller.index(param.input)
                res shouldBe param.expected
            }
        }

        context("mocking") {
            withData(nameFn = { "${it.input.name} ${it.input.age}" }, params) { param ->
                every { outputMapper.convert(any<MyParamDTO>()) } returns mockk()
                every { service.execute(any()) } returns mockk()
                val exp = mockk<MyParamDTO>()
                every { outputMapper.convert(any<MyParam>()) } returns exp

                val res = sut.index(param.input)
                res shouldBeSameInstanceAs exp
            }
        }
    }
}
