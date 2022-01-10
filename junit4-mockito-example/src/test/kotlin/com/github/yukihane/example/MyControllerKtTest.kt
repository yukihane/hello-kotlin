package com.github.yukihane.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@RunWith(Parameterized::class)
class MyControllerKtTest(private val param: Param) {

    @Mock
    private lateinit var service: MyService

    @Mock
    private lateinit var outputMapper: MyParamMapper

    @InjectMocks
    private lateinit var sut: MyController

    data class Param(val input: MyParamDTO, val expected: MyParamDTO)

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun provide(): List<Param> {
            return listOf(
                Param(
                    MyParamDTO("alice", 16),
                    MyParamDTO("alice", 17)
                ),
                Param(
                    MyParamDTO("bob", 32),
                    MyParamDTO("bob", 33)
                )
            )
        }
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun normal() {
        val service: MyService = MyServiceImpl()
        val controller = MyController(service, MyParamMapper.INSTANCE)
        val res = controller.index(param.input)
        assertThat(res).isEqualTo(param.expected)
    }

    @Test
    fun mocking() {
        `when`(outputMapper.convert(any(MyParamDTO::class.java))).thenReturn(mock(MyParam::class.java))
        `when`(service.execute(any())).thenReturn(mock(MyParam::class.java))
        val exp = mock(MyParamDTO::class.java)
        `when`(outputMapper.convert(any(MyParam::class.java))).thenReturn(exp)

        val res = sut.index(param.input)
        assertThat(res).isSameAs(exp)
    }
}
