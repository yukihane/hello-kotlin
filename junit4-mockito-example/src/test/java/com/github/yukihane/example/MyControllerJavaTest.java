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

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class MyControllerJavaTest {

    private final Param param;

    @Mock
    private MyService service;
    @Mock
    private MyInputMapper inputMapper;
    @Mock
    private MyOutputMapper outputMapper;

    @InjectMocks
    private MyController sut;

    public record Param(MyInputDTO input, MyOutputDTO expected) {
    }

    @Parameterized.Parameters
    public static List<Param> provide() {
        return List.of(new Param(new MyInputDTO("alice", 16), new MyOutputDTO("alice", 17)),
                new Param(new MyInputDTO("bob", 32), new MyOutputDTO("bob", 33)));
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void normal() {
        MyService service = new MyServiceImpl();

        MyController controller = new MyController(service, MyInputMapper.INSTANCE, MyOutputMapper.INSTANCE);

        MyOutputDTO res = controller.index(param.input);

        assertThat(res).isEqualTo(param.expected);
    }

    @Test
    public void mocking() {
        MyOutputDTO res = sut.index(param.input);
    }
}
