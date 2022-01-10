package com.github.yukihane.example;

import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class MyControllerJavaTest {

    private final Param param;

    @Mock
    private MyService service;
    @Mock
    private MyParamMapper paramMapper;

    @InjectMocks
    private MyController sut;

    public record Param(MyParamDTO input, MyParamDTO expected) {
    }

    @Parameterized.Parameters
    public static List<Param> provide() {
        return List.of(new Param(new MyParamDTO("alice", 16), new MyParamDTO("alice", 17)),
                new Param(new MyParamDTO("bob", 32), new MyParamDTO("bob", 33)));
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void normal() {
        final MyService service = new MyServiceImpl();

        final MyController controller = new MyController(service, MyParamMapper.INSTANCE);

        final MyParamDTO res = controller.index(param.input);

        assertThat(res).isEqualTo(param.expected);
    }

    @Test
    public void mocking() {
        when(paramMapper.convert(any(MyParamDTO.class))).thenReturn(mock(MyParam.class));
        when(service.execute(any())).thenReturn((mock(MyParam.class)));
        final MyParamDTO exp = mock(MyParamDTO.class);
        when(paramMapper.convert(any(MyParam.class))).thenReturn(exp);

        final MyParamDTO res = sut.index(param.input);
        assertThat(res).isSameAs(exp);
    }
}
