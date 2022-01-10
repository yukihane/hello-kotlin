package com.github.yukihane.example

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(Parameterized::class)
class MyControllerKtTest(private val param: Param) {

    @Mock
    private lateinit var service: MyService

    @Mock
    private lateinit var inputMapper: MyInputMapper

    @Mock
    private lateinit var outputMapper: MyOutputMapper

    @InjectMocks
    private lateinit var sut: MyController

    data class Param(val input: MyInputDTO, val expected: MyOutputDTO)

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun provide(): List<Param> {
            return listOf(
                Param(MyInputDTO("alice", 16), MyOutputDTO("alice", 17)),
                Param(MyInputDTO("bob", 32), MyOutputDTO("bob", 33))
            )
        }
    }

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun normal() {
        val service: MyService = MyServiceImpl()
        val controller = MyController(service, MyInputMapper.INSTANCE, MyOutputMapper.INSTANCE)
        val res = controller.index(param.input)
        Assertions.assertThat(res).isEqualTo(param.expected)
    }

    @Test
    fun mocking() {
        val res = sut.index(param.input)
    }
}