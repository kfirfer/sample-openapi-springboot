package com.kfirfer.userservice;


import com.qdesrame.openapi.diff.OpenApiCompare;
import com.qdesrame.openapi.diff.model.ChangedOpenApi;
import com.qdesrame.openapi.diff.output.MarkdownRender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
public class OpenApiDiffApiContract {

    private Path resourceDirectory = Paths.get("src", "test", "resources");

    @Test
    public void apiContractTest() throws Exception {
        ChangedOpenApi diff = OpenApiCompare.fromLocations(resourceDirectory + "/swagger/documentation/openapi.yml", resourceDirectory + "/swagger/documentation/openapi_from_code.json");
        renderMarkDown(diff);
        Assert.assertEquals(0, diff.getChangedOperations().size());
    }

    private void renderMarkDown(ChangedOpenApi diff) throws IOException {
        String render = new MarkdownRender().render(diff);
        FileWriter fw = new FileWriter(
                resourceDirectory + "/swagger/diff/api_diff-" + diff.getNewSpecOpenApi().getInfo().getVersion() + ".md");
        fw.write(render);
        fw.close();
    }

}
