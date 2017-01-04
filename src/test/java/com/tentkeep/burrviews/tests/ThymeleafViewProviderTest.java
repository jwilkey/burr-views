package com.tentkeep.burrviews.tests;

import com.tentkeep.burrviews.FragmentRegistry;
import com.tentkeep.burrviews.ThymeleafViewProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.thymeleaf.context.AbstractContext;
import org.thymeleaf.context.WebContext;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ThymeleafViewProviderTest {

    AbstractContext context;
    Map<String,Object> arguments;
    @Mock
    FragmentRegistry fragmentRegistry;
    @InjectMocks
    ThymeleafViewProvider subject;

    @Before
    public void beforeEach() {
        context = new WebContext(new MockHttpServletRequest(), new MockHttpServletResponse(), new MockServletContext());
        arguments = new HashMap<>();
    }

    @Test
    public void get_withViewIdentifierAndArguments_putsTheArgsOnTheWebContext() {
        arguments.put("type", "blue");
        arguments.put("number", 77);

        subject.get("identifier", context, arguments);

        assertEquals("blue", context.getVariables().get("type"));
        assertEquals(77, context.getVariables().get("number"));
    }

    @Test
    public void get_withViewIdentifierAndArguments_returnsFragmentSelector() {
        arguments.put("type", "blue");
        arguments.put("number", 77);
        String identifier = TestHelper.randomString();
        when(fragmentRegistry.get(identifier)).thenReturn("fragment path :: fragment selector");

        String fragmentSelector = subject.get(identifier, context, arguments);

        assertEquals("fragment path :: fragment selector (number=${number},type=${type})", fragmentSelector);
    }

    @Test
    public void get_withViewIdentifier_returnsFragmentSelector() {
        String identifier = TestHelper.randomString();
        when(fragmentRegistry.get(identifier)).thenReturn("fragment path :: fragment selector");

        String fragmentSelector = subject.get(identifier);

        assertEquals("fragment path :: fragment selector", fragmentSelector);
    }

}