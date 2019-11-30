package com.kfirfer.userservice;


import com.qdesrame.openapi.diff.OpenApiCompare;
import com.qdesrame.openapi.diff.model.ChangedOpenApi;
import com.qdesrame.openapi.diff.output.MarkdownRender;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OpenApiDiffApiContract {

    @Autowired
    public MockMvc mockMvc;

    private Path resourceDirectory = Paths.get("src", "test", "resources");

    @Test
    public void apiContractTest() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/api-docs");
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder1 = mockHttpServletRequestBuilder.accept(MediaType.APPLICATION_JSON);

        ResultActions resultActions = this.mockMvc.perform(mockHttpServletRequestBuilder1);
        String swaggerJsonString = resultActions.andReturn().getResponse().getContentAsString();
        FileUtils.writeStringToFile(new File(resourceDirectory + "/swagger/documentation/new_swagger.json"), swaggerJsonString, Charset.defaultCharset());

        ChangedOpenApi diff = OpenApiCompare.fromLocations(resourceDirectory + "/swagger/documentation/swagger.yml", resourceDirectory + "/swagger/documentation/new_swagger.json");

        renderMarkDown(diff);

        Assert.assertEquals(diff.getChangedOperations().size(), 2);
    }

    private void renderMarkDown(ChangedOpenApi diff) throws IOException {
        String render = new MarkdownRender().render(diff);
        FileWriter fw = new FileWriter(
                resourceDirectory + "/swagger/diff/testDiff.md");
        fw.write(render);
        fw.close();
    }

}
